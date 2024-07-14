package com.startjava.lesson_2_3_4.bookcase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookShelfTest {
    public static void main(String[] args) {
        BookShelf bookcase = new BookShelf();
        try {
            bookcase.add(new Book("Лев Толстой", "Война и мир", 1867));
            bookcase.add(new Book("Льюис Кэрролл", "Алиса в Стране чудес", 1939));
            bookcase.add(new Book("Александр Волков", "Волшебник Изумрудного города", 1867));
            bookcase.add(new Book("Лаймен Фрэнк Баум", "Удивительный волшебник из страны ОЗ", 1900));
            bookcase.add(new Book("Ирвинг Стоун", "Жажда жизни", 1973));
            bookcase.add(new Book("Рэй Бредбери", "451 градус по Фаренгейту", 1980));
            bookcase.add(new Book("Джек Лондон", "Белый Клык", 1906));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        boolean incorrectInput;
        int menuItem;
        do {
            // ожидание правильного пункта меню
            try {
                menuItem = showMenu();
            } catch (RuntimeException e) {
                System.out.println("Несоответствующий формат ввода целого числа!");
                menuItem = 0;
            }

            // выполнение одного из пунктов меню
            Scanner scanner = new Scanner(System.in);
            String author;
            String title;
            switch (menuItem) {
                case 1 -> {
                    // п. меню -добавить книгу
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
                                System.out.println("Год - вводимое целое число должно между 0 и 2100, " +
                                        "делайте попытку еще");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Несоответствующий формат ввода года " +
                                    "(положительное 4-хзначное число), делайте попытку еще");
                        }
                    } while (incorrectInput);
                    try {
                        bookcase.add(new Book(author, title, year));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    // п. меню - удалить книгу
                    System.out.print("Ведите автора книги: ");
                    author = scanner.nextLine();
                    System.out.print("Ведите название книги: ");
                    title = scanner.nextLine();
                    Book bookForDelete = new Book(author, title);
                    try {
                        int place = bookcase.findShelfNumber(bookForDelete);
                        bookcase.delete(place);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 ->
                        // п. меню - очистить шкаф
                        bookcase.cleanBookShelf();

                case 4 -> {
                    // п. меню - посмотреть содержимое шкафа
                    // просто разрешенный пункт меню,
                    // по зваершении пункта всегда показываю содержимое шкафа
                }
                case 5 -> {
                    // просто разрешенный пункт меню
                }
                default -> System.out.println("Нужно ввести целое число от 1 до 5, делайте попытку еще раз.");
            }
            if (menuItem != 5) {
                currentStatus(bookcase);
                printBookShelfNew(bookcase);
                System.out.println("Для продолжения нажмите Enter");
                String str = scanner.nextLine();
                if (!str.isEmpty()) {
                    System.out.println("Нужно было нажать просто Enter");
                }
            }
        } while (menuItem != 5);
    }

    public static int showMenu() throws InputMismatchException {
        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("""
                    |-------------------------------------------------------------|
                    |      1      |    2      |    3     |      4     |     5     |
                    |-------------------------------------------------|-----------|
                    |   Создать   |  Удалить  | Очистить | Содержимое | Завершить |
                    | новую книгу |  книгу    |  шкаф    |    шкафа   |   работу  |
                    |-------------------------------------------------------------|""");
        System.out.print("Введите пункт меню: ");
        option = Integer.parseInt(keyboard.nextLine());
        return option;
    }

    // актуальное состояние шкафа
    public static void currentStatus(BookShelf bookShelf) {
        if (bookShelf.getCountBooks() > 0) {
            System.out.println("В шкафу книг - " + bookShelf.getCountBooks() + ". свободно полок - " +
                    bookShelf.getEmptyShelves());
        }
    }

    public static void printBookShelfNew(BookShelf bookcase) {
        if (bookcase.getCountBooks() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        } else {
            // вывод не пустых полок шкафа
            int length = bookcase.lengthShelf();
            String strRepeat = "    |" + "-".repeat(length + 2) + "|";
            for (int i = 0; i < bookcase.getCountBooks(); i++) {
                String line = String.format("    | %-" + length + "s |", bookcase.getBooks()[i]);
                System.out.println(strRepeat);
                System.out.println(line);
            }
            System.out.println(strRepeat);
        }
    }
}
