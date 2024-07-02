package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] numbers = new int[GuessNumber.COUNT_ATTEMPTS * GuessNumber.COUNT_ROUNDS];

    //private int attempt;
    private int winsCount;
    // Сквозная нумерация всех попыток игрока
    private int attempt;

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinsCount() {
        return winsCount;
    }
    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }

    public boolean addNumber(int number) {
        boolean incorrectInput = true;
        if ((number > 0) && (number <= 100)) {
            incorrectInput = false;
            // нумерация попыток сквозная, не зависит от номера раунда
            numbers[attempt++] = number;
        } else {
            System.out.println("Вводимое целое число должно быть в интервале [1:100], " +
                    "делайте попытку еще");
        }
        return incorrectInput;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void increaseWinsCount() {
        winsCount++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        setAttempt(0);
        setWinsCount(0);
    }
}
