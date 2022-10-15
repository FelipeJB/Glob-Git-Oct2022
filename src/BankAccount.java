package src;
import java.time.LocalDate;

public class BankAccount {
    public float accountNumber;
    public LocalDate openingDate;
    public float balance;

    BankAccount(float accountNumber, LocalDate openingDate, float balance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public float getAccountNumber() { return this.accountNumber; }
    public LocalDate getOpeningDate() { return this.openingDate; }
    public float getBalance() {return this.balance; }

}
