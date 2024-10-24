package practice;

import java.util.Scanner;

public class Main {
    private static final TodoList TODO_LIST = new TodoList();

    public static void main(String[] args) {
        while (true) {
            String regexNumber = "[^0-9]";
            String regexName = "[0-9]";
            String add = "ADD"; String edit = "EDIT"; String list = "LIST"; String delete = "DELETE"; String exit = "EXIT";
            String text = new Scanner(System.in).nextLine();
            String[] nameCommand = text.split(" ");
            String command = nameCommand[0];
            int space = text.indexOf(' ');
            if (command.equals(add)) {
                String nameIsEmpty = nameCommand[1].replaceAll(regexNumber, "");
                if (nameIsEmpty.isEmpty()) {
                    TODO_LIST.add(text.substring(space + 1));
                } else {
                    String name = text.replaceAll(regexName, "");
                    TODO_LIST.add(Integer.parseInt(nameCommand[1]), name.substring(space + 2));
                }
            }
            if (command.equals(edit)) {
                String name = text.replaceAll(regexName, "");
                TODO_LIST.edit(Integer.parseInt(nameCommand[1]), name.substring(space + 2));
            }
            if (command.equals(list)) {
                TODO_LIST.getTodos();
            }
            if (command.equals(delete)) {
                TODO_LIST.delete(Integer.parseInt(nameCommand[1]));
            }
            if (command.equals(exit)) {
                break;
            }
        }
    }
}