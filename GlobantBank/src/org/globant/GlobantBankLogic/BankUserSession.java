package org.globant.GlobantBankLogic;

import org.globant.GlobantBankData.BankDataBase;
import org.globant.GlobantBankData.SavingsAccount;
import org.globant.GlobantBankData.User;

import java.util.List;

public class BankUserSession {

    private String user;
    private boolean authentication;
    private int index;

    // ------------ CONSTRUCTOR ----------

    public BankUserSession(String user, int password){

        this.user = user;
        this.authentication = this.setUserAuthentication(user, password);
        this.index = setUserIndex(user);

    }

    // -------------- GETTERS -------------

    public String getUser(){
        return this.user;
    }

    public boolean getAuthenticationStatus(){
        return this.authentication;
    }

    public int getIndex(){
        return this.index;
    }

    // -------------- SETTERS --------------

    public boolean setUserAuthentication(String user, int password){

        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            if (currentUser.getUserName().equals(user)){
                return currentUser.confirmPassword(password);
            }
        }
        return false;
    }

    public int setUserIndex(String user){
        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            if (currentUser.getUserName().equals(user)){
                return i;
            }
        }
        return -1;
    }

    // ----------- METHODS ------------

    public void deposit(float amount){
        BankDataBase.modifyEntryBalance(this.getIndex(), amount);
    }

    public String withdraw(float amount){
        if (amount < 0){
            return "Invalid amount. Please use a positive number";
        } else if (amount < 1000) {
            float taxedAmount = (amount + 200)* -1;
            if (BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount)){
                // BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount);
                return "Transaction Completed. A tax for $200 was deducted";
            } else {
                return "Not enough funds, remember a tax of $200 will be deducted";
            }
        } else {
            float tax = (float) ((amount * 0.15) + 200);
            float taxedAmount = (float) (amount + (amount * 0.15) + 200) * -1;
            if (BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount)){
                // BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount);
                return "Transaction Completed. A tax for: $" + tax + " Was deducted.";
            } else {
                return "Not enough funds, remember a tax of $" + tax + " will be deducted";
            }
        }
    }

    public String transfer(float amount, int receivingAccount){

        int receivingAccountIndex = BankDataBase.findAccountIndex(receivingAccount);
        float amountToSubtract = (amount + 100) * -1;

        if ( receivingAccountIndex >= 0){
            if (BankDataBase.modifyEntryBalance(this.index, amountToSubtract)){
                BankDataBase.modifyEntryBalance(receivingAccountIndex, amount);
                return "Transaction Completed. An additional tax of $100 was charged.";
            } else {
                return "You don't have enough funds, remember there is a transaction cost of $100";
            }
        } else {
            return "Account not found.";
        }
    }
}
