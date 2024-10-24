import ru.skillbox.notification_sender.NotificationSender;
import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {

    @Override
    public void send(SmsNotification sendNotification) {
        System.out.println(sendNotification.formattedMessage());
    }

    @Override
    public void send(List<SmsNotification> sendNotificationList) {
        for (SmsNotification sendNotification : sendNotificationList) {
            send(sendNotification);
        }
    }
}