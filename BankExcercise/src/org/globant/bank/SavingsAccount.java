package org.globant.bank;

import java.util.Date;

public class SavingsAccount {
    private int accountNumber;
    private Date accountOpeningDate;
    private double balanceAccount;

    public SavingsAccount(int accountNumber, Date accountOpeningDate, double balanceAccount, int userID) {
        this.accountNumber = accountNumber;
        this.accountOpeningDate = accountOpeningDate;
        this.balanceAccount = balanceAccount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public double getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(double amount) {
        this.balanceAccount += amount;
    }

    public boolean withdrawAccount (double amount) {
        if (amount >= this.balanceAccount) {
            return false;
        } else {
            this.balanceAccount -= amount;
        }
        return true;
    }
}
