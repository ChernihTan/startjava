package com.startjava.lesson_2_3.guess;

public class Player {

    private String name;
    private int winsPoints = 0;

    // конструктор
    public Player(String name) {
        this.name = name;
        winsPoints = 0;
    }    

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getWinsPoints() {
        return winsPoints;
    }

    public void addPoint() {
        winsPoints++;
    }
}