## Project Description

The Event Management System is used to manage events and bookings. Users can register and login into the system. After login, users can view available events, book events and see their bookings. Events can also be added and deleted.

## Features

* User Registration
* User Login
* Add Event
* View Events
* Delete Event
* Book Event
* View Bookings
* Cancel Booking

## Technologies Used

* Java
* Java Swing
* MySQL
* JDBC
* Maven
* JUnit
* GitHub

## Project Structure

* `controller` → Handles logic
* `view` → GUI pages
* `model` → Classes for data
* `database` → Database connection
* `util` → Helper classes

## Database Tables

* users
* events
* bookings

## How to Run

1. Create database in MySQL named `eventdb`
2. Update username and password in `DBConnection.java`
3. Open project in VS Code
4. Run `Main.java`

## Testing

JUnit test cases are added for different modules.

## Build

Maven is used to build the project and generate JAR file.

