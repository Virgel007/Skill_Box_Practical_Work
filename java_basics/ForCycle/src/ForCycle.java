import java.util.Scanner;

public class ForCycle {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int value = new Scanner(System.in).nextInt();
        for (int i = 0; i <= value; i++) {
            for (int j = 0; j <= value; j++) {
                if (i * j == value) {
                    System.out.println(i + " * " + j);
                }
            }
        }
    }
}