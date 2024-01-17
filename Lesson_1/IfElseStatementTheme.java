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

        float growth = 1.82f;
        if (growth < 1.8) {
            System.out.println("Рост " + growth + "м\tдля Голландии вы невысокий человек");
        } else {
            System.out.println("Рост " + growth + "м:\tдля Китая вы высокий человек");
        }

        //String name = "George";
        String name = "Marina";
        char firstLetterName = name.charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Имя " + name + " начинается на букву 'M'"); 
        } else if (firstLetterName == 'I') {
            System.out.println("Имя " + name + " начинается на букву 'I'");
        }
        else {  
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
        String even = "";
        String positiv = "";
        if (number == 0) {
            System.out.println("Это число 0");    
        } else {
            if (number % 2 == 0) {
                even = "четным";
            } else {
                even = "нечетным";
            }
            if (number > 0) {
                positiv = "положительным";
            } else {
                positiv = "отрицательным";
            }
            System.out.println("Число " + number + " является " + positiv + " и " + even);  
        }

        //4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");
        a = 123;
        b = 223;
        int a1 = (a % 100) % 10;
        int a10 = (a % 100) / 10;
        int a100 = a / 100;
        int b1 = (b % 100) % 10;
        int b10 = (b % 100) / 10;
        int b100 = b / 100;
        boolean isEq1 = false;
        boolean isEq10 = false;
        boolean isEq100 = false;
        
        // если все цифры в разрядах разные, то 
        // поразрядная проверка выполняться уже не должна
        if ((a1 == a10) || (a1 == a100) || (a10 == a100) ||
            (b1 == b10) || (b1 == b100) || (b10 == b100)) {
            System.out.println("Есть хотя бы одно число, у которого есть одинаковые цифры, " + 
                    "значит делаем поразрядную проверку");
            if (a1 == b1) {
                isEq1 = true;
            }
            if (a10 == b10) {
                isEq10 = true;
            }
            if (a100 == b100) {
                isEq100 = true;
            }
            if (isEq1 || isEq10 || isEq100) {
                System.out.println("исходные числа: a = " + a + " b = " + b);
                if (isEq1) {
                    System.out.println("цифра " + a1 + " - номер разряда 1");
                }
                if (isEq10) {
                    System.out.println("цифра " + a10 + " - номер разряда 2");
                }
                if (isEq100) {
                    System.out.println("цифра " + a100 + " - номер разряда 3");
                }
            } else {
                System.out.println("Одинаковых цифр в каждом разряде нет!");
            }
        } else {
            System.out.println("У обоих чисел все цифры разные.");
        }

        //5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';  // '\u005E' и '\u0031'
        System.out.print("Символ - " + symbol + " ");
        if (symbol >= '\u0030' && symbol <= '\u0039') {
            System.out.println("цифра");
        } else if (symbol >= '\u0041' && symbol <= '\u005A') {
            System.out.println("- большая буква");
        } else if (symbol >= '\u0061' && symbol <= '\u007A') {
            System.out.println("- маленькая буква");
        } else if (symbol <= '\u00FF') {
            System.out.println("- не буква и не цифра");
        }

        //6. Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        float depositSum = 301_000;
        float accruedInterest = 0;
        float totalSum = 0;
        if (depositSum < 100_000) {
            accruedInterest = depositSum * 0.05f;
        } else if (depositSum < 300_000) {
            accruedInterest = depositSum * 0.07f;
        } else {
            accruedInterest = depositSum * 0.1f;
        }
        totalSum = depositSum + accruedInterest;
        System.out.println("сумму вклада " + depositSum);
        System.out.println("сумму начисленного % " + accruedInterest);
        System.out.println("итоговую сумму с % " + totalSum);

        //7. Определение оценки по предметам
        System.out.println("7. Определение оценки по предметам");
        int percentHistory = 59;
        int percentProgramming = 92;
        int scoreHistory = 0;
        int scoreProgramming = 0;
        float averagePercent = (percentHistory + percentProgramming) / 2f;
        float averageScore = 0;
        // история
        if (percentHistory <= 60) {
            scoreHistory = 2;
        } else if (percentHistory <= 73) {
            scoreHistory = 3; 
        } else if (percentHistory <= 91) {
            scoreHistory = 4;
        } else {
            scoreHistory = 5; 
        }
        // программирование
        if (percentProgramming <= 60) {
            scoreProgramming = 2;
        } else if (percentProgramming <= 73) {
            scoreProgramming = 3; 
        } else if (percentProgramming <= 91) {
            scoreProgramming = 4;
        } else {
            scoreProgramming = 5; 
        }
        // средний балл
        if (averagePercent <= 60) {
            averageScore = 2;
        } else if (averagePercent <= 73) {
            averageScore = 3; 
        } else if (averagePercent <= 91) {
            averageScore = 4;
        } else {
            averageScore = 5; 
        }
        System.out.println("История\t\t\t\t\t" + scoreHistory + 
                "\nПрограммирование\t\t\t" + scoreProgramming +
                "\nCредний балл оценок по предметам\t" + averageScore +
                "\nCредний % по предметамt\t\t\t" + averagePercent);

        //8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли");
        int costProduction = 9_000;
        int rentalSpace = 5_000;
        int monthlSales = 15_000;
        float profitYear = (monthlSales - costProduction - rentalSpace) * 12;
        if (profitYear == 0) {
            System.out.println("Прибыль за год: " + profitYear + " руб.\n");  
        } else {
            System.out.printf("Прибыль за год: " + "%1$+,9.2f" + " руб.\n", profitYear); 
        }

    }
}