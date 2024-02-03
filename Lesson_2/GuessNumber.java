import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    // возвращает 1 - выиграл первый игрок, 0 - выиграл второй игрок
    public int game(String Player1, String Player2) {
        Scanner scanner = new Scanner(System.in);
        //Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        //int computerNumber = (int) (Math.random()*100) + 1;
        
        //нужно (0, 100] - целые числа
        Random r = new Random();
        int computerNumber = r.nextInt(1, 100);
        int guess = -1;
        int whoPlays = 0;
        int count = 0;
        System.out.println("Техническое сообщение для меня:");
        System.out.println("Компьютер загадал случайное число целое в полуинтервале (0, 100]: " + 
                computerNumber);
        String namePlayer;
        while (guess != computerNumber) {
            count++;
            whoPlays = count % 2;

            if (whoPlays == 1) {
                namePlayer = Player1;
            } else {
                namePlayer = Player2;
            }
            System.out.print("\nИгрок " + namePlayer + " делает попытку отгадать число: ");
            guess = scanner.nextInt();
            if (guess == computerNumber) {
                System.out.println("Игрок угадал!");
            } else if (guess < computerNumber) {
                System.out.println("Число " + guess + " меньше того, что загадал компьютер");
            } else {
                System.out.println("Число " + guess + " больше того, что загадал компьютер");
            }
        }
        return whoPlays;
    }
}
