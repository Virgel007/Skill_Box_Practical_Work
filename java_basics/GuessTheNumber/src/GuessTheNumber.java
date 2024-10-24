import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int value = new Random().nextInt(100);
        System.out.println("The game! Guess the Number");
        while (true) {
            int attempt = new Scanner(System.in).nextInt();
            if (attempt == value) {
                System.out.println("You guessed right!");
                break;
            } else if (attempt < value) {
                System.out.println("The mysterious number is bigger!");
            } else if (attempt > value) {
                System.out.println("The mysterious number is less!");
            }
        }
    }
}