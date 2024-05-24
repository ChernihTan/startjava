package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    static final int CONSTANTA_ELEMENTS_IN_EXPRESSION = 3;
    private static int a;
    private static int b;
    private static char sign;
    // метод отвечает за проверку математического знака и сами вычисления

    public static double calculate(String expression) throws NumberFormatException, ArithmeticException,
            SignException, UnspacedExpression, NegativeNumber {
        a = 0;
        b = 0;
        sign = ' ';
        // Разбор выражения
        String[] args = expression.split(" ");  // (" |\\\n");
        int length = args.length;

        // если случайно набрали несколько пробелов подряд,
        // не пустые элементы элементы массива переношу в начало массива
        if (length < CONSTANTA_ELEMENTS_IN_EXPRESSION) {
            // генерирую исключение
            throw new UnspacedExpression("Ошибка: выражение введено без пробелов!\n");
        }
        // вариант 1 избавления от лишних пробелов
        for (int i = 0; i < length - 1; i++) {
            int j;
            // если текущий элемент пустой, ищу далее первый не пустой
            try {
                if (args[i].isEmpty()) {
                    j = i;
                    do {
                        j++;
                    } while (args[j].isEmpty());
                    args[i] = args[j];
                    args[j] = "";
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        // Вариант второй избавления от личших пробелов
        String[] argsNew = expression.split(" ");  // (" |\\\n");
        for (int i = 0; i < length - 1; i++) {
            int j;
            // если текущий элемент пустой, ищу далее первый не пустой
            if (argsNew[i].isEmpty()) {
                j = i;
                do {
                    if (++j == length) {
                        break;
                    }
                } while (argsNew[j].isEmpty());
                if (j == length) {
                    break;
                }
                argsNew[i] = argsNew[j];
                argsNew[j] = "";
            }
        }

        a = defineArgument(args[0]);
        b = defineArgument(args[2]);
        sign = args[1].charAt(0);

        // проверка на 0 второго аргумента, если операция деления
        if (b == 0 && (sign == '/' || sign == '%')) {
            throw new ArithmeticException("Ошибка: делить на ноль нельзя!\n");
        }
        // Выполнение операции (+, -, *, /, ^, %)

        double result = switch (sign) {
            case '+' -> (double) a + b;
            case '-' -> (double) a - b;
            case '*' -> (double) a * b;
            case '/' -> (double) a / b;
            case '^' -> Math.pow(a, b);
            case '%' -> (double) a % b;
            default -> throw new SignException("Ошибка: знак " + sign + " не поддерживается!\n");
        };
        return result;
    }

    // печать результата
    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        System.out.printf((result % 1 > 0) ? ("%.3f%n") : ("%.0f%n"), result);
        System.out.println();
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
