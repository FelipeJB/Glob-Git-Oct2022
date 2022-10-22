package src.org.globantBank.data;

public class Client {

    private String name;
    private String user;
    private String password;
    private Account savingsAccount;
    public Client() {}
    public Client(String name, String user, String password){
        this.savingsAccount = new Account(user);
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public boolean authenticateClient(String user, String password){
        return this.user.equals(user) && this.password.equals(password);
    }


}