public class Client {

    private String user;

    private int password;

    private Account savingsAccount;

    public Client(double balance, String user, int password){
        this.savingsAccount = new Account(balance);
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "user='" + user + '\'' +
                ", password=" + password +
                ", savingsAccount=" + savingsAccount +
                '}';
    }

    public String getUser(){
        return this.user;
    }

    public int getPassword(){
        return this.password;
    }

    public Account getSavingsAccount(){
        return this.savingsAccount;
    }

}


