package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "YES";
    private static final String NO = "NO";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Начинаем игру \"Угадай число\".");
        Player[] players = new Player[GuessNumber.COUNT_PLAYERS];
        inputPlayerNames(players);
        GuessNumber game = new GuessNumber(players);
        String answer = YES;

        do {
            if (YES.equals(answer)) {
                game.start();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.next().toUpperCase();
        } while (!NO.equals(answer));
    }

    private static void inputPlayerNames(Player[] players) {
        for (int i = 0; i < GuessNumber.COUNT_PLAYERS; i++) {
            System.out.print("Введите имя игрока под номером " + (i + 1) + ": ");
            players[i] = new Player(scanner.next());
        }
    }
}
