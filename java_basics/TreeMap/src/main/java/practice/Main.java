package practice;

import java.util.Scanner;

public class Main {
    private static final PhoneBook PHONE_BOOK = new PhoneBook();
    private static final Scanner SCANNER = new Scanner(System.in);
    static String regexPhone = "[^0-9]";
    static String regexName = "[^А-Яа-я]";
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = SCANNER.nextLine();
            if (input.equals("EXIT")) {
                System.out.println("Выход из программы! " + input);
                break;
            }
            if (!inputIsName(input) && !inputIsPhone(input) && !input.equals("LIST")) {
                printError();
            }
            if (input.equals("LIST")) {
                System.out.println(PHONE_BOOK.getAllContacts());
            }
            if (inputIsName(input)) {
                processingName(input);
            }
            if (inputIsPhone(input)) {
                processingPhone(input);
            }
        }
    }

    public static void processingName(String name) {
        if (!PHONE_BOOK.containsName(name)) {
            System.out.println("Такого имени в телефонной книге нет." + "\n" +
                    "Введите номер телефона для абонента: " + name);
            String phone = SCANNER.nextLine();
            if (inputIsPhone(phone)) {
                PHONE_BOOK.addContact(phone, name);
                printSaveContact();
            } else {
                printError();
            }
        } else {
            System.out.println("Такое имя уже есть." + "\n" +
                    "Введите номер телефона для абонента: " + name);
            String phone = SCANNER.nextLine();
            if (inputIsPhone(phone)) {
                PHONE_BOOK.addContact(phone, name);
                printSaveContact();
            } else {
                printError();
            }
        }
    }
    public static void processingPhone(String phone) {
        if (!PHONE_BOOK.containsPhone(phone)) {
            System.out.println("Такого номера нет в телефонной книге." + "\n" +
                    "Введите имя абонента для номера: " + phone);
            String name = SCANNER.nextLine();
            if (inputIsName(name)) {
                PHONE_BOOK.addContact(phone, name);
                printSaveContact();
            } else {
                printError();
            }
        } else {
            System.out.println("Такой номер телефона уже есть:" + "\n" +
                    "Введите имя абонента для номера: " + phone);
            String name = SCANNER.nextLine();
            if (inputIsName(name)) {
                PHONE_BOOK.addContact(phone, name);
                printSaveContact();
            } else {
                printError();
            }
        }
    }

    public static boolean inputIsName (String input) {
        return input.equals(input.replaceAll(regexName, ""));
    }
    public static boolean inputIsPhone (String input) {
        return input.equals(input.replaceAll(regexPhone, ""));
    }

    public static void printSaveContact() {
        System.out.println("Контакт сохранен!");
    }

    public static void printError() {
        System.out.println("Неверный формат ввода");
    }
}