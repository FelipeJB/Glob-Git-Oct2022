package src;
import java.time.LocalDate;


public class Client {

    private final float accountNumber;
    private final String name;

    private final String user;

    private final String password;

    Client(float accountNumber, String name, String user, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public float getAccountNumber() { return this.accountNumber; }
    public String getName() { return this.name; }
    public String getUser() { return this.user; }
    public String getPassword() { return this.password; }

    BankAccount anaAccount = new BankAccount(123, LocalDate.parse("2009-05-30"), 300  );
    BankAccount mariaAccount = new BankAccount(456, LocalDate.parse("2009-09-21"), 500  );





}

