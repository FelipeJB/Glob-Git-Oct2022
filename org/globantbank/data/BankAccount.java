package org.globantbank.data;

import java.time.LocalDate;


public class BankAccount {
    public int accountNumber;
    public LocalDate openingDate;
    public float balance;


    public BankAccount(int accountNumber, LocalDate openingDate, int balance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public float addMoney(float amountToAdd) {
        return this.balance + amountToAdd;
    }

    public float withdrawMoney(float amountToWithdraw) {

        if (amountToWithdraw < 200) {
            return this.balance - amountToWithdraw - 200;
        } else {
            return (float) (this.balance - (amountToWithdraw + 200 + (0.15 * amountToWithdraw)));
        }
    }

    public boolean verifyBalanceForWithdrawals(float amountToWithdraw) {
        if (amountToWithdraw < 1000) {
            return this.balance >= (amountToWithdraw + 200);
        } else {
            return this.balance >= (amountToWithdraw + 200 + (0.15 * amountToWithdraw));
        }
    }

    public float transferMoney(float amountToTransfer) {
        return this.balance - (amountToTransfer + 100);
    }

    public boolean verifyBalanceForTransfer(float amountToTransfer) {
        return this.balance >= (amountToTransfer + 100);
    }

}
