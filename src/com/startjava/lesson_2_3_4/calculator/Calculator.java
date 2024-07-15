package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int ARGS_LIMIT = 3;
    private static int a;
    private static int b;
    private static char sign;

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static char getSign() {
        return sign;
    }

    // метод отвечает за проверку математического знака и сами вычисления
    public static double calculate(String expression) {
        parseExpression(expression);

        // Выполнение операции (+, -, *, /, ^, %)
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/', '%' -> {
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: делить на ноль нельзя!\n");
                }
                yield (sign == '/' ? (double) a / b : a % b);
            }
            case '^' -> Math.pow(a, b);
            default -> throw new SignException("Ошибка: знак " + sign + " не поддерживается!\n");
        };
    }

    private static void parseExpression(String expression) {
        // Избавление от лишних пробелов
        String[] args = expression.strip().split("\\s+");
        if (args.length != ARGS_LIMIT) {
            throw new UnspacedExpression("Ошибка: должно быть 3 аргумента, разделенных пробелами!\n");
        }
        a = checkNaturalNumber(args[0]);
        b = checkNaturalNumber(args[2]);
        sign = args[1].charAt(0);
    }

    private static int checkNaturalNumber(String arg) {
        int number = Integer.parseInt(arg);
        if (number < 0) {
            throw new NegativeNumberException("Введено отрицательное число!\n");
        }
        return number;
    }
}
