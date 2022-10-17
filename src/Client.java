public class Client {
    public String user;
    public String account;
    public String password;

    public Client(String user, String savingsAccount, String password) {
        this.user = user;
        this.account = savingsAccount;
        this.password = password;
    }

    @Override
    public String toString() {
        return"user:" + user +
                " savingsAccount:" + account +
                " password:" + password + '\n';
    }
}
