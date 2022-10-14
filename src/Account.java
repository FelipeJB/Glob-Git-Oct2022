package src;

import java.util.Date;

public class Account {
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
    public Account (){
        this.accountNumber = 4525 + counter;
        this.openingDate = new Date();
        this.balance = 0;
        counter++;
    }
    public double depositMoney(float amount) {
        this.balance = this.balance + amount;
        return this.balance;
    }
    public double withdrawMoney(float amount) {
        if (amount < 1000){
            float fee = 200;
            this.balance = this.balance - amount - fee;
            return this.balance;
        }else{
            double fee = (amount * 0.15) + 200;
            this.balance = this.balance - amount - fee;
            return this.balance;
        }
    }
}

