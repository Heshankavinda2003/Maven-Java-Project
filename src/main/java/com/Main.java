package com;
import com.student.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select [1]- Student Registration | [2] Student Login");

        // Using Integer.parseInt(sc.nextLine()) to avoid the nextInt() newline bug
        int mainChoice = Integer.parseInt(sc.nextLine());
        long studentId;

        System.out.println("Username");
        String u = sc.nextLine();
        System.out.println("Password");
        String p = sc.nextLine();

        if (mainChoice == 1) {
            studentId = StudentService.register(u, p);
        } else {
            studentId = StudentService.login(u, p);
            if (studentId == 0) return;
        }

        while (true) {
            System.out.println("\nSelect [1] register courses | [2] view registered | [0] exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) break;

            if (choice == 1) {
                CourseService.showCourses();
                System.out.println("Enter Course Ids (e.g. 2,3)");
                String[] ids = sc.nextLine().split(",");
                for (String id : ids) {
                    CourseRegistrationService.register(studentId, Long.parseLong(id.trim()));
                }
            } else if (choice == 2) {
                CourseService.showRegistered(studentId);
            }
        }
        System.out.println("\nProcess finished with exit code 0");
    }
}