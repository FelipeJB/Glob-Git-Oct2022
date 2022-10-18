public class Client {

    private String user;

    private int password;

    private Account savingsAccount;

    public Client(double balance, String user, int password){
        Account savingsAccount = new Account(balance);

        this.user = user;
        this.password = password;
    }



}
