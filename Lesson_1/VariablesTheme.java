public class  VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("\n1. Вывод характеристик компьютера:"); 
        // Тактовая частота центрального процессора (CPU)
        float clockSpeedCpu = 2.4f;
        System.out.println("Тактовая частота центрального процессора:\t\t" + clockSpeedCpu + "GHz");
        // Количество ядер центрального процессора 
        short numberCoresCpu = 6;
        System.out.println("Количество ядер центрального процессора:\t\t" + numberCoresCpu + 
                " ядер");
        // Количество логических процессоров центрального процессора
        short numberLogicalProcessors = 12;
        System.out.println("Количество логических процессоров ЦП:\t\t\t" + numberLogicalProcessors);
        // Объем оперативной памяти 
        long capacityRam = 2 * (8589934592l / 1073741824l);
        System.out.println("Объем оперативной памяти:\t\t\t\t" + capacityRam + "Гб");
        //Объем памяти видеокарты
        int graphicsCardMemorySize = 6144;
        System.out.println("Объем памяти видеокарты:\t\t\t\t" + graphicsCardMemorySize + "Мб");
        // Размер свободного пространства на жестком диске 
        float freeSpaceLogicalDisk =  671.94f;
        System.out.println("Размер свободного пространства на жестком диске:\t" + 
                freeSpaceLogicalDisk + "Гб");
        // Версия операционной системы
        String versionOs = "Windows 10 Домашняя версия 22H2 64-bit";
        System.out.println("Версия операционной системы:\t\t\t\t" + versionOs);

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой:"); 
        float penPrice = 100f;
        float bookPrice = 200f;
        float discounPercent = 11f;
        float totalCostWithoutDiscount = penPrice + bookPrice;
        float totalDiscountedPrice = totalCostWithoutDiscount * (100 - discounPercent) / 100f;
        float amountDiscount = totalCostWithoutDiscount - totalDiscountedPrice;
        System.out.println("Общая стоимость товаров без скидки:\t" + totalCostWithoutDiscount);
        System.out.println("Сумма скидки:\t\t\t\t" + amountDiscount);
        System.out.println("Общая стоимость товаров со скидкой:\t" + totalDiscountedPrice);

        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n"); 
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n3. 4. Вывод min и max значений целых числовых типов");
        System.out.println("\t\tчисло\t\t\t инкремент\t\t декремент");
        // max byte
        byte typeByte = 127;
        System.out.print("max byte: \t" + typeByte + "\t\t\t " + ++typeByte + "\t\t\t ");
        typeByte--;
        System.out.println("" + --typeByte);
        // min byte
        typeByte = -128;
        System.out.print("min byte: \t" + typeByte + "\t\t\t " + ++typeByte + "\t\t\t ");
        typeByte--;
        System.out.println("" + --typeByte);

        // max short
        short typeShort = 32_767;
        System.out.print("max short: \t" + typeShort + "\t\t\t " + ++typeShort + "\t\t\t ");
        typeShort--;
        System.out.println("" + --typeShort);
        // min short
        typeShort = -32_768;
        System.out.print("min short: \t" + typeShort + "\t\t\t " + ++typeShort + "\t\t\t ");
        typeShort--;
        System.out.println("" + --typeShort);

        // max int
        int typeInt = 2_147_483_647;
        System.out.print("max int: \t" + typeInt + "\t\t " + ++typeInt + "\t\t ");
        typeInt--;
        System.out.println("" + --typeInt);
        // min int
        typeInt = -2_147_483_648;
        System.out.print("min int: \t" + typeInt + "\t\t " + ++typeInt + "\t\t ");
        typeInt--;
        System.out.println("" + --typeInt);

        // max long
        long typeLong = 9_223_372_036_854_775_807l;
        System.out.print("max long: \t" + typeLong + "\t " + ++typeLong + "\t ");
        typeLong--;
        System.out.println("" + --typeLong);
        // min long
        typeLong = -9_223_372_036_854_775_808l;
        System.out.print("min long: \t" + typeLong + "\t " + ++typeLong + "\t ");
        typeLong--;
        System.out.println("" + --typeLong);

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
        char Dollar = '$';
        char Asterisk = '*';
        char AtSign = '@';
        char VerticalBar = '|';
        char Tilde = '~';

        System.out.println("код символа\t" + "cимвол"); 
        int numberInt = (int)Dollar;
        System.out.println("\t" + numberInt + "\t" + Dollar); 
        
        numberInt = (int)Asterisk;
        System.out.println("\t" + numberInt + "\t" + Asterisk); 

        numberInt = (int)AtSign;
        System.out.println("\t" + numberInt + "\t" + AtSign);

        numberInt = (int)VerticalBar;
        System.out.println("\t" + numberInt + "\t" + VerticalBar); 

        numberInt = (int)Tilde;
        System.out.println("\t" + numberInt + "\t" + Tilde); 

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка"); 
        char Slash = '/';
        char BackSlash = '\\';
        char LeftParenthesis = '(';
        char RightParenthesis = ')';
        char Underscore = '_';
        System.out.println("    " + Slash + BackSlash); 
        System.out.println("   " + Slash + "  " + BackSlash); 
        System.out.println("  " + Slash + Underscore + LeftParenthesis + " " + 
                RightParenthesis + BackSlash); 
        System.out.println(" " + Slash + "      " + BackSlash); 
        System.out.println("" + Slash + Underscore + Underscore + 
                Underscore + Underscore + Slash + BackSlash + Underscore +
                Underscore + BackSlash + " "); 

        // 8. Вывод количества сотен, десятков и единиц числа
        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        // произвольное число
        int randomNumber = 123;
        // сотни
        int countHundreds = randomNumber / 100;
        // десятки
        int countTens = (randomNumber / 10) % 10;
        // единицы
        int countUnits = randomNumber % 10;
        // сумма цифр
        int sumDigits = countHundreds + countTens + countUnits;
        // произведение цифр
        int multiplicationDigits = countHundreds * countTens * countUnits;
        System.out.println(" Число " + randomNumber + " содержит:");
        System.out.println("  сотен - " + countHundreds);
        System.out.println("  десятков - " + countTens);
        System.out.println("  единиц - " + countUnits);
        System.out.println("Сумма его цифр - " + sumDigits);
        System.out.println("Произведение - " + multiplicationDigits);

        System.out.println("\n9. Вывод времени");
        int timeInSeconds = 86399;
        int clocks =  timeInSeconds / 60 / 60;
        int minutes = (timeInSeconds / 60) % 60;
        int seconds = timeInSeconds % 60;
        System.out.println("Время: " + clocks + ":" + minutes + ":" + seconds);
    }
} 