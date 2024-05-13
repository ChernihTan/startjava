package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
// import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int COUNT_ATTEMPTS_CONSTANT = 10;
    static final int COUNT_ROUNDS_CONSTANT = 5; // 3;
    static final int COUNT_PLAYERS_CONSTANT = 3;

    private String namePlayer1;
    private String namePlayer2;
    private String namePlayer3;
    Player[] players = new Player[COUNT_PLAYERS_CONSTANT];
    int[] namedNumbers = new int[COUNT_ATTEMPTS_CONSTANT * COUNT_PLAYERS_CONSTANT];
    int currentAttempt = 0;

    // конструктор класса
    public GuessNumber(String namePlayer1, String namePlayer2, String namePlayer3) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
        this.namePlayer3 = namePlayer3;
        // создаю игроков
        players[0] = new Player(namePlayer1);
        players[1] = new Player(namePlayer2);
        players[2] = new Player(namePlayer3);
    }

    // сама игра
    public void start() {
        // Количество раунтов - 3
        for (int i = 1; i <= COUNT_ROUNDS_CONSTANT; i++) {
            // тасуем игроков перед каждым раундом :
            // случайный индекс (из 0,1,2) на последнее место, следующий случайный индекс (из 0,1)
            // на предпоследнее место
            Player temp;
            Random rand = new Random();
            int randomNum;
            // new Random().nextInt(3);  // [0...2] [min = 0, max = 2]
            for (int j = players.length - 1; j > 0; j--) {            //
                randomNum = rand.nextInt(j);
                temp = players[j];                                    // меняю местами элементы
                players[j] = players[randomNum];
                players[randomNum] = temp;
            }
            System.out.print("Раунд № " + i + " начинают игроки в порядке очереди: ");
            System.out.println(players[0].getName() + ", " + players[1].getName() + " и " +
                    players[2].getName());

            // Загадываем число:
            // rand.nextInt(100);  // [0...99] [min = 0, max = 99]
            int guessedNum = rand.nextInt(100) + 1;
            System.out.println(guessedNum);

            System.out.println("Игра началась! У каждого игрока по 10 попыток.");
            Scanner scanner = new Scanner(System.in);
            int enteredNum = -1;
            currentAttempt = 0;
            try {
                for (int j = 0; j < COUNT_ATTEMPTS_CONSTANT; j++) {
                    for (int k = 0; k < players.length; k++) {
                        // жду только правильного ввода - yes/no
                        boolean incorrectInput = true;
                        do {
                            try {
                                System.out.print("Игрок " + players[k].getName() + ": ");
                                enteredNum = Integer.parseInt(scanner.nextLine()); // scanner.nextInt();
                                if ((enteredNum > 0) && (enteredNum <= 100)) {
                                    incorrectInput = false;
                                } else {
                                    System.out.println("Вводимое целое число должно между 0 и 100, " +
                                            "делайте попытку еще");
                                    // System.out.print("Игрок " + players[k].getName() + "еще раз: ")
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Несоответствующий формат ввода целого числа, " +
                                        "делайте попытку еще");
                                // System.out.print("Игрок " + players[k].getName() + ": ")
                            }
                        } while (incorrectInput);

                        // сохраняем данные попытки по игроку
                        players[k].setNumber(j, enteredNum);
                        players[k].setAttempt(j + 1);
                        // фиксируем очередное введенное число
                        namedNumbers[currentAttempt++] = enteredNum;
                        if (enteredNum == guessedNum) {
                            System.out.println("Игрок " + players[k].getName() + " угадал " + guessedNum +
                                    " с " + ++j + " попытки");
                            // выводим все названные числа
                            printResult(currentAttempt, namedNumbers);
                            // фиксируем выигрыш у победителя раунда
                            players[k].addWinsCount();
                            // Печать после окончания очередного раунда по проигравшим игрокам
                            printAfterRound(k);
                            // генерирую исключение
                            String text = "Закончился раунд " + i; // String.valueOf(i);
                            throw new FinishRoundException(text);
                        } else {
                            System.out.println("Число " + enteredNum +
                                    (enteredNum < guessedNum ? " меньше" : " больше") + " загаданного");
                        }
                        // currentAttempt++;
                        if (j == COUNT_ATTEMPTS_CONSTANT - 1) {
                            System.out.println("У " + players[k].getName() + " закончились попытки");
                        }
                    }
                }
            } catch (FinishRoundException e) {
                System.out.println(e.getMessage());
                // чищу данные игроков перед следующей игрой
                for (Player player : players) {
                    player.Clear();
                }
                // Чищу общий массив попыток
                Arrays.fill(namedNumbers, 0, currentAttempt - 1, 0);
            }
        }
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
        System.out.println("Все названные числа:");
        int half = (int) Math.ceil((float) attemptCount / 2) - 1;
        for (int i = 0; i < attemptCount; i++) {
            System.out.printf((i == half) ? "%2d\n" : "%2d ", numbers[i]);
        }
        System.out.println();
    }

    public void printPlayer(int indexPlayer) {
        // int[] numbersToPrint = Arrays.copyOf(player.getNumbers(), player.getAttempt() + 1);
        System.out.print("Числа, названные игроком " + players[indexPlayer].getName() + ": ");
        if (players[indexPlayer].getAttempt() > 0) {
            int[] numbersToPrint = Arrays.copyOf(players[indexPlayer].getNumbers(),
                    players[indexPlayer].getAttempt());
            for (int number : numbersToPrint) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public void printAfterRound(int indexWinner) {
        // Печать после окончания очередного раунда по проигравшим игрокам
        for (int p = 0; p < players.length; p++) {
            if (indexWinner != p) {
                printPlayer(p);
            }
        }
    }
}

