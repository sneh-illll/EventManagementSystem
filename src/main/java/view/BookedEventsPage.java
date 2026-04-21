package view;

import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookingController;
import util.UIStyle;

public class BookedEventsPage extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton cancelBtn;

    public BookedEventsPage() {
        setTitle("My Bookings");
        setSize(650, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(UIStyle.bgColor);

        model = new DefaultTableModel();
        table = new JTable(model);

        table.setRowHeight(30);
        table.setFont(new java.awt.Font("Arial", 0, 13));
        table.getTableHeader().setFont(new java.awt.Font("Arial", 1, 14));
        table.getTableHeader().setBackground(UIStyle.primaryColor);
        table.getTableHeader().setForeground(java.awt.Color.WHITE);

        model.addColumn("Booking ID");
        model.addColumn("Event Name");
        model.addColumn("Date");
        model.addColumn("Location");
        model.addColumn("Price");

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 20, 600, 250);
        add(sp);

        cancelBtn = new JButton("Cancel Booking");
        cancelBtn.setBounds(230, 300, 180, 35);
        UIStyle.styleDangerButton(cancelBtn);
        add(cancelBtn);

        loadBookings();

        cancelBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select booking!");
                return;
            }

            int id = (int) model.getValueAt(row, 0);
            new BookingController().cancelBooking(id);

            model.setRowCount(0);
            loadBookings();
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadBookings() {
        try {
            ResultSet rs = new BookingController().getBookings();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("booking_id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getDouble("price")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}