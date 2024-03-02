package com.startjava.lesson_2_3.calculator;

public class Calculator {

    // метод отвечает за проверку математического знака и сами вычисления
    public float calculate(int a, char sign, int b) {
        float result = 0;
        // операции +, -, *, /, ^, %
        switch(sign) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/' :
                if (b == 0) {
                    System.out.println("Делить на ноль нельзя!!!");
                } else {
                    result = a / (float) b;
                }
                return result;
            case '^' :
                result = 1;
                for (int i = 1; i <= b; i++) {
                    result *= a;
                }
                return result;
            case '%' :
                return a % b;
            default :
                System.out.println("Введенная мат. операция не поддерживается!");
                return result;
        }
    }

}