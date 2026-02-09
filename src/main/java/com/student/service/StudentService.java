package com.student.service;

import java.sql.SQLException;
import com.student.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentService {

    public static long register(String username, String password) {
        long id = 0;
        try {
            Connection con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student(username,password) VALUES (?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) id = rs.getLong(1);

            System.out.println("student created");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static long login(String username, String password) {
        long id = 0;
        try {
            Connection con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id FROM student WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getLong("id");
                System.out.println("Student Login Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
