package com.student.service;

import com.student.jdbc.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseRegistrationService {

    public static void register(long studentId, long courseId) {
        try {
            Connection con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO course_registration(student_id,course_id) VALUES (?,?)"
            );
            ps.setLong(1, studentId);
            ps.setLong(2, courseId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
