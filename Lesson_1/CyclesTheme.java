public class CyclesTheme {
    public static void main(String[] args) {
        //1. Подсчет суммы четных и нечетных чисел
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int i = -10;
        int countEven = 0;
        int countOdd = 0;
        do {
            if (i % 2 == 0) {
                countEven++;
                System.out.println(i + "\t- четное " );
            } else {
                countOdd++;
                System.out.println(i + "\t- нечетное" );
            }
            i++;
        } while (i <= 21);
        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + countEven +
            ", а нечетных = " + countOdd);

        //2. Вывод чисел в порядке убывания
        System.out.println("\n2. Вывод чисел в порядке убывания");
        // определяю min и max 
        int[] numbers = {10, 5, -1};
        int max = numbers[0];
        int min = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            } 
            if (number < min) {
                min = number;
            }
        }
        System.out.println("max = " + max + " и min = " + min);

        // вывод в одну строку в порядке убывания все числа в интервале (min, max)
        System.out.println("Вывод в одну строку в порядке убывания все числа в интервале (" + min +
            ", " + max + "):");
        for (int j = --max; j > min; j--) {
            System.out.print(j + " ");
        }

        //3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр.");
        int quotient = 1234;
        int remainder = 0;
        int sumDigits = 0;
        System.out.print("Исходное число " + quotient + ", исходное число в обратном порядке ");
        while (quotient != 0) {
            remainder = quotient % 10;
            quotient /= 10;
            System.out.print(remainder);
            sumDigits += remainder;
        }
        System.out.println("\nСумма полученных цифр " + sumDigits);

        //4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк.");
        //  [1, 24) или [1, 30)
        min = 1;
        max = 24;  //30; 
        int zero = 0;
        // Первое нечетное
        int minBegin = min;
        if ( min % 2 == 0) {
            minBegin = min + 1;
        }
        // Вывод в каждой строке по 5 нечетных чисел
        int count = 0;
        for (i = minBegin ; i < max; i += 2 ) {
            count++;
            if (count == 5) {
                System.out.printf("%9d\n", i);
                count = 0;
            } else {
                System.out.printf("%9d", i);
            }
        }
        // недостающее в последней строке до 5 количество чисел заполняю нулями
        if (count != 0) {
            for (i = count++; i < 5; i++) {
                System.out.printf("%9d", zero);
            }
            System.out.printf("\n");            
        }

        //5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность.");
        quotient = 3242592;
        remainder = 0;
        int quantityTwos = 0;
        System.out.print("В числе " + quotient);
        while (quotient != 0) {
            remainder = quotient % 10;
            quotient /= 10;
            if (remainder == 2) {
                quantityTwos++;
            }
        }
        if (quantityTwos % 2 != 0) {
            System.out.println(" нечетное количество двоек - " + quantityTwos);
        } else {
            System.out.println(" четное количество двоек - " + quantityTwos);            
        }

        //6. Отображение геометрических фигур
        System.out.println("\n6. Отображение геометрических фигур.");
        System.out.println("Прямоугольник:");
        for (int j = 1; j <= 5 ;j++) {
            for (i = 1; i <= 10; i++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println("Прямоугольный треугольник:");
        int j = 5;
        while (j >= 1) {
            i = 1;
            while (i <= j) {
                System.out.print("#");
                i++;
            }
            System.out.print("\n");
            j--; 
        }

        System.out.println("Второй треугольник:");
        i = 1; // номер ряда
        j = i; 
        do {
            int k = 1;    
            do { 
                if (k == j) {
                    System.out.println("$");
                } else {
                    System.out.print("$");
                }
                k++;
            } while (k <= j); 
            i++;
            if (i <= 3) {
                j++;
            } else {
                j--;
            } 
        } while (i <= 5);

        //7. Отображение ASCII-символов
        System.out.println("\n7. Отображение ASCII-символов.");
        // Cимволы, начиная с кода 15 и идущие до цифр и имеющие нечетные коды
        min = 15;
        max = 48;
        minBegin = min;
        // определяю первый нечетный
        if ( min % 2 == 0) {
            minBegin = min + 1;
        } 
        System.out.printf(" %-7s |  %-10s |  %-30s %n", "DECIMAL", "CHARACTER", "DESCRIPTION" );
        for (i = minBegin; i < max; i += 2) {
            System.out.printf("   %3d   |      %1c      |  %-30s %n", i, (char) i, Character.getName(i) );
        }

        //маленькие английские буквы, имеющие четные коды
        min = 97;
        max = 122;
        minBegin = min;
        // определяю первый четный
        if ( min % 2 == 1) {
            minBegin = min + 1;
        } 
        System.out.printf("\n %-7s |  %-10s |  %-30s %n", "DECIMAL", "CHARACTER", "DESCRIPTION" );
        for (i = minBegin; i <= max; i += 2) {
            System.out.printf("   %3d   |      %1c      |  %-30s %n", i, (char)i, Character.getName(i) );
        }

        //8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом.");
        int originalNumber = 123454321;
        int palindrome = 0;
        quotient = originalNumber;
        remainder = 0;
        while (quotient != 0) {
            remainder = quotient % 10;
            quotient /= 10;
            palindrome = palindrome * 10 + remainder;
        }
        if (originalNumber == palindrome) {
            System.out.println("Число " + originalNumber + " является палиндромом");
        } else {
            System.out.println("Число " + originalNumber + " не является палиндромом");
        }

        //9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым.");
        originalNumber = 111359;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        int sum = 0;
        quotient = originalNumber;
        int numberCycle = 1;
        while (quotient > 0) {
            for (i = 1; i<= 3; i++) {
                remainder = quotient % 10;
                quotient /= 10;
                sum += remainder;
            }
            if (numberCycle == 1) {
                numberCycle++;
                sumSecondHalf = sum;
                sum = 0;
            } else {
                sumFirstHalf = sum;
                sum = 0;
            }
        }
        String isLucky = " не является";
        if (sumFirstHalf == sumSecondHalf) {
            isLucky = " является";
        } 
        System.out.println("Число " + originalNumber + isLucky + " счастливым.");
        System.out.println("Сумма цифр ABC = " + sumFirstHalf + ", а сумма DEF = " + sumSecondHalf);

        //10. Отображение таблицы умножения Пифагора
        System.out.println("\n10. Отображение таблицы умножения Пифагора.");        
        // Заголовок
        System.out.printf("%3c|%3d%3d%3d%3d%3d%3d%3d%3d%n", ' ', 2,3,4,5,6,7,8,9);
        System.out.printf("----------------------------%n");
        // Сама таблица умножения
        for ( i = 2; i <= 10; i++) {
            for ( j = 1; j < 10; j++) {
                if (j == 1) {
                    System.out.printf("%3d|", i * j);
                } else {
                    System.out.printf("%3d", i * j);
                }    
             }
            System.out.println();
        }
    }
}