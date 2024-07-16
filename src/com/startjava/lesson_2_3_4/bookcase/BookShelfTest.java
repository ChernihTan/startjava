package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookShelfTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bookshelf bookcase = new Bookshelf();
        testFill(bookcase);

        do {
            int menuItem;
            // ожидание правильного пункта меню
            showMenu();
            menuItem = selectItem();
            if (menuItem == 4) {
                return;
            }
            if (menuItem != 0) {
                executionItem(menuItem, bookcase);
                printBookshelf(bookcase);
                System.out.println("Для продолжения нажмите Enter");
                String str = scanner.nextLine();
                if (!str.isEmpty()) {
                    System.out.println("Нужно было нажать просто Enter");
                }
            }
        } while (true);
    }

    private static void testFill(Bookshelf bookcase) {
        try {
            bookcase.add(new Book("Лев Толстой", "Война и мир", 1867));
            bookcase.add(new Book("Льюис Кэрролл", "Алиса в Стране чудес", 1939));
            bookcase.add(new Book("Александр Волков", "Волшебник Изумрудного города", 1867));
            bookcase.add(new Book("Лаймен Фрэнк Баум", "Удивительный волшебник из страны ОЗ", 1900));
            bookcase.add(new Book("Ирвинг Стоун", "Жажда жизни", 1973));
            bookcase.add(new Book("Рэй Бредбери", "451 градус по Фаренгейту", 1980));
            bookcase.add(new Book("Джек Лондон", "Белый Клык", 1906));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("""
                |-------------------------------------------------|
                |      1      |    2      |    3     |      4     |
                |-------------------------------------------------|
                |   Создать   |  Удалить  | Очистить | Завершить  |
                | новую книгу |  книгу    |  шкаф    |   работу   |
                |-------------------------------------------------|""");
    }

    private static int selectItem() {
        System.out.print("Введите пункт меню: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("Несоответствующий формат ввода целого числа!");
            return 0;
        }
    }

    private static void executionItem(int menuItem, Bookshelf bookcase) {
        switch (menuItem) {
            case 1 -> addBook(bookcase);
            case 2 -> deleteBook(bookcase);
            case 3 -> bookcase.cleanBookShelf();
            default -> System.out.println("Нужно ввести целое число от 1 до 4, " +
                    "делайте попытку еще раз.");
        }
    }

    private static void addBook(Bookshelf bookcase) {
        boolean incorrectInput;
        // п. меню -добавить книгу
        System.out.print("Ведите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Ведите название книги: ");
        String title = scanner.nextLine();
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
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteBook(Bookshelf bookcase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ведите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Ведите название книги: ");
        String title = scanner.nextLine();
        Book bookForDelete = new Book(author, title);
        try {
            int place = bookcase.findShelfNumber(bookForDelete);
            bookcase.delete(place);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getCountBooks() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        } else {
            System.out.println("В шкафу книг - " + bookshelf.getCountBooks() + ". свободно полок - " +
                    bookshelf.countingEmptyShelves());
            // вывод не пустых полок шкафа
            int length = bookshelf.lengthShelf();
            String strRepeat = "    |" + "-".repeat(length + 2) + "|";
            for (int i = 0; i < bookshelf.getCountBooks(); i++) {
                String line = String.format("    | %-" + length + "s |", bookshelf.getBooks()[i]);
                System.out.println(strRepeat);
                System.out.println(line);
            }
            System.out.println(strRepeat);
        }
    }
}
