package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) throws SignException {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String mathExpression;
        do {
            System.out.print("\nВведите математическое выражение: ");
            mathExpression = scanner.nextLine();
            try {
                Calculator.calculate(mathExpression);
            } catch (NumberFormatException e) {
                // e.printStackTrace();
                String message = e.getMessage();
                int index1 = message.indexOf('"') + 1; // 2
                int index2 = message.lastIndexOf('"'); // 19 "test"
                String substring = message.substring(index1, index2); // 23
                // message.split(" ")
                System.out.println("Ошибка: неверный формат целого числа - " + substring + "\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Длинное выражение, должно быть два числа и между ними " +
                        "знак математической операции, разделенные пробелом.\n");
            } catch (NegativeNumber | ArithmeticException | SignException | UnspacedExpression e) {
                System.out.println(e.getMessage());
            }
            // жду только правильного ввода
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine().toUpperCase();
            } while (!answer.equals("NO") && !answer.equals("YES"));
        } while (!answer.equals("NO"));
        System.out.println("Программа завершена");
    }
}