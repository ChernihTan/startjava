package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    private final String author;
    private final String title;
    private final int yearPublication;

    public Book(String author, String title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.yearPublication = 0;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }

    public boolean equalsAuthor(String s) {
        return author.equals(s);
    }
    public boolean equalsTitle(String s) {
        return title.equals(s);
    }
}
