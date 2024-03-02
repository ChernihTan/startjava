package com.startjava.lesson_1.base;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        //1. Перевод псевдокода на язык Java
        System.out.println("1. Перевод псевдокода на язык Java\n");
        boolean maleSex = true;
        if (!maleSex) {
            System.out.println("maleSex = " + maleSex + " => Уважаемая..");
        } else {
            System.out.println("maleSex = " + maleSex + " => Уважаемый..");
        }

        int age = 19;
        if (age > 18) {
            System.out.println("Тебе - " + age + ".\tПоздравляю, на твое имя можно открыть счет в банке!");
        } else {
            System.out.println("Тебе - " + age + ".\tУвы, на твое имя нельзя открыть счет в банке.");
        }

        float height = 1.82f;
        if (height < 1.8) {
            System.out.println("Рост " + height + "м\tдля Голландии вы невысокий человек");
        } else {
            System.out.println("Рост " + height + "м:\tдля Китая вы высокий человек");
        }

        //String name = "George";
        String name = "Marina";
         if (name.charAt(0) == 'M') {
            System.out.println("Имя " + name + " начинается на букву 'M'"); 
        } else if (name.charAt(0) == 'I') {
            System.out.println("Имя " + name + " начинается на букву 'I'");
        } else {  
            System.out.println("Имя " + name + " не начинается на букву 'M' или 'I'"); 
        }

        //2.  Поиск большего числа
        System.out.println("\n2.  Поиск большего числа");
        int a = 35;
        int b = 47;
        if (a > b) {
            System.out.println("Число " + a + " больше числа " + b);
        } else if (a < b) {
            System.out.println("Число " + a + " меньше числа " + b);
        } else {
            System.out.println("Числа " + a + " и " + b + " равны");
        }

        //3. Проверка числа
        System.out.println("\n3. Проверка числа");
        int number = -15;
        String evenText = "нечетным";
        String positivText = "отрицательным";
        if (number != 0) {
            if (number % 2 == 0) {
                evenText = "четным";
            } 
            if (number > 0) {
                positivText = "положительным";
            } 
            System.out.println("Число " + number + " является " + positivText + " и " + evenText);  
        } else {
            System.out.println("Это число 0");
        }

        //4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");
        a = 123;
        b = 423;  //223;
        // определяем разряды
        int a1 = a % 10;
        int a10 = (a % 100) / 10;
        int a100 = a / 100;
        int b1 = b % 10;
        int b10 = (b % 100) / 10;
        int b100 = b / 100;

        boolean isEqual = false;
        System.out.println("исходные числа: a = " + a + " b = " + b);
        if (a1 == b1) {
            isEqual = true;
            System.out.println("цифра " + a1 + " - номер разряда 1");
        } 
        if (a10 == b10) {
            isEqual = true;
            System.out.println("цифра " + a10 + " - номер разряда 2");
        } 
        if (a100 == b100) {
            isEqual = true;
            System.out.println("цифра " + a100 + " - номер разряда 3");
        } 
        if (isEqual == false) {
            System.out.println("Одинаковых цифр в каждом разряде нет!");
        } 

        //5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';  // '\u005E' и '\u0031'
        System.out.print("Символ - " + symbol + " ");
        if (symbol >= '0' && symbol <= '9') {
            System.out.println("цифра");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("- большая буква");
        } else if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("- маленькая буква");
        } else  {
            System.out.println("- не буква и не цифра");
        }

        //6. Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        float depositSum = 301_000;
        float percent = 0.1f;
        if (depositSum < 100_000) {
            percent = 0.05f;
        } else if (depositSum < 300_000) {
            percent = 0.07f;
        }
        float accruedInterest = depositSum * percent;
        float totalSum = depositSum + accruedInterest;
        System.out.printf("%-30s %15.2f руб.%n", "Сумма вклада", depositSum);
        System.out.printf("%-30s %15.2f руб.%n", "Сумма начисленного процента", accruedInterest);
        System.out.printf("%-30s %15.2f руб.%n", "Итоговая сумма с процентом",totalSum);

        //7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам");
        // история
        int historyPercent = 59;
        int historyScore = 5;
        if (historyPercent <= 60) {
            historyScore = 2;
        } else if (historyPercent <= 73) {
            historyScore = 3; 
        } else if (historyPercent <= 91) {
            historyScore = 4;
        } 

        // программирование
        int programmingPercent = 92;
        int programmingScore = 5;
        if (programmingPercent <= 60) {
            programmingScore = 2;
        } else if (programmingPercent <= 73) {
            programmingScore = 3; 
        } else if (programmingPercent <= 91) {
            programmingScore = 4;
        } 

        // средний балл и процент
        float averageScore = (historyScore + programmingScore) / 2f;
        float averagePercent = (historyPercent + programmingPercent) / 2f;
        System.out.println("История\t\t\t\t\t" + historyScore + 
                "\nПрограммирование\t\t\t" + programmingScore +
                "\nCредний балл оценок по предметам\t" + averageScore +
                "\nCредний % по предметам\t\t\t" + averagePercent);

        //8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли");
        int costProduction = 9_000;
        int rentalSpace = 5_000;
        int monthlSales = 15_000;
        float profitYear = (monthlSales - costProduction - rentalSpace) * 12;
        // при этом +0 быть не должно
        if (profitYear == 0) {
            System.out.println("Прибыль за год: " + profitYear + " руб.\n");  
        } else {
            // Вывожу ненулевую прибыль, как в образце задачи
            //Прибыль за год: -1 000 руб.
            //или
            //Прибыль за год: +3 000 руб.
            System.out.printf("Прибыль за год: " + "%+,9.2f" + " руб.\n", profitYear); 
        }

    }
}