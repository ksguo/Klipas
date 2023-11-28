package main.com.universitysystem.model;
import java.time.LocalDateTime;
public class Booking {

    private String bookingId;
    private Room room;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String eventName;

    // Constructor
    public Booking(String bookingId, Room room, User user, LocalDateTime startTime, LocalDateTime endTime, String eventName) {
        this.bookingId = bookingId;
        this.room = room;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventName = eventName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
