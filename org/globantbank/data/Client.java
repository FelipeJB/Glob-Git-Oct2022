package org.globantbank.data;

import org.globantbank.data.BankAccount;

public class Client {
    public BankAccount account;
    public String user;
    public int password;
    public Client(BankAccount account, String user, int password) {
        this.account = account;
        this.user = user;
        this.password = password;
    }
    public Client() {
    }

}
