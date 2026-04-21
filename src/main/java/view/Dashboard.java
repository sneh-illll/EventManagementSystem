package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import util.UIStyle;

public class Dashboard extends JFrame {

    JButton addEventBtn, viewEventBtn, bookedBtn;

    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(UIStyle.bgColor);

        JLabel title = new JLabel("Dashboard");
        title.setFont(UIStyle.titleFont);
        title.setBounds(140, 20, 200, 30);
        add(title);

        addEventBtn = new JButton("Add Event");
        addEventBtn.setBounds(120, 80, 150, 35);
        UIStyle.styleButton(addEventBtn);
        add(addEventBtn);

        viewEventBtn = new JButton("View Events");
        viewEventBtn.setBounds(120, 130, 150, 35);
        UIStyle.styleButton(viewEventBtn);
        add(viewEventBtn);

        bookedBtn = new JButton("My Bookings");
        bookedBtn.setBounds(120, 180, 150, 35);
        UIStyle.styleButton(bookedBtn);
        add(bookedBtn);

        addEventBtn.addActionListener(e -> new AddEventPage());
        viewEventBtn.addActionListener(e -> new ViewEventsPage());
        bookedBtn.addActionListener(e -> new BookedEventsPage());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}