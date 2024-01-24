public class Calculator {
    public static void main(String[] args) {
        //1.  Калькулятор над целыми положительными числами
        System.out.println("Калькулятор над целыми положительными числами");
        // После извлечения чисел и знака операции перехожу к расчету
        int a = 5;
        int b = 2;
        char sign = '/';
        float result = 0f;
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
            result = 1f ;
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
        } else if (sign == '%') {
            result = a % b;
        } else {
            System.out.println("Предполагаютcя только операции +, -, *, /, ^, %, а здесь - '" + 
                    sign + "'");
            result = 0f;
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
















/*/****************************************
        // значение выражения присваиваю прямо в коде
        //String userText = "456 + 556 = ";
        //String userText = "5 ^ 3 = ";
        //String userText = "125 * 5 = ";
        String userText = "847 / 19 = ";
        // первое и второе числа
        String number1 = "";
        String number2 = "";
        int indicator = 0;
        // знак операции
        char sign = ' ';
        String number = "";
        for (int i = 0; i < userText.length(); i++) {
            //беру очередной символ из строки
            char symbol = userText.charAt(i); 
            // если символ является числом то записываем его в строковую переменную number
            // и indicator показывает, (не 0), что начали выделять число из строки
            if (Character.isDigit(symbol)) {
                number += symbol;
                indicator++;
            } else if (Character.isDigit(symbol) == false && indicator > 0) { 
            // если символ является не цифрой, а чтение числа было начато, 
            // то число уже считано и его можно взять из переменной number
                //System.out.println("Выделено число: " + number);
                if (number1 == "") {
                    number1 = number;
                } else {
                    number2 = number;
                }
                // После получения числа готовлюсь к получению следующего
                indicator = 0;
                number = "";
            } else if (Character.isDigit(symbol) == false && indicator == 0) {
                // символ не цифра, и это не завершение чтения числа,
                // значит это либо пробел или =, либо знак операции
                if ((symbol != ' ') && (symbol != '=')) {
                    sign = symbol;
                }
            }
        }
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
*/
