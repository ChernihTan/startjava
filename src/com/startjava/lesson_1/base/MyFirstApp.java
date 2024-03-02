package com.startjava.lesson_1.base;

import java.nio.charset.Charset; // подключаем класс Charset,
import java.util.Scanner;

public class MyFirstApp {	
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset().displayName());
        System.out.println("Write once, run anywhere");
        System.out.println("Написано однажды, работает везде");

        Scanner console = new Scanner(System.in, "cp866");
        System.out.print("Введите свое имя: ");
        System.out.println(console.nextLine());
        // исправление
    }
}

