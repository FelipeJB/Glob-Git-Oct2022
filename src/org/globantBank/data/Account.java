package src.org.globantBank.data;

import java.util.Date;

public class Account {

    private String user;
    private int number;
    private Date openingDate;
    private double balance;
    private static int counter = 1;

    public Account(){}
    public Account (String user){
        this.user = user;
        this.number = 4000 + counter;
        this.openingDate = new Date();
        this.balance = 0;
        counter++;
    }

    public int getNumber() {
        return number;
    }

    public String getUser(int number) {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public double depositMoney(float amount) {
        if (amount > 0){
            this.balance = this.balance + amount;
            return this.balance;
        } else {
            return 0;
        }

    }
    public double withdrawMoney(float amount) {
        double taxes;
        if (amount <= 1000){
            taxes = 200;
            if (amount + taxes < this.balance){
                this.balance = this.balance - amount - taxes;
                return this.balance;
            }
            }
        if (amount > 1000){
            taxes = (amount * 0.15) + 200;
            if (amount + taxes < this.balance){
                this.balance = this.balance - amount - taxes;
                return this.balance;
            }
        }

        return 0;
    }
    public double transferMoney(double amount){
        double taxes = 100;
        if (amount + taxes < this.balance){
            this.balance = this.balance - amount - taxes;
            return this.balance;
        }
        return 0;
    }
}

