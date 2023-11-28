package main.com.universitysystem.GUI;

import main.com.universitysystem.model.Course;
import main.com.universitysystem.model.User;
import main.com.universitysystem.service.AuthenticationService;
import main.com.universitysystem.service.CourseService;
import main.com.universitysystem.service.NotificationService;
import main.com.universitysystem.dao.CourseDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class gui {

    private AuthenticationService authService;
    private CourseService courseService;
    private NotificationService notificationService;
    private JFrame frame;
    private User authenticatedUser; // Store the authenticated user
    private String selectedCourseName; // To store the name of the selected course

    public gui(AuthenticationService authService) {
        this.authService = authService;
        this.courseService = new CourseService(new CourseDAO()); // Initialize CourseService with CourseDAO
        this.notificationService = new NotificationService(); // Initialize NotificationService
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("University System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); // Center the window
    }

    public void displayLoginInterface() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel();

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                User user = authService.authenticate(username, password);
                if (user != null) {
                    displayOperationInterface(user);
                } else {
                    messageLabel.setText("Login failed.");
                }
            }
        });

        frame.revalidate();
        frame.setVisible(true);
    }

    private void displayOperationInterface(User user) {
        authenticatedUser = user;

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(new BorderLayout());

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        JButton btnCourse = new JButton("Course");
        JButton btnRoom = new JButton("Room");
        JButton btnUser = new JButton("User");
        JButton btnNotification = new JButton("Notification");

        btnCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCourses();
            }
        });

        btnNotification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayNotification();
            }
        });



        sidePanel.add(btnCourse);
        sidePanel.add(btnRoom);
        sidePanel.add(btnUser);
        sidePanel.add(btnNotification);

        frame.add(sidePanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        frame.add(rightPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.setVisible(true);
    }

    private void displayCourses() {
        List<Course> courses = courseService.getAllCourses();
        JPanel coursesPanel = new JPanel();
        coursesPanel.setLayout(new BoxLayout(coursesPanel, BoxLayout.Y_AXIS));

        for (Course course : courses) {
            JButton courseButton = new JButton(course.getCourseName());
            coursesPanel.add(courseButton);

            courseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectedCourseName = course.getCourseName();
                    String notificationMessage = "You have registered for the course: " + course.getCourseName();
                    notificationService.sendNotification(authenticatedUser, notificationMessage, course.getCourseName());
                    JOptionPane.showMessageDialog(frame, notificationMessage);
                }
            });
        }

        // Add a "Back" button to return to the main operation interface
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayOperationInterface(authenticatedUser);
            }
        });

        coursesPanel.add(backButton);

        frame.getContentPane().removeAll();
        frame.add(coursesPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void displayNotification() {
        frame.getContentPane().removeAll();
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));

        JTextArea notificationArea = new JTextArea();
        notificationArea.setEditable(false);

        if (selectedCourseName != null) {
            notificationArea.setText("You are registered for the course: " + selectedCourseName);
        } else {
            notificationArea.setText("No course selected");
        }

        notificationPanel.add(notificationArea);

        // Add a "Back" button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayOperationInterface(authenticatedUser);
            }
        });

        notificationPanel.add(backButton);

        frame.add(notificationPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }


}
