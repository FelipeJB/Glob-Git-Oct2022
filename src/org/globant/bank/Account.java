package org.globant.bank;

import java.util.Date;

public class Account {

    private final int accountNumber;
    static int serialNumberAccount = 100;
    static public String accountType = "Savings Account";
    private final Date openingDate;
    private double balance;
    private final double withdrawalsTax;
    public final double transferTax;

    public Account(){
        serialNumberAccount = serialNumberAccount + 1;
        accountNumber = serialNumberAccount;
        openingDate = new Date();
        withdrawalsTax = 0.15;
        transferTax = 100;
    }

    public String toString(){
        return "   Account type: " + accountType + "\n"
                + "   Account number: " + accountNumber + "\n"
                + "   Balance: " + balance + "\n"
                + "   Opening Date: " + openingDate + "\n" ;
    }

    public String getBalance(){
        return "******    BALANCE    ****** \n"
                + "  Your Balance  $" + balance + "\n";
    }

    public String withdrawMoney(double amount){
        if(amount < 0){
            return  "Invalid number, please enter a positive number \n";
        }

        if(amount < 1000){
            double taxesAmount = 200;
            double totalAmount = amount + taxesAmount;
            if(balance >= totalAmount){
                balance = balance - totalAmount;
                return  "******    TRANSACTION    ****** \n"
                             + "  Withdrawn  $" + amount + "\n"
                             + "  Taxes      $" + taxesAmount + "\n"
                             + "  TOTAL      $" + totalAmount + taxesAmount + "\n"
                             + "  ------ \n"
                             + "  Balance    $" + balance + "\n";
            }
        } else {
            double taxesAmount = 200 + (amount * withdrawalsTax);
            double totalAmount = amount + 200 + (amount * withdrawalsTax);
            if(balance >= totalAmount){
                     balance = balance - totalAmount;
                     return  "******    TRANSACTION    ****** \n"
                             + "  Withdrawn  $" + amount + "\n"
                             + "  Taxes      $" + taxesAmount + "\n"
                             + "  TOTAL      $" + totalAmount + "\n"
                             + "  ------ \n"
                             + "  Balance    $" + balance + "\n";
            } else {
                     return "***** TRANSACTION REJECTED ***** \n"
                             + "  Reason: Insufficient funds";
            }
        }
        return "Invalid number, please enter a positive number";
    }

    public String depositMoney(double amount){
        if(amount < 0){
            return "Invalid number, please enter a positive number \n";
        }
        balance = balance + amount;
        return "******    TRANSACTION    ****** \n"
                + "  You have deposited $" + amount + "\n"
                + "  ------ \n"
                + "  Balance            $" + balance + "\n";
    }

    public String sendMoney(double amount){
        if(amount < 0){
            return "Invalid number, please enter a positive number \n";
        }

        double totalAmount = amount + transferTax;
        if(balance >= totalAmount){
            balance = balance - totalAmount;
            return "******    TRANSACTION    ****** \n"
                    + "  Transferred  $" + amount + "\n"
                    + "  Taxes        $" + transferTax + "\n"
                    + "  TOTAL        $" + totalAmount + "\n"
                    + "  ------ \n"
                    + "  Balance      $" + balance + "\n";
        } else{
            return "***** TRANSACTION REJECTED ***** \n"
                    + "  Reason: Insufficient funds";
        }
    }

    public void receiveMoney(double amount){
        balance = balance + amount;
        //return "Successful transfer";
    }

    //public void searchAccount(){}

}














