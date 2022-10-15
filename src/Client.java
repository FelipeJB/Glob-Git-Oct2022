package src;
import java.time.LocalDate;

public class Client {

    public float accountNumber;

    public String user;

    public String password;

    Client(float accountNumber, String user, String password) {

        this.accountNumber = accountNumber;
        this.user = user;
        this.password = password;
    }

    public float getAccountNumber() { return this.accountNumber; }
    public String getUser() { return this.user; }
    public String getPassword() { return this.password; }
    BankAccount myBankAccount = new BankAccount(123, LocalDate.parse("2009-05-30"), 300  );




}

