public class Calculator {
    public static void main(String[] args) {
        //1.  Калькулятор над целыми положительными числами
        System.out.println("Калькулятор над целыми положительными числами");
        // После извлечения чисел и знака операции перехожу к расчету
        int a = 5;
        int b = 2;
        char sign = '/';
        float result = 0;
        // операции +, -, *, /, ^, %
        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            result = a / (float) b;
        } else if (sign == '^') {
            result = 1;
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
        } else if (sign == '%') {
            result = a % b;
        } else {
            System.out.println("Поддерживаются только операции +, -, *, /, ^, %, а здесь - '" + 
                    sign + "'");
        }
        
        System.out.print(a + " " + sign + " " + b + " = ");
        if (sign == '/') {
            // только при операции деления ответ м.б. с дробной частью
            System.out.printf("%.2f%n", result);
        } else {
            System.out.printf("%.0f%n", result);
        }
    }
}
