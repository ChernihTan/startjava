import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        int a;
        char sign;
        int b;
 
        do {
            System.out.print("\nВведите первое число: ");
            a = scanner.nextInt();
            
            System.out.print("Введите знак математической операции: ");
            sign = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            b = scanner.nextInt();

            Calculator calc = new Calculator();
            float result = calc.calculate(a, sign, b);
            calc.printResult(a, sign, b, result);

            // жду только правильного ввода
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next();
                answer = answer.toUpperCase();  //toLowerCase();
            } while(!answer.equals("NO") && !answer.equals("YES"));
        } while(answer.equals("YES") ? true : false); 
        System.out.println("Программа завершена");
    }
}