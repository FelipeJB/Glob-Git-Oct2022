package GlobantBank.Data;

import java.time.LocalDate;

public class Account {
    public int accountNumber;
    public LocalDate openingDate;
    public double balance;

    public Account() {
        this.accountNumber = (int) (Math.random()*1000000);
        this.balance = 0;
        this.openingDate= LocalDate.now();
    }

    public boolean withdrawMoney(double amount){
        boolean successfulTransaction = false;
        if (balance>=amount){
            balance = balance - amount;
            successfulTransaction = true;
        }
        return successfulTransaction;
    }
    public double addMoney(double amount){
        balance = balance + amount;
        return balance;
    }



    @Override
    public String toString() {
        return String.format("%20d|%20s|%20s", accountNumber,openingDate,balance);
    }
}
