package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int UPPER_RANGE = 101;
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

    public int getWinsCount() {
        return winsCount;
    }

    public boolean addNumber(int number) {
        boolean isValidInput = false;
        if ((number >= LOWER_RANGE) && (number < UPPER_RANGE)) {
            isValidInput = true;
            // нумерация попыток сквозная, не зависит от номера раунда
            numbers[attempt++] = number;
        }
        return isValidInput;
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
