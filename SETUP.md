# Setup Instructions for Expense Tracker

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL 5.7 or higher
- Apache Tomcat 8.5 or higher
- IDE: Eclipse, IntelliJ IDEA, or Netbeans
- Maven (optional but recommended)

## Step 1: Database Setup

1. Open MySQL Command Line Client or MySQL Workbench
2. Copy and paste the contents of `database.sql` file
3. Execute the SQL commands
4. Verify tables are created:
   ```sql
   USE expense_tracker;
   SHOW TABLES;
   ```

## Step 2: IDE Configuration (Eclipse Example)

### For Eclipse:
1. File → New → Dynamic Web Project
2. Project name: `ExpenseTracker`
3. Target runtime: Apache Tomcat v8.5
4. Click Next → Finish

### Copy Project Files:
1. Copy the `src` folder contents to `src` directory
2. Copy the `web` folder contents to `WebContent` directory
3. Copy `database.sql` to project root
4. Copy `README.md` and `SETUP.md` to project root

## Step 3: Add MySQL Driver

### Using Maven (if using Maven):
1. Copy `pom.xml` to project root
2. Right-click project → Maven → Update Project
3. Maven will download mysql-connector-java automatically

### Manual Setup:
1. Download `mysql-connector-java-8.0.33.jar` from MySQL website
2. Right-click project → Build Path → Add External Archive
3. Select the downloaded JAR file

## Step 4: Update Database Configuration

1. Open `DatabaseConnection.java` file
2. Update database credentials if needed:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
   private static final String USER = "root";  // Your MySQL username
   private static final String PASSWORD = "root";  // Your MySQL password
   ```

## Step 5: Deploy to Tomcat

1. Right-click project → Run As → Run on Server
2. Select Apache Tomcat v8.5
3. Click Finish

## Step 6: Access Application

1. Open browser
2. Navigate to: `http://localhost:8080/ExpenseTracker`
3. You should see the login page

## Test the Application

### Create Test Account:
1. Click "Register here" link
2. Fill in username, email, password
3. Click Register

### Login:
1. Enter username and password
2. Click Login

### Add Expense:
1. Click "+ Add Expense" button
2. Select category
3. Enter amount
4. Enter description
5. Select date
6. Click "Add Expense"

### View Expenses:
- All expenses appear in the dashboard table
- Total amount is displayed at the top

### Delete Expense:
- Click "Delete" button next to any expense
- Confirm deletion

## Troubleshooting

### Database Connection Error:
- Check MySQL is running
- Verify database credentials in `DatabaseConnection.java`
- Ensure `expense_tracker` database exists

### Class Not Found Exception:
- Add MySQL JDBC driver to classpath
- Rebuild project (Project → Clean)

### Page Not Found (404):
- Ensure Tomcat is running
- Check correct context path: `/ExpenseTracker`
- Verify JSP files are in `WebContent` folder

### Compilation Errors:
- Check Java version is 8 or higher
- Rebuild project
- Clean project and rebuild

## Project Structure Expected

```
ExpenseTracker/
├── src/
│   └── com/expensetracker/
│       ├── controller/
│       ├── dao/
│       ├── model/
│       └── util/
├── WebContent/
│   ├── login.jsp
│   ├── register.jsp
│   ├── dashboard.jsp
│   ├── addExpense.jsp
│   ├── index.jsp
│   ├── css/
│   │   └── style.css
│   └── WEB-INF/
│       └── web.xml
├── database.sql
├── pom.xml (if using Maven)
└── README.md
```

## Running without IDE (Command Line)

If using Maven:
```bash
cd ExpenseTracker
mvn clean package
mvn tomcat7:run
```

## Database Backup

To backup your database:
```bash
mysqldump -u root -p expense_tracker > backup.sql
```

To restore:
```bash
mysql -u root -p expense_tracker < backup.sql
```

## Performance Tips

1. Enable indexing (already done in database.sql)
2. Use connection pooling for production
3. Implement caching for frequently accessed data
4. Optimize database queries

## Security Considerations

For production use:
1. Use prepared statements (already implemented)
2. Implement password hashing (bcrypt recommended)
3. Add HTTPS support
4. Implement CSRF protection
5. Add input validation and sanitization
6. Use environment variables for database credentials

## Additional Resources

- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Apache Tomcat Documentation](https://tomcat.apache.org/tomcat-8.5-doc/)
- [Java Servlet Documentation](https://docs.oracle.com/cd/E19226-01/820-7627/)
- [JDBC Documentation](https://docs.oracle.com/javase/tutorial/jdbc/)
