package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        // 1. Реверс значений массива
        System.out.println("1. Реверс значений массива");
        int[] sourceArray = {1, 7, 4, 5, 2, 6, 3};
        System.out.printf("%17s", "До реверса: [");
        printArray(sourceArray);
        System.out.println("]");

        int length = sourceArray.length;
        int countIteration = length / 2;
        int temp;
        for (int i = 0; i < countIteration; i++) {
            temp = sourceArray[i];
            sourceArray[i] = sourceArray[length - i - 1];
            sourceArray[length - i - 1] = temp;
        }
        System.out.printf("%17s", "После реверса: [");
        printArray(sourceArray);
        System.out.println("]");

        // 2. Вычисление факториала
        System.out.println("\n2. Вычисление факториала");
        int indexStart = 0;
        int indexEnd = 9;
        int[] multipliers = new int[indexEnd - indexStart + 1];
        for (int i = indexStart; i <= indexEnd; i++) {
            multipliers[i] = i;
        }
        int factorial = 1;
        for (int i = 1; i <= indexEnd - 1; i++) {
            System.out.print((i == 1 ? "" : " * ") + multipliers[i]);
            factorial *= multipliers[i];
        }
        System.out.println(" = " + factorial);

        // 3. У д а л е н и е  э л е м е н т о в  м а с с и в а
        System.out.println("\n3. Удаление элементов массива");
        double[] realRandomNumbers = new double[15];
        length = realRandomNumbers.length;
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        for (int i = 0; i < length; i++) {
            realRandomNumbers[i] = Math.random();
        }
        System.out.println("Исходный массив:");
        int averageIndex = length / 2;
        for (int i = 0; i < length; i++) {
            if (i == averageIndex) {
                System.out.printf("  %,.3f\n", realRandomNumbers[i]);
            } else {
                System.out.printf("  %,.3f", realRandomNumbers[i]);
            }
        }
        System.out.println();
        double numberMiddle = realRandomNumbers[averageIndex];
        System.out.printf("Число из середины массива:   %,.3f \n", numberMiddle);
        // Измененный массив
        System.out.println("Измененный массив:");
        for (int i = 0; i < length; i++) {
            double realNumber = realRandomNumbers[i] > numberMiddle ? 0.00 : realRandomNumbers[i];
            if (i == averageIndex) {
                System.out.printf("  %,.3f\n", realNumber);
            } else {
                System.out.printf("  %,.3f", realNumber);
            }
        }

        // 4. В ы в о д   а л ф а в и т а   л е с е н к о й
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        length = alphabet.length;
        // Инициализацияи массива
        for (int i = 0; i < length; i++) {
            alphabet[i] = (char) (65 + i);
        }
        // вывод лесенкой
        for (int i = 1; i <= length; i++) {
            for (int j = length - 1; j >= length - i; j--) {
                System.out.printf("%c", alphabet[j]);
            }
            System.out.println();
        }

        // 5. Заполнение массива уникальными числами.
        System.out.println("\n5. Заполнение массива уникальными числами");
        int[] uniqueIntegers = new int[30];
        int rangeBegin = 60;
        int rangeEnd = 100;
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        uniqueIntegers[0] = (int) (Math.random() * (rangeEnd - rangeBegin)) + rangeBegin;
        int number = 0;
        for (int i = 1; i < uniqueIntegers.length; i++) {
            boolean isUnique = false; // не уникально, продолжаю искать
            while (!isUnique) {
                number = (int) (Math.random() * (rangeEnd - rangeBegin)) + rangeBegin;
                isUnique = true;
                for (int j = 0; j < i; j++) {
                    if (uniqueIntegers[j] == number) {
                        isUnique = false;  // не уникальное, продолжаю искать
                        break;
                    }
                }
            }
            uniqueIntegers[i] = number;
        }
        // сортировка по возрастанию
        Arrays.sort(uniqueIntegers);
        for (int integer : uniqueIntegers) {
            System.out.printf("  %d", integer);
        }

        // 6. Виселица
        System.out.println("\n6. Виселица");
        String[] repository = {"ЕВРОПА", "ЛАНДЫШ", "ИГРОК", "ТАЙГА",
                "ГАДАЛКА", "БАБОЧКА",
                "МАРЦИПАН", "КАБЛУЧОК", "ЛАБИРИНТ", "ЛАБОРАНТ",
                "ПАВИЛЬОН", "МАТЕРИАЛ", "САКСОФОН"};

        System.out.println("Начинаем игру \"Угадай слово\".");
        // Выбираю слово через случайную выборку
        Random randomNum = new Random();
        number = randomNum.nextInt(repository.length);
        String variantWord = repository[number];  // выбранный вариант слова

        char[] word = variantWord.toCharArray();  // слово по букавам
        char[] wordScreen = word.clone();         // слово для отображения на экране
        Arrays.fill(wordScreen, '_');

        // Слово на экран
        for (char symbol : wordScreen) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // Подготовка перед циклом
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        int counterUsedLetter = 0;  // счетчик использованных букв
        int attempt = 5;   // попытки
        char[] usedLetters = new char[33];  // массив использованных букв

        // Цикл, пока isPlaying = true
        do {
            printLetters(usedLetters, counterUsedLetter);
            System.out.print("Введите букву:  ");
            char newChar = scanner.next().charAt(0);
            newChar = Character.toUpperCase(newChar);

            boolean found = false;
            // Если такая буква уже была, не добавляю в массив использованных букв
            int toIndex = counterUsedLetter + 1;
            // Буква, не введеная повторно
            if (linearSearch(usedLetters, newChar, toIndex) == -1) {
                usedLetters[counterUsedLetter++] = newChar;
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
                    printGallowsNew(attempt);  // Рисую виселицу
                }
                // Слово на экран
                for (char c : wordScreen) {
                    System.out.print(c + " ");
                }
                System.out.println();
                // Если количество попыток еще осталось и есть "_", то не все буквы найдены
                if (linearSearch(wordScreen, '_', wordScreen.length) == -1) {
                    System.out.println("\nВы отгадали слово!");
                    isPlaying = false;
                } else if (attempt == 0) {
                    isPlaying = false;
                    System.out.println("\nВы проиграли!");
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

    public static void printLetters(char[] array, int index) {
        if (index > 0) {
            System.out.print("\nВы использовали буквы: ");
        }
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printGallowsNew(int version) {
        // печать виселицы
        String[] gallows = {
                """
                            |--------
                            |/      |
                            |       O
                            |      /0\\
                            |       /\\""",
                """
                            |--------
                            |/      |
                            |       @
                            |
                            |""",
                """
                            |--------
                            |/      |
                            |
                            |
                            |""",
                """
                            |--------
                            |/
                            |
                            |
                            |""",
                """
                            |
                            |
                            |
                            |
                            |"""
        };
        System.out.println(gallows[version] + "\n");
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

    public static void printArray(int[] array) {
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
    }
}
