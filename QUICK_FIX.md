# QUICK FIX FOR ERRORS

## Problem
Your project is missing **Servlet libraries**. This is why you see red errors.

## Solution - Choose ONE:

### Option 1: Using Maven (Recommended)
1. Copy the pom.xml file content to your project root
2. In Eclipse: Right-click Project → Maven → Update Project
3. Wait for Maven to download libraries
4. Errors will disappear

### Option 2: Manual Download (If not using Maven)
1. Download `javax.servlet-api-3.1.0.jar` from:
   https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/3.1.0

2. Download `mysql-connector-java-8.0.33.jar` from:
   https://dev.mysql.com/downloads/connector/j/

3. In Eclipse:
   - Right-click Project → Build Path → Add External Archives
   - Select both JAR files
   - Press OK

### Option 3: Using Tomcat Server Runtime (Easiest)
1. In Eclipse: Right-click Project → Properties
2. Search for "Project Facets"
3. Check "Dynamic Web Module"
4. In "Runtimes" tab, select your Tomcat server
5. Apply and Close

## After Fix
- All red errors should disappear
- Your project will compile successfully
- You can then deploy to Tomcat

## If still seeing errors:
- Clean Project (Project → Clean)
- Rebuild Project (Project → Build Project)
- Close and reopen Eclipse
