package com.expensetracker.controller;

import com.expensetracker.dao.ExpenseDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * DeleteExpenseServlet - Handles deleting expenses
 * 
 * What it does:
 * 1. Checks if user is logged in
 * 2. Gets expense ID to delete
 * 3. Deletes from database
 * 4. Redirects back to dashboard
 */
@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // Get expense ID to delete
        int expenseId = Integer.parseInt(request.getParameter("expenseId"));
        
        // Create ExpenseDAO to delete from database
        ExpenseDAO expenseDAO = new ExpenseDAO();
        
        // Try to delete
        if (expenseDAO.deleteExpense(expenseId)) {
            // Success - redirect to dashboard
            response.sendRedirect("dashboard.jsp?success=1");
        } else {
            // Failed - redirect with error
            response.sendRedirect("dashboard.jsp?error=1");
        }
    }
}
