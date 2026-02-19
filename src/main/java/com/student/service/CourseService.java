package com.student.service;

import com.student.jdbc.DBConnector;
import java.sql.*;

public class CourseService {
    public static void showCourses() {
        String sql = "SELECT * FROM course";
        try (Statement st = DBConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("[" + rs.getLong("id") + "] : "
                        + rs.getString("course_code") + " - "
                        + rs.getString("name"));
            }
        } catch (Exception e) {
            System.err.println("Error fetching courses: " + e.getMessage());
        }
    }

    public static void showRegistered(long studentId) {
        String sql = "SELECT c.course_code, c.name FROM course c " +
                "JOIN course_registration cr ON c.id = cr.course_id " +
                "WHERE cr.student_id = " + studentId;
        try (Statement st = DBConnector.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("[" + rs.getString("course_code") + "] " + rs.getString("name"));
            }
        } catch (Exception e) {
            System.err.println("Error fetching registered courses: " + e.getMessage());
        }
    }
}