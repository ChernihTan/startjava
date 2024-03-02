package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;

    // конструктор класса
    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // сама игра
    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        //нужно (0, 100] - целые числа
        Random r = new Random();
        int targetNum = r.nextInt(100) + 1;
        int guess = -1;

        System.out.println("Техническое сообщение для меня:");
        System.out.println("Компьютер загадал случайное число целое в полуинтервале (0, 100]: " + 
                targetNum);
        // чтобы все время не начинал ход первый игрок, беру случайное из [1,2]
        Player currentPlayer = player1;
        int whoBegin = r.nextInt(2) + 1;
        if (whoBegin == 2) {
            currentPlayer = player2;
        }
        
        while(true) {
            System.out.print("\nИгрок " + currentPlayer.getName() + " делает попытку отгадать число: ");
            guess = scanner.nextInt();
            if (guess == targetNum) {
                System.out.println("Игрок " + currentPlayer.getName() + " угадал число!");
                currentPlayer.addPoint();
                break;
            } else if (guess < targetNum) {
                System.out.println("Число " + guess + " меньше того, что загадал компьютер");
            } else {
                System.out.println("Число " + guess + " больше того, что загадал компьютер");
            }

            // переход хода к другому игроку
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
}
