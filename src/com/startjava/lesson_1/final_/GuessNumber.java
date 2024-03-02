public class GuessNumber {
    public static void main(String[] args) {
        //2. Игра "Угадай число"
        System.out.println("Игра \"Угадай число\"");
        //Math.random() генерирует случайные вещественные числа из промежутка [0;1)
        int numberToGuess = (int) (Math.random()*100) + 1;
        System.out.println("Компьютер загадал случайное число целое в полуинтервале (0, 100]: " + 
                numberToGuess);
        // Первая попытка игрока
        //int guess = (int) (Math.random()*100) + 1;
        int guess = 50;
        int max = 100;
        int min = 1;
        int count = 1;
        System.out.println("Попытки игрока:\n" + count + ") " + guess);
        while (guess != numberToGuess) {
            if (guess < numberToGuess) {
                min = guess;
                System.out.println("Число " + guess + " меньше того, что загадал компьютер");
            } else {
                max = guess;
                System.out.println("Число " + guess + " больше того, что загадал компьютер");
            }
            guess = (min + max) / 2;
            if ((min + max) % 2 == 1) {
                guess++;
            }
            count++;
            System.out.println(count + ") " + guess);
        }
        System.out.println("Вы победили!  Ответ " + guess + "!");
    }
}
