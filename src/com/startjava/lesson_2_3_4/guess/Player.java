package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ONE_HUNDRED = 100;
    private final String name;
    private final int[] numbers = new int[GuessNumber.COUNT_ATTEMPTS * GuessNumber.COUNT_ROUNDS];

    private int winsCount;

    // Сквозная нумерация всех попыток игрока
    private int attempt;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public int getWinsCount() {
        return winsCount;
    }

    public boolean addNumber(int number) {
        if ((number > 0) && (number <= Player.ONE_HUNDRED)) {
            // нумерация попыток сквозная, не зависит от номера раунда
            numbers[attempt++] = number;
            return true;
        } else {
            return false;
        }
    }

    public void increaseWinsCount() {
        winsCount++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
        winsCount = 0;
    }
}
