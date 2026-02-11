package com.expensetracker.dao;

import com.expensetracker.model.Expense;
import com.expensetracker.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ExpenseDAO Class (Database Access Object)
 * Handles all database operations for Expenses
 * 
 * Tasks:
 * - Add new expenses
 * - View expenses
 * - Delete expenses
 * - Calculate total expenses
 */
public class ExpenseDAO {
    
    // 1. ADD EXPENSE - Insert new expense into database
    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (user_id, category, amount, description, date) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Set all the values
            pstmt.setInt(1, expense.getUserId());
            pstmt.setString(2, expense.getCategory());
            pstmt.setDouble(3, expense.getAmount());
            pstmt.setString(4, expense.getDescription());
            pstmt.setDate(5, java.sql.Date.valueOf(expense.getDate()));
            
            // Execute insert
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // 2. GET ALL EXPENSES - Get all expenses for a user
    public List<Expense> getExpensesByUserId(int userId) {
        List<Expense> expenses = new ArrayList<>(); // Create empty list
        String sql = "SELECT * FROM expenses WHERE user_id = ? ORDER BY date DESC";
        
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            // Loop through all expenses found
            while (rs.next()) {
                // Create new Expense object
                Expense expense = new Expense();
                // Fill it with data from database
                expense.setExpenseId(rs.getInt("expense_id"));
                expense.setUserId(rs.getInt("user_id"));
                expense.setCategory(rs.getString("category"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setDate(rs.getDate("date").toLocalDate());
                
                // Add to list
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses; // Return list of expenses
    }
    
    // 3. GET SINGLE EXPENSE - Get one expense by ID
    public Expense getExpenseById(int expenseId) {
        String sql = "SELECT * FROM expenses WHERE expense_id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, expenseId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Expense expense = new Expense();
                expense.setExpenseId(rs.getInt("expense_id"));
                expense.setUserId(rs.getInt("user_id"));
                expense.setCategory(rs.getString("category"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setDate(rs.getDate("date").toLocalDate());
                return expense;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 4. UPDATE EXPENSE - Edit an existing expense
    public boolean updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET category = ?, amount = ?, description = ?, date = ? WHERE expense_id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, expense.getCategory());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setString(3, expense.getDescription());
            pstmt.setDate(4, java.sql.Date.valueOf(expense.getDate()));
            pstmt.setInt(5, expense.getExpenseId());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // 5. DELETE EXPENSE - Delete an expense from database
    public boolean deleteExpense(int expenseId) {
        String sql = "DELETE FROM expenses WHERE expense_id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, expenseId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // 6. GET TOTAL EXPENSES - Calculate total amount spent
    public double getTotalExpensesByUser(int userId) {
        String sql = "SELECT SUM(amount) as total FROM expenses WHERE user_id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // 7. GET EXPENSES BY CATEGORY - Get expenses from one category
    public List<Expense> getExpensesByCategory(int userId, String category) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE user_id = ? AND category = ? ORDER BY date DESC";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, category);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setExpenseId(rs.getInt("expense_id"));
                expense.setUserId(rs.getInt("user_id"));
                expense.setCategory(rs.getString("category"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setDate(rs.getDate("date").toLocalDate());
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
