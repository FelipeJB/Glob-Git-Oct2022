package org.globant.bank;

public class Client {
    public Account savingsAccount;
    String user;
    int password;


    //cada vez que se crea un cliente se crea un account
    public  Client(String user, int password){
        this.user = user;
        this.password = password;
        this.savingsAccount = new Account();
    }

    public String toString(){
        return "\n>> User : " + this.user + "\n"
                + savingsAccount.toString();
    }
}
