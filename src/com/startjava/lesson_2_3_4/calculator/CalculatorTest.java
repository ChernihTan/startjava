package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SignException {
        String answer;
        String mathExpression;
        double result;
        // Возможны 4 варианта ввода от пользователя, в зависимости от вопроса:
        // 1. Введите математическое выражение
        // 2. Повторите ввод математического выражения
        // 3. Хотите продолжить вычисления? [yes/no]
        // 4. Введите корректный ответ [yes/no]
        int variantQuestion = 1;
        do {
            switch (variantQuestion) {
                case 1 -> System.out.print("\nВведите математическое выражение: ");
                case 2 -> System.out.print("\nПовторите ввод математического выражения: ");
                case 3 -> System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                case 4 -> System.out.print("Введите корректный ответ [yes/no]: ");
                default -> System.out.print("Неучтенная ошибка! ");
            }
            answer = scanner.nextLine().toUpperCase();
            if (variantQuestion == 1 || variantQuestion == 2) {
                mathExpression = answer;
                try {
                    result = Calculator.calculate(mathExpression);
                    printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
                    variantQuestion = 3;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный формат целого числа\n");
                    variantQuestion = 2;
                } catch (NegativeNumberException | ArithmeticException | SignException |
                         UnspacedExpression e) {
                    System.out.println(e.getMessage());
                    variantQuestion = 2;
                }
            } else {
                if ("YES".equals(answer)) {
                    variantQuestion = 1;
                } else {
                    variantQuestion = 4;
                }
            }
        } while (!"NO".equals(answer));
        System.out.println("Программа завершена");
    }

    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        System.out.printf((result % 1 > 0) ? ("%.3f%n") : ("%.0f%n"), result);
        System.out.println();
    }
}