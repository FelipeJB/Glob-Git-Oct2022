package org.globant.globantBank.data;

public class Client {
    public String userName;
    public Account account;
    public String password;

    public Client(){

    }

    public Client(String userName, Account account, String password){
        this.userName = userName;
        this.account = account;
        this.password = password;
    }
}