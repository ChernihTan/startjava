package com.startjava.lesson_2_3_4.bookcase;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;
    private final int yearPublication;

    // длина полки для отображения
    private final int lengthShelf;

    public Book(String title) {
        this("", title, 0);
    }

    public Book(String author, String title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;

        // отображение начинается с |_  и заканчивается _|
        this.lengthShelf = toString().length() + 4;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthShelf() {
        return lengthShelf;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
