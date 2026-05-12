// ========================= package attendance; =========================
// ========================= Subject.java =========================

class Subject {

    private String subjectId;
    private String subjectName;
    private String facultyId;

    public Subject(String subjectId, String subjectName, String facultyId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.facultyId = facultyId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    @Override
    public String toString() {
        return subjectId + " - " + subjectName + " (Faculty: " + facultyId + ")";
    }
}
