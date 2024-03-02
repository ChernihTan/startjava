package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Начинаем игру \"Угадай число\"."); 
        System.out.println("Для участия в игре приглашаются два игрока.");
        // Ввод игроков
        System.out.print("Первый игрок,представьтесь, пожалуйста: ");
        String namePlayer = scanner.next();    
        Player player1 = new Player(namePlayer);

        System.out.print("Второй игрок, представьтесь, пожалуйста: ");
        namePlayer = scanner.next();    
        Player player2 = new Player(namePlayer);

        System.out.println("Игру начинают два игрока под именами: " + 
                player1.getName() + " и " + player2.getName());

        GuessNumber game = new GuessNumber(player1, player2);
        String answer;
        // игра
        do {
            game.start();
            // жду только правильного ввода - yes/no
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next().toUpperCase();
            } while(!answer.equals("NO") && !answer.equals("YES"));
        } while(!answer.equals("NO")); 

        // завершение
        System.out.println("Игра закончена со счетом:");
        System.out.printf("%-12s%-12s%n", player1.getName(), player2.getName());
        System.out.printf("  %-12d%-12d%n", player1.getWinsPoints(), player2.getWinsPoints());    
    }
}
