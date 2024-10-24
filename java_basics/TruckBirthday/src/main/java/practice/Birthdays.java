package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {
        int day = 7; //31
        int month = 2; //12
        int year = 1988; //1990
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate today = LocalDate.now().plusDays(1);
        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - E", Locale.ENGLISH);
        int i = 0;
        StringBuilder text = new StringBuilder();

        while (birthday.isBefore(today)) {
            text.append(i).append(birthday.format(formatDate)).append(System.lineSeparator());
            birthday = birthday.plusYears(1);
            i++;
        }
        return text.toString();
    }
}
