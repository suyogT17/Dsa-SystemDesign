package com.systemdesign.designpattern.bridge;

public class  BridgeMain {
    public static void main(String[] args) {
        Text textOverEmail = new Text(new Email());
        textOverEmail.sendNotification();
        QRCode qrCodeOverEmail = new QRCode(new Email());
        qrCodeOverEmail.sendNotification();

        Text textOverSMS = new Text(new SMS());
        textOverSMS.sendNotification();
        QRCode qrCodeOverSMS = new QRCode(new SMS());
        qrCodeOverSMS.sendNotification();
    }
}

interface NotificationSender {
    void sendNotification();
}

class SMS implements NotificationSender {

    public void sendNotification() {
        System.out.println("Sending SMS");
    }
}

class Email implements NotificationSender {

    public void sendNotification() {
        System.out.println("Sending Email");
    }
}
//in future can add many other implementation

abstract class Notification {
    NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract void sendNotification();
}

class Text extends Notification {

    public Text(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is text notification");
    }

    void sendNotification() {
        notificationSender.sendNotification();
    }
}

class QRCode extends Notification {

    public QRCode(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is QR code");
    }

    void sendNotification() {
        notificationSender.sendNotification();
    }
}