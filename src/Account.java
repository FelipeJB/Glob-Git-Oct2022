package src;

import java.util.Date;

public class Account {

    public String user;
    private int accountNumber;
    public Date openingDate;
    private double balance;
    public static int counter = 1001;

    public int getAccountNumber() {
        return accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }
    public Account (String user){
        this.user = user;
        this.accountNumber = 4525 + counter;
        this.openingDate = new Date();
        this.balance = 0;
        counter++;
    }
    public String toString(){return " Account: " + accountNumber + "\n Opened: " + openingDate + "\n Balance: " + balance; }
    public double depositMoney(float amount) {
        this.balance = this.balance + amount;
        return this.balance;
    }
    public double withdrawMoney(float amount) {
        if (amount < 1000){
            float tax = 200;
            this.balance = this.balance - amount - tax;
            return this.balance;
        }else{
            double tax = (amount * 0.15) + 200;
            this.balance = this.balance - amount - tax;
            return this.balance;
        }
    }
}

