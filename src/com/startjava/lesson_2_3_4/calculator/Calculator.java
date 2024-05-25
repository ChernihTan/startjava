package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int ARGS_LIMIT = 3;
    private static int a;
    private static int b;
    private static char sign;
    // метод отвечает за проверку математического знака и сами вычисления

    public static double calculate(String expression) throws NumberFormatException {
        a = 0;
        b = 0;
        sign = ' ';
        // Разбор выражения, предварительно убираю лишние пробелы
        String[] args = expression.strip().split("\s+");
        int length = args.length;

        if (length != ARGS_LIMIT) {
            throw new UnspacedExpression("Ошибка: выражение введено без пробелов!\n");
        }

        a = defineArgument(args[0]);
        b = defineArgument(args[2]);
        sign = args[1].charAt(0);

        // проверка на 0 второго аргумента, если операция деления
        if (b == 0 && (sign == '/' || sign == '%')) {
            throw new ArithmeticException("Ошибка: делить на ноль нельзя!\n");
        }
        // Выполнение операции (+, -, *, /, ^, %)

        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (double) a / b;
            case '^' -> Math.pow(a, b);
            case '%' -> (double) a % b;
            default -> throw new SignException("Ошибка: знак " + sign + " не поддерживается!\n");
        };
    }

    private static int defineArgument(String argument) throws NegativeNumber {
        int number = java.lang.Integer.parseInt(argument);
        if (number < 0) {
            throw new NegativeNumber("Введено отрицательное число!\n");
        }
        return number;
    }

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static char getSign() {
        return sign;
    }
}
