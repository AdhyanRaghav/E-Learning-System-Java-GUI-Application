package com.elearning.views;

import com.elearning.controllers.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginView() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 80, 30);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 30);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                UserController userController = new UserController();
                if (userController.authenticate(email, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new DashboardView();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                }
            }
        });
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }
}
