// ========================= package attendance; =========================
// ========================= Faculty.java =========================


import java.util.*;

class Faculty extends User {

    public Faculty(String userId, String name, String password) {
        super(userId, name, password);
    }

    // ================= MARK ATTENDANCE =================
    public void markAttendance() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== MARK ATTENDANCE =====");

        System.out.print("Enter Student ID: ");
        String studentId = sc.next();

        Student student = DataStore.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nAvailable Subjects:");

        for (Subject s : DataStore.subjects) {
            System.out.println(s.getSubjectId() + " - " + s.getSubjectName());
        }

        System.out.print("Enter Subject ID: ");
        String subjectId = sc.next();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.next();

        System.out.print("Enter Status (Present/Absent): ");
        String status = sc.next();

        AttendanceRecord record =
                new AttendanceRecord(
                        studentId,
                        subjectId,
                        date,
                        status
                );

        DataStore.attendance.add(record);

        System.out.println("Attendance marked successfully.");
    }

    // ================= VIEW ALL RECORDS =================
    public void viewAttendanceRecords() {

        System.out.println("\n===== ALL ATTENDANCE RECORDS =====");

        if (DataStore.attendance.isEmpty()) {
            System.out.println("No attendance records available.");
            return;
        }

        for (AttendanceRecord ar : DataStore.attendance) {
            System.out.println(ar);
        }
    }

    // ================= MENU =================
    @Override
    public void displayMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FACULTY MENU =====");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance Records");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    markAttendance();
                    break;

                case 2:
                    viewAttendanceRecords();
                    break;

                case 3:
                    logout();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
