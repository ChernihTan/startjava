public class Calculator {

//    private int firstNumber = 2;
//    private int secondNumber = 10;
//    private char mathOperation = '^';
//    private float result = 0;
/*
создайте класс Calculator. Он будет отвечать за проверку математического знака и сами вычисления
    замените все if-else, проверяющие математический знак, на оператор switch
    выводите сообщение, если введенная мат. операция не поддерживается
*/
    public boolean check(char mathOperation) {
        boolean isExists;
        switch(mathOperation) {
            case '+' :
                isExists = true;
                break;
            case '-' :
                isExists = true;
                break;
            case '*' :
                isExists = true;
                break;
            case '/' :
                isExists = true;
                break;
            case '^' :
                isExists = true;
                break;
            case '%' :
                isExists = true;
                break;
            default :
                isExists = false;
                System.out.println("Введенная мат. операция не поддерживается!");
        }
        return isExists;
    }

    public float calculating(int firstNumber, char mathOperation, int secondNumber) {

        float result = 0;
        // операции +, -, *, /, ^, %
        switch(mathOperation) {
            case '+' :
                result = firstNumber + secondNumber;
                break;
            case '-' :
                result = firstNumber - secondNumber;
                break;
            case '*' :
                result = firstNumber * secondNumber;
                break;
            case '/' :
                if (secondNumber == 0) {
                    System.out.println("Делить на ноль нельзя");
                } else {
                    result = firstNumber / (float) secondNumber;
                }
                break;
            case '^' :
                result = 1;
                for (int i = 1; i <= secondNumber; i++) {
                    result *= firstNumber;
                }
                break;
            case '%' :
                result = firstNumber % secondNumber;
            }
            return result;
    }
}