package com.expensetracker.model;

import java.time.LocalDate;

/**
 * Expense Model Class
 * Represents an expense object with all expense information
 */
public class Expense {
    // Expense properties/variables
    private int expenseId;      // Unique ID (auto-generated)
    private int userId;         // ID of user who created this
    private String category;    // Category (Food, Transport, etc)
    private double amount;      // Amount spent (with decimals)
    private String description; // Details about the expense
    private LocalDate date;     // When was the expense made
    
    // Empty Constructor
    public Expense() {
    }
    
    // Constructor without ID (used when adding new expense)
    public Expense(int userId, String category, double amount, String description, LocalDate date) {
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
    
    // Getter and Setter methods
    public int getExpenseId() {
        return expenseId;
    }
    
    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
