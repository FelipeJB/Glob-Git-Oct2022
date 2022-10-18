package org.globantbank.data;

import org.globantbank.data.Client;

import java.util.ArrayList;

public class Bank {
    public ArrayList<Client> clients;

    public Bank() {
        this.clients = new ArrayList<>();
    }

    public ArrayList<String> getAllClientsInfo() {
        ArrayList<String> clientsInformation = new ArrayList<>();

        for (int i = 0; i < clients.size(); i++) {
            clientsInformation.add("Account number: " + clients.get(i).account.accountNumber + " User: " + clients.get(i).user + " Account Balance: " + clients.get(i).account.balance + " Opening date: " + clients.get(i).account.openingDate + "\n");
        }
        return clientsInformation;

    }

    public Client findAccount(int accountNumber) {
        Client client = new Client();
        for (int i = 0; i < this.clients.size(); i++) {
            if (clients.get(i).account.accountNumber == accountNumber) {
                client = clients.get(i);
            }
        }
        return client;


    }

    public void addMoney(int accountNumber, float amountToAdd) {
        Client client = this.findAccount(accountNumber);
        client.account.balance = client.account.addMoney(amountToAdd);
    }

    public boolean withdrawMoney(int accountNumber, float amountToWithdraw) {
        Client client = this.findAccount(accountNumber);
        boolean canWithDraw = false;
        if (client.account.verifyBalanceForWithdrawals(amountToWithdraw)) {
            client.account.balance = client.account.withdrawMoney(amountToWithdraw);
            canWithDraw = true;
        }
        return canWithDraw;
    }


    public boolean transferMoney(int senderAccount, int receiverAccount, int amountToTransfer) {
        boolean canTransfer = false;
        Client senderClient = this.findAccount(senderAccount);
        Client receiverClient = this.findAccount(receiverAccount);

        if (senderClient.account.verifyBalanceForTransfer(amountToTransfer)) {
            senderClient.account.balance = senderClient.account.transferMoney(amountToTransfer);
            receiverClient.account.balance = receiverClient.account.addMoney(amountToTransfer);
            canTransfer = true;
        }
        return canTransfer;
    }
}
