package org.globant.bank;

import java.util.Date;

public class Account {

    private final int accountNumber;
    static int serialNumberAccount = 100;
    static public String accountType = "Savings Account";
    private final Date openingDate;
    private double balance;
    private final double withdrawalsTax;
    private final double transferTax;

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
        try{
            if(amount < 0){
                return "Invalid number, please enter a positive number \n";
            }
            if(amount < 1000){
                double taxesAmount = 200;
                double totalAmount = amount + taxesAmount;
                balance = balance - totalAmount;
                return "******    TRANSACTION    ****** \n"
                        + "  Withdrawn  $" + amount + "\n"
                        + "  Taxes      $" + taxesAmount + "\n"
                        + "  TOTAL      $" + totalAmount + taxesAmount + "\n"
                        + "  ------ \n"
                        + "  Balance    $" + balance + "\n";
            } else {
                double taxesAmount = 200 + (amount * withdrawalsTax);
                double totalAmount = amount + 200 + (amount * withdrawalsTax);
                balance = balance - totalAmount;
                return "******    TRANSACTION    ****** \n"
                        + "  Withdrawn  $" + amount + "\n"
                        + "  Taxes      $" + taxesAmount + "\n"
                        + "  TOTAL      $" + totalAmount + "\n"
                        + "  ------ \n"
                        + "  Balance    $" + balance + "\n";
            }
        } catch(Exception e){
            return "INCORRECT NUMBER";
        }

    }
    public String depositMoney(double amount){
        balance = balance + amount;
        return "******    TRANSACTION    ****** \n"
                + "  You have deposited $" + amount + "\n"
                + "  ------ \n"
                + "  Balance            $" + balance + "\n";
    }

    public String sendMoney(double amount){
        double totalAmount = amount + transferTax;
        balance = balance - totalAmount;

        balance = balance + amount;

        return "******    TRANSACTION    ****** \n"
                + "  Transferred  $" + amount + "\n"
                + "  Taxes        $" + transferTax + "\n"
                + "  TOTAL        $" + totalAmount + "\n"
                + "  ------ \n"
                + "  Balance      $" + balance + "\n";
    }

    public void receiveMoney(double amount){
        balance = balance + amount;
    }

    //public void searchAccount(){}

}














