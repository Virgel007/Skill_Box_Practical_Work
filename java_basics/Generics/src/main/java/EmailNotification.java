import lombok.Data;
import ru.skillbox.notification.Notification;
import java.util.ArrayList;
import java.util.List;
@Data
public class EmailNotification implements Notification {
    private static final String NOTIFICATION_NAME = "EMAIL";
    private String subject;
    private List<String> emailList = new ArrayList<>();
    private String message;

    private String getStringEmailList() {
        StringBuilder result = new StringBuilder();
        for (String string : emailList) {
            result.append(string).append(" ");
        }
        return result.toString();
    }

    @Override
    public String formattedMessage() {
        return NOTIFICATION_NAME +  "\n" +
                "subject: " + getSubject() + "\n" +
                "receivers: " + getStringEmailList() + "\n" +
                "message: <p>" + getMessage() + "</p>";
    }
}