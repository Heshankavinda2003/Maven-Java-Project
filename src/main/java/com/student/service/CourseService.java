package com.student.service;
import com.student.jdbc.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseService {

    public static void showCourses() {
        try {
            Connection con = DBConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course");

            while (rs.next()) {
                System.out.println("[" + rs.getLong("id") + "] : "
                        + rs.getString("course_code") + " - "
                        + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showRegistered(long studentId) {
        try {
            Connection con = DBConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT c.course_code, c.name FROM course c " +
                            "JOIN course_registration cr ON c.id = cr.course_id " +
                            "WHERE cr.student_id = " + studentId
            );

            while (rs.next()) {
                System.out.println("[" + rs.getString("course_code") + "] "
                        + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
