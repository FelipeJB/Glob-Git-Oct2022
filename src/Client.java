import java.time.LocalDate;

public class Client{

    //variables nativas
    public int clientId;
    public String name;
    public String password;
    public Account savingAccount;

    //constructores
    public Client(int clientId, String name, String password) {
        this.clientId = clientId ;
        this.name = name;
        this.password = password;
        this.savingAccount = new Account();
    }

    //Metodos
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getNumberAccount(){ return savingAccount.numberAccount; }
    public double getBalance(){ return savingAccount.balance; }
    public LocalDate getDate(){ return savingAccount.opening; }
}
