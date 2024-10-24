import lombok.Data;
import ru.skillbox.notification.Notification;

@Data
public class SmsNotification implements Notification {

    private static final String NOTIFICATION_NAME = "SMS";
    private String phone;
    private String message;

    @Override
    public String formattedMessage() {
        return NOTIFICATION_NAME +  "\n" +
                "receivers: " + getPhone() + "\n" +
                "message: " + getMessage();
    }
}