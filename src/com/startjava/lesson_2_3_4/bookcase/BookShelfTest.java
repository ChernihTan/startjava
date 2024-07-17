package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookShelfTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bookshelf bookcase = new Bookshelf();
        fillTestData(bookcase);

        do {
            // ожидание правильного пункта меню
            showMenu();
            int menuItem = selectItem();
            if (menuItem == 5) {
                return;
            }
            if (menuItem != 0) {
                executeItem(menuItem, bookcase);
                printBookshelf(bookcase);
                inputEnter();
            }
        } while (true);
    }

    private static void fillTestData(Bookshelf bookcase) {
        try {
            bookcase.add(new Book("Лев Толстой", "Война и мир", 1867));
            bookcase.add(new Book("Льюис Кэрролл", "Алиса в Стране чудес", 1939));
            bookcase.add(new Book("Александр Волков", "Волшебник Изумрудного города", 1867));
            bookcase.add(new Book("Лаймен Фрэнк Баум", "Удивительный волшебник из страны ОЗ", 1900));
            bookcase.add(new Book("Ирвинг Стоун", "Жажда жизни", 1973));
            bookcase.add(new Book("Рэй Бредбери", "451 градус по Фаренгейту", 1980));
            bookcase.add(new Book("Джек Лондон", "Белый Клык", 1906));
            bookcase.add(new Book("Роберт Стивенсон", "Остров сокровищ", 1883));
            bookcase.add(new Book("Александр Дюма", "Асканио", 1843));
            bookcase.add(new Book("Фенимор Купер", "Зверобой", 1841));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputEnter() {
        System.out.println("Для продолжения нажмите Enter");
        String str = scanner.nextLine();
        if (!str.isEmpty()) {
            System.out.println("Нужно было нажать просто Enter");
        }
    }

    private static void showMenu() {
        System.out.println("""
                |--------------------------------------------------------------------|
                |      1      |    2      |    3     |        4          |      5    |
                |--------------------------------------------------------------------|
                |  Сохранить  |  Удалить  | Очистить |      Получить     | Завершить |
                | новую книгу |  книгу    |  шкаф    | книгу по названию |  работу   |
                |--------------------------------------------------------------------|""");
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

    private static void executeItem(int menuItem, Bookshelf bookcase) {
        switch (menuItem) {
            case 1 -> addBook(bookcase);
            case 2 -> deleteBook(bookcase);
            case 3 -> bookcase.cleanBookshelf();
            case 4 -> showBook(bookcase);
            default -> System.out.println("Нужно ввести целое число от 1 до 5, " +
                    "делайте попытку еще раз.");
        }
    }

    private static void addBook(Bookshelf bookcase) {
        // п. меню -добавить книгу
        String author = inputAuthor();
        String title = inputTitle();
        int year = 0;
        // жду только правильного ввода года
        boolean incorrectInput = true;
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

    private static String inputAuthor() {
        System.out.print("Ведите автора книги: ");
        return scanner.nextLine();
    }

    private static String inputTitle() {
        System.out.print("Ведите название книги: ");
        return scanner.nextLine();
    }

    private static void deleteBook(Bookshelf bookcase) {
        String title = inputTitle();
        Book bookForDelete = new Book(title);
        try {
            bookcase.delete(bookcase.findShelfNumber(bookForDelete));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showBook(Bookshelf bookcase) {
        String title = inputTitle();
        Book bookForShow = new Book(title);
        try {
            System.out.println(bookcase.getBooks()[bookcase.findShelfNumber(bookForShow)].toString());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getCountBooks() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        } else {
            System.out.println("В шкафу книг - " + bookshelf.getCountBooks() + ". свободно полок - " +
                    bookshelf.countEmptyShelves());
            // вывод не пустых полок шкафа
            int length = bookshelf.countMaxLengthShelf();
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
