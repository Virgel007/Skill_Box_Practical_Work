package practice;

import java.util.Scanner;

public class Main {
    private static final EmailList EMAIL_LIST = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] nameCommand = input.split(" ");
            String command = nameCommand[0];
            if (command.equals("EXIT")) {
                System.out.println("Выход из программы.");
                break;
            }

            if (command.equals("ADD")) {
                EMAIL_LIST.add(nameCommand[1]);
            }

            if (command.equals("LIST")) {
                EMAIL_LIST.getSortedEmails();
            }
        }
    }
}
