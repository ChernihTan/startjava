package com.startjava.lesson_2_3_4.bookcase;

//import com.startjava.lesson_2_3_4.calculator.SignException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookShelfTest {
    static final int CONSTANTA_COUNT_BOOKS = 10;

    public static void main(String[] args) {
        BookShelf bookcase = new BookShelf();
        try {
            bookcase.AddBook("Лев Толстой", "Война и мир", 1867);
            bookcase.AddBook("Льюис Кэрролл", "Алиса в Стране чудес", 1939);
            bookcase.AddBook("Александр Волков", "Волшебник Изумрудного города", 1867);
            bookcase.AddBook("Лаймен Фрэнк Баум", "Удивительный волшебник из страны ОЗ", 1900);
            bookcase.AddBook("Ирвинг Стоун", "Жажда жизни", 1973);
            bookcase.AddBook("Рэй Бредбери", "451 градус по Фаренгейту", 1980);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        boolean incorrectInput = true;
        int menuItem = 0;
        do {
            // ввожу правильный пункт меню
            do {
                try {
                    menuItem = ShowMenu();
                    if ((menuItem >= 1) && (menuItem <= 5)) {
                        incorrectInput = false;
                    } else {
                        System.out.println("Нужно ввести целое число от 1 до 5, делайте попытку еще");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Несоответствующий формат ввода целого числа, делайте попытку еще");
                }
            } while (incorrectInput);

            // выполнение одного из пунктов меню
            Scanner scanner = new Scanner(System.in);
            String author;
            String title;
            switch (menuItem) {
                case 1 -> {
                    // добавить книгу
                    System.out.print("Ведите автора книги: ");
                    author = scanner.nextLine();
                    System.out.print("Ведите название книги: ");
                    title = scanner.nextLine();
                    int year = 0;
                    // жду только правильного ввода года
                    incorrectInput = true;
                    do {
                        try {
                            System.out.print("Ведите год издания книги: ");
                            year = Integer.parseInt(scanner.nextLine());
                            if ((year > 0) && (year <= 2100)) {
                                incorrectInput = false;
                            } else {
                                System.out.println("Год - вводимое целое число должно между 0 и 2100, делайте попытку еще");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Несоответствующий формат ввода года (положительное 4-хзначное число), делайте попытку еще");
                        }
                    } while (incorrectInput);
                    try {
                        bookcase.AddBook(author, title, year);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2 -> {
                    // удалить книгу
                    System.out.print("Ведите автора книги: ");
                    author = scanner.nextLine();
                    System.out.print("Ведите название книги: ");
                    title = scanner.nextLine();
                    try {
                        int index = bookcase.FindBook(author, title);
                        bookcase.DeleteBook(index);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 3 -> {
                    // очистить шкаф
                    bookcase.CleanBookShelf();
                }
                case 4 -> {
                    // посмотреть содержимое шкафа
                    // ничего не делаю, просто разрешенный пункт, по зваершении пункта всегда показываю содержимое шкафа
                }
            }
            CurrentStatus(bookcase);
            bookcase.PrintBookShelf();
            bookcase.PrintBookShelfNew();
            System.out.println("Для продолжения нажмите Enter");
            String str = scanner.nextLine();
        } while (menuItem != 5);
    }

    public static int ShowMenu() throws InputMismatchException {
        int optionn = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("""
                    |-------------------------------------------------------------|
                    |      1      |    2      |    3     |      4     |     5     |
                    |-------------------------------------------------|-----------|
                    |   Создать   |  Удалить  | Очистить | Содержимое | Завершить |
                    | новую книгу |  книгу    |  шкаф    |    шкафа   |   работу  |
                    |-------------------------------------------------------------|  
                """);
        System.out.print("Введите пункт меню: ");
        //String str = keyboard.nextLine();
        optionn = Integer.parseInt(keyboard.nextLine());   //nextInt();
        return optionn;
    }

    // актуальное состояние шкафа
    public static void CurrentStatus(BookShelf bookShelf) {
        if (bookShelf.getCountBooks() > 0) {
            System.out.println("В шкафу книг - " + bookShelf.getCountBooks() + ". свободно полок - " +
                    bookShelf.EmptyShelves());
        }
    }

}
