import ru.skillbox.notification_sender.NotificationSender;
import java.util.List;

public class PushNotificationSender implements NotificationSender<PushNotification> {

    @Override
    public void send(PushNotification sendNotification) {
        System.out.println(sendNotification.formattedMessage());
    }

    @Override
    public void send(List<PushNotification> sendNotificationList) {
        for (PushNotification sendNotification : sendNotificationList) {
            send(sendNotification);
        }
    }
}