package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        // 1. Реверс значений массива
        reverse();

        // 2. Вычисление факториала
        calcFactorial();

        // 3. Удаление элементов массива
        // Очистка некоторых элементов массива
        deleteElements();

        // 4.  Вывод алфавита лесенкой
        outputAlphabetByLadder();

        // 5. Заполнение массива уникальными числами.
        fillUniqueNumbers();

        // 6. Виселица
        gameGallows();

        // 7. Вывод текста с эффектом пишущей машинки
        outputTextWithEffectTypewriter();
    }

    private static void reverse() {
        System.out.println("1. Реверс значений массива");
        int[] numbersForReverse = {1, 7, 4, 5, 2, 6, 3};
        System.out.printf("%17s", "До реверса: ");
        printArray(numbersForReverse);

        int length = numbersForReverse.length;
        for (int i = 0; i < numbersForReverse.length / 2; i++) {
            int temp = numbersForReverse[i];
            numbersForReverse[i] = numbersForReverse[--length];
            numbersForReverse[length] = temp;
        }
        System.out.printf("%17s", "После реверса: ");
        printArray(numbersForReverse);
    }

    private static void printArray(int[] array) {
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("]");
    }

    private static void calcFactorial() {
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

    private static void deleteElements() {
        System.out.println("\n3. Удаление элементов массива");
        double[] randomReals = new double[15];
        int length = randomReals.length;
        // Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        for (int i = 0; i < length; i++) {
            randomReals[i] = Math.random();
        }
        System.out.println("Исходный массив:");
        printRandomReals(randomReals);

        double numberMiddle = randomReals[length / 2];
        System.out.printf("\nЧисло из середины массива:   %,.3f \n", numberMiddle);
        int zeroElements = 0;
        for (int i = 0; i < length; i++) {
            if (randomReals[i] > numberMiddle) {
                zeroElements++;
            }
            randomReals[i] = randomReals[i] > numberMiddle ? 0.00 : randomReals[i];
        }
        System.out.println("\nИзмененный массив:");
        printRandomReals(randomReals);
        System.out.printf("\nОбнулили " + zeroElements + " элементов массива\n");
    }

    private static void printRandomReals(double[] randomReals) {
        int length = randomReals.length;
        int averageIndex = length / 2;
        for (int i = 0; i < length; i++) {
            if (i == averageIndex) {
                System.out.printf("  %,.3f\n", randomReals[i]);
            } else {
                System.out.printf("  %,.3f", randomReals[i]);
            }
        }
        System.out.println();
    }

    private static void outputAlphabetByLadder() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        int length = alphabet.length;
        // Инициализация массива
        for (int i = 0; i < length; i++) {
            alphabet[i] = (char) (65 + i);
        }
        // вывод лесенкой
        for (int i = 1; i <= length; i++) {
            for (int j = length - 1; j >= length - i; j--) {
                System.out.print(alphabet[j]);
            }
            System.out.println();
        }
    }

    private static void fillUniqueNumbers() {
        System.out.println("\n5. Заполнение массива уникальными числами");
        int[] uniqueNumbers = new int[30];
        int beginRange = 60;
        int endRange = 100;
        Random rnd = new Random();
        uniqueNumbers[0] = rnd.nextInt(beginRange, endRange);
        int newNumber = 0;
        for (int i = 1; i < uniqueNumbers.length; i++) {
            boolean isUnique = false;
            while (!isUnique) {
                newNumber = rnd.nextInt(beginRange, endRange);
                isUnique = true;
                for (int j = 0; j < i; j++) {
                    if (uniqueNumbers[j] == newNumber) {
                        isUnique = false;
                        break;
                    }
                }
            }
            uniqueNumbers[i] = newNumber;
        }
        // сортировка по возрастанию
        Arrays.sort(uniqueNumbers);
        int column = 0;
        for (int number : uniqueNumbers) {
            System.out.printf("  %d", number);
            column++;
            if (column == 10) {
                column = 0;
                System.out.println();
            }
        }
    }

    private static void gameGallows() {
        System.out.println("\n6. Виселица");
        String[] repository = {"ЕВРОПА", "ЛАНДЫШ", "ИГРОК", "ТАЙГА",
                "ГАДАЛКА", "БАБОЧКА", "МАРЦИПАН", "КАБЛУЧОК", "ЛАБИРИНТ",
                "ЛАБОРАНТ", "ПАВИЛЬОН", "МАТЕРИАЛ", "САКСОФОН"};

        // Для отображения виселицы использую массив текстовых блоков,
        // где каждый текстовый блок - это вариант изображения виселицы
        // первый вариант - просто столб, второй - столб с перекладиной и т.д.
        // всего 5 вариантов. Вид виселицы соответствует количеству попыток
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

        System.out.println("Начинаем игру \"Угадай слово\".");

        // Выбираю слово через случайную выборку
        Random randomNum = new Random();
        int number = randomNum.nextInt(repository.length);
        String guessingWord = repository[number];

        char[] guessingWordArray = guessingWord.toCharArray();
        char[] mask = guessingWordArray.clone();
        Arrays.fill(mask, '_');

        // Подготовка перед циклом
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        int counterUsedLetter = 0;
        int attempt = 5;
        char[] usedLetters = new char[33];

        do {
            printLetters(usedLetters, counterUsedLetter, mask);

            // Слово на экран
            for (char symbol : mask) {
                System.out.print(symbol + " ");
            }
            System.out.println();
            System.out.print("\nВведите букву:  ");
            char newLetter = scanner.next().charAt(0);
            newLetter = Character.toUpperCase(newLetter);

            // Если такая буква уже была, не добавляю в массив использованных букв
            // Если буква новая - вставляю в шаблон
            boolean found = false;
            int toIndex = counterUsedLetter + 1;
            if (searchLetter(usedLetters, newLetter, toIndex) == -1) {
                usedLetters[counterUsedLetter++] = newLetter;
                for (int i = 0; i < guessingWordArray.length; i++) {
                    if (guessingWordArray[i] == newLetter) {
                        found = true;
                        mask[i] = newLetter;
                    }
                }

                // Если букву угадала, количество попыток увеличиваю
                if (found) {
                    attempt = ((++attempt >= gallows.length) ? gallows.length : attempt);
                } else {
                    attempt--;
                    System.out.println(gallows[attempt] + "\n");
                    if (attempt > 0) {
                        System.out.println("У вас осталось " + attempt + "  попыток.");
                    } else {
                        System.out.println("У вас не осталось больше попыток.");
                    }
                }

                // Выхожу из цикла, если все буквы найдены или закончились попытки
                isPlaying = false;
                if (searchLetter(mask, '_', mask.length) == -1) {
                    System.out.println("\nВы отгадали слово - " + guessingWord + "!\n");
                } else if (attempt == 0) {
                    System.out.println("\nВы проиграли!");
                    System.out.println("Загаданное слово - " + guessingWord + "\n");
                } else {
                    isPlaying = true;
                }
            }
        } while (isPlaying);
    }

    private static void outputTextWithEffectTypewriter() {
        System.out.println("7. Вывод текста с эффектом пишущей машинки.");
        String text = "Java -- это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "-- James Gosling";
        try {
            typewriter(text);
            typewriter("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                    "-- Robert Martin");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int searchLetter(char[] array, char elementToSearch, int toIndex) {
        for (int i = 0; i < toIndex; i++) {
            if (array[i] == elementToSearch) {
                return i;
            }
        }
        return -1;
    }

    private static void printLetters(char[] array, int index, char[] mask) {
        if (index > 0) {
            System.out.print("\nВы использовали буквы: ");
        }
        for (int i = 0; i < index; i++) {
            if ((searchLetter(mask, array[i], mask.length) == -1)) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    private static void typewriter(String text) throws InterruptedException {
        // можно перечислить несколько разделителей, разделенных в свою очередь символом |
        // String[] words = text.split(" |\\,|\\.|\\\n|\\:|\\-");
        String[] words = text.split("\\p{P}|\\p{Z}");

        int indexLongWord = 0;
        int indexShortWord = 0;
        int lengthLongWord = words[0].length();
        int lengthShortWord = words[0].length();
        for (int i = 1; i < words.length; i++) {
            // Для проверки, что строка пустая или содержит только пробелы, используйте метод isBlank()
            if (!words[i].isBlank()) {
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
        // ищу индекс, с которого начинается само короткое слово,
        // оно может входить в состав других слов

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
            Thread.sleep(50);
        }
        System.out.println();
    }
}
