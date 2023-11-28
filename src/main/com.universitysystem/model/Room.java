package main.com.universitysystem.model;

public class Room {
    private String roomNumber;
    private int capacity;
    private boolean isAvailable;
    // Other room properties like equipment, location, etc.

    // Constructor
    public Room(String roomNumber, int capacity, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }


    // Constructor, getters, and setters


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
