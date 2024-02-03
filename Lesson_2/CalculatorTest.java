import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            int a;
            char sign;
            int b;
            System.out.print("\nВведите первое число: ");
            a = scanner.nextInt();
            
            System.out.print("Введите знак математической операции: ");
            sign = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            b = scanner.nextInt();

            Calculator calc = new Calculator();
            float result = calc.calculate(a, sign, b);
            printResult(a, sign, b, result);

            // жду только правильного ввода
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next().toUpperCase();
            } while(!answer.equals("NO") && !answer.equals("YES"));
        } while(!answer.equals("NO")); 
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, float result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        if(result % 1 > 0) {
            System.out.printf("%.2f%n", result);
        } else {
            System.out.printf("%.0f%n", result);
        }
    }    
}