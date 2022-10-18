package GlobantBank.Data;

public class User {
    public int userID;
    public String fullName;
    public String userName;
    public Account savingAccount;
    public String password;

    public User(int userID, String fullName, String userName, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.userName = userName;
        this.savingAccount = new Account();
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("|%20d|%20s|%20s|%20s|", userID, fullName, userName,savingAccount);
    }
}
