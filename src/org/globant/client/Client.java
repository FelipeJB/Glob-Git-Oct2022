package org.globant.client;

import java.time.LocalDateTime;

public class Client {
    private String user;
    private String password;
    private double balance;
    private Double accountNumber;
    private LocalDateTime openingDate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public Client(String user, String password, double balance, Double accountNumber, LocalDateTime openingDate) {
        this.user = user;
        this.password = password;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
    }
    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "user='" + user + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", openingDate=" + openingDate +
                '}';
    }
}
