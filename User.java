package com.expensetracker.model;

/**
 * User Model Class
 * Represents a user object with all user information
 */
public class User {
    // User properties/variables
    private int userId;        // Unique ID (auto-generated from database)
    private String username;   // User's username
    private String email;      // User's email
    private String password;   // User's password
    
    // Empty Constructor - creates empty User object
    public User() {
    }
    
    // Full Constructor - creates User with all values
    public User(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    // Getter and Setter methods for each property
    // Getter = read value, Setter = write/change value
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
