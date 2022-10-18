public class Client {
    public BankAccount bankAccount;
    public String username;
    public String password;

    public Client(String userName, String password, float openingMoney) {
        this.username = userName;
        this.password = password;
        this.bankAccount = new BankAccount(openingMoney);
    }

}
