package com.expensetracker.controller;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet - Handles user login
 * 
 * What it does:
 * 1. Receives username and password from login form
 * 2. Checks if user exists in database
 * 3. If found, creates session and redirects to dashboard
 * 4. If not found, redirects back to login with error
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Create UserDAO object to access database
        UserDAO userDAO = new UserDAO();
        
        // Try to login user
        User user = userDAO.loginUser(username, password);
        
        // If user found
        if (user != null) {
            // Create session
            HttpSession session = request.getSession();
            // Store user ID and username in session
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            
            // Redirect to dashboard
            response.sendRedirect("dashboard.jsp");
        } else {
            // User not found - redirect back to login with error
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
