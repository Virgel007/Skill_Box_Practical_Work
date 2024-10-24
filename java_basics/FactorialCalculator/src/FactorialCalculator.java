import java.util.Scanner;
public class FactorialCalculator {
    public static void main(String[] args) {
        System.out.println("Enter a number from 1 to 12");
        int value = new Scanner(System.in).nextInt();
        for (int i = 1; i < 100; i++) {
            value = value * i;
            if (value < 10000) {
                System.out.println(value + "!");
            } else if (value > 10001) {
                System.out.println("Stop");
                break;
            }
        }
    }
}