package com.startjava.lesson_2_3_4.calculator;
public class Calculator {
    // метод отвечает за проверку математического знака и сами вычисления
    public static void calculate(String Expression) throws NumberFormatException, ArithmeticException,
            SignException, UnspacedExpression, NegativeNumber, ArrayIndexOutOfBoundsException
    {
        int a = 0;
        int b = 0;
        char sign = ' ';
        // Разбор выражения
        String[] words = Expression.split(" ");  //(" |\\\n");
        String[] arr = new String[3];
        double result = Double.NaN;
        // Убираем пустые строки, если случайно набрали несколько пробелов подряд
        if (words.length < 3) {
            // генерирую исключение
            throw new UnspacedExpression("Ошибка: выражение введено без пробелов!\n");
        }
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                arr[j++] = words[i];
            }
        }
        a = java.lang.Integer.parseInt(arr[0]);
        b = java.lang.Integer.parseInt(arr[2]);
        if(a < 0 || b < 0) {
            throw new NegativeNumber("Введено отрицательное число!\n");
        }
        sign = arr[1].charAt(0);

        // Выполнение операции (+, -, *, /, ^, %)
        result = switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if ((double) a / b == Double.POSITIVE_INFINITY) { //Infinity
                    throw new ArithmeticException("Ошибка: делить на ноль нельзя!\n");
                }
                yield (double) a / b;
            }
            case '^' -> Math.pow(a, b);
            case '%' -> a % b;
            default -> throw new SignException("Ошибка: знак " + sign + " не поддерживается!\n");
        };
        printResult(a, sign, b, result);
    }
    // печать результата
    public static void printResult(int a, char sign, int b, double result) {
        System.out.print(a + " " + sign + " " + b + " = ");
        System.out.printf((result % 1 > 0) ? ("%.3f%n") : ("%.0f%n"), result);
        System.out.println();
    }
}
