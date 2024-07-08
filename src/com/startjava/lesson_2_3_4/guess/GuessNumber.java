package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int COUNT_ATTEMPTS = 10;
    static final int COUNT_ROUNDS = 3;
    static final int COUNT_PLAYERS = 3;

    // Если объявляется конечная переменная, позже мы не сможете изменить или присвоить ей значения.
    // В случае объектов и массивов, если ссылочная переменная является окончательной,
    // она не может указывать на другой объект/массив, кроме как ссылаться на массив объектов-игроков
    private final Player[] players;

    private final Scanner scanner = new Scanner(System.in);
    private final Random rand = new Random();

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void start() {
        clearDataPlayers();
        shufflePlayers();
        for (int round = 1; round <= COUNT_ROUNDS; round++) {
            System.out.println("\nРаунд - " + round);

            int guessedNumber = guessNumber();
            System.out.println("Информация для меня - " + guessedNumber);

            System.out.println("Игра началась! У каждого игрока по " + COUNT_ATTEMPTS + " попыток.");

            boolean isGuessedNumber = false;
            for (int attempt = 0; attempt < COUNT_ATTEMPTS; attempt++) {
                for (Player player : players) {
                    if (isGuessed(player, attempt, guessedNumber)) {
                        isGuessedNumber = true;
                        break;
                    }
                }
                if (isGuessedNumber) {
                    break;
                }
            }
        }
        determineWinner();
        printNumbersNamedPlayers();
    }

    // очистка данных игроков перед следующей игрой
    private void clearDataPlayers() {
        for (Player player : players) {
            player.clear();
        }
    }

    // перемешивание игроков перед началом игры
    private void shufflePlayers() {
        // случайный индекс (из 0,1,2) на последнее место, следующий случайный индекс (из 0,1)
        // на предпоследнее место
        int length = players.length;
        for (int i = length - 1; i > 0; i--) {
            int randomNumber = rand.nextInt(i);

            // меняю местами элементы
            Player swap = players[i];
            players[i] = players[randomNumber];
            players[randomNumber] = swap;
        }
        System.out.print("Игру начинают игроки в порядке очереди: ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(players[i].getName() + ", ");
        }
        System.out.println(players[length - 1].getName());
    }

    private int guessNumber() {
        return rand.nextInt(Player.LOWER_RANGE, Player.UPPER_RANGE + 1);
    }

    // обработка одного хода игрока - одного отгадывания:
    // игрок называет число от 1 до 100 (c проверкой),
    // сверка с задуманным,
    // добавление в массив названных игроком чисел, а если угадал число,
    // добавление к количеству побед в раундах и
    // возвращение true, если на данном ходе отгадано число
    private boolean isGuessed(Player player, int attempt, int guessedNumber) {
        int enteredNumber = inputNumber(player);

        if (enteredNumber == guessedNumber) {
            System.out.println("Игрок " + player.getName() + " угадал " + guessedNumber +
                    " с " + ++attempt + " попытки");

            // фиксируем выигрыш у победителя раунда
            player.increaseWinsCount();
            return true;
        }
        checkNumberPlayer(player, attempt, guessedNumber, enteredNumber);
        return false;
    }

    private void checkNumberPlayer(Player player, int attempt, int guessedNumber, int enteredNumber) {
        System.out.println("Число " + enteredNumber +
                (enteredNumber < guessedNumber ? " меньше" : " больше") + " загаданного");
        if (attempt == COUNT_ATTEMPTS - 1) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private int inputNumber(Player player) {
        boolean correctInput = false;
        int enteredNumber = 0;
        do {
            try {
                System.out.print("Игрок " + player.getName() + ": ");
                enteredNumber = Integer.parseInt(scanner.nextLine());

                // сохраняем названное игроком число в данных игрока
                correctInput = player.addNumber(enteredNumber);
                if (!correctInput) {
                    System.out.println("Вводимое целое число должно быть в интервале [" +
                            Player.LOWER_RANGE + ":" + Player.UPPER_RANGE + "], " +
                            "делайте попытку еще");
                }
            } catch (NumberFormatException e) {
                System.out.println("Несоответствующий формат ввода целого числа, " +
                        "делайте попытку еще");
            }
        } while (!correctInput);
        return enteredNumber;
    }

    private void determineWinner() {
        int max = players[0].getWinsCount();
        int min = players[0].getWinsCount();
        for (int i = 1; i < players.length; i++) {
            max = Math.max(players[i].getWinsCount(), max);
            min = Math.min(players[i].getWinsCount(), min);
        }
        if (max == min) {
            System.out.println("Победила дружба!");
        } else {
            int winnerCount = 0;
            for (Player player : players) {
                if (player.getWinsCount() == max) {
                    winnerCount++;
                    System.out.println(winnerCount > 1 ? ",и победил " : "Победил " + player.getName());
                }
            }
        }
    }

    // Вывод всех названных игроками чисел, с выводом имен игроков
    public void printNumbersNamedPlayers() {
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

