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
        double amountPlusTax;
        if(amount<1000){
            amountPlusTax = amount + 200;
        }else {
            amountPlusTax = amount + 200 + (amount * 0.15);
        }
        System.out.println("This is the amount that will be withdrawn from your account including tax: " + amountPlusTax);

        if (balance>=amountPlusTax){
            balance = balance - amountPlusTax;
            successfulTransaction = true;
        }
        return successfulTransaction;
    }
    public double addMoney(double amount){
        balance = balance + amount;
        return balance;
    }

    public boolean TransferMoney(double amount){
        boolean successfulTransaction = false;
        double amountPlusTax = amount + 100;
        if (balance>=amountPlusTax){
            balance = balance - amountPlusTax;
            successfulTransaction = true;
        }
        return successfulTransaction;
    }


    @Override
    public String toString() {
        return String.format("%20d|%20s|%20s", accountNumber,openingDate,balance);
    }
}
