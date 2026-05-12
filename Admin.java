// ========================= package attendance; =========================
// ========================= Admin.java =========================

import java.util.Scanner;
import java.util.Iterator;

class Admin extends User {

    public Admin(String userId, String name, String password) {
        super(userId, name, password);
    }

    // ================= ADD SUBJECT =================
 // ================= ENROLL SUBJECT TO STUDENT =================
    public void enrollSubjectToStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== ENROLL SUBJECT =====");

        System.out.print("Enter Student ID: ");
        String studentId = sc.next();

        Student student =
                DataStore.findStudent(studentId);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nAvailable Subjects:");

        for (Subject s : DataStore.subjects) {
            System.out.println(
                    s.getSubjectId()
                            + " - "
                            + s.getSubjectName()
            );
        }

        System.out.print("Enter Subject ID: ");
        String subjectId = sc.next();

        Subject selectedSubject = null;

        for (Subject s : DataStore.subjects) {

            if (s.getSubjectId().equals(subjectId)) {

                selectedSubject = s;
                break;
            }
        }

        if (selectedSubject == null) {

            System.out.println("Subject not found.");
            return;
        }

        student.enrollSubject(selectedSubject);
    }
    public void addSubject() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== ADD SUBJECT =====");

        System.out.print("Enter Subject ID: ");
        String subjectId = sc.next();

        sc.nextLine();

        System.out.print("Enter Subject Name: ");
        String subjectName = sc.nextLine();

        System.out.print("Enter Faculty ID: ");
        String facultyId = sc.next();

        Subject subject =
                new Subject(subjectId, subjectName, facultyId);

        DataStore.subjects.add(subject);

        System.out.println("Subject added successfully.");
    }

    // ================= REMOVE SUBJECT =================
    public void removeSubject() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== REMOVE SUBJECT =====");

        System.out.print("Enter Subject ID: ");
        String subjectId = sc.next();

        boolean removed = false;

        Iterator<Subject> iterator =
                DataStore.subjects.iterator();

        while (iterator.hasNext()) {

            Subject s = iterator.next();

            if (s.getSubjectId().equals(subjectId)) {

                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Subject removed successfully.");
        } else {
            System.out.println("Subject not found.");
        }
    }

    // ================= VIEW SUBJECTS =================
    public void viewSubjects() {

        System.out.println("\n===== SUBJECT LIST =====");

        if (DataStore.subjects.isEmpty()) {
            System.out.println("No subjects available.");
            return;
        }

        for (Subject s : DataStore.subjects) {
            System.out.println(s);
        }
    }

    // ================= MENU =================
    @Override
    public void displayMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Subject");
            System.out.println("2. Remove Subject");
            System.out.println("3. View Subjects");
            System.out.println("4. Enroll Subject To Student");
            System.out.println("5. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addSubject();
                    break;

                case 2:
                    removeSubject();
                    break;

                case 3:
                    viewSubjects();
                    break;

                case 4:
                    enrollSubjectToStudent();
                    break;

                case 5:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
