
public class ClassSession {

    private int sessionId;
    private int subjectId;
    private String sessionName;
    private String sessionTime;

    public ClassSession(int sessionId, int subjectId, String sessionName, String sessionTime) {
        this.sessionId = sessionId;
        this.subjectId = subjectId;
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void displaySession() {
        System.out.println("Session ID: " + sessionId +
                ", Subject ID: " + subjectId +
                ", Session Name: " + sessionName +
                ", Time: " + sessionTime);
    }
}
