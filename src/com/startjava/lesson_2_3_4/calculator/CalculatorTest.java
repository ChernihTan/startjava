package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    //public static void main(String[] args) throws InterruptedException {
    public static void main(String[] args) throws SignException {
        //package com.startjava.lesson_2_3.calculator;
        Scanner scanner = new Scanner(System.in);
        String answer;
        String мathExpression;
        int a = 0;
        int b = 0;
        do {
            System.out.print("\nВведите математическое выражение: ");
            мathExpression = scanner.nextLine();
            try {
                Calculator.calculate(мathExpression);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                String message = e.getMessage();
                int index1 = message.indexOf('"') + 1; // 2
                int index2 = message.lastIndexOf('"'); //19 "test"
                String substr = message.substring(index1, index2); //23
                //message.split(" ")
                System.out.println("Ошибка: неверный формат целого числа - " + substr + "\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Длинное выражение, должно быть два числа и между ними знак математической " +
                        "операции, разделенные пробелом.\n");
            } catch (NegativeNumber e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (SignException e) {
                System.out.println(e.getMessage());
            } catch (UnspacedExpression e) {
                System.out.println(e.getMessage());
            }
            // жду только правильного ввода
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine().toUpperCase();
                ;
            } while (!answer.equals("NO") && !answer.equals("YES"));
        } while (!answer.equals("NO"));
        System.out.println("Программа завершена");
    }
}