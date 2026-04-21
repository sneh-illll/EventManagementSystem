package model;

public class Event {
    private int eventId;
    private String name;
    private String date;
    private String location;
    private double price;

    public Event(String name, String date, String location, double price) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.price = price;
    }

    public String getName() { return name; }
}