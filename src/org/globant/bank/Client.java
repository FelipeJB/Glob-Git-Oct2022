package org.globant.bank;

public class Client {
    public Account savingsAccount;
    final String user;
    final String password;

    public  Client(String user, String password){
        this.user = user;
        this.password = password;
        this.savingsAccount = new Account();
    }

    public String toString(){
        return "\n>> User : " + this.user + "\n"
                + savingsAccount.toString();
    }
}