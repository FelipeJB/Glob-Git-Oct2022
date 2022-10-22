package src.org.globantBank.data;

import java.util.Date;

public class Account {

    private String user;
    private int number;
    private Date openingDate;
    private double balance;
    private static int counter = 1001;

    public Account (String user){
        this.user = user;
        this.number = 4525 + counter;
        this.openingDate = new Date();
        this.balance = 0;
        counter++;
    }
    public String toString(){return " Account: " + number + "\n Opened: " + openingDate + "\n Balance: " + balance; }
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

