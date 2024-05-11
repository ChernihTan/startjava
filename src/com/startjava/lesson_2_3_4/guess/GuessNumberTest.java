package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //, "cp866");
        System.out.println("Начинаем игру \"Угадай число\".");
        System.out.println("Для участия в игре приглашаются три игрока.\nПредставьтесь, пожалуйста:");
        // Ввод игроков
        System.out.print("Первый игрок - ");
        String namePlayer1 = scanner.next();

        System.out.print("Второй игрок - ");
        String namePlayer2 = scanner.next();

        System.out.print("Третий игрок - ");
        String namePlayer3 = scanner.next();

         //GuessNumber game = new GuessNumber(player1, player2);
        GuessNumber game = new GuessNumber(namePlayer1, namePlayer2, namePlayer3);

        String answer;
        // игра
        do {
            game.start();
            // жду только правильного ввода - yes/no
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next().toUpperCase();
            } while (!answer.equals("NO") && !answer.equals("YES"));
        } while (!answer.equals("NO"));

        // завершение
        System.out.println("Игра закончена со счетом:");
        //System.out.printf("%-12s%-12s%n", player1.getName(), player2.getName());
        //System.out.printf("  %-12d%-12d%n", player1.getWinsPoints(), player2.getWinsPoints());
    }
}
