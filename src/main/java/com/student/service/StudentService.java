package com.student.service;

import com.student.jdbc.DBConnector;
import java.sql.*;

public class StudentService {
    public static long register(String username, String password) {
        String sql = "INSERT INTO student(username, password) VALUES (?,?)";
        try (PreparedStatement ps = DBConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("student created");
                return rs.getLong(1);
            }
        } catch (Exception e) {
            System.err.println("Student registration failed: " + e.getMessage());
        }
        return 0;
    }

    public static long login(String username, String password) {
        String sql = "SELECT id FROM student WHERE username=? AND password=?";
        try (PreparedStatement ps = DBConnector.getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Student Login Successfully");
                return rs.getLong("id");
            }
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        }
        return 0;
    }
}