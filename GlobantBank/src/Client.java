/**
 * Bank -> Client -> Account
 * ----------
 * Class:
 * Methods:
 */

public class Client {
    private Account account;
    private String userName;
    private String password;

    public Client(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.account = new Account();
    }

    // Getters
    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    // Setters
    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}


