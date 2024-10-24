package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class Birthdays {
    private static final int DAY = 7; //31
    private static final int MONTH = 2; //12
    private static final int YEAR = 1988; //1990

    public static void main(String[] args) {
        collectBirthdays(YEAR, MONTH, DAY);
    }

    public static String collectBirthdays(int year,int month,int day) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - E", Locale.ENGLISH);
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while (birthday.isBefore(today)) {
            builder.append(i).append(birthday.format(formatDate)).append(System.lineSeparator());
            birthday = birthday.plusYears(1);
            i++;
        }
        System.out.println(builder);
        return String.valueOf(builder);
    }
}
