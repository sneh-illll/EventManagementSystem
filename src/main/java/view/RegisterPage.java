package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UserController;

public class RegisterPage extends JFrame {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JButton registerBtn;

    public RegisterPage() {
        setTitle("Register");
        setSize(300, 250);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 150, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 150, 25);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 100, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 100, 150, 25);
        add(passwordField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(100, 150, 100, 30);
        add(registerBtn);

        UserController uc = new UserController();

        registerBtn.addActionListener(e -> {
            boolean success = uc.register(
                nameField.getText(),
                emailField.getText(),
                new String(passwordField.getPassword())
            );

            JOptionPane.showMessageDialog(this,
                success ? "Registered Successfully" : "Error");
        });

        setVisible(true);
    }
}