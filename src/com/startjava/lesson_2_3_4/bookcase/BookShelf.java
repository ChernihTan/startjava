package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class BookShelf {
    static final int MAX_COUNT_BOOKS = 10;
    private Book[] books = new Book[MAX_COUNT_BOOKS];

    private int countBooks;

    // №1
    public void add(String author, String title, int yearPublication) throws Exception {
        // считаю количество книг в шкафу, проверяю,есть ли место
        // и генерирую новый объект - книга, заполняю данные по книге
        if (countBooks == MAX_COUNT_BOOKS) {
            throw new Exception("Шкаф заполнен, добавить книгу не могу!\n");
        }
        books[countBooks++] = new Book(author, title, yearPublication);
    }

    // №2
    public int findShelfNumber(Book searchedBook) throws RuntimeException {
        for (int i = 0; i < countBooks; i++) {
            // s1.equals(s2)
            if (books[i].getAuthor().equals(searchedBook.getAuthor()) && books[i].getTitle().equals(searchedBook.getTitle())) {
                return i;
            }
        }
        throw new RuntimeException("Такая книга не найдена!\n");
    }

    // №3
    public void delete(int position) throws RuntimeException {
        // сдвигаем данные на место удаленного и все последующие книги
        if (!(position >= 0 && position < MAX_COUNT_BOOKS)) {
            throw new RuntimeException("Ошибка в номере полки!\n");
        }
        System.arraycopy(books, position + 1, books,
                position, countBooks - position - 1);

        countBooks--;
    }

//    // №4
//    public void printBookShelfNew() {
//        if (countBooks == 0) {
//            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
//        } else {
//            // вывод не пустых полок шкафа
//            int length = lengthShelf();
//            String strRepeat = "    |" + "-".repeat(length + 2) + "|";
//            for (int i = 0; i < countBooks; i++) {
//                String line = String.format("    | %-" + length + "s |", books[i]);
//                System.out.println(strRepeat);
//                System.out.println(line);
//            }
//            System.out.println(strRepeat);
//        }
//    }

    // №5
    public int getCountBooks() {
        return countBooks;
    }

    // №6 - получить количество свободных полок в шкафу
    public int getEmptyShelves() {
        return MAX_COUNT_BOOKS - countBooks;
    }
    // №7 - очистить шкаф

    public void cleanBookShelf() {
        // чищу, начиная с 0-го элемента все занятые полки
        Arrays.fill(books, 0,countBooks, null);
        countBooks = 0;
    }
    // №8 - определение длины полки

    public int lengthShelf() {
        int max = 0;
        for (int i = 0; i < countBooks; i++) {
            int length = books[i].getTitle().length() + books[i].getAuthor().length() + 4 + 4;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    // Геттеры

    public Book[] getBooks() {
        return books;
    }
}


