import java.util.Scanner;

public class CalculatorTest {
    public static int firstNumber;
    public static char mathOperation;
    public static int secondNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean moreItems = true;
        String answer;
 
        do {
            System.out.print("\nВведите первое число: ");
            firstNumber = scanner.nextInt();
            
            System.out.print("Введите знак математической операции: ");
            mathOperation = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            secondNumber = scanner.nextInt();

            Calculator calc = new Calculator();
            if (calc.check(mathOperation)) {
                float result = calc.calculating(firstNumber, mathOperation, secondNumber);
                System.out.print(firstNumber + " " + mathOperation + 
                    " " + secondNumber + " = ");
                if(result % 1 > 0) {
                    System.out.printf("%.2f%n", result);
                } else {
                    System.out.printf("%.0f%n", result);
                }
            }
            do {
            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            answer = scanner.next();
            //moreItems = answer.equals("yes") || answer.equals("YES")? true : false;
            } while(!answer.equals("no") && !answer.equals("NO") &&
                    !answer.equals("yes") && !answer.equals("YES"));
            moreItems = (answer.equals("yes") || answer.equals("YES") ? true : false);
        } while(moreItems == true); 
        System.out.println("Программа завершена");

/*
    Модифицируйте программу “Калькулятор”:
    создайте класс CalculatorTest, который будет содержать метод main() и в нем код, отвечающий за:
    создание объектов
    их инициализацию
    ввод математического выражения
    запуск вычислений
    обработку ответа пользователя о продолжении/завершении
    создайте класс Calculator. Он будет отвечать за проверку математического знака и сами вычисления
    замените все if-else, проверяющие математический знак, на оператор switch
    выводите сообщение, если введенная мат. операция не поддерживается
    для ввода математического выражения используйте клавиатуру и класс Scanner
    пользователь должен вводить мат. выражение в следующем формате (пример):
    Введите первое число: 2
    Введите знак математической операции: ^
    Введите второе число: 10


    по окончанию каждого вычисления выводите сообщение "Хотите продолжить вычисления? [yes/no]: ":
    yes — пользователю заново предлагается ввести математическое выражение
    no — программа завершается
    при ином значении выводите сообщение до тех пор, пока не будут введены допустимые ответы

*/
    }
}