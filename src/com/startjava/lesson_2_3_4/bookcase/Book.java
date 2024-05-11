package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    private String author;
    private String title;
    private int yearPublication;
    private int informationLength;

    public Book(String author, String title, int yearPublication) {
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }
    public int getInformationLength() {
        informationLength = author.length() + title.length() + 4;
        return informationLength;
    }
    public void setInformationLength() {
        this.informationLength = author.length() + title.length() + 4;;
    }

    public String toString() {
        String str = author + ", " + title + ", " + yearPublication;
        return str;
     }
}
