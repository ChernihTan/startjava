import java.math.BigDecimal;

public class VariableNamesTheme {
    public static void main(String[] args) {

        // 1 блок - Разные переменные
        System.out.println("1. БЛОК 'Разные переменные'");
        // 1. цифра
        byte numberOneDigit  = 8;
        System.out.println("\n1. Цифра: " + numberOneDigit);

        // 2. сумма чисел
        int sumNumbers = 15 + 17;
        System.out.println("\n2. Сумма чисел: " + sumNumbers);

        // 3. произведение цифр
        int digitMultiplication = 15 * 25;
        System.out.println("\n3. Произведение цифр: " + digitMultiplication);
        
        // 4. максимальное число
        long numberMaximum = 3_000_000_000L;
        System.out.println("\n4. Максимальное число: " + numberMaximum);

        // 5. количество десятков
        int countTens = 150_000 / 10;
        System.out.println("\n5. Количество десятков: " + countTens);
        

        // 6. вес собаки
        short dogWeight = 113;
        System.out.println("\n6. Вес собаки: " + dogWeight);

        // 7. исходное число
        float numberOriginal  = 3.1415926f;
        System.out.println("\n7. Исходное число: " + numberOriginal);

        // 8. процент по вкладу
        BigDecimal percentDeposit = new BigDecimal("16.17");
        System.out.println("\n8. Процент по вкладу: " + percentDeposit + "%");

        //9. (переменная хранит символ) &
        char symbol = '&';
        //char symbol = 0x0026; // Unicode AMPERSAND
        //char symbol = 0x000C; // Unicode
        System.out.println("\n9. Переменная хранит символ &: " + symbol);

        //10. код ошибки
        String codeError = "D0152";
        System.out.println("\n10. Код ошибки: " + codeError);

        //11. тип сообщения
        char typeMessage = 'W'; // например, W- предупреждение, E- ошибка, I- информация
        System.out.println("\n11. Тип сообщения: " + typeMessage);

        //12. число нулей
        int numberZeros = 6;
        System.out.println("\n12. Число нулей: " + numberZeros);

        //13. уникальное число
        long numberUnique = 9_876_543_210L;
        System.out.println("\n13. Уникальное число: " + numberUnique);

        //14. случайное число
        int numberRandom = 995;
        System.out.println("\n14. Случайное число: " + numberRandom);

        //15. математическое выражение
        String expressionMathematical = "V = a * b * c";
        System.out.println("\n15. Математическое выражение: " + expressionMathematical);

        //16. выбор (чего-либо)
        String choiceParagraph = "7.5.1";
        System.out.println("\n16. Выбор параграфа: " + choiceParagraph);

        //17. счет (в игре)
        byte gameScoreTeam1 = 15;
        byte gameScoreTeam2 = 17;
        System.out.println("\n17. Счет (в игре) " + gameScoreTeam1 + ":" +gameScoreTeam2);


        //18. максимальная длина (строки)
        short maxLengthString = 256;
        System.out.println("\n18. Максимальная длина (строки): " + maxLengthString + " символов");
 
        //19. пункт меню
        String menuBar =  "Файл";
        System.out.println("\n19. Пункт меню: " + menuBar);

        //20. стоимость кофе на вынос
         BigDecimal priceСoffeeTakeaway = new BigDecimal("175.50");
        System.out.println("\n20. Стоимость кофе на вынос: " + priceСoffeeTakeaway + " рублей");


        //21. дата начала (чего-либо)
        String dateBegin = "27 декабря 2023 года";
        System.out.println("\n21. Дата начала обучения: " + dateBegin);

        //22. окончание диапазона
        String endRange = "B115";
        System.out.println("\n22. Окончание диапазона: " + endRange);


        //23. полное имя работника месяца
        String fullnameEmployeeMonth = "Иванова Мария Ивановна";
        System.out.println("\n23. Полное имя работника месяца: " + fullnameEmployeeMonth);

        //24. заголовок электронной книги
        String eBookHeader = "Нейроигры! Понравилось мне, понравится и тебе тоже!";
        System.out.println("\n24. Заголовок электронной книги: " + eBookHeader);

 
        //25. размер
        int size = 4096;
        System.out.println("\n25. Размер: " + size);

        //26. вместимость (чего-либо)
        int volume = 16_384;
        System.out.println("\n26. Вместимость: " + volume);

        //27. счетчик
        int counter = 14;
        System.out.println("\n27. Счетчик: " + counter);

        //28. путь до файла
        String pathFile = "T:\\0_JAVA\\StartJava\\Homework1_6";
        System.out.println("\n28. Путь до файла: " + pathFile);

        //29. количество чисел в каждой строке
        int countNumbersInString = 25;
        System.out.println("\n29. Количество чисел в каждой строке: " + countNumbersInString);


        // 2 блок - Переменные boolean
        System.out.println("\n2. БЛОК - 'Переменные boolean'");
        //2.1. сотни равны?
        boolean hundredsEqual = false;
        System.out.println("\n2.1. Сотни равны?: " + hundredsEqual);

        //2.2. компьютер включен?
        boolean computerOn = true;
        System.out.println("\n2.2. Компьютер включен?: " + computerOn);

        //2.3. есть равные цифры?
        boolean areDigitsEqual  = true;
        System.out.println("\n2.3. Есть равные цифры?: " + areDigitsEqual);

        //2.4. (что-либо) создано?
        boolean isCreated = true;
        System.out.println("\n2.4. Это создано?: " + isCreated);

        //2.5. (что-либо) пустое?
        boolean isEmpty = false;
        System.out.println("\n2.5. Это пустое?: " + isEmpty);

        //2.6. (что-либо) активное?
        boolean isActive = true;
        System.out.println("\n2.6. Это активное?: " + isActive);

        //2.7. новый?
        boolean isNew = true;
        System.out.println("\n2.7. Это новый?: " + isNew);

        //2.8. электронная почта действительная?
        boolean emailValid = true;
        System.out.println("\n2.8. Электронная почта действительная?: " + emailValid);

        //2.9. имеются уникальные строки?
        boolean areUniqueStrings = false;
        System.out.println("\n2.9. Имеются уникальные строки?: " + areUniqueStrings);

        // 3. Аббревиатуры
        System.out.println("\n3. БЛОК - 'Аббревиатуры'");

        // 3.1. старый universally unique identifier
        // UUID представляет собой 16-байтный (128-битный) номер
        // пример:'550e8400-e29b-41d4-a716-446655440000'
        String oldUUIDs = "550e8400-e29b-41d4-a716-446655440000";
        // второй вариант - массив из 16 байт, в каждом байте 2 шестнадцатеричных числа
        byte[] oldUUID = new byte[16];
        oldUUID[0] = (byte)0x55;
        oldUUID[1] = (byte)0x0E;
        oldUUID[2] = (byte)0x84;
        oldUUID[3] = (byte)0x00;
        oldUUID[4] = (byte)0xE2;
        oldUUID[5] = (byte)0x9B;
        oldUUID[6] = (byte)0x41;
        oldUUID[7] = (byte)0xD4;
        oldUUID[8] = (byte)0xA7;
        oldUUID[9] = (byte)0x16;
        oldUUID[10] = (byte)0x44;
        oldUUID[11] = (byte)0x66;
        oldUUID[12] = (byte)0x55;
        oldUUID[13] = (byte)0x44;
        oldUUID[14] = (byte)0x00;
        oldUUID[15] = (byte)0x00;                 
        String str = String.format("\n3.1 старый universally unique identifier :" + 
        " %02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x ",
        oldUUID[0], oldUUID[1], oldUUID[2], oldUUID[3], oldUUID[4], oldUUID[5],
        oldUUID[6], oldUUID[7], oldUUID[8], oldUUID[9],
        oldUUID[10], oldUUID[11], oldUUID[12], oldUUID[13], oldUUID[14], oldUUID[15]);
        System.out.println(str);
        System.out.println("3.1 Старый universally unique identifier : " + oldUUIDs);

        // 3.2. производитель оперативной памяти
        String manufacturerRAM = "Micron";
        System.out.println("\n3.2 Производитель оперативной памяти : " + manufacturerRAM);

        // 3.3. емкость жесткого диска Hard DiskDrive в Кб
        long capacityHDD = 500_000_000L;
        System.out.println("\n3.3 Емкость жесткого диска : " + capacityHDD + "Кбайт");

        // 3.4. протокол передачи гипертекста
        //(Hypertext Transfer Protocol - HTTP), HTTP/2, HTTP/3 и HTTPS
        String protocolHTTP = "HTTPS";
        System.out.println("\n3.4. Протокол передачи гипертекста : " + protocolHTTP);

        // 3.5. сокращенный uniform resource locator
        //https://www.usatoday.com/story/travel/2022/02/10/amtrak-deal-valentines-offer-sale/6741296001/ to 
        //https://bit.ly/3Bg19uM
        String shortenedURL = "https://bit.ly/3Bg19uM";
        System.out.println("\n3.5. Cокращенный uniform resource locator : " + shortenedURL);

        // 3.6. новый идентификатор клиента
        //Идентификатор клиента (CUID) — это уникальный идентификатор пользователя
        String CUID = "2BM-9617641160-961701000-201808150446459104749";
        System.out.println("\n3.6. Новый идентификатор клиента : " + CUID);

        // 3.7. кодировка american standard code for information interchange
        // код символа в кодировке ASCII
        byte codeASCII = 0x7B;
        System.out.println("\n3.7. Кодировка в ASCII символа '{': " + codeASCII);

    }
}