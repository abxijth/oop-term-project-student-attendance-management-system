// ========================= package attendance; =========================
// ========================= AttendanceRecord.java =========================

class AttendanceRecord {

    private String studentId;
    private String subjectId;
    private String date;
    private String status; // Present / Absent

    public AttendanceRecord(String studentId, String subjectId, String date, String status) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return studentId + " | " + subjectId + " | " + date + " | " + status;
    }
}
