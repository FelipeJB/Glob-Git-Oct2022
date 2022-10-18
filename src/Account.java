import org.omg.CORBA.Current;

import java.time.Instant;


public class Account {
    private String accountNumber;
    private float balance = 0;
    private Instant openDate;

    public Account(String accountNumber, float balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openDate = Instant.now();
    }

    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Instant getOpenDate() {
        return openDate;
    }

    public void withdraw(float amount){

    }

    public void addMoney(float amount){
        this.balance += amount;
    }

    public void transferMoney(float amount, SavingAccount originAccount, SavingAccount targetAccount){

    }
}