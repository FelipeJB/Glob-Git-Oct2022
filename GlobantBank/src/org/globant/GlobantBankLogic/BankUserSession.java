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

    public BankUserSession(String user, String password){

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

    public boolean setUserAuthentication(String user, String password){

        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            if (currentUser.getUserName() == user){
                return currentUser.confirmPassword(password);
            }
        }
        return false;
    }

    public int setUserIndex(String user){
        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            if (currentUser.getUserName() == user){
                return i;
            }
        }
        return -1;
    }

    // ----------- METHODS ------------

    public void deposit(float amount){
        BankDataBase.modifyEntryBalance(this.getIndex(), amount);
    }

    public boolean withdraw(float amount){
        if (amount < 0){
            return false;
        } else if (amount < 1000) {
            float taxedAmount = amount + 200;
            return BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount);
        } else {
            float taxedAmount = (float) (amount + (amount * 0.15) + 200);
            return BankDataBase.modifyEntryBalance(this.getIndex(), taxedAmount);
        }
    }

    public boolean transfer()
}
