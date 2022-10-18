package org.globant.bank;

import java.util.Date;

public class User {
    private int userID;
    private String userName;
    private String password;
    private SavingsAccount savingsAccount;

    public User(int userID, String userName, String password, int accountNumber, double balance) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        addSavingsAccount(accountNumber, balance);
}

    private boolean addSavingsAccount(int accountNumber, double balance) {
        if(savingsAccount == null){
            Date date = new Date();
            savingsAccount = new SavingsAccount(accountNumber, date, balance, userID);
            return true;
        }
        return false;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }
}
