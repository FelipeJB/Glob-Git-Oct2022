package org.bank.model;

public class User {
    // attributes
    private String username;
    private String password;
    private Account savingsAccount;

    // constructor
    public User(String username, String password, Account savingsAccount) {
        this.username = username;
        this.password = password;
        this.savingsAccount = savingsAccount;
    }

    // methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

    @Override
    public String toString() {
        return "User = " + username + '\n' +
                savingsAccount;
    }
}
