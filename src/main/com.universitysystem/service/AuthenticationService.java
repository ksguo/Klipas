package main.com.universitysystem.service;

import main.com.universitysystem.dao.UserDAO;
import main.com.universitysystem.model.User;

public class AuthenticationService {

    private UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Method to authenticate users
    public User authenticate(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }
    // Other methods...
}
