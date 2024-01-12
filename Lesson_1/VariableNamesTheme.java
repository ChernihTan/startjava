import java.math.BigDecimal;

public class VariableNamesTheme {
    public static void main(String[] args) {
        // I блок - Разные переменные
        System.out.println("I. БЛОК 'Разные переменные'");
        // 1. цифра
        byte number  = 8;
        System.out.println("1. Цифра: " + number);

        // 2. сумма чисел
        int sumNumbers = 15 + 17;
        System.out.println("2. Сумма чисел: " + sumNumbers);

        // 3. произведение цифр
        int multiplicationDigits = 15 * 25;
        System.out.println("3. Произведение цифр: " + multiplicationDigits);
        
        // 4. максимальное число
        long maxNumber = 3_000_000_000L;
        System.out.println("4. Максимальное число: " + maxNumber);

        // 5. количество десятков
        int countTens = 150_000 / 10;
        System.out.println("5. Количество десятков: " + countTens);

        // 6. вес собаки
        short dogWeight = 113;
        System.out.println("6. Вес собаки: " + dogWeight);

        // 7. исходное число
        float originalNumber  = 3.1415926f;
        System.out.println("7. Исходное число: " + originalNumber);

        // 8. процент по вкладу
        BigDecimal percentDeposit = new BigDecimal("16.17");
        System.out.println("8. Процент по вкладу: " + percentDeposit + "%");

        //9. переменная хранит символ &
        char symbolAmpersand = '&';
        //char symbol = 0x0026; // Unicode AMPERSAND
        System.out.println("9. Переменная хранит символ &: " + symbolAmpersand);

        //10. код ошибки
        String errorCode = "D0152";
        System.out.println("10. Код ошибки: " + errorCode);

        //11. тип сообщения
        char typeMessage = 'W'; // например, W- предупреждение, E- ошибка, I- информация
        System.out.println("11. Тип сообщения: " + typeMessage);

        //12. число нулей
        int zerosNumber = 6;
        System.out.println("12. Число нулей: " + zerosNumber);

        //13. уникальное число
        long uniqueNumber = 9_876_543_210L;
        System.out.println("13. Уникальное число: " + uniqueNumber);

        //14. случайное число
        int randomNumber = 995;
        System.out.println("14. Случайное число: " + randomNumber);

        //15. математическое выражение
        String mathExpression = "V = a * b * c";
        System.out.println("15. Математическое выражение: " + mathExpression);

        //16. выбор (чего-либо)
        String choiceParagraph = "7.5.1";
        System.out.println("16. Выбор параграфа: " + choiceParagraph);

        //17. счет (в игре)
        byte gameScoreTeam1 = 15;
        byte gameScoreTeam2 = 17;
        System.out.println("17. Счет (в игре) " + gameScoreTeam1 + ":" +gameScoreTeam2);

        //18. максимальная длина (строки)
        short maxLengthString = 256;
        System.out.println("18. Максимальная длина (строки): " + maxLengthString + " символов");
 
        //19. пункт меню
        String menuItem =  "Файл";
        System.out.println("19. Пункт меню: " + menuItem);

        //20. стоимость кофе на вынос
         BigDecimal priceСoffeeTakeaway = new BigDecimal("175.50");
        System.out.println("20. Стоимость кофе на вынос: " + priceСoffeeTakeaway + " рублей");

        //21. дата начала (чего-либо)
        String beginDate = "27 декабря 2023 года";
        System.out.println("21. Дата начала обучения: " + beginDate);

        //22. окончание диапазона
        String endRange = "B115";
        System.out.println("22. Окончание диапазона: " + endRange);

        //23. полное имя работника месяца
        String fullnameEmployeeMonth = "Иванова Мария Ивановна";
        System.out.println("23. Полное имя работника месяца: " + fullnameEmployeeMonth);

        //24. заголовок электронной книги
        String eBookTitle = "Нейроигры! Понравилось мне, понравится и тебе тоже!";
        System.out.println("24. Заголовок электронной книги: " + eBookTitle);
 
        //25. размер
        int size = 4096;
        System.out.println("25. Размер: " + size);

        //26. вместимость (чего-либо)
        int volume = 16_384;
        System.out.println("26. Вместимость: " + volume);

        //27. счетчик
        int counter = 14;
        System.out.println("27. Счетчик: " + counter);

        //28. путь до файла
        String pathFile = "T:\\0_JAVA\\StartJava\\Homework1_6";
        System.out.println("28. Путь до файла: " + pathFile);

        //29. количество чисел в каждой строке
        int countNumbersInString = 25;
        System.out.println("29. Количество чисел в каждой строке: " + countNumbersInString);

        // II блок - Переменные boolean
        System.out.println("\nII. БЛОК - 'Переменные boolean'");
        //2.1. сотни равны?
        boolean  isHundredsEqual = false;
        System.out.println("2.1. Сотни равны?: " + isHundredsEqual);

        //2.2. компьютер включен?
        boolean isComputerOn = true;
        System.out.println("2.2. Компьютер включен?: " + isComputerOn);

        //2.3. есть равные цифры?
        boolean hasDigitsEqual  = true;
        System.out.println("2.3. Есть равные цифры?: " + hasDigitsEqual);

        //2.4. (что-либо) создано?
        boolean isCreated = true;
        System.out.println("2.4. Это создано?: " + isCreated);

        //2.5. (что-либо) пустое?
        boolean isEmpty = false;
        System.out.println("2.5. Это пустое?: " + isEmpty);

        //2.6. (что-либо) активное?
        boolean isActive = true;
        System.out.println("2.6. Это активное?: " + isActive);

        //2.7. новый?
        boolean isNew = true;
        System.out.println("2.7. Это новый?: " + isNew);

        //2.8. электронная почта действительная?
        boolean isEmailValid = true;
        System.out.println("2.8. Электронная почта действительная?: " + isEmailValid);

        //2.9. имеются уникальные строки?
        boolean hasUniqueStrings = false;
        System.out.println("2.9. Имеются уникальные строки?: " + hasUniqueStrings);

        // 3. Аббревиатуры
        System.out.println("\nIII. БЛОК - 'Аббревиатуры'");

        // 3.1. старый universally unique identifier
        // UUID представляет собой 16-байтный (128-битный) номер
        // пример:'550e8400-e29b-41d4-a716-446655440000'
        String oldUuid = "550e8400-e29b-41d4-a716-446655440000";
        System.out.println("3.1. Старый universally unique identifier : " + oldUuid);

        // 3.2. производитель оперативной памяти
        String manufacturerRam = "Micron";
        System.out.println("3.2. Производитель оперативной памяти : " + manufacturerRam);

        // 3.3. емкость жесткого диска Hard DiskDrive в Кб
        long capacityHdd = 500_000_000L;
        System.out.println("3.3. Емкость жесткого диска : " + capacityHdd + "Кбайт");

        // 3.4. протокол передачи гипертекста
        //(Hypertext Transfer Protocol - HTTP), HTTP/2, HTTP/3 и HTTPS
        String protocolHttp = "HTTPS";
        System.out.println("3.4. Протокол передачи гипертекста : " + protocolHttp);

        // 3.5. сокращенный uniform resource locator
        //https://www.usatoday.com/story/travel/2022/02/10/amtrak-deal-valentines-offer-sale/6741296001/ to 
        //https://bit.ly/3Bg19uM
        String shortUrl = "https://bit.ly/3Bg19uM";
        System.out.println("3.5. Cокращенный uniform resource locator : " + shortUrl);

        // 3.6. новый идентификатор клиента
        //Идентификатор клиента (CUID) — это уникальный идентификатор пользователя
        String newClientId = "2BM-9617641160-961701000-201808150446459104749";
        System.out.println("3.6. Новый идентификатор клиента : " + newClientId);

        // 3.7. кодировка american standard code for information interchange
        // код символа в кодировке ASCII
        byte codeAscii = 0x7B;
        System.out.println("3.7. Кодировка в ASCII символа '{': " + codeAscii);
    }
}