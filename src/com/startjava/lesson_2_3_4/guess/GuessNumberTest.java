package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        final int COUNT_PLAYERS = 3;
        System.out.println("Начинаем игру \"Угадай число\".");
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[COUNT_PLAYERS];
        for(int i = 0; i < COUNT_PLAYERS; i++) {
            int j = i + 1;
            System.out.print("Введите имя игрока под номером " + j + ": ");
            String namePlayer = scanner.next();
            players[i] = new Player(namePlayer);
        }
        GuessNumber game = new GuessNumber(players);
        String answer = "YES";
        // игра
        do {
            if("YES".equals(answer)) {
                game.start();
            }
            // жду только правильного ввода - yes/no
            System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next().toUpperCase();
        } while (!"NO".equals(answer));

    }
}
