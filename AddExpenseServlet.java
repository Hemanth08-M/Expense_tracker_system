package com.expensetracker.controller;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 * AddExpenseServlet - Handles adding new expenses
 * 
 * What it does:
 * 1. Checks if user is logged in (has session)
 * 2. Gets expense details from form
 * 3. Saves expense to database
 * 4. Redirects back to dashboard
 */
@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {\n    \n    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get session (without creating new one if doesn't exist)
        HttpSession session = request.getSession(false);
        
        // Check if user is logged in
        if (session == null || session.getAttribute("userId") == null) {
            // Not logged in - redirect to login
            response.sendRedirect("login.jsp");
            return;
        }
        
        // Get user ID from session
        int userId = (Integer) session.getAttribute("userId");
        
        // Get expense details from form
        String category = request.getParameter("category");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String description = request.getParameter("description");
        String dateStr = request.getParameter("date");
        LocalDate date = LocalDate.parse(dateStr);
        
        // Create new Expense object
        Expense expense = new Expense(userId, category, amount, description, date);
        
        // Create ExpenseDAO to save to database
        ExpenseDAO expenseDAO = new ExpenseDAO();
        
        // Try to add expense
        if (expenseDAO.addExpense(expense)) {
            // Success - redirect to dashboard with success message
            response.sendRedirect("dashboard.jsp?success=1");
        } else {
            // Failed - redirect back to add expense page with error
            response.sendRedirect("addExpense.jsp?error=1");
        }
    }
}
