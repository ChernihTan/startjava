import java.util.Random;

public class RpsGameFormatting {
    public static void main(String[] args) {
        /*
        3.  “Форматирование кода”:
        •   скопируйте к себе на компьютер класс RpsGameFormatting, или перепечатайте его содержимое самостоятельно (что предпочтительней)
        •   отформатируйте его вручную, используя правила
        •   попробуйте разобраться в его коде и запустить, чтобы посмотреть, что он делает
        •   в классе есть ошибка - попробуйте ее найти и исправить
        •   если символы ✊, ✌, ✋отображаются в виде ??, то замените их на буквы R, S, P
        */    
        // Игра Камень-Ножницы-Бумага
        //public static void main(String[] args) throws InterruptedException {
        String rock = "R";      //"✊";
        String scissors = "S";  //"✌\uFE0F";
        String paper = "P";     //"✋" ;
        
        // Ход первого игрока
        String name1  = "HEL";
        Random r = new Random( );
        int position1 = r.nextInt( 1, 100 );
        System.out.print("Первый Random position1 = " + position1);
        String sign1 = rock;
        if (position1 > 66) {
            sign1 = paper;
        } else if (position1 > 33) {
            sign1 = scissors;
        }
        System.out.println(" соответствует sign1 = " + sign1);
        System.out.println("Ход " + name1 + ": ");
        for (int i = 0; i < 5; i ++) {
            System.out.print (rock + "\r") ;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print (scissors + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print (paper + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sign1);

        // Ход второго игрока
        String name2 = "WALLE";
        int position2 = r.nextInt (1,100);
        System.out.print("Второй Random position2 = " + position2);
        String sign2 = rock;
        if (position2 > 66) {
            sign2 = paper;
        } else if (position2 > 33) {
            sign2 = scissors;
        }
        System.out.println(" соответствует sign2 = " + sign2);
        System.out.println("Ход " + name2 + ": ");
        for (int i = 0 ; i < 5 ; i ++) {
            System.out.print(rock + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print( scissors + "\r" );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print ( paper + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println (sign2);

        if (sign1.equals( sign2 )) {
            System.out.println("Победила дружба!") ;
            return;
        }
        boolean isName1Equal = sign1.equals(rock) && sign2.equals(scissors) ||
                sign1.equals(scissors) && sign2.equals(paper) ||
                sign1.equals(paper) && sign2.equals(rock);
        if (isName1Equal) {
            System.out.println("\nПобедил - " + name1);
        } else {
                System.out.println("\nПобедил - " + name2);
        }
    }
}




/* Первоначальный код
import java.util.Random;

public class RpsGameFormatting {
// Игра Камень-Ножницы-Бумага
        public static void main(String[] args) throws InterruptedException {
        String rock ="✊";
        String scissors= "✌\uFE0F";
        String paper = "✋" ;


            // Ход первого игрока
        String name1  = "HEL";
        Random r = new Random( );
            int position1 = r.nextInt( 1, 100 );
            String sign1 = rock;


            if (position1 > 66) {
                sign1 = paper;
            }
    else if (position1 > 33) {
                sign1 = scissors;
            }


            System.out.println("Ход "+name1+ ": ");

        for (int i = 0; i<5; i ++)
        {
                System.out.print (rock + "\r") ;
            Thread.sleep(100);
                System.out.print (scissors + "\r" );
            Thread.sleep(100);
                System.out.print (paper + "\r");
            Thread.sleep(100);
        }

        System.out.println(sign1);


    // Ход второго игрока
        String name2 = "WALLE";
        int position2 = r.nextInt (1,100);
            String sign2 = rock;


            if (position1 > 66) {
                sign2 = paper;
            } else {
                if (position1 > 33) {
                    sign2 = scissors;
                }
            }

            System.out.println("Ход " +name2 +": ");

        for (int i = 0 ; i < 5 ; i ++) {
            System.out.print(rock + "\r");
                Thread.sleep(100);
            System.out.print( scissors + "\r" );
                Thread.sleep(100);
            System.out.print ( paper + "\r");
                Thread.sleep(100);
        }

        System.out.println (sign2);


        if (sign1.equals( sign2 ))
        {
            System.out.println("Победила дружба!") ;
            return;
        }


            boolean isName1Equal = sign1.equals(rock) && sign2.equals(scissors) ||
                    sign1.equals(scissors) && sign2.equals(paper) ||
                    sign1.equals(paper) && sign2.equals(rock);

            if (isName1Equal) {
        System.out.println("\nПобедил - " + name1);
          }   else {
                System.out.println("\nПобедил - " + name2);
            }
    }


}
*/