package com.globant.model;

public class Client {

    private String username;
    private String password;
    private Account SavingsAccount;

    public Client(String username, String password, Account savingsAccount) {
        this.username = username;
        this.password = password;
        SavingsAccount = savingsAccount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSavingsAccount(Account savingsAccount) {
        SavingsAccount = savingsAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Account getSavingsAccount() {
        return SavingsAccount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", SavingsAccount=" + SavingsAccount +
                '}';
    }
}
