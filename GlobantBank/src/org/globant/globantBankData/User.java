package org.globant.globantBankData;

public class User {

    public static int counter = 1;

    private String userName;
    private int password;
    private int id;
    private SavingsAccount account;

    // ----------- CONSTRUCTOR --------------

    public User(String userName, int password, float balance) {
        this.userName = userName;
        this.password = password;
        this.account = new SavingsAccount(balance);

        this.id = counter;
        counter++;

    }

    // ----------- GETTERS --------------

    public String getUserName(){
        return this.userName;
    }

    public int getId(){
        return this.id;
    }

    public SavingsAccount getAccount(){
        return this.account;
    }

    // ------------ METHODS --------------

    public boolean confirmPassword(int passwordAttempt){
        if (this.password == passwordAttempt){
            return true;
        } else {
            return false;
        }
    }

}
