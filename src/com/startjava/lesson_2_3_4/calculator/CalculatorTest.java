package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) throws SignException {
        Scanner scanner = new Scanner(System.in);
        String answer = "YES";
        String mathExpression;
        double result;

        do {
            if ("YES".equals(answer)) {
                System.out.print("\nВведите математическое выражение: ");
                mathExpression = scanner.nextLine();
                try {
                    result = Calculator.calculate(mathExpression);
                    printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат целого числа\n");
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    System.out.println("Длинное выражение, должно быть два числа и между ними " +
//                            "знак математической операции, разделенные пробелом.\n");
                } catch (NegativeNumberException | ArithmeticException | SignException |
                         UnspacedExpression e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.nextLine().toUpperCase();
        } while (!"NO".equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        System.out.printf((result % 1 > 0) ? ("%.3f%n") : ("%.0f%n"), result);
        System.out.println();
    }
}