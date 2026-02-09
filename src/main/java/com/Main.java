package com;

import com.student.service.CourseRegistrationService;
import com.student.service.StudentService;
import com.student.service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select [1]- Student Registration | [2] Student Login");
        int mainChoice = sc.nextInt();
        sc.nextLine();

        long studentId = 0;

        if (mainChoice == 1) {
            System.out.println("\nStudent Registration Form");

            System.out.println("Username");
            String u = sc.nextLine();

            System.out.println("Password");
            String p = sc.nextLine();

            studentId = StudentService.register(u, p);
        }

        if (mainChoice == 2) {
            System.out.println("\nStudent Login Form");

            System.out.println("Username");
            String u = sc.nextLine();

            System.out.println("Password");
            String p = sc.nextLine();

            studentId = StudentService.login(u, p);
            if (studentId == 0) return;
        }

        int cont = 1;
        while (cont == 1) {

            System.out.println("Select [1] to register courses | Select [2] to view registered courses");
            int c = sc.nextInt();
            sc.nextLine();

            if (c == 1) {
                CourseService.showCourses();
                System.out.println("Enter Course Ids example 2,3");

                String[] ids = sc.nextLine().split(",");
                for (String id : ids) {
                    CourseRegistrationService.register(studentId, Long.parseLong(id.trim()));
                }
            }

            if (c == 2) {
                CourseService.showRegistered(studentId);
            }

            System.out.println("If you continue enter - [1] or else press [0] to exit");
            cont = sc.nextInt();
        }

        System.out.println("\nProcess finished with exit code 0");
    }
}
