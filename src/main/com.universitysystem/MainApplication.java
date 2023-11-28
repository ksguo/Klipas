package main.com.universitysystem;

import main.com.universitysystem.GUI.gui;
import main.com.universitysystem.dao.UserDAO;
import main.com.universitysystem.service.AuthenticationService;

public class MainApplication {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO(); // Create a UserDAO instance
        AuthenticationService authService = new AuthenticationService(userDAO); // Pass it to AuthenticationService
        gui gui = new gui(authService);
        gui.displayLoginInterface();
    }
}

