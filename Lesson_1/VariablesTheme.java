public class  VariablesTheme {
    public static void main(String[] args) {
/*
1. Вывод характеристик компьютера (это название задачи)
объявите переменные всех существующих в Java примитивных типов данных, присвоив им значения
в качестве значений используйте характеристики компьютера: количество ядер, частота процессора и т.д.
выведите в консоль:
значения этих переменных
описание характеристик
*/    
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

/*
2, Расчет стоимости товара со скидкой
ручка стоит 100 руб., а книга — 200 руб.
вместе на них действует скидка 11%
выведите в консоль:
общую стоимость товаров без скидки
сумму скидки
общую стоимость товаров со скидкой
*/
        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой:"); 
        // Цена ручки
        float penPrice = 100f;
        // Цена книги
        float bookPrice = 200f;
        // процент скидки
        float discounPercent = 11f;
        // общая стоимость товаров без скидки
        float totalCostWithoutDiscount = penPrice + bookPrice;
        // общая стоимость товаров со скидкой 
        float totalDiscountedPrice = totalCostWithoutDiscount * (100 - discounPercent) / 100f;
        // сумма скидки
        float amountDiscount = totalCostWithoutDiscount - totalDiscountedPrice;
        System.out.println("Общая стоимость товаров без скидки:\t" + totalCostWithoutDiscount);
        System.out.println("Сумма скидки:\t\t\t\t" + amountDiscount);
        System.out.println("Общая стоимость товаров со скидкой:\t" + totalDiscountedPrice);

/*
Вывод слова JAVA
Отобразите без использования переменных в консоли слово JAVA:
   J    a  v     v  a                                                  
   J   a a  v   v  a a                                                 
J  J  aaaaa  V V  aaaaa                                                
 JJ  a     a  V  a     a
*/
        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n"); 
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

/*
4. Вывод min и max значений целых числовых типов
Вывод min и max значений целых числовых типов
создайте переменные всех целых числовых типов
присвойте им самые большие числа, которые они могут хранить
выводите данные в консоль для каждой переменной в следующей последовательности:
первоначальное значение
значение после инкремента на единицу
значение после декремента на единицу
не смешивайте вывод разных типов
*/
        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n3. 4. Вывод min и max значений целых числовых типов");
        System.out.println("\t\tчисло\t\t\t инкремент\t\t декремент");
        byte typeByte = 127;
        byte typeByteInc = typeByte;
        byte typeByteDec = typeByte;
        typeByteInc++;
        typeByteDec--;
        System.out.println("max byte: \t" + typeByte + "\t\t\t " + typeByteInc + "\t\t\t " + 
            typeByteDec);
        typeByte = -128;
        typeByteInc = typeByte;
        typeByteDec = typeByte;
        typeByteInc++;
        typeByteDec--;
        System.out.println("min byte: \t" + typeByte + "\t\t\t " + typeByteInc + "\t\t\t " + 
            typeByteDec);

        // max short
        short typeShort = 32_767;
        short typeShortInc = typeShort;
        short typeShortDec = typeShort;
        typeShortInc++;
        typeShortDec--;
        System.out.println("max short: \t" + typeShort + "\t\t\t" + typeShortInc + "\t\t\t" + 
            typeShortDec);
        // min short
        typeShort = -32_768;
        typeShortInc = typeShort;
        typeShortDec = typeShort;
        typeShortInc++;
        typeShortDec--;
        System.out.println("min short: \t" + typeShort + "\t\t\t" + typeShortInc + "\t\t\t" + 
            typeShortDec);

        // max int
        int typeInt = 2_147_483_647;
        int typeIntInc = typeInt;
        int typeIntDec = typeInt;
        typeIntInc++;
        typeIntDec--;
        System.out.println("max int: \t" + typeInt + "\t\t" + typeIntInc + "\t\t" + typeIntDec);
        // min int
        typeInt = -2_147_483_648;
        typeIntInc = typeInt;
        typeIntDec = typeInt;
        typeIntInc++;
        typeIntDec--;
        System.out.println("min int: \t" + typeInt + "\t\t" + typeIntInc + "\t\t" + typeIntDec);

        // max long
        long typeLong = 9_223_372_036_854_775_807l;
        long typeLongInc = typeLong;
        long typeLongDec = typeLong;
        typeLongInc++;
        typeLongDec--;
        System.out.println("max long: \t" + typeLong + "\t" + typeLongInc + "\t" + typeLongDec);
        // min long
        typeLong = -9_223_372_036_854_775_808l;
        typeLongInc = typeLong;
        typeLongDec = typeLong;
        typeLongInc++;
        typeLongDec--;
        System.out.println("min long: \t" + typeLong + "\t" + typeLongInc + "\t" + typeLongDec);

/*
5.  Перестановка значений переменных
•   создайте две переменные типа int, присвоив им 2 и 5
•   поменяйте их значения местами следующими способами:
o   с помощью третьей переменной
o   с помощью арифметических операций
o   с помощью побитовой операции ^
•   перед началом очередных перестановок присваивать переменным исходные значения не нужно
•   решение должно быть универсальным, а не привязано к конкретным значениям
•   выведите в консоль:
o   название способа перестановки значений
o   исходные значения переменных
o   новые значения переменных
*/
        //5. Перестановка значений переменных 
        System.out.println("\n5. Перестановка значений переменных");
        int var1 = 2;
        int var2 = 5;
        System.out.println("Исходные значения переменных: \ta = " + var1 + "\tb = " + var2);
        // поменяйте их значения местами следующими способами:
        // 1) с помощью третьей переменной-----
        System.out.println("1) меняю местами с помощью третьей переменной");
        int var3 = var1;
        var1 = var2;
        var2 = var3;
        System.out.println("Новые значения переменных: \ta = " + var1 + "\tb = " + var2);
        // 2) с помощью арифметических операций-----
        System.out.println("2) меняю местами с помощью арифметических операций");
        var1 = var1 + var2;
        var2 = var1 - var2;
        var1 = var1 - var2;
        System.out.println("Новые значения переменных: \ta = " + var1 + "\tb = " + var2);
        // 3) с помощью побитовой операции ^-----
        System.out.println("3) меняю местами с помощью побитовой операции ^");
        var1 = var1 ^ var2;  
        var2 = var1 ^ var2;
        var1 = var1 ^ var2;
        System.out.println("Новые значения переменных: \ta = " + var1 + "\tb = " + var2);
        // Пошаговое отображение побитовых операций
        System.out.println("\nПошаговое отображение:___");
        String binaryStringA = Integer.toBinaryString(var1);
        String withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        String binaryStringB = Integer.toBinaryString(var2);
        String withLeadingZerosB = String.format("%32s", binaryStringB).replace(' ', '0');
        System.out.println("a =" + "\t" + withLeadingZerosA);
        System.out.println("b =" + "\t" + withLeadingZerosB);

        var1 = var1 ^ var2;  
        binaryStringA = Integer.toBinaryString(var1);
        withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        System.out.println("a=a^b =" + "\t" + withLeadingZerosA);

        var2 = var1 ^ var2;
        binaryStringB = Integer.toBinaryString(var2);
        withLeadingZerosB = String.format("%32s", binaryStringB).replace(' ', '0');
        System.out.println("b=a^b =" + "\t" + withLeadingZerosB);

        var1 = var1 ^ var2;
        binaryStringA = Integer.toBinaryString(var1);
        withLeadingZerosA = String.format("%32s", binaryStringA).replace(' ', '0');
        System.out.println("a=a^b =" + "\t" + withLeadingZerosA);

/*
6.  Вывод символов и их кодов
проинициализируйте переменные типа char символами (а не их кодами), 
найдя их в ASCII-таблице по кодам: 36, 42, 64, 124, 126
выведите в консоль в столбец попарно:
код символа 
соответствующий коду символ
код символа берите из переменной, а не пишите его руками
*/
        //6.  Вывод символов и их кодов
        System.out.println("\n6.  Вывод символов и их кодов");        
        char symbolDollar = '$';
        char symbolAsterisk = '*';
        char symbolAtSign = '@';
        char symbolVerticalBar = '|';
        char symbolTilde = '~';

        System.out.println("код символа\t" + "cимвол"); 
        short numberShort = (short)symbolDollar;
        System.out.println("\t" + numberShort + "\t" + symbolDollar); 
        
        numberShort = (short)symbolAsterisk;
        System.out.println("\t" + numberShort + "\t" + symbolAsterisk); 

        numberShort = (short)symbolAtSign;
        System.out.println("\t" + numberShort + "\t" + symbolAtSign);

        numberShort = (short)symbolVerticalBar;
        System.out.println("\t" + numberShort + "\t" + symbolVerticalBar); 

        numberShort = (short)symbolTilde;
        System.out.println("\t" + numberShort + "\t" + symbolTilde); 

/*
7. Вывод в консоль ASCII-арт Дюка
отобразите с помощью переменных в консоли Java-талисман:
    /\    
   /  \   
  /_( )\  
 /      \ 
/____/\__\
каждый уникальный символ Дюка (а не его код) храните в отдельной переменной (кроме пробелов)
*/
        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка"); 
        char symbolSlash = '/';
        char symbolBackSlash = '\\';
        char symbolLeftParenthesis = '(';
        char symbolRightParenthesis = ')';
        char symbolUnderscore = '_';
        System.out.println("    " + symbolSlash + symbolBackSlash); 
        System.out.println("   " + symbolSlash + "  " + symbolBackSlash); 
        System.out.println("  " + symbolSlash + symbolUnderscore + symbolLeftParenthesis + " " + 
            symbolRightParenthesis + symbolBackSlash); 
        System.out.println(" " + symbolSlash + "      " + symbolBackSlash); 
        System.out.println("" + symbolSlash + symbolUnderscore + symbolUnderscore + 
            symbolUnderscore + symbolUnderscore +
            symbolSlash + symbolBackSlash + symbolUnderscore +
            symbolUnderscore + symbolBackSlash + " "); 

/*
8. Вывод количества сотен, десятков и единиц числа
из числа 123 выделите сотни, десятки и единицы
выделяйте каждую цифру числа программно, а не написав их самостоятельно
используйте для этого только операции / и %
не используйте цикл
найдите произведение и сумму выделенных цифр
выведите результат в формате:
Число N содержит:
  сотен - X
  десятков - Y
  единиц - Z 
Сумма его цифр = S
Произведение = P
*/
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

/*
9. Вывод времени
имеется 86399 секунд
переведите число в часы, минуты и секунды
используйте для этого только операции / и %
выведите в консоль значения в формате ЧЧ:ММ:СС
*/
        System.out.println("\n9. Вывод времени");
        int timeInSeconds = 86399;
        int clocks =  timeInSeconds / 60 / 60;
        int minutes = (timeInSeconds / 60) % 60;
        int seconds = timeInSeconds % 60;
        System.out.println("Время: " + clocks + ":" + minutes + ":" + seconds);
    }
} 