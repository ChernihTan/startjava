package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
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
                    if (isGuessed(player, guessedNumber)) {
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

    // очистка данных игроков перед началом игры
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
    private boolean isGuessed(Player player, int guessedNumber) {
        int enteredNumber = inputNumber(player);
        int attempt = player.getAttempt() - 1;

        if (enteredNumber == guessedNumber) {
            System.out.println("Игрок " + player.getName() + " угадал " + guessedNumber +
                    " с " + ++attempt + " попытки");

            // фиксация выигрыша у победителя раунда
            player.increaseWinsCount();
            return true;
        }
        checkNumberPlayer(player, guessedNumber);
        checkAttemptPlayer(player);
        return false;
    }

    private int inputNumber(Player player) {
        boolean correctInput = false;
        int enteredNumber = 0;
        do {
            try {
                System.out.print("Игрок " + player.getName() + ": ");
                enteredNumber = Integer.parseInt(scanner.nextLine());

                // сохранение числа, названное игроком, в данных игрока
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

    private void checkNumberPlayer(Player player, int guessedNumber) {
        int enteredNumber = player.getLastNumber();
        System.out.println("Число " + enteredNumber +
                (enteredNumber < guessedNumber ? " меньше" : " больше") + " загаданного");
    }

    private void checkAttemptPlayer(Player player) {
        int attempt = player.getAttempt();
        if (attempt == COUNT_ATTEMPTS - 1) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private void determineWinner() {
        System.out.println("После сортировки в порядке убывания победных очков");
        Arrays.sort(players, Comparator.comparing(Player::getWinsCount).reversed());
        System.out.println(Arrays.toString(players));

        // Если первый в списке иммет 0 побед, то никто не победил
        // Если первый в списке имеет столько же побед, сколько последний - победила дружба
        // Если первый имеет больше побед, чем второй - победил первый
        // Если первый имеет столько же побед, сколько второй, третий и до тех пор,
        // пока у других игроков столько же, сколько у первого - это все победители

        int winsFirstInList = players[0].getWinsCount();

        if (winsFirstInList == 0) {
            System.out.println("Никто не победил!");
        } else if (winsFirstInList == players[players.length - 1].getWinsCount()) {
            System.out.println("Победила дружба!");
        } else if (winsFirstInList > players[1].getWinsCount()) {
            System.out.println("Победил " + players[0].getName());
        } else {
            // эта ветка, если игроков больше 3
            System.out.print("Победили: " + players[0].getName());
            int i = 1;
            while (players[i].getWinsCount() == winsFirstInList) {
                System.out.print(", " + players[i].getName());
                i++;
            }
            System.out.println(0);
        }
    }

    // Вывод всех названных игроками чисел, с выводом имен игроков
    private void printNumbersNamedPlayers() {
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

