package view;

import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookingController;
import controller.EventController;
import util.UIStyle;

public class ViewEventsPage extends JFrame {

    JTable table;
    DefaultTableModel model;

    JButton bookBtn, deleteBtn, refreshBtn;

    public ViewEventsPage() {

        setTitle("View Events");
        setSize(750, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(UIStyle.bgColor);

        JLabel title = new JLabel("All Events");
        title.setFont(UIStyle.titleFont);
        title.setBounds(300, 10, 200, 30);
        add(title);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Date");
        model.addColumn("Location");
        model.addColumn("Price");

        table = new JTable(model);

        table.setRowHeight(28);
        table.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 60, 690, 250);
        add(sp);

        bookBtn = new JButton("Book Event");
        bookBtn.setBounds(40, 350, 150, 35);
        UIStyle.styleButton(bookBtn);
        add(bookBtn);

        deleteBtn = new JButton("Delete Event");
        deleteBtn.setBounds(250, 350, 150, 35);
        UIStyle.styleDangerButton(deleteBtn);
        add(deleteBtn);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(470, 350, 150, 35);
        UIStyle.styleButton(refreshBtn);
        add(refreshBtn);

        loadEvents();

        bookBtn.addActionListener(e -> bookEvent());

        deleteBtn.addActionListener(e -> deleteEvent());

        refreshBtn.addActionListener(e -> refreshTable());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadEvents() {
        try {
            EventController ec = new EventController();
            ResultSet rs = ec.getAllEvents();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("event_id"),
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

    public void refreshTable() {
        model.setRowCount(0);
        loadEvents();
    }

    public void bookEvent() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select event first!");
            return;
        }

        int eventId = (int) model.getValueAt(row, 0);

        BookingController bc = new BookingController();

        boolean success = bc.bookEvent(1, eventId);

        JOptionPane.showMessageDialog(this,
                success ? "Event Booked!" : "Booking Failed");
    }

    public void deleteEvent() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select event first!");
            return;
        }

        int eventId = (int) model.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this event?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            EventController ec = new EventController();

            boolean success = ec.deleteEvent(eventId);

            if (success) {
                JOptionPane.showMessageDialog(this, "Event Deleted!");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Delete Failed!");
            }
        }
    }
}