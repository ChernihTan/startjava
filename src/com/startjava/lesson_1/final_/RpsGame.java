package com.startjava.lesson_1.final_;

import java.util.Random;

public class RpsGame {

    // Игра Камень-Ножницы-Бумага
    public static void main(String[] args) throws InterruptedException {
        String rock = "✊";
        String scissors = "✌️";
        String paper = "✋";
        Random r = new Random();

        // Ход первого игрока
        String name1 = "HEL";
        int position = r.nextInt(1, 100);
        String sign1 = rock;

        if (position > 66) {
            sign1 = paper;
        } else if (position > 33) {
            sign1 = scissors;
        }

        System.out.println("Ход " + name1 + ": ");

        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }

        System.out.println(sign1);

        // Ход второго игрока
        String name2 = "WALLE";
        position = r.nextInt(1, 100);
        String sign2 = rock;

        if (position > 66) {
            sign2 = paper;
        } else if (position > 33) {
            sign2 = scissors;
        }

        System.out.println("Ход " + name2 + ": ");

        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }

        System.out.println(sign2);

        if (sign1.equals(sign2)) {
            System.out.println("Победила дружба!");
            return;
        }

        boolean isName1Equal = sign1.equals(rock) && sign2.equals(scissors) ||
                sign1.equals(scissors) && sign2.equals(paper) ||
                sign1.equals(paper) && sign2.equals(rock);

        if (isName1Equal) {
            System.out.println("\nПобедил - " + name1);
        } else {
            System.out.println("\nПобедил - " + name2);
        }
    }
}