import java.math.BigDecimal;

public class VariableNamesTheme {
        public static void main(String[] args) {
        /*
        комментарий
        объявление и инициализация переменной
        вывод ее значения на консоль
        пустая строка
        Отделяйте в консоли вывод одного блока от другого пустой строкой
        */
        // 1. цифра
        byte numberOneDigit  = 8;
        System.out.println("1. цифра: " + numberOneDigit);

        // 2. сумма чисел
        int sumNumbers = 15 + 17;
        System.out.println("\n2. сумма чисел: " + sumNumbers);

        // 3. произведение цифр
        int digitMultiplication = 15 * 25;
        System.out.println("\n3. произведение цифр: " + digitMultiplication);
        
        // 4. максимальное число
        long numberMaximum = 3_000_000_000L;
        System.out.println("\n4. максимальное число: " + numberMaximum);

        // 5. количество десятков
        int countTens = 150_000 / 10;
        System.out.println("\n5. количество десятков: " + countTens);
        

        // 6. вес собаки
        short dogWeight = 113;
        System.out.println("\n6. вес собаки: " + dogWeight);

        // 7. исходное число
        float numberOriginal  = 3.1415926f;
        System.out.println("\n7. исходное число: " + numberOriginal);

        // 8. процент по вкладу
        BigDecimal percentDeposit = new BigDecimal("16.17");
        System.out.println("\n8. процент по вкладу: " + percentDeposit + "%");

        //9. (переменная хранит символ) &
        char symbol = '&';
        //char symbol = 0x0026; // Unicode AMPERSAND
        //char symbol = 0x000C; // Unicode
        System.out.println("\n9. (переменная хранит символ) &: " + symbol);

        //10. код ошибки
        String codeError = "D0152";
        System.out.println("\n10. код ошибки: " + codeError);

        //11. тип сообщения
        char typeMessage = 'W'; // например, W- предупреждение, E- ошибка, I- информация
        System.out.println("\n11. тип сообщения: " + typeMessage);

        //12. число нулей
        int numberZeros = 6;
        System.out.println("\n12. число нулей: " + numberZeros);

        //13. уникальное число
        long numberUnique = 9_876_543_210L;
        System.out.println("\n13. уникальное число: " + numberUnique);

        //14. случайное число
        int numberRandom = 995;
        System.out.println("\n14. случайное число: " + numberRandom);

        //15. математическое выражение
        String expressionMathematical = "V = a * b * c";
        System.out.println("\n15. математическое выражение: " + expressionMathematical);

        //16. выбор (чего-либо)
        String choiceParagraph = "7.5.1";
        System.out.println("\n16. выбор параграфа: " + choiceParagraph);

        //17. счет (в игре)
        byte gameScoreTeam1 = 15;
        byte gameScoreTeam2 = 17;
        System.out.println("\n17. счет (в игре) " + gameScoreTeam1 + ":" +gameScoreTeam2);


        //18. максимальная длина (строки)
        short maxLengthString = 256;
        System.out.println("\n18. максимальная длина (строки): " + maxLengthString + " символов");
 
        //19. пункт меню
        String menuBar =  "Файл";
        System.out.println("\n19. пункт меню: " + menuBar);

        //20. стоимость кофе на вынос
         BigDecimal priceСoffeeTakeaway = new BigDecimal("175.50");
        System.out.println("\n20. стоимость кофе на вынос: " + priceСoffeeTakeaway + " рублей");


        //21. дата начала (чего-либо)
        String dateBegin = "27 декабря 2023 года";
        System.out.println("\n21. дата начала обучения: " + dateBegin);

        //22. окончание диапазона
        String endRange = "B115";
        System.out.println("\n22. окончание диапазона: " + endRange);


        //23. полное имя работника месяца
        String fullnameEmployeeMonth = "Иванова Мария Ивановна";
        System.out.println("\n23. полное имя работника месяца: " + fullnameEmployeeMonth);

        //24. заголовок электронной книги
        String eBookHeader = "Нейроигры! Понравилось мне, понравится и тебе тоже!";
        System.out.println("\n24. заголовок электронной книги: " + eBookHeader);

 
        //25. размер
        int size = 4096;
        System.out.println("\n25. размер: " + size);

        //26. вместимость (чего-либо)
        int volume = 16_384;
        System.out.println("\n26. вместимость: " + volume);

        //27. счетчик
        int counter = 14;
        System.out.println("\n27. счетчик: " + counter);

        //28. путь до файла
        String pathFile = "T:\\0_JAVA\\StartJava\\Homework1_6";
        System.out.println("\n28. путь до файла: " + pathFile);

        //29. количество чисел в каждой строке
        int countNumbersInString = 25;
        System.out.println("\n229. количество чисел в каждой строке: " + countNumbersInString);

    }
}