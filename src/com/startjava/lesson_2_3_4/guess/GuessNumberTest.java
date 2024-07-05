package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    static final String YES = "YES";
    static final String NO = "NO";

    public static void main(String[] args) {
        System.out.println("Начинаем игру \"Угадай число\".");
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[GuessNumber.COUNT_PLAYERS];
        inputPlayerNames(players);
        GuessNumber game = new GuessNumber(players);
        String answer;

        do {
            game.start();

            // жду только правильного ввода - yes/no
            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            do {
                answer = scanner.next().toUpperCase();
                if (!NO.equals(answer) && !YES.equals(answer)) {
                    System.out.print("Введите корректный ответ [yes/no]: ");
                }
            } while (!NO.equals(answer) && !YES.equals(answer));
        } while (!NO.equals(answer));
    }

    public static void inputPlayerNames(Player[] players) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < GuessNumber.COUNT_PLAYERS; i++) {
            System.out.print("Введите имя игрока под номером " + (i + 1) + ": ");
            players[i] = new Player(scanner.next());
        }
    }
}
