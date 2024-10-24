import ru.skillbox.notification_sender.NotificationSender;
import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {

    @Override
    public void send(EmailNotification sendNotification) {
        System.out.println(sendNotification.formattedMessage());
    }

    @Override
    public void send(List<EmailNotification> sendNotificationList) {
        for (EmailNotification sendNotification : sendNotificationList) {
            send(sendNotification);
        }
    }
}
