package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EventController;
import util.UIStyle;

public class AddEventPage extends JFrame {

    JTextField nameField, dateField, locationField, priceField;
    JButton addBtn;

    public AddEventPage() {
        setTitle("Add Event");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(UIStyle.bgColor);

        JLabel title = new JLabel("Add Event");
        title.setFont(UIStyle.titleFont);
        title.setBounds(130, 10, 200, 30);
        add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 180, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(30, 100, 100, 25);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(150, 100, 180, 30);
        add(dateField);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(30, 140, 100, 25);
        add(locationLabel);

        locationField = new JTextField();
        locationField.setBounds(150, 140, 180, 30);
        add(locationField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(30, 180, 100, 25);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(150, 180, 180, 30);
        add(priceField);

        addBtn = new JButton("Add Event");
        addBtn.setBounds(130, 230, 150, 35);
        UIStyle.styleButton(addBtn);
        add(addBtn);

        EventController ec = new EventController();

        addBtn.addActionListener(e -> {
            try {
                boolean success = ec.addEvent(
                        nameField.getText(),
                        dateField.getText(),
                        locationField.getText(),
                        Double.parseDouble(priceField.getText())
                );

                JOptionPane.showMessageDialog(this,
                        success ? "Event Added!" : "Error");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input");
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}