package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) throws SignException {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String mathExpression;
        double result;
        do {
            System.out.print("\nВведите математическое выражение: ");
            mathExpression = scanner.nextLine();
            try {
                result = Calculator.calculate(mathExpression);
                Calculator.printResult(Calculator.getA(), Calculator.getSign(), Calculator.getB(), result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат целого числа\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Длинное выражение, должно быть два числа и между ними " +
                        "знак математической операции, разделенные пробелом.\n");
            } catch (NegativeNumber | ArithmeticException | SignException | UnspacedExpression e) {
                System.out.println(e.getMessage());
            }

            // жду только правильного ввода
            //System.out.print("Если не хотите продолжить вычисления, введите no: ");
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.nextLine().toUpperCase();
            if (!answer.equals("YES")) {
                answer = "NO";
            }
//            do {
//                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
//                answer = scanner.nextLine().toUpperCase();
//            } while (!answer.equals("NO") && !answer.equals("YES"));
        } while (!answer.equals("NO"));
        System.out.println("Программа завершена");
    }
}