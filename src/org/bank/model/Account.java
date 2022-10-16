package org.bank.model;

import java.util.Date;

public class Account {
    // attributes
    private Integer accountNumber;
    private Date openingDate;
    private Double accountBalance;
    private static int countAccountNumber;

    // constructor
    public Account(Date openingDate, Double accountBalance) {
        this.accountNumber = ++countAccountNumber;
        this.openingDate = openingDate;
        this.accountBalance = accountBalance;
    }

    // methods
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public boolean withdraw(Integer amountToWithdraw) {
        if (amountToWithdraw > 0 && amountToWithdraw <= (accountBalance * 0.75)) {
            if (amountToWithdraw <= 1000) {
                accountBalance -= (amountToWithdraw + 200);
                return true;
            }
            if (amountToWithdraw > 1001) {
                accountBalance -= (amountToWithdraw + 200 + (amountToWithdraw * 0.15));
                return true;
            }
        }
        return false;
    }

    public boolean deposit(Integer amountToDeposit) {
        if (amountToDeposit > 0) {
            accountBalance += amountToDeposit;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account N° = " + accountNumber + ", Opening date = " + openingDate + ", accountBalance = " + accountBalance;
    }
}
