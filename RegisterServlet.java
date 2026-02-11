package com.expensetracker.controller;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RegisterServlet - Handles user registration
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from registration form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Create UserDAO object
        UserDAO userDAO = new UserDAO();

        // Check if passwords match
        if (password == null || !password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=password");
            return;
        }

        // Check if username already exists
        if (userDAO.userExists(username)) {
            response.sendRedirect("register.jsp?error=exists");
            return;
        }

        // Create User object and set values
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        // Register user
        boolean isRegistered = userDAO.registerUser(user);

        if (isRegistered) {
            // Registration successful
            response.sendRedirect("login.jsp?success=1");
        } else {
            // Registration failed
            response.sendRedirect("register.jsp?error=failed");
        }
    }
}
