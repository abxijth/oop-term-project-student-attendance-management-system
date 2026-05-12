
import java.util.*;

class Student extends User {

    // ================= ENROLLED SUBJECTS =================
    private ArrayList<Subject> enrolledSubjects;

    public Student(String userId,
                   String name,
                   String password) {

        super(userId, name, password);

        enrolledSubjects = new ArrayList<>();
    }

    // ================= ENROLL SUBJECT =================
    public void enrollSubject(Subject subject) {

        enrolledSubjects.add(subject);

        System.out.println(
                subject.getSubjectName()
                        + " enrolled successfully."
        );
    }

    // ================= GET ENROLLED SUBJECTS =================
    public ArrayList<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    // ================= VIEW SUBJECTS =================
    public void viewSubjects() {

        System.out.println("\n===== ENROLLED SUBJECTS =====");

        if (enrolledSubjects.isEmpty()) {

            System.out.println("No subjects enrolled.");
            return;
        }

        for (Subject s : enrolledSubjects) {
            System.out.println(s);
        }
    }

    // ================= VIEW ATTENDANCE =================
    public void viewAttendance() {

        System.out.println("\n===== ATTENDANCE RECORD =====");

        boolean found = false;

        for (AttendanceRecord ar : DataStore.attendance) {

            if (ar.getStudentId().equals(userId)) {

                System.out.println(ar);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No attendance records found.");
        }
    }

    // ================= SUBJECT-WISE ATTENDANCE PERCENTAGE =================
    public void viewAttendancePercentage() {

        System.out.println(
                "\n===== SUBJECT-WISE ATTENDANCE PERCENTAGE ====="
        );

        if (enrolledSubjects.isEmpty()) {

            System.out.println("No enrolled subjects.");
            return;
        }

        for (Subject subject : enrolledSubjects) {

            int total = 0;
            int present = 0;

            for (AttendanceRecord ar : DataStore.attendance) {

                if (ar.getStudentId().equals(userId)
                        &&
                        ar.getSubjectId().equals(
                                subject.getSubjectId())) {

                    total++;

                    if (ar.getStatus().equalsIgnoreCase("Present")) {
                        present++;
                    }
                }
            }

            double percentage = 0;

            if (total > 0) {
                percentage =
                        (present * 100.0) / total;
            }

            System.out.println(
                    subject.getSubjectName()
                            + " : "
                            + percentage
                            + "%"
            );
        }
    }

    // ================= MENU =================
    @Override
    public void displayMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. View Enrolled Subjects");
            System.out.println("2. View Attendance");
            System.out.println("3. View Attendance Percentage");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewSubjects();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    viewAttendancePercentage();
                    break;

                case 4:
                    logout();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
