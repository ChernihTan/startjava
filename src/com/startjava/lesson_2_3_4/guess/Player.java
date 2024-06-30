package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] numbers = new int[GuessNumber.COUNT_ATTEMPTS * GuessNumber.COUNT_ROUNDS];
    //private int attempt;
    private int winsCount;

    public int getNumberingAttempts() {
        return numberingAttempts;
    }

    public void setNumberingAttempts(int numberingAttempts) {
        this.numberingAttempts = numberingAttempts;
    }

    // Сквозная нумерация всех попыток игрока
    private int numberingAttempts;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void addNumber(int number) {
        // у меня сквозная через все раунды нумерация попыток,
        // чтобы отобразить все числа, названные игроком
        numbers[numberingAttempts++] = number;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numberingAttempts);
    }

    public void increaseWinsCount() {
        winsCount++;
    }
    public void Clear() {
        Arrays.fill(numbers, 0,  numberingAttempts , 0);
        setNumberingAttempts(0);
    }
}
