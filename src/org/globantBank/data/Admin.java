package src.org.globantBank.data;

public class Admin {
    private String name;
    private String user;
    private String password;

    public Admin() {}
    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public boolean isAdmin(String user, String password) {
        return this.user.equals(user) && this.password.equals(password);
    }
}
