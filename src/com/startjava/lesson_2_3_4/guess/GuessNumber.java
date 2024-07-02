package com.startjava.lesson_2_3_4.guess;

// import java.util.InputMismatchException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    final static int COUNT_ATTEMPTS = 4;
    final static int COUNT_ROUNDS = 3;
    final int COUNT_PLAYERS = 3;

    private final Player[] players;
    // Если объявляется конечная переменная, позже мы не сможете изменить или присвоить ей значения.
    // В случае объектов и массивов, если ссылочная переменная является окончательной,
    // она не может указывать на другой объект/массив, кроме как ссылаться на массив объектов-игроков

    int[] namedNumbers = new int[COUNT_ATTEMPTS * COUNT_PLAYERS * COUNT_ROUNDS];
    // все попытки за все раунды, сквозная нумерация
    private int currentAttempt;

    // конструктор класса
    public GuessNumber(Player[] players) {
        this.players = players;
    }

    // сама игра
    public void start() {
        // чищу данные игроков перед следующей игрой
        for (Player player : players) {
            player.clear();
        }
        // Чищу общий массив названных чисел всеми игроками (вне задания)
        Arrays.fill(namedNumbers, 0, currentAttempt, 0);
        currentAttempt = 0;
        // Количество раунтов - 3
        // тасуем игроков перед началом игры :
        shufflePlayers(players);
        for (int round = 1; round <= COUNT_ROUNDS; round++) {
            System.out.println("\nРаунд - " + round);
            // Загадываем число:
            int guessedNum = guessNumber();
            System.out.println("Информация для меня - " + guessedNum);

            System.out.println("Игра началась! У каждого игрока по 10 попыток.");
            int enteredNum = 0;
            try {
                for (int attempt = 0; attempt < COUNT_ATTEMPTS; attempt++) {
                    for (Player player : players) {
                        enteredNum = processSingleGuess(player, attempt, guessedNum);
                        // фиксируем очередное введенное число (вне задания)
                        namedNumbers[currentAttempt++] = enteredNum;
                    }
                }
            } catch (FinishRoundException e) {
                System.out.println(e.getMessage() + round);
                // фиксируем очередное введенное число (вне задания)
                namedNumbers[currentAttempt++] = enteredNum;
            }
        }
        determineWinner(players);
        // выводим все названные числа (вне задания)
        printResult(currentAttempt, namedNumbers);
        // Вывожу все, названные игроками числа, сначала от одного игрока, потом от следующего
        printResultNew(players);
        // Вывожу все, названные игроками числа, с выводом имен игроков
        printResultNew2(players);
    }

    private int guessNumber() {
        // Загадываем число:
        Random rand = new Random();
        // rand.nextInt(100);  // [0...99] [min = 0, max = 99]
        return rand.nextInt(100) + 1;
    }

    private void shufflePlayers(Player[] players) {
        // случайный индекс (из 0,1,2) на последнее место, следующий случайный индекс (из 0,1)
        // на предпоследнее место
        Player temp;
        int length = players.length;
        Random rand = new Random();
        int randomNum;
        // new Random().nextInt(3);  // [0...2] [min = 0, max = 2]
        for (int j = length - 1; j > 0; j--) {            //
            randomNum = rand.nextInt(j);
            temp = players[j];                                    // меняю местами элементы
            players[j] = players[randomNum];
            players[randomNum] = temp;
        }
        System.out.print("Игру начинают игроки в порядке очереди: ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(players[i].getName() + ", ");
        }
        System.out.println(players[length - 1].getName());
    }

    private int processSingleGuess(Player player, int attempt, int guessedNum) throws NumberFormatException {
        // обработка одного хода игрока - одного отгадывания:
        // игрок называет число от 1 до 100 (проверка), сверяем с задуманным,
        // добавляем в массив названных игроком чисел, а если угадал число,
        // добавляем к количеству побед в раундах и
        // генерируем событие - конец раунда

        // жду только правильного ввода - yes/no
        int enteredNum = playerInputWithCheck(player);

        if (enteredNum == guessedNum) {
            System.out.println("Игрок " + player.getName() + " угадал " + guessedNum +
                    " с " + ++attempt + " попытки");
            // фиксируем выигрыш у победителя раунда
            player.increaseWinsCount();
            // генерирую исключение
            String text = "Закончился раунд ";
            throw new FinishRoundException(text);
        } else {
            System.out.println("Число " + enteredNum +
                    (enteredNum < guessedNum ? " меньше" : " больше") + " загаданного");
        }
        if (attempt == COUNT_ATTEMPTS - 1) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        return enteredNum;
    }

    private int playerInputWithCheck(Player player) {
        boolean incorrectInput = true;
        int enteredNum = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Игрок " + player.getName() + ": ");
                enteredNum = Integer.parseInt(scanner.nextLine()); // scanner.nextInt();
                // сохраняем названное игроком число в данных игрока
                incorrectInput = player.addNumber(enteredNum);
            } catch (NumberFormatException e) {
                System.out.println("Несоответствующий формат ввода целого числа, " +
                        "делайте попытку еще");
            }
        } while (incorrectInput);
        return enteredNum;
    }

    private void determineWinner(Player[] players) {
        int max = players[0].getWinsCount();
        int min = players[0].getWinsCount();
        for (int i = 1; i < players.length; i++) {
            // max = (players[i].getWinsCount() > max ? players[i].getWinsCount() : max);
            max = Math.max(players[i].getWinsCount(), max);
            // min = (players[i].getWinsCount() < min ? players[i].getWinsCount() : min);
            min = Math.min(players[i].getWinsCount(), min);
        }
        if (max == min) {
            System.out.println("Победила дружба!");
        } else {
            int winnerCount = 0;
            // for (int j = 0; j < players.length; j++) {
            for (Player player : players) {
                if (player.getWinsCount() == max) {
                    winnerCount++;
                    System.out.println(winnerCount > 1 ? ",и победил " : "Победил " + player.getName());
                }
            }
        }
    }

    public void printResult(int attemptCount, int[] numbers) {
        System.out.println("Все названные числа (вне задания):");
        int half = (int) Math.ceil((float) attemptCount / 2) - 1;
        for (int i = 0; i < attemptCount; i++) {
            System.out.printf((i == half) ? "%2d\n" : "%2d ", numbers[i]);
        }
        System.out.println();
    }

    public void printResultNew(Player[] players) {

        // определяю длину общего массива
        int length = 0;
        for (Player player : players) {
            length += player.getAttempt();
        }
        // Создаю массив из названных игроками цифр
        int[] numbersToPrint = new int[length];
        // Заполняю итоговый массиы с названными числами всеми игроками
        int quantity;
        int begin = 0;
        for (Player player : players) {
            quantity = player.getAttempt();
            System.arraycopy(player.getNumbers(), 0, numbersToPrint, begin, quantity);
            begin += quantity;
        }
        System.out.println("Все числа, названные игроками:");
        int half = (int) Math.ceil((float) length / 2) - 1;
        for (int i = 0; i < length; i++) {
            System.out.printf((i == half) ? "%2d\n" : "%2d ", numbersToPrint[i]);
        }
        System.out.println();
    }

    public void printResultNew2(Player[] players) {
        int length;
        for (Player player : players) {
            System.out.print("Числа, названные игроком " + player.getName() + " в ходе игры: \n");
            int[] numbersToPrint = player.getNumbers();
            length = numbersToPrint.length;
            int half = (int) Math.ceil((float) length / 2) - 1;
            for (int i = 0; i < length; i++) {
                System.out.printf((i == half) ? "%2d\n" : "%2d ", numbersToPrint[i]);
            }
            System.out.println();
        }
    }
}

