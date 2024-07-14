package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class BookShelf {
    static final int MAX_COUNT_BOOKS = 10;
    private final Book[] books = new Book[MAX_COUNT_BOOKS];

    private int countBooks;

    public void add(Book newBook) throws RuntimeException {
        // подсчет количества занятых полок в шкафу (на каждой полке по одной книге),
        // проверка, если количество занятых полок (строк массива) пока не максимально, то
        // ссылка на переданный объект добавляется в следующую строку массива
        if (countBooks == MAX_COUNT_BOOKS) {
            throw new RuntimeException("Шкаф заполнен, добавить книгу не могу!\n");
        }
        books[countBooks++] = newBook;
    }

    public int findShelfNumber(Book searchedBook) throws RuntimeException {
        for (int i = 0; i < countBooks; i++) {
            // s1.equals(s2)
            if (books[i].getAuthor().equals(searchedBook.getAuthor()) &&
                    books[i].getTitle().equals(searchedBook.getTitle())) {
                return i;
            }
        }
        throw new RuntimeException("Такая книга не найдена!\n");
    }

    public void delete(int position) throws RuntimeException {
        // сдвигаем данные на место удаленного и все последующие книги
        if (!(position >= 0 && position < MAX_COUNT_BOOKS)) {
            throw new RuntimeException("Ошибка в номере полки!\n");
        }
        System.arraycopy(books, position + 1, books,
                position, countBooks - position - 1);

        countBooks--;
    }

    public int getCountBooks() {
        return countBooks;
    }

    // получение количество свободных полок в шкафу
    public int getEmptyShelves() {
        return MAX_COUNT_BOOKS - countBooks;
    }

    public void cleanBookShelf() {
        // очистка, начиная с 0-го элемента всех занятых полок
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
    }

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


