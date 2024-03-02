package com.startjava.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("\n1. Вывод характеристик компьютера:"); 

        // Тактовая частота центрального процессора (CPU)
        float clockSpeedCpu = 2.4f;
        System.out.println("Тактовая частота центрального процессора:\t\t" + clockSpeedCpu + "GHz");

        // Количество ядер центрального процессора 
        byte numberCoresCpu = 6;
        System.out.println("Количество ядер центрального процессора:\t\t" + 
                numberCoresCpu + " ядер");

        // Количество логических процессоров центрального процессора
        short numberLogicalCpus = 12;
        System.out.println("Количество логических процессоров ЦП:\t\t\t" + numberLogicalCpus);

        // Объем оперативной памяти 
        long capacityRam = 2 * (8589934592l / 1073741824l);
        System.out.println("Объем оперативной памяти:\t\t\t\t" + capacityRam + "Гб");

        //Объем памяти видеокарты
        int gRam = 6144;
        System.out.println("Объем памяти видеокарты:\t\t\t\t" + gRam + "Мб");

        // Размер свободного пространства на жестком диске 
        double freeSpaceLogicalDisk =  671.94d;
        System.out.println("Размер свободного пространства на жестком диске:\t" + 
                freeSpaceLogicalDisk + "Гб");

        // Версия операционной системы
        String versionOs = "Windows 10 Домашняя версия 22H2 64-bit";
        System.out.println("Версия операционной системы:\t\t\t\t" + versionOs);

        // 64-разрядный процессор?
        boolean is64Bit = true;
        System.out.println("64-разрядный процессор? :\t\t\t\t" + is64Bit);

        //Имя главного логического диска обозначается латинской буквой
        char  nameLogicDisc = 'C';
        System.out.println("Имя главного логического диска " +
                "обозначается: " + "\t\t" + nameLogicDisc + ":");

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой:"); 
        float penPrice = 100f;
        float bookPrice = 200f;
        // процент скидки
        float percentDiscount = 11f;
        float totalCostWithoutDiscount = penPrice + bookPrice;
        // сумма скидки
        float sumDiscount = totalCostWithoutDiscount * percentDiscount / 100f;
        float totalCostWithDiscount = totalCostWithoutDiscount - sumDiscount;

        System.out.println("Общая стоимость товаров без скидки:\t" + totalCostWithoutDiscount);
        System.out.println("Сумма скидки:\t\t\t\t" + sumDiscount);
        System.out.println("Общая стоимость товаров со скидкой:\t" + totalCostWithDiscount);

        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n"); 
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        System.out.println("\t\tмаксимальное число\t после инкремента\t после декремента");
        // max byte
        byte maxByte = 127;
        System.out.println("тип byte: \t" + maxByte + "\t\t\t " + ++maxByte + 
                "\t\t\t " + --maxByte);

        // max short
        short maxShort = 32_767;
        System.out.println("тип short: \t" + maxShort + "\t\t\t " + ++maxShort + 
                "\t\t\t " + --maxShort);

        // max int
        int maxInt = 2_147_483_647;
        System.out.println("тип int: \t" + maxInt + "\t\t " + ++maxInt + 
                "\t\t " + --maxInt);

        // max long
        long maxLong = 9_223_372_036_854_775_807l;
        System.out.println("тип long: \t" + maxLong + "\t " + ++maxLong + 
                "\t " + --maxLong);

        //5. Перестановка значений переменных 
        System.out.println("\n5. Перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.println("Исходные значения переменных: \ta = " + a + "\tb = " + b);
        // поменяйте их значения местами следующими способами:
        // 1) с помощью третьей переменной-----
        System.out.println("1) меняю местами с помощью третьей переменной");
        int c = a;
        a = b;
        b = c;
        System.out.println("Новые значения переменных: \ta = " + a + "\tb = " + b);
        // 2) с помощью арифметических операций-----
        System.out.println("2) меняю местами с помощью арифметических операций");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("Новые значения переменных: \ta = " + a + "\tb = " + b);
        // 3) с помощью побитовой операции ^-----
        System.out.println("3) меняю местами с помощью побитовой операции ^");
        a ^= b;  
        b ^= a;
        a ^= b;
        System.out.println("Новые значения переменных: \ta = " + a + "\tb = " + b);
        // Пошаговое отображение побитовых операций
        System.out.println("\nПошаговое отображение:___");
        String binaryStringA = Integer.toBinaryString(a);
        String withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        String binaryStringB = Integer.toBinaryString(b);
        String withLeadingZerosB = String.format("%32s", binaryStringB).replace(' ', '0');
        System.out.println("a =" + "\t" + withLeadingZerosA);
        System.out.println("b =" + "\t" + withLeadingZerosB);

        a ^= b;  
        binaryStringA = Integer.toBinaryString(a);
        withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        System.out.println("a=a^b =" + "\t" + withLeadingZerosA);

        b ^= a;
        binaryStringB = Integer.toBinaryString(b);
        withLeadingZerosB = String.format("%32s", binaryStringB).replace(' ', '0');
        System.out.println("b=a^b =" + "\t" + withLeadingZerosB);

        a ^= b;
        binaryStringA = Integer.toBinaryString(a);
        withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        System.out.println("a=a^b =" + "\t" + withLeadingZerosA);

        //6.  Вывод символов и их кодов
        System.out.println("\n6.  Вывод символов и их кодов");        
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';

        System.out.println("код символа\t" + "cимвол"); 
        System.out.println("\t" + (int) dollar + "\t" + dollar); 
        System.out.println("\t" + (int) asterisk + "\t" + asterisk); 
        System.out.println("\t" + (int) atSign + "\t" + atSign);
        System.out.println("\t" + (int) verticalBar + "\t" + verticalBar); 
        System.out.println("\t" + (int) tilde + "\t" + tilde); 

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка"); 
        char slash = '/';
        char backSlash = '\\';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        char underscore = '_';
        System.out.println("    " + slash + backSlash); 
        System.out.println("   " + slash + "  " + backSlash); 
        System.out.println("  " + slash + underscore + leftParenthesis + " " + 
                rightParenthesis + backSlash); 
        System.out.println(" " + slash + "      " + backSlash); 
        System.out.println("" + slash + underscore + underscore + 
                underscore + underscore + slash + backSlash + underscore +
                underscore + backSlash); 

        // 8. Вывод количества сотен, десятков и единиц числа
        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int randomNumber = 123;
        int hundreds = randomNumber / 100;
        int tens = (randomNumber / 10) % 10;
        int ones = randomNumber % 10;
        int sumDigits = hundreds + tens + ones;
        int multiplicationDigits = hundreds * tens * ones;
        System.out.println(" Число " + randomNumber + " содержит:");
        System.out.println("  сотен - " + hundreds);
        System.out.println("  десятков - " + tens);
        System.out.println("  единиц - " + ones);
        System.out.println("Сумма его цифр - " + sumDigits);
        System.out.println("Произведение - " + multiplicationDigits);

        System.out.println("\n9. Вывод времени");
        int timeInSeconds = 86399;
        int hh =  timeInSeconds / 60 / 60;
        int mm = (timeInSeconds / 60) % 60;
        int ss = timeInSeconds % 60;
        System.out.println("Время: " + hh + ":" + mm + ":" + ss);
    }
}