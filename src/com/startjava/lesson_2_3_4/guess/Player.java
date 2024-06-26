package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

import static java.util.Arrays.*;

public class Player {

    private String name;
    private int[] numbers = new int[10];
    private int attempt = 0;
    private int winsCount = 0;

    // конструктор
    public Player(String name) {
        this.name = name;
        winsCount = 0;
        // очищаю массив с числами - мах. 10 попыток
        fill(numbers, -1);
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getWinsCount() {
        return winsCount;
    }

      public void setNumber(int index, int number) {
        numbers[index] = number;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public void addWinsCount() {
        winsCount++;
    }
    public void Clear() {
        Arrays.fill(numbers, 0,  attempt , 0);
        setAttempt(0);
    }
}
