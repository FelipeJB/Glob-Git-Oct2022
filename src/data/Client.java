package src.data;

public class Client {

    private String user;
    private String password;
    private Account savingsAccount;

    public Client(String user, String password){
        this.savingsAccount = new Account(user);
        this.user = user;
        this.password = password;
    }
    public String toString(){return "Client: \n User: " + user + " \n Password: " + password + "\n" + savingsAccount;}
}