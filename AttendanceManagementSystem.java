// ========================= package attendance; =========================
// ========================= AttendanceManagementSystem.java =========================
// MAIN CLASS

import java.util.*;

public class AttendanceManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT ATTENDANCE MANAGEMENT SYSTEM =====");
            System.out.println("1. Student Login");
            System.out.println("2. Faculty Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ================= STUDENT LOGIN =================
                case 1:

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.next();

                    System.out.print("Enter Password: ");
                    String studentPassword = sc.next();

                    Student student =
                            DataStore.findStudent(studentId);

                    if (student != null &&
                            student.login(studentPassword)) {

                        System.out.println(
                                "\nWelcome Student: "
                                        + student.getName()
                        );

                        student.displayMenu();

                    } else {
                        System.out.println("Invalid login.");
                    }

                    break;


                // ================= FACULTY LOGIN =================
                case 2:

                    System.out.print("Enter Faculty ID: ");
                    String facultyId = sc.next();

                    System.out.print("Enter Password: ");
                    String facultyPassword = sc.next();

                    Faculty faculty =
                            DataStore.findFaculty(facultyId);

                    if (faculty != null &&
                            faculty.login(facultyPassword)) {

                        System.out.println(
                                "\nWelcome Faculty: "
                                        + faculty.getName()
                        );

                        faculty.displayMenu();

                    } else {
                        System.out.println("Invalid login.");
                    }

                    break;


                // ================= ADMIN LOGIN =================
                case 3:

                    System.out.print("Enter Admin ID: ");
                    String adminId = sc.next();

                    System.out.print("Enter Password: ");
                    String adminPassword = sc.next();

                    Admin admin =
                            DataStore.findAdmin(adminId);

                    if (admin != null &&
                            admin.login(adminPassword)) {

                        System.out.println(
                                "\nWelcome Admin: "
                                        + admin.getName()
                        );

                        admin.displayMenu();

                    } else {
                        System.out.println("Invalid login.");
                    }

                    break;


                // ================= EXIT =================
                case 4:

                    System.out.println("Exiting System...");
                    sc.close();
                    return;


                // ================= INVALID =================
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
