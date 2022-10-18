package com.globant.model;

import java.util.Date;

public class Account {
    private int accountNumber;
    private Date OpeningDate;
    private double balance;

    public Account() {
        this.accountNumber = (int)(Math.random() * 99999 + 11111);
        OpeningDate = new Date();
        this.balance = 0d;
    }

    public boolean withdraw(double amountToWithdraw) {
        //coming soon
        return false;
    }

    public boolean addMoney(double amountToAdd) {
        //coming soon
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Date getOpeningDate() {
        return OpeningDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOpeningDate(Date openingDate) {
        OpeningDate = openingDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
