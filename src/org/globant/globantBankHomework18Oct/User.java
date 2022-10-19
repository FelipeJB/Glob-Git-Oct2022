public class User {

    public String username;
    public String password;
    public SavingsAccount savingsAccount;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.savingsAccount = new SavingsAccount();
    }
}
