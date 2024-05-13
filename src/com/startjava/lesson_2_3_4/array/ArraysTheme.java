package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        // 1. Реверс значений массива
        System.out.println("1. Реверс значений массива");
        int[] sourceArray = new int[]{1, 7, 4, 5, 2, 6, 3};
        int[] reversingArray = new int[sourceArray.length];
        int k = 0;
        for (int i = sourceArray.length - 1; i >= 0; i--) {
            reversingArray[k] = sourceArray[i];
            k++;
        }
        System.out.printf("%17s", "До реверса: [");
        System.out.print(sourceArray[0]);
        for (int i = 1; i < sourceArray.length; i++) {
            System.out.print(", " + sourceArray[i]);
        }
        System.out.println("]");
        System.out.printf("%17s", "После реверса: [");
        System.out.print(reversingArray[0]);
        for (int i = 1; i < reversingArray.length; i++) {
            System.out.print(", " + reversingArray[i]);
        }
        System.out.println("]");

        // 2. Вычисление факториала
        System.out.println("\n2. Вычисление факториала");
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        int factorial = 1;
        for (int i = 1; i <= 8; i++) {
            System.out.print((i == 1) ? numbers[i] : (" * " + numbers[i]));
            factorial *= numbers[i];
        }
        System.out.println(" = " + factorial);

        // 3. Удаление элементов массива **************************************
        System.out.println("\n3. Удаление элементов массива");
        double[] realNumbers = new double[15];
        // int averageIndex = realNumbers.length / 2;
        // double[] modifyRealNumbers = new double[15];
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        for (int i = 0; i < realNumbers.length; i++) {
            realNumbers[i] = Math.random();
        }
        System.out.println("Печать исходного массива:");
        for (int i = 0; i < realNumbers.length; i++) {
            if (i == 7) {
                System.out.printf("  %,.3f\n", realNumbers[i]);
            } else {
                System.out.printf("  %,.3f", realNumbers[i]);
            }
        }
        System.out.println();
        int averageIndex = realNumbers.length / 2;
        double[] modifyRealNumbers = new double[15];
        double numberMiddle = realNumbers[averageIndex];
        System.out.printf("Число из середины массива:   %,.3f \n", numberMiddle);
        // Измененный массив
        for (int i = 0; i < realNumbers.length; i++) {
            modifyRealNumbers[i] = ((realNumbers[i] > numberMiddle) ? 0.00 : realNumbers[i]);
        }
        System.out.println("Печать измененного массива:");
        for (int i = 0; i < modifyRealNumbers.length; i++) {
            if (i == 7) {
                System.out.printf("  %,.3f\n", modifyRealNumbers[i]);
            } else {
                System.out.printf("  %,.3f", modifyRealNumbers[i]);
            }
        }

        // 4. Вывод алфавита лесенкой *************************************
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 1; i <= alphabet.length; i++) {
            for (int j = alphabet.length - 1; j >= alphabet.length - i; j--) {
                System.out.printf("%c", alphabet[j]);
            }
            System.out.println();
        }

        // 5. Заполнение массива уникальными числами.
        System.out.println("\n5. Заполнение массива уникальными числами");
        int[] integers = new int[30];
        int a = 60;
        int b = 100;
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        integers[0] = (int) (Math.random() * (b - a)) + a;
        for (int i = 1; i < integers.length; i++) {
            boolean looking = true; // Ищу
            while (looking) {
                int number = (int) (Math.random() * (b - a)) + a;
                looking = false;
                integers[i] = number;
                for (int j = 0; j < i; j++) {
                    if (integers[j] == number) {
                        looking = true;  // Ищу
                        break;
                    }
                }
            }
        }
        // сортировка по возрастанию
        Arrays.sort(integers);
        for (int integer : integers) {
            System.out.printf("  %d", integer);
        }

        // 6. Виселица ***********************************.
        System.out.println("\n6. Виселица");
        String[] repository = {"МАРЦИПАН", "КАБЛУЧОК", "ЛАБИРИНТ", "ЛАБОРАНТ",
                "ПАВИЛЬОН", "МАТЕРИАЛ", "САКСОФОН"};
        System.out.println("Начинаем игру \"Угадай слово\".");
        // Выбираю слово
        Random randomNum = new Random();
        int number = randomNum.nextInt(repository.length);
        String variantWord = repository[number];
        char[] word = variantWord.toCharArray();
        char[] wordScreen = word.clone();
        Arrays.fill(wordScreen, '_');

        // Слово на экран
        for (char symbol : wordScreen) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        int index3 = 0;
        int attempt = 5;   // попытки
        char[] usedLetters = new char[33];
        // Цикл, пока isPlaying = true
        do {
            printArray(usedLetters, index3);
            System.out.print("Введите букву:  ");
            char newChar = scanner.next().charAt(0);
            newChar = Character.toUpperCase(newChar);

            boolean found = false;
            // Если такая буква уже была, не добавляю в массив использованных букв
            int toIndex = index3 + 1;
            // Буква, не введеная повторно
            if (linearSearch(usedLetters, newChar, toIndex) == -1) {
                usedLetters[index3++] = newChar;
                // букву вставляем в шаблон
                for (int i = 0; i < word.length; i++) {
                    // Подмена
                    if (word[i] == newChar) {
                        found = true;
                        wordScreen[i] = newChar;
                    }
                }
                // Если букву угадала, количество попыток увеличиваю
                if (found) {
                    attempt++;
                    // attempt = ((attempt >= 5) ? 5 : attempt);
                    attempt = Math.min(attempt, 5);
                } else {
                    attempt--;
                    gallows(attempt);  // Рисую виселицу
                }
                // Слово на экран
                for (char c : wordScreen) {
                    System.out.print(c + " ");
                }
                System.out.println();
                // Если количество попыток еще осталось и есть "_", то не все буквы найдены
                if (linearSearch(wordScreen, '_', wordScreen.length) == -1) {
                    System.out.println("\nВы отгадали слово");
                    isPlaying = false;
                } else if (attempt == 0) {
                    isPlaying = false;
                    System.out.println("\nВы проиграли");
                }
            }
        } while (isPlaying);

        // 7. Вывод текста с эффектом пишущей машинки ******************************
        System.out.println("7. Вывод текста с эффектом пишущей машинки.");
        String text = "Java -- это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "-- James Gosling";
        typewriter(text);
        typewriter("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "-- Robert Martin");
    }

    public static int linearSearch(char[] array, char elementToSearch, int toIndex) {
        for (int i = 0; i < toIndex; i++) {
            if (array[i] == elementToSearch) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(char[] array, int index) {
        if (index > 0) {
            System.out.print("\nВы использовали буквы: ");
        }
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void gallows(int version) {
        switch (version) {
            case 4:
                System.out.println("""
                            |
                            |
                            |
                            |
                            |
                        """);
                break;
            case 3:
                System.out.println("""
                            |--------
                            |/
                            |
                            |
                            |
                        """);
                break;
            case 2:
                System.out.println("""
                            |--------
                            |/      |
                            |
                            |  
                            |     
                        """);
                break;
            case 1:
                System.out.println("""
                            |--------
                            |/      |
                            |       @
                            |
                            |      
                        """);
                break;
            case 0:
                System.out.println("""
                            |--------
                            |/      |
                            |       O
                            |      /0\\
                            |       /\\
                        """);
                break;
            default:
                // default statements
                System.out.println("Ничего не рисую!");
        }
    }

    public static void typewriter(String text) throws InterruptedException {
        // можно перечислить несколько разделителей, разделенных в свою очередь символом |
        String[] words = text.split(" |\\,|\\.|\\\n"); // Разделения строки text с помощью метода split()
        int indexLongWord = 0;
        int indexShortWord = 0;
        int lengthLongWord = words[0].length();
        int lengthShortWord = words[0].length();
        for (int i = 1; i < words.length; i++) {
            // Для проверки, что строка пустая или содержит только пробелы, используйте метод isBlank()
            if (!words[i].isBlank()) { // words[i].length() != 0
                if (words[i].length() > lengthLongWord) {
                    lengthLongWord = words[i].length();
                    indexLongWord = i;
                }
                if (words[i].length() < lengthShortWord) {
                    lengthShortWord = words[i].length();
                    indexShortWord = i;
                }
            }
        }
        char[] letters = text.toCharArray();
        // ищу индекс, с которого начинается короткое слово, оно может входить в состав других слов
        // само короткое слово
        String shortWord = words[indexShortWord];
        int indexSortInText;
        int indexLongInText;
        int indexSeparator;
        int indexSeparator1;
        // определяю место в тексте
        boolean lookingFor = true;
        int intFrom = 0;
        do {
            // Символ сразу после короткого слова должен быть разделителем
            // и символ перед коротким словом должен быть разделителем
            indexSortInText = text.indexOf(shortWord, intFrom);
            indexSeparator = indexSortInText + lengthShortWord;
            indexSeparator1 = indexSortInText - 1;
            if ((letters[indexSeparator] == ' ' || letters[indexSeparator] == ',' ||
                    letters[indexSeparator] == '.') &&
                    (letters[indexSeparator1] == ' ' || letters[indexSeparator1] == ',' ||
                            letters[indexSeparator1] == '.')) {
                lookingFor = false;
            } else {
                intFrom = indexSeparator;
            }
        } while (lookingFor);
        indexLongInText = text.indexOf(words[indexLongWord]);

        // Какое слово раньше - самое длинное или самое которкое
        int indexBegin;
        int indexEnd;
        if (indexLongWord < indexShortWord) {
            indexBegin = indexLongInText;
            indexEnd = indexSortInText + lengthShortWord - 1;
        } else {
            indexBegin = indexSortInText;
            indexEnd = indexLongInText + lengthLongWord - 1;
        }
        // перевожу часть букв в заглавные
        for (int i = indexBegin; i <= indexEnd; i++) {
            letters[i] = Character.toUpperCase(letters[i]);
        }
        for (char letter : letters) {
            System.out.print(letter);
            Thread.sleep(100);
        }
        System.out.println();
    }
}
