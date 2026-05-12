// ========================= package attendance; =========================
// ========================= DataStore.java =========================
// In-memory database (NO CSV / NO DB)


import java.util.*;

class DataStore {

    // ================= STORAGE =================
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Faculty> faculties = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Subject> subjects = new ArrayList<>();
    static ArrayList<AttendanceRecord> attendance = new ArrayList<>();


    // ================= INITIAL DATA =================
    static {

        // Subjects
        subjects.add(new Subject("SUB101", "Java", "F101"));
        subjects.add(new Subject("SUB102", "Math", "F102"));
        subjects.add(new Subject("SUB103", "DSA", "F103"));

        // Students
        students.add(new Student("ST101", "Rohan", "123"));
        students.add(new Student("ST102", "Abhijith", "123"));

        // Faculty
        faculties.add(new Faculty("F101", "Dr Smith", "123"));
        faculties.add(new Faculty("F102", "Prof Anita", "123"));

        // Admin
        admins.add(new Admin("A101", "Admin", "123"));
    }


    // ================= FIND STUDENT =================
    public static Student findStudent(String id) {
        for (Student s : students) {
            if (s.userId.equals(id)) return s;
        }
        return null;
    }


    // ================= FIND FACULTY =================
    public static Faculty findFaculty(String id) {
        for (Faculty f : faculties) {
            if (f.userId.equals(id)) return f;
        }
        return null;
    }


    // ================= FIND ADMIN =================
    public static Admin findAdmin(String id) {
        for (Admin a : admins) {
            if (a.userId.equals(id)) return a;
        }
        return null;
    }
}
