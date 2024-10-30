package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

public class Login {
    private final String username;
    private final String password;

    // Constructor to initialize username and password
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to authenticate user
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Method to prompt user for login details and authenticate
    public boolean promptLogin() {
        String enteredUsername = JOptionPane.showInputDialog("Enter Username:");
        String enteredPassword = JOptionPane.showInputDialog("Enter Password:");

        if (authenticate(enteredUsername, enteredPassword)) {
            JOptionPane.showMessageDialog(null, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Incorrect username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
