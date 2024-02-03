import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Начинаем игру \"Угадай число\"."); 
        System.out.println("Для участия в игре приглашаются два игрока."); 

        Player player1 = new Player("Игрок1");
        Player player2 = new Player("Игрок2");
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
                player1.setName(scanner.next());
                break;
            case 2:
                player2.setName(scanner.next());
            }
        } while (count < 2); 
        System.out.println("Игру начинают два игрока под именами: " + 
                player1.getName() + " и " + player2.getName());
        // игра
        do {
            int whoWins = gameProcess.game(player1.getName(), player2.getName());
            switch(whoWins) {
                case 1:
                    player1.addPoint();
                    break;
                case 0:
                 player2.addPoint();
            }
            // жду только правильного ввода
            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scanner.next().toUpperCase();
            } while(!answer.equals("NO") && !answer.equals("YES"));
        } while(!answer.equals("NO")); 
        // завершение
        System.out.println("Игра закончена со счетом:");
        System.out.printf("%-12s%-12s%n", player1.getName(), player2.getName());
        System.out.printf("  %-12d%-12d%n", player1.getWinsPoints(), player2.getWinsPoints());    
    }
}
