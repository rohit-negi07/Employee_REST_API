package com.trainingproject.employee_files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	 // Step 1: Private static variable to hold the single instance of the class
    private static DBConnection instance;
    private Connection connection;

    // Step 2: Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/training"; // Update with your DB URL
    private static final String USER = "root"; // Update with your DB 
    private static final String PASSWORD = "Rohit@123"; // Update with your DB password

    // Step 3: Private constructor to prevent instantiation from outside
    private DBConnection() {
        try {
            // Step 4: Load MySQL JDBC driver (optional in MySQL 8.0 and later)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 5: Establish connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle connection error appropriately
        }
    }

    // Step 6: Public method to get the instance of DBConnection
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
            System.out.println("instance method called");
        }
        return instance;
    }

    // Step 7: Method to get the connection
    public Connection getConnection() {
    	System.out.println("Connection established!");
        return connection;
    }

    // Step 8: Optional method to close the connection (not always needed)
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
