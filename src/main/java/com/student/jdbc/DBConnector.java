package com.student.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private static Connection connection = null;
    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "r00t");
                System.out.println("..........Database Connected..........");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
