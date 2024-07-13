package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final String YES = "YES";
    private static final String NO = "NO";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String answer = YES;
        double result;

        do {
            if (YES.equals(answer)) {
                result = Calculator.calculate();
                printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.next().toUpperCase();
        } while (!NO.equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.println(decimalFormat.format(result));
    }
}