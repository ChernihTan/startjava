package com.startjava.lesson_2_3_4.person;

class Person {

    // Поля (атрибуты), описывающие характеристики человека
    //пол, имя, рост, вес, возраст
    private char sex = 'М';
    private String name = "Иван Иванович";
    // рост в метрах
    private float height = 1.84f;
    // вес в кг
    float weight = 92f;
    int age = 65;

    // Методы, описывающие поведение (что он может делать) человека:
    // идти, сидеть, бежать, говорить, учить Java
    public void go() {
        System.out.println("Идет!");
    }

    public void sit() {
        System.out.println("Сидит!");
    }

    public void run() {
        System.out.println("Бежит!");
    }

    public void say() {
        System.out.println("Говорит!");
    }

    public void learnJava() {
        System.out.println("Учит Java!");
    }

}