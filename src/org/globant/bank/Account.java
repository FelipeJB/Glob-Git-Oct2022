package org.globant.bank;

import com.sun.jmx.snmp.SnmpString;

import java.util.Date;

public class Account {

    int accountNumber;
    static int serialNumberAccount = 100;
    public String accountType = "Savings Account";
    Date openingDate;
    public double balance;
    double tax;

    public Account(){
        serialNumberAccount = serialNumberAccount + 1;
        accountType = "Savings Account";
        accountNumber = serialNumberAccount;
        openingDate = new Date();
        tax = 0.15;
    }

    public String toString(){
        return "  > Account type: " + accountType + "\n"
                + "  > Account number: " + accountNumber + "\n"
                + "  > Balance: " + balance + "\n"
                + "  > Opening Date: " + openingDate + "\n" ;
    }

    public String getBalance(){
        return "******    BALANCE    ****** \n"
                + "  Your Balance  $" + balance;
    }

    public String withdrawMoney(double amount){
        if(amount < 1000){
            double taxesAmount = 200;
            double totalAmount = amount + taxesAmount;
            balance = balance - totalAmount;
            return "******    TRANSACTION    ****** \n"
                    + "  You have withdrawn $" + amount + "\n"
                    + "  Taxes $" + taxesAmount + "\n"
                    + "  TOTAL $" + totalAmount + taxesAmount + "\n"
                    + "  ------ \n"
                    + "  New Balance: $" + balance + "\n";
        } else {
            double taxesAmount = 200 + (amount * tax);
            double totalAmount = amount + 200 + (amount * tax);
            balance = balance - totalAmount;
            return "******    TRANSACTION    ****** \n"
                    + "  You have withdrawn $" + amount + "\n"
                    + "  Taxes $" + taxesAmount + "\n"
                    + "  TOTAL $" + totalAmount + "\n"
                    + "  ------ \n"
                    + "  New Balance: $" + balance + "\n";
        }
    }
    public String addMoney(double amount){
        balance = balance + amount;
        return "******    TRANSACTION    ****** \n"
                + "  You have deposited $" + amount + "\n"
                + "  ------ \n"
                + "  New Balance: $" + balance + "\n";
    }

    public String transferMoney(double amount, Account numberAccountToTransfer){

    }
}


