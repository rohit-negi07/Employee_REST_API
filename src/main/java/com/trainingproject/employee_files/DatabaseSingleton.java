package com.trainingproject.employee_files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	    private static DatabaseSingleton instance;  // Single instance
	    private Connection connection;
	    private static final String URL = "jdbc:mysql://localhost:3306/training/";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Rohit@123";

	    // Private constructor to prevent external instantiation
	    private DatabaseSingleton() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
	            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new RuntimeException("Database Connection Error: " + e.getMessage());
	        }
	    }

	    // Public method to get the single instance
	    public static DatabaseSingleton getInstance() {
	        if (instance == null) { // Lazy Initialization
	            synchronized (DatabaseSingleton.class) { // Thread safety
	                if (instance == null) {
	                    instance = new DatabaseSingleton();
	                }
	            }
	        }
	        return instance;
	    }

	    // Method to get the database connection
	    public Connection getConnection() {
	        return connection;
	    }
}