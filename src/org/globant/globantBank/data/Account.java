package org.globant.globantBank.data;

public class Account {
    public int accountNumber;
    public String accountOpeningDate;
    public float accountBalance;

    public Account(int accountNumber, String accountOpeningDate, float accountBalance){
        this.accountNumber = accountNumber;
        this.accountOpeningDate = accountOpeningDate;
        this.accountBalance = accountBalance;
    }

    public float addMoney(float moneyAmountToBeAdded){
        return this.accountBalance + moneyAmountToBeAdded;
    }

    public float withdrawMoney(float amountToBeWithdrawn){
        if (amountToBeWithdrawn < 1000) {
            return this.accountBalance - (amountToBeWithdrawn + 200);
        } else {
            return (float) (this.accountBalance - (amountToBeWithdrawn + 200 + (0.15 * amountToBeWithdrawn)));
        }
    }

    public boolean verifyBeforeWithdraw(float amountToBeWithdrawn){
        if (amountToBeWithdrawn < 1000) {
            return this.accountBalance >= (amountToBeWithdrawn + 200);
        } else {
            return this.accountBalance >= (amountToBeWithdrawn + 200 + (0.15 * amountToBeWithdrawn));
        }
    }

    public float transferMoney(float amountToBeTransfer){
        return this.accountBalance - (amountToBeTransfer + 100);
    }

    public boolean verifyBeforeTransfer(float amountToBeTransfer){
        return this.accountBalance >= (amountToBeTransfer + 100);
    }
}
