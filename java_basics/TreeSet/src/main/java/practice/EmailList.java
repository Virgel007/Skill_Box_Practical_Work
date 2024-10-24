package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class EmailList {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    private final TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        String regex = "[^@.]+";
        String equalsRegex = "@.";
        if (equalsRegex.equals(email.replaceAll(regex, ""))) {
            emailList.add(email.toLowerCase());
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        for (String list : emailList) {
            System.out.println(list);
        }
        return new ArrayList<>(emailList);
    }
}