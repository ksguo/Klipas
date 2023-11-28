package main.com.universitysystem.dao;

import main.com.universitysystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> users;

    public UserDAO() {
        // Initialize with some mock users
        users = new HashMap<>();
        users.put("kguo1", new User("1", "kguo1", "123456", "kguo1@smail.uni-koeln.de"));
        users.put("admin", new User("2", "admin", "123456", "admin@example.com"));
        // Add more mock users as needed
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }
}
