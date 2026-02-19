package com.student.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            // Check if connection is null or closed before returning
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student_management_system", "root", "r00t");
                System.out.println("..........Database Connected..........");
            }
        } catch (Exception e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
        return connection;
    }
}