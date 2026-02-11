# Expense Tracker System

A web-based expense tracking application built with HTML, CSS, and JDBC for Java.

## Features

- **User Authentication**: Register and login functionality
- **Expense Management**: Add, view, and delete expenses
- **Category Tracking**: Categorize expenses (Food, Transport, Entertainment, etc.)
- **Expense Dashboard**: View total expenses and recent transactions
- **Responsive Design**: Works on desktop and mobile devices
- **Secure Database**: MySQL database with proper relationships

## Project Structure

```
Expense Tracker/
├── src/main/java/com/expensetracker/
│   ├── controller/
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── AddExpenseServlet.java
│   │   ├── DeleteExpenseServlet.java
│   │   └── LogoutServlet.java
│   ├── dao/
│   │   ├── UserDAO.java
│   │   └── ExpenseDAO.java
│   ├── model/
│   │   ├── User.java
│   │   └── Expense.java
│   └── util/
│       └── DatabaseConnection.java
├── web/
│   ├── login.jsp
│   ├── register.jsp
│   ├── dashboard.jsp
│   ├── addExpense.jsp
│   ├── css/
│   │   └── style.css
│   └── WEB-INF/
│       └── web.xml
├── database.sql
└── README.md
```

## Database Setup

1. Open MySQL command line or MySQL Workbench
2. Run the SQL commands from `database.sql` file
3. Database will be created with `users` and `expenses` tables

## Configuration

Update database credentials in `DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
private static final String USER = "root";
private static final String PASSWORD = "root";
```

## Requirements

- Java 8 or higher
- MySQL 5.7 or higher
- Tomcat 8.5 or higher (or any Servlet container)
- MySQL JDBC Driver (mysql-connector-java)

## Installation Steps

1. **Clone/Download the project** to your desired location
2. **Create database** using the `database.sql` file
3. **Configure IDE** (Eclipse, IntelliJ IDEA, or Netbeans)
4. **Add MySQL JDBC driver** to your project libraries
5. **Deploy to Tomcat** server
6. **Access the application** at `http://localhost:8080/ExpenseTracker`

## Usage

1. **Register**: Create a new account with username, email, and password
2. **Login**: Login with your credentials
3. **Add Expense**: Click "Add Expense" button and fill in the details
4. **View Expenses**: All expenses are displayed on the dashboard with total amount
5. **Delete Expense**: Click delete button to remove an expense
6. **Logout**: Click logout to exit the application

## Technologies Used

- **Frontend**: HTML5, CSS3, JavaScript
- **Backend**: Java Servlets, JSP
- **Database**: MySQL
- **Driver**: JDBC (mysql-connector-java)
- **Server**: Apache Tomcat

## Future Enhancements

- Edit expense functionality
- Monthly expense reports and graphs
- Category-wise expense breakdown
- Expense budget setting and alerts
- Export to PDF/Excel
- Advanced filtering and search
- Email notifications
- Multi-currency support

## License

This project is open source and available for educational purposes.
