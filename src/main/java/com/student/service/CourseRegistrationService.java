package com.student.service;
import com.student.jdbc.DBConnector;
import java.sql.PreparedStatement;

public class CourseRegistrationService {
    public static void register(long studentId, long courseId) {
        String sql = "INSERT INTO course_registration(student_id, course_id) VALUES (?,?)";

        try (PreparedStatement ps = DBConnector.getConnection().prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ps.setLong(2, courseId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Registration error: " + e.getMessage());
        }
    }
}
