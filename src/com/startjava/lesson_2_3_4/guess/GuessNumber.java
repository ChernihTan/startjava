package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int COUNT_ATTEMPTS = 10;
    static final int COUNT_ROUNDS = 3;
    static final int COUNT_PLAYERS = 3;

    private final Player[] players;
    // Если объявляется конечная переменная, позже мы не сможете изменить или присвоить ей значения.
    // В случае объектов и массивов, если ссылочная переменная является окончательной,
    // она не может указывать на другой объект/массив, кроме как ссылаться на массив объектов-игроков

    private final Scanner scanner = new Scanner(System.in);
    private final Random rand = new Random();

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void start() {
        // очистка данных игроков перед следующей игрой
        for (Player player : players) {
            player.clear();
        }

        // перемешивание игроков перед началом игры :
        shufflePlayers();
        for (int round = 1; round <= COUNT_ROUNDS; round++) {
            System.out.println("\nРаунд - " + round);

            int guessedNum = guessNumber();
            System.out.println("Информация для меня - " + guessedNum);

            System.out.println("Игра началась! У каждого игрока по 10 попыток.");

            boolean guessedNumber = false;
            for (int attempt = 0; attempt < COUNT_ATTEMPTS; attempt++) {
                for (Player player : players) {
                    if (processSingleGuess(player, attempt, guessedNum)) {
                        guessedNumber = true;
                        break;
                    }
                }
                if (guessedNumber) {
                    break;
                }
            }
        }
        determineWinner();

        // Вывожу все, названные игроками числа, с выводом имен игроков
        printNumbersNamedPlayers();
    }

    private void shufflePlayers() {
        // случайный индекс (из 0,1,2) на последнее место, следующий случайный индекс (из 0,1)
        // на предпоследнее место
        int length = players.length;
        for (int i = length - 1; i > 0; i--) {            //
            int randomNum = rand.nextInt(i);
            Player swap = players[i];                                    // меняю местами элементы
            players[i] = players[randomNum];
            players[randomNum] = swap;
        }
        System.out.print("Игру начинают игроки в порядке очереди: ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(players[i].getName() + ", ");
        }
        System.out.println(players[length - 1].getName());
    }

    private int guessNumber() {
        return rand.nextInt(Player.LOWER_RANGE, Player.UPPER_RANGE);
    }

    private boolean processSingleGuess(Player player, int attempt, int guessedNum) {
        // обработка одного хода игрока - одного отгадывания:
        // игрок называет число от 1 до 100 (c проверкой),
        // сверка с задуманным,
        // добавление в массив названных игроком чисел, а если угадал число,
        // добавление к количеству побед в раундах и
        // возвращение true, если на данном ходе отдадано число

        int enteredNum = inputNumber(player);

        if (enteredNum == guessedNum) {
            System.out.println("Игрок " + player.getName() + " угадал " + guessedNum +
                    " с " + ++attempt + " попытки");
            // фиксируем выигрыш у победителя раунда
            player.increaseWinsCount();
            return true;
        } else {
            System.out.println("Число " + enteredNum +
                    (enteredNum < guessedNum ? " меньше" : " больше") + " загаданного");
            if (attempt == COUNT_ATTEMPTS - 1) {
                System.out.println("У " + player.getName() + " закончились попытки");
            }
        }
        return false;
    }

    private int inputNumber(Player player) {
        boolean correctInput = false;
        int enteredNum = 0;
        do {
            try {
                System.out.print("Игрок " + player.getName() + ": ");
                enteredNum = Integer.parseInt(scanner.nextLine());
                // сохраняем названное игроком число в данных игрока
                correctInput = player.addNumber(enteredNum);
                if (!correctInput) {
                    System.out.println("Вводимое целое число должно быть в интервале [1:100], " +
                            "делайте попытку еще");
                }
            } catch (NumberFormatException e) {
                System.out.println("Несоответствующий формат ввода целого числа, " +
                        "делайте попытку еще");
            }
        } while (!correctInput);
        return enteredNum;
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

