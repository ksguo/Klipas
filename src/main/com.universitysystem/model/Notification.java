package main.com.universitysystem.model;

public class Notification {
    private String notificationId;
    private String message;
    private User recipient;
    private boolean isRead;
    private String courseInfo; // Attribute for course information

    // Updated constructor
    public Notification(String notificationId, String message, User recipient, boolean isRead, String courseInfo) {
        this.notificationId = notificationId;
        this.message = message;
        this.recipient = recipient;
        this.isRead = isRead;
        this.courseInfo = courseInfo; // Set the course information
    }


    // Getters and Setters


    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }
    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getRecipient() {
        return recipient;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
    // ...

    // Method to mark notification as read
    public void markAsRead() {
        this.isRead = true;
    }

    // Additional methods relevant to notifications
    // ...
}
