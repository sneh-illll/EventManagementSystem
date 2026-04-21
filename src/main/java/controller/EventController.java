package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class EventController {

    public boolean addEvent(String name, String date, String location, double price) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO events(name, date, location, price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, location);
            ps.setDouble(4, price);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllEvents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM events";
            PreparedStatement ps = con.prepareStatement(query);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getEventById(int eventId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM events WHERE event_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, eventId);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteEvent(int eventId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM events WHERE event_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, eventId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}