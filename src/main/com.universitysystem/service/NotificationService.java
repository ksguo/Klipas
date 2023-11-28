package main.com.universitysystem.service;

import main.com.universitysystem.model.Notification;
import main.com.universitysystem.model.User;

public class NotificationService {

    public void sendNotification(User recipient, String message, String courseInfo) {
        Notification notification = new Notification("1", message, recipient, false, courseInfo);
        System.out.println("Notification sent to " + recipient.getUsername() + ": " + message);
        // In a real application, you would save this notification and handle its delivery
    }
}

