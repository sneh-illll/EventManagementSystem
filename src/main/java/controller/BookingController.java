package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class BookingController {

    public boolean bookEvent(int userId, int eventId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO bookings(user_id, event_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, eventId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getBookings() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT b.booking_id, e.name, e.date, e.location, e.price " +
                           "FROM bookings b " +
                           "JOIN events e ON b.event_id = e.event_id";

            PreparedStatement ps = con.prepareStatement(query);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean cancelBooking(int bookingId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM bookings WHERE booking_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, bookingId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getBookingsByUser(int userId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT b.booking_id, e.name, e.date, e.location, e.price " +
                           "FROM bookings b " +
                           "JOIN events e ON b.event_id = e.event_id " +
                           "WHERE b.user_id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}