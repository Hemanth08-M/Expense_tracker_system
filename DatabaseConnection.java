package com.expensetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection Class
 * This class handles connection to MySQL database
 * Use getConnection() method to get database connection
 */
public class DatabaseConnection {
    // Database Details
    private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String USER = "root";      // MySQL username
    private static final String PASSWORD = "root"; // MySQL password
    
    // Static block - runs once when class loads
    // Loads the MySQL driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * getConnection() - Get a database connection
     * Call this whenever you need to connect to database
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
