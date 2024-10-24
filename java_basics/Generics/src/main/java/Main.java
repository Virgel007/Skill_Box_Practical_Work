import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailNotification emailNotification_0 = new EmailNotification();
        emailNotification_0.setSubject("Успешная регистрация!");
        emailNotification_0.setMessage("Спасибо за регистрацию на сервисе!");
        emailNotification_0.getEmailList().add("oleg@java.skillbox.ru");
        emailNotification_0.getEmailList().add("masha@java.skillbox.ru");
        emailNotification_0.getEmailList().add("yan@java.skillbox.ru");
        EmailNotification emailNotification_1 = new EmailNotification();
        emailNotification_1.setSubject("Успешная регистрация!");
        emailNotification_1.setMessage("Спасибо за регистрацию на сервисе!");
        emailNotification_1.getEmailList().add("1_oleg@java.skillbox.ru");
        emailNotification_1.getEmailList().add("1_masha@java.skillbox.ru");
        emailNotification_1.getEmailList().add("1_yan@java.skillbox.ru");

        EmailNotificationSender emailSender = new EmailNotificationSender();
        emailSender.send(emailNotification_0);
        List<EmailNotification> emailListSender = new ArrayList<>();
        emailListSender.add(emailNotification_0);
        emailListSender.add(emailNotification_1);
        emailSender.send(emailListSender);

        System.out.println();
        PushNotification pushNotification_0 = new PushNotification();
        pushNotification_0.setTitle("Успешная регистрация!");
        pushNotification_0.setReceiver("o.ivan");
        pushNotification_0.setMessage("Спасибо за регистрацию на сервисе!");
        PushNotification pushNotification_1 = new PushNotification();
        pushNotification_1.setTitle("Успешная регистрация!");
        pushNotification_1.setReceiver("1_o.ivan");
        pushNotification_1.setMessage("Спасибо за регистрацию на сервисе!");

        PushNotificationSender pushSender = new PushNotificationSender();
        pushSender.send(pushNotification_0);
        List<PushNotification> pushListSender = new ArrayList<>();
        pushListSender.add(pushNotification_0);
        pushListSender.add(pushNotification_1);
        pushSender.send(pushListSender);

        System.out.println();
        SmsNotification smsNotification_0 = new SmsNotification();
        smsNotification_0.setPhone("+70001234567");
        smsNotification_0.setMessage("Спасибо за регистрацию на сервисе!");
        SmsNotification smsNotification_1 = new SmsNotification();
        smsNotification_1.setPhone("+71111234567");
        smsNotification_1.setMessage("Спасибо за регистрацию на сервисе!");

        SmsNotificationSender smsSender = new SmsNotificationSender();
        smsSender.send(smsNotification_0);
        List<SmsNotification> smsListSender = new ArrayList<>();
        smsListSender.add(smsNotification_0);
        smsListSender.add(smsNotification_1);
        smsSender.send(smsListSender);
    }
}