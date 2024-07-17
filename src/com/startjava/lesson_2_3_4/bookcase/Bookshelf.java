package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookshelf {
    private static final int MAX_COUNT_BOOKS = 10;
    private final Book[] books = new Book[MAX_COUNT_BOOKS];
    private int countBooks;

    public Book[] getBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return countBooks;
    }

    public void add(Book newBook) {
        // подсчет количества занятых полок в шкафу (на каждой полке по одной книге),
        // проверка, если количество занятых полок (строк массива) пока не максимально, то
        // ссылка на переданный объект добавляется в следующую строку массива
        if (countBooks == MAX_COUNT_BOOKS) {
            throw new RuntimeException("Шкаф заполнен, добавить книгу не могу!\n");
        }
        books[countBooks++] = newBook;
    }

    public int findShelfNumber(Book searchedBook) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].equals(searchedBook)) {
                return i;
            }
        }
        throw new RuntimeException("Такая книга не найдена!\n");
    }

    public void delete(int position) {
        // сдвигаем данные на место удаленного и все последующие книги
        if (!(position >= 0 && position < MAX_COUNT_BOOKS)) {
            throw new RuntimeException("Ошибка в номере полки!\n");
        }
        System.arraycopy(books, position + 1, books,
                position, countBooks - position - 1);

        countBooks--;
    }

    // получение количество свободных полок в шкафу
    public int countEmptyShelves() {
        return MAX_COUNT_BOOKS - countBooks;
    }

    public void cleanBookshelf() {
        // очистка, начиная с 0-го элемента всех занятых полок
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
    }

    public int countMaxLengthShelf() {
        int max = 0;
        // цикл только по занятым полкам
        for (Book book : getBooks()) {
            max = Math.max(book.getLengthShelf(), max);
        }
        return max;
    }
}


