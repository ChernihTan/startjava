package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        // 1. Реверс значений массива
        reversalOfArrayValues();

        // 2. Вычисление факториала
        factorialCalculation();

        // 3. Удаление элементов массива
        // Очистка некоторых элементов массива
        changingSomeArrayElements();

        // 4.  Вывод алфавита лесенкой
        alphabetOutputByLadder();

        // 5. Заполнение массива уникальными числами.
        fillingArrayWithUniqueNumbers();

        // 6. Виселица
        gameGallows();

        // 7. Вывод текста с эффектом пишущей машинки
        System.out.println("7. Вывод текста с эффектом пишущей машинки.");
        String text = "Java -- это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "-- James Gosling";
        typewriter(text);
        typewriter("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "-- Robert Martin");
    }

    public static int searchLetterInArray(char[] array, char elementToSearch, int toIndex) {
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
        System.out.print("[ " + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("]");
    }

    public static void reversalOfArrayValues() {
        System.out.println("1. Реверс значений массива");
        int[] numbersForReverse = {1, 7, 4, 5, 2, 6, 3};
        System.out.printf("%17s", "До реверса: ");
        printArray(numbersForReverse);

        int length = numbersForReverse.length;
        int countIteration = length / 2;
        length--;
        for (int i = 0; i < countIteration; i++) {
            int temp = numbersForReverse[i];
            numbersForReverse[i] = numbersForReverse[length];
            numbersForReverse[length] = temp;
            length--;
        }
        System.out.printf("%17s", "После реверса: ");
        printArray(numbersForReverse);
    }

    public static void factorialCalculation() {
        System.out.println("\n2. Вычисление факториала");
        int[] multipliers = new int[10];
        int length = multipliers.length;
        for (int i = 0; i < length; i++) {
            multipliers[i] = i;
        }
        int factorial = 1;
        for (int i = 1; i <= length - 2; i++) {
            System.out.print((i == 1 ? "" : " * ") + multipliers[i]);
            factorial *= multipliers[i];
        }
        System.out.println(" = " + factorial);
    }

    public static void changingSomeArrayElements() {
        System.out.println("\n3. Удаление элементов массива");
        double[] randomReals = new double[15];
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        for (int i = 0; i < randomReals.length; i++) {
            randomReals[i] = Math.random();
        }
        printRandomReals(randomReals, false);
        printRandomReals(randomReals, true);
    }

    public static void printRandomReals(double[] randomReals, boolean isModifyArray) {
        int length = randomReals.length;
        int averageIndex = length / 2;
        double numberMiddle = randomReals[averageIndex];
        if (isModifyArray) {
            System.out.printf("\nЧисло из середины массива:   %,.3f \n", numberMiddle);
            System.out.println("\nИзмененный массив:");
        } else {
            System.out.println("Исходный массив:");
        }
        for (int i = 0; i < length; i++) {
            double realNumber = randomReals[i];
            if (isModifyArray) {
                realNumber = randomReals[i] > numberMiddle ? 0.00 : randomReals[i];
            }
            if (i == averageIndex) {
                System.out.printf("  %,.3f\n", realNumber);
            } else {
                System.out.printf("  %,.3f", realNumber);
            }
        }
        System.out.println();
    }

    public static void alphabetOutputByLadder() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        int length = alphabet.length;
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
    }

    // 5. Заполнение массива уникальными числами.
    public static void fillingArrayWithUniqueNumbers() {
        System.out.println("\n5. Заполнение массива уникальными числами");
        int[] uniqueIntegers = new int[30];
        int beginRange = 60;
        int endRange = 100;
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        // uniqueIntegers[0] = (int) (Math.random() * (endRange - beginRange)) + beginRange;
        Random randomNum = new Random();
        uniqueIntegers[0] = randomNum.nextInt(beginRange, endRange);
        int number = 0;
        for (int i = 1; i < uniqueIntegers.length; i++) {
            boolean isUnique = false;
            while (!isUnique) {
                // number = (int) (Math.random() * (endRange - beginRange)) + beginRange;
                number = randomNum.nextInt(beginRange, endRange);
                isUnique = true;
                for (int j = 0; j < i; j++) {
                    if (uniqueIntegers[j] == number) {
                        isUnique = false;
                        break;
                    }
                }
            }
            uniqueIntegers[i] = number;
        }
        // сортировка по возрастанию
        Arrays.sort(uniqueIntegers);
        int column = 0;
        for (int integer : uniqueIntegers) {
            System.out.printf("  %d", integer);
            column++;
            if (column == 10) {
                column = 0;
                System.out.println();
            }
        }
    }

    public static void gameGallows() {
        System.out.println("\n6. Виселица");
        String[] repository = {
                "ЕВРОПА", "ЛАНДЫШ", "ИГРОК", "ТАЙГА",
                "ГАДАЛКА", "БАБОЧКА", "МАРЦИПАН", "КАБЛУЧОК",
                "ЛАБИРИНТ", "ЛАБОРАНТ", "ПАВИЛЬОН", "МАТЕРИАЛ",
                "САКСОФОН"};

        System.out.println("Начинаем игру \"Угадай слово\".");
        // Выбираю слово через случайную выборку
        Random randomNum = new Random();
        int number = randomNum.nextInt(repository.length);
        String guessingWord = repository[number];  // выбранный вариант слова

        char[] guessingWordArray = guessingWord.toCharArray();  // слово по букавам
        char[] mask = guessingWordArray.clone();         // слово для отображения на экране
        Arrays.fill(mask, '_');

        // Слово на экран
        for (char symbol : mask) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // Подготовка перед циклом
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        int counterUsedLetter = 0;  // счетчик использованных букв
        int attempt = 5;   // попытки
        char[] usedLetters = new char[33];  // массив использованных букв

        do {
            printLetters(usedLetters, counterUsedLetter);
            System.out.print("Введите букву:  ");
            char newLetter = scanner.next().charAt(0);
            newLetter = Character.toUpperCase(newLetter);

            boolean found = false;
            // Если такая буква уже была, не добавляю в массив использованных букв
            int toIndex = counterUsedLetter + 1;
            // Буква, не введеная повторно
            if (searchLetterInArray(usedLetters, newLetter, toIndex) == -1) {
                usedLetters[counterUsedLetter++] = newLetter;
                // букву вставляем в шаблон
                for (int i = 0; i < guessingWordArray.length; i++) {
                    // Подмена
                    if (guessingWordArray[i] == newLetter) {
                        found = true;
                        mask[i] = newLetter;
                    }
                }
                // Если букву угадала, количество попыток увеличиваю
                if (found) {
                    attempt++;
                    attempt = Math.min(attempt, 5);
                } else {
                    attempt--;
                    printGallowsNew(attempt);  // Рисую виселицу
                }
                // Слово на экран
                for (char c : mask) {
                    System.out.print(c + " ");
                }
                System.out.println();
                System.out.println("У вас осталось " + attempt + "  попыток.");

                // Выхожу из цикла, если все буквы найдены или законсились попытки
                isPlaying = false;
                if (searchLetterInArray(mask, '_', mask.length) == -1) {
                    System.out.println("\nВы отгадали слово!");
                } else if (attempt == 0) {
                    System.out.println("\nВы проиграли!");
                    System.out.println("Загаданное слово - " + guessingWord + "\n");
                } else {
                    isPlaying = true;
                }
            }
        } while (isPlaying);
    }
}
