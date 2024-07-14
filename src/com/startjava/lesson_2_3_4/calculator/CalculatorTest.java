package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final String YES = "YES";
    private static final String NO = "NO";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String expression;
        String answer = YES;
        do {
            if (YES.equals(answer)) {
                System.out.print("\nВведите математическое выражение: ");
                expression = scanner.nextLine();
                try {
                    double result = Calculator.calculate(expression);
                    printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
                    System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                    answer = scanner.nextLine().toUpperCase();
                } catch (NegativeNumberException | ArithmeticException | SignException |
                         UnspacedExpression e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат целого числа\n");
                }
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
                answer = scanner.nextLine().toUpperCase();
            }
        } while (!NO.equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.println(decimalFormat.format(result));
    }
}