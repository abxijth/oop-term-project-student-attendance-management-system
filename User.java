// ========================= package attendance; =========================
// ========================= User.java =========================

abstract class User {

    protected String userId;
    protected String name;
    protected String password;

    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public boolean login(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void logout() {
        System.out.println(name + " logged out successfully.");
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public abstract void displayMenu();
}
