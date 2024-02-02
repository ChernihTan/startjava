public class Calculator {

    // метод отвечает за проверку математического знака и сами вычисления
    public float calculate(int firstNumber, char mathOperation, int secondNumber) {
        float result = 0;
        // операции +, -, *, /, ^, %
        switch(mathOperation) {
            case '+' :
                return firstNumber + secondNumber;
            case '-' :
                return firstNumber - secondNumber;
            case '*' :
                return firstNumber * secondNumber;
            case '/' :
                if (secondNumber == 0) {
                    System.out.println("Делить на ноль нельзя");
                    return result;
                } else {
                    return firstNumber / (float) secondNumber;
                }
            case '^' :
                result = 1;
                for (int i = 1; i <= secondNumber; i++) {
                    result *= firstNumber;
                }
                return result;
            case '%' :
                return firstNumber % secondNumber;
            default :
                System.out.println("Введенная мат. операция не поддерживается!");
                return result;
        }
    }

    public void printResult(int a, char sign, int b, float result) {
        System.out.print(a + " " + sign + 
                " " + b + " = ");
        if(result % 1 > 0) {
            System.out.printf("%.2f%n", result);
        } else {
            System.out.printf("%.0f%n", result);
        }
    }
}