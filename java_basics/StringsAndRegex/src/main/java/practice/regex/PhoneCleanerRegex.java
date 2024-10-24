package practice.regex;
import java.util.Scanner;

public class PhoneCleanerRegex {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      // TODO:напишите ваш код тут, результат вывести в консоль.
    String input = scanner.nextLine();
    String cleanedInput = input.replaceAll("\\D+", "");
    if (cleanedInput.matches("([78])?90([59])\\d{7}")) {
      cleanedInput = cleanedInput.replaceFirst("^(8?)(90)", "7$2");
      System.out.println(cleanedInput);
    } else {
      System.out.print("Неверный формат номера");
    }
  }
}