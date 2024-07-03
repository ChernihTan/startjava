package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        final int countPlayers = 3;
        System.out.println("Начинаем игру \"Угадай число\".");
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[countPlayers];
        inputPlayerNames(players);
        GuessNumber game = new GuessNumber(players);
        String answer = "YES";
        // игра
        do {
            if ("YES".equals(answer)) {
                game.start();
            }
            // жду только правильного ввода - yes/no
            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            answer = scanner.next().toUpperCase();
            if (!"NO".equals(answer) & !"YES".equals(answer)) {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
        } while (!"NO".equals(answer));
    }

    public static void inputPlayerNames(Player[] players) {
        final int countPlayers = 3;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < countPlayers; i++) {
            int j = i + 1;
            System.out.print("Введите имя игрока под номером " + j + ": ");
            String namePlayer = scanner.next();
            players[i] = new Player(namePlayer);
        }
    }
}
