package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;
import java.util.Scanner;

public class BookShelf {
    static final int CONSTANTA_COUNT_BOOKS = 10;
    private Book[] arrShelf = new Book[CONSTANTA_COUNT_BOOKS];

    private int countBooks = 0;

    // №1 - добавить книгу
    public void AddBook(String author, String title, int yearPublication) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // считаю количество книг в шкафу, проверяю,есть ли место
        // и генерирую новый объект - книга, заполняю данные по книге
        if (countBooks == 10) {
            throw new Exception("Шкаф заполнен, добавить книгу не могу!\n");
        }
        arrShelf[countBooks++] = new Book(author, title, yearPublication);
    }

    // №2 - найти книгу
    public int FindBook(String author, String title) throws Exception {
        for (int i = 0; i < countBooks; i++) {
            // s1.equals(s2)
            if ((arrShelf[i].getAuthor().equals(author)) && arrShelf[i].getTitle().equals(title)) {
                return i;
                //if (arrShelf[i].getAuthor() == author)
            }
            //  || arrShelf[i].getTitle() == title) {
        }
        throw new Exception("Такая книга не найдена!\n");
    }

    // №3 - удалить книгу
    public void DeleteBook(int index) throws Exception {
        // сдвигаем данные на место удаленного и все последующие книги
        for (int i = index + 1; i < countBooks; i++) {
            arrShelf[i - 1].setAuthor(arrShelf[i].getAuthor());
            arrShelf[i - 1].setTitle(arrShelf[i].getTitle());
            arrShelf[i - 1].setYearPublication(arrShelf[i].getYearPublication());
        }
        countBooks--;
    }

    // №4 - получить все книги (для распечатки шкафа)
    public void PrintBookShelf() {
        if(countBooks == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        } else {
            // вывод не пустых полок шкафа
            for (int i = 0; i < countBooks; i++) {
                System.out.print("""
                                |--------------------------------------------------------------|
                        """);
                String book = """
                                | %-60s |  
                        """.formatted(arrShelf[i]);
                System.out.print(book);
            }
            System.out.println("""
                            |--------------------------------------------------------------|
                            |                                                              |  
                    """);
        }
//        String person = """
//                <person>
//                    <firstName>%s</firstName>
//                    <lastName>%s</lastName>
//                </person>
//                """.formatted(first, last);
    }
    // №4а - получить все книги (для распечатки шкафа)
    public void PrintBookShelfNew() {

        if (countBooks == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        } else {
            // вывод не пустых полок шкафа
            int length = LengthShelf();
            String strRepeat = "    |" + "-".repeat(length + 2) + "|";
            //String s = "    | %-" + length + "s |";
            for (int i = 0; i < countBooks; i++) {
                //String line = String.format(s, arrShelf[i]);
                String line = String.format("    | %-" + length + "s |", arrShelf[i]);
                System.out.println(strRepeat);
                System.out.println(line);
            }
            System.out.println(strRepeat);
            //System.out.print("""
            //                |--------------------------------------------------------------|
            //        """);
//                String book = """
//                                | %-60s |
//                        """.formatted(arrShelf[i]);
//                System.out.print(book);
//            }
//            System.out.println("""
//                            |--------------------------------------------------------------|
//                            |                                                              |
//                    """);
        }
    }
//

    // №5 - получить количество книг в шкафу
    public int getCountBooks() {
        return countBooks;
    }

    // №6 - получить количество свободных полок в шкафу
    public int EmptyShelves() {
        int emptyShelves = CONSTANTA_COUNT_BOOKS - countBooks;
        return emptyShelves;
    }
    // №7 - очистить шкаф
    public void CleanBookShelf() {
        Arrays.fill(arrShelf,null);
        countBooks = 0;
        //arrShelf
    }
    // №8 - определение длины полки
    public int LengthShelf() {
        int max = 0;
        for (int i = 0; i < countBooks; i++) {
            int length = arrShelf[i].getTitle().length() + arrShelf[i].getAuthor().length() + 4 + 4;
            if(length  > max) {
                max = length;
            }
        }
        return max;
    }
    // Геттеры и сеттеры
    public void setCountBooks(int countBooks) {
        this.countBooks = countBooks;
    }
}


