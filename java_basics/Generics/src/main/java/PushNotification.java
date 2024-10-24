import lombok.Data;
import ru.skillbox.notification.Notification;

@Data
public class PushNotification implements Notification {

    private static final String NOTIFICATION_NAME = "PUSH";
    private String title;
    private String receiver;
    private String message;

    @Override
    public String formattedMessage() {
        return NOTIFICATION_NAME +  "\n" +
                "title: " + getTitle() + "\n" +
                "receiver: " + getReceiver() + "\n" +
                "message: \uD83D\uDC4B " + getMessage();
    }
}
