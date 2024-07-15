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
            boolean isException = true;
            if (YES.equals(answer)) {
                System.out.print("\nВведите математическое выражение: ");
                String expression = scanner.nextLine();
                try {
                    double result = Calculator.calculate(expression);
                    printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
                    isException = false;
                    System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат целого числа\n");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            if (!isException || !YES.equals(answer)) {
                answer = scanner.nextLine().toUpperCase();
            }
        } while (!NO.equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(result));
    }
}