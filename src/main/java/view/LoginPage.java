package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UserController;
import util.UIStyle;

public class LoginPage extends JFrame {

    JTextField emailField;
    JPasswordField passwordField;
    JButton loginBtn, registerBtn;

    public LoginPage() {
        setTitle("Login");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(UIStyle.bgColor);

        JLabel title = new JLabel("Event Management");
        title.setBounds(70, 10, 250, 30);
        title.setFont(UIStyle.titleFont);
        add(title);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 60, 150, 30);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 100, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 100, 150, 30);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(40, 150, 100, 35);
        UIStyle.styleButton(loginBtn);
        add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(160, 150, 120, 35);
        UIStyle.styleButton(registerBtn);
        add(registerBtn);

        UserController uc = new UserController();

        loginBtn.addActionListener(e -> {
            if (uc.login(emailField.getText(), new String(passwordField.getPassword()))) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        registerBtn.addActionListener(e -> new RegisterPage());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}