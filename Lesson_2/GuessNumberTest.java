import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Начинаем игру \"Угадай число\"."); 
        System.out.println("Для участия в игре приглашаются два игрока."); 

        Player playerOne = new Player("Игрок1");
        Player playerSecont = new Player("Игрок2");
        GuessNumber gameProcess = new GuessNumber();
        String answer;
        String namePlayer;
        int count = 0;
        // Ввод игроков
        do {
            count++;
            System.out.print("Игрок №" + count + ", представьтесь, пожалуйста: ");
            switch(count) {
            case 1:
                //Player PlayerOne = new Player(scanner.next());
                playerOne.setName(scanner.next());
                break;
            case 2:
                //Player PlayerSecont = new Player(scanner.next());
                playerSecont.setName(scanner.next());
            }
        } while (count < 2); 
        System.out.println("Игру начинают два игрока под именами: " + 
                playerOne.getName() + " и " + playerSecont.getName());
        // игра
        do {
            int whoWins = gameProcess.game(playerOne.getName(), playerSecont.getName());
            switch(whoWins) {
                case 1:
                    playerOne.addPoint();
                    break;
                case 0:
                 playerSecont.addPoint();
            }
            // жду только правильного ввода
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next();
                answer = answer.toUpperCase();  //toLowerCase();
            } while(!answer.equals("NO") && !answer.equals("YES"));
        } while(answer.equals("YES") ? true : false); 
        // завершение
        System.out.println("Игра закончена со счетом:");
        System.out.printf("%-12s%-12s%n", playerOne.getName(), playerSecont.getName());
        System.out.printf("  %-12d%-12d%n", playerOne.getWinsPoints(), playerSecont.getWinsPoints());    
    }
}

/*
        System.out.print("Первый игрок, представьтесь, пожалуйста: "); 
        //String name1 = scanner.next();
        Player PlayerOne = new Player(scanner.next());
        System.out.print("Второй игрок, представьтесь, пожалуйста: "); 
        //String name1 = scanner.next();
        Player PlayerSecont = new Player(scanner.next());

*/