package com.expensetracker.dao;

import com.expensetracker.model.User;
import com.expensetracker.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO Class (Database Access Object)
 * Handles all database operations for Users
 * 
 * Tasks:
 * - Register new users
 * - Login users
 * - Check if user exists
 * - Get user information
 */
public class UserDAO {
    
    // 1. REGISTER USER - Add a new user to database
    public boolean registerUser(User user) {
        // SQL command to insert new user
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (
            // Get connection to database
            Connection conn = DatabaseConnection.getConnection();
            // Prepare the SQL statement
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Fill in the ? values in SQL query
            pstmt.setString(1, user.getUsername());  // First ? = username
            pstmt.setString(2, user.getEmail());     // Second ? = email
            pstmt.setString(3, user.getPassword());  // Third ? = password
            
            // Execute the insert query
            pstmt.executeUpdate();
            return true; // Success
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Failed
        }
    }
    
    // 2. LOGIN USER - Check if user exists with this username and password
    public User loginUser(String username, String password) {
        // SQL command to find a user
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Set search values
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            // Execute query and get result
            ResultSet rs = pstmt.executeQuery();
            
            // If user is found
            if (rs.next()) {
                // Create new User object
                User user = new User();
                // Fill it with data from database
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user; // Return the user
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // User not found
    }
    
    // 3. GET USER BY ID - Find user by their ID
    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 4. CHECK IF USER EXISTS - Check if username is already taken
    public boolean userExists(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if found, false if not
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
