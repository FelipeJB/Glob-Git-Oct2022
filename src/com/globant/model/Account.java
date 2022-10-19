package com.globant.model;

import java.util.Date;

public class Account {
    private int accountNumber;
    private Date OpeningDate;
    private double balance;

    public Account() {
        this.accountNumber = (int)(Math.random() * 99999 + 11111);
        OpeningDate = new Date();
        this.balance = 0d;
    }

    public boolean withdraw(Client client, double amountToWithdraw, double tax) {
        try {
            if ((amountToWithdraw+tax) <= client.getSavingsAccount().getBalance()){
                client.getSavingsAccount().setBalance(client.getSavingsAccount().getBalance()-amountToWithdraw-tax);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addMoney(Client client, double amountToAdd) {
        try {
            client.getSavingsAccount().setBalance(client.getSavingsAccount().getBalance()+amountToAdd);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean transferMoney(Client client, Client clientToTransfer, double amountToTransfer) {
        try {
            if ((amountToTransfer+100) <= client.getSavingsAccount().getBalance()){
                client.getSavingsAccount().setBalance(client.getSavingsAccount().getBalance()-amountToTransfer-100);
                clientToTransfer.getSavingsAccount().setBalance(clientToTransfer.getSavingsAccount().getBalance()+amountToTransfer);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Date getOpeningDate() {
        return OpeningDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOpeningDate(Date openingDate) {
        OpeningDate = openingDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
