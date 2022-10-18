public class Client {
    private String user;
    private int password;
    private Account savingAccount;

    public Client(String user, int password, int numberAccount) {
        this.user = user;
        this.password = password;
        this.savingAccount = new Account(numberAccount);
    }

    public String getUser() {
        return user;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "user='" + user + '\'' +
                ", password=" + password +
                ", savingAccount=" + savingAccount +
                '}';
    }

    public Account getSavingAccount() {
        return savingAccount;
    }
}
