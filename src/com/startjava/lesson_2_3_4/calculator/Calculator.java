package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int ARGUMENTS_LIMIT = 3;
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
    public static double calculate() {
        String expression;
        double calculationResult = 0;
        boolean isRightExpression = false;
        do {
            try {
                System.out.print("\nВведите верное математическое выражение: ");
                expression = CalculatorTest.scanner.nextLine();
                calculationResult = executionExpression(expression);
                isRightExpression = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат целого числа\n");
            } catch (NegativeNumberException | ArithmeticException | SignException |
                     UnspacedExpression e) {
                System.out.println(e.getMessage());
            }
        } while (!isRightExpression);
        return calculationResult;
    }

    private static double executionExpression(String expression) {
        // Избавление от лишних пробелов
        String[] arguments = expression.strip().split("\\s+");
        checkExpression(arguments);

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

    private static void checkExpression(String[] arguments) {
        if (arguments.length != ARGUMENTS_LIMIT) {
            throw new UnspacedExpression("Ошибка: должно быть 3 аргумента, разделенных пробелами!\n");
        }
        a = checkArgument(arguments[0]);
        b = checkArgument(arguments[2]);
        sign = arguments[1].charAt(0);
    }

    private static int checkArgument(String argument) {
        int number = Integer.parseInt(argument);
        if (number < 0) {
            throw new NegativeNumberException("Введено отрицательное число!\n");
        }
        return number;
    }
}
