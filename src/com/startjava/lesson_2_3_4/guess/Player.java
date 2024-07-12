package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int UPPER_RANGE = 100;
    static final int LOWER_RANGE = 1;
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

    public boolean addNumber(int number) {
        if ((number >= LOWER_RANGE) && (number <= UPPER_RANGE)) {
            numbers[attempt++] = number;
            return true;
        }
        return false;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void increaseWinsCount() {
        winsCount++;
    }

    public int getAttempt() {
        return attempt;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
        winsCount = 0;
    }

    public String toString() {
        return name + ": " + winsCount;
    }
}
