package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = YES;
        do {
            try {
                if (YES.equals(answer)) {
                    System.out.print("\nВведите математическое выражение: ");
                    String expression = scanner.nextLine();
                    double result = Calculator.calculate(expression);
                    printResult(result);
                    System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                } else {
                    System.out.print("Введите корректный ответ [yes/no]: ");
                }
                answer = scanner.nextLine().toUpperCase();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат целого числа\n");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!NO.equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(double result) {
        System.out.print(Calculator.getA() + " " + Calculator.getSign() + " " + Calculator.getB() + " = ");
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(result));
    }
}