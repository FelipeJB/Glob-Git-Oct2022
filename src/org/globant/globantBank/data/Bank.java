package org.globant.globantBank.data;

import java.util.ArrayList;

public class Bank {
    public ArrayList<Client> clients;

    public Bank(){
        this.clients = new ArrayList<>();
    }

    public ArrayList<String> getClientsInfo(){
        ArrayList<String> usersInfo = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            usersInfo.add((i + 1) + ".Account number: " + clients.get(i).account.accountNumber + " | User: " + clients.get(i).userName + " | Account balance: " + clients.get(i).account.accountBalance + " | Account opening date: " + clients.get(i).account.accountOpeningDate);
        }
        return usersInfo;
    }

    public Client createAccount(String userName, String password, float accountBalance) {
        int accountNumber = clients.size() + 1;

        String accountOpeningDate = String.valueOf(java.time.LocalDate.now());

        Account account = new Account(accountNumber, accountOpeningDate, accountBalance);
        Client client = new Client(userName, account, password);

        clients.add(client);

        return client;
    }

    public Client findAccountByAccountNumber(int accountNumber){
        Client client = new Client();
        for (int i = 0; i < this.clients.size(); i++) {
            if (clients.get(i).account.accountNumber == accountNumber){
                client = clients.get(i);
            }
        }
        return client;
    }

    public boolean logIn(int accountNumber, String password){
        boolean canLogIn = false;
        Client client = findAccountByAccountNumber(accountNumber);
        if(client.userName != null){
            if(client.password.equals(password)){
                canLogIn = true;
            }
        }
        return canLogIn;
    }

    public void addMoney(int accountNumber, float moneyAmountToBeAdded){
        Client client = this.findAccountByAccountNumber(accountNumber);

        client.account.accountBalance =  client.account.addMoney(moneyAmountToBeAdded);
    }

    public boolean withdrawMoney(int accountNumber, float amountToBeWithdrawn){
        boolean moneyWithdrawn = false;
        Client client = this.findAccountByAccountNumber(accountNumber);

        if(client.account.verifyBeforeWithdraw(amountToBeWithdrawn)){
            client.account.accountBalance = client.account.withdrawMoney(amountToBeWithdrawn);
            moneyWithdrawn = true;
        }
        return moneyWithdrawn;
    }

    public boolean transferMoney(int accountNumberSender, int accountNumberReceiver, float amountToBeTransferred){
        boolean moneyTransferred = false;

        if(accountNumberSender != accountNumberReceiver){
            Client senderClient = this.findAccountByAccountNumber(accountNumberSender);
            Client receiverClient = this.findAccountByAccountNumber(accountNumberReceiver);

            if(senderClient.userName != null && receiverClient.userName != null){
                if(senderClient.account.verifyBeforeTransfer(amountToBeTransferred)){
                    senderClient.account.accountBalance =  senderClient.account.transferMoney(amountToBeTransferred);
                    receiverClient.account.accountBalance = receiverClient.account.addMoney(amountToBeTransferred);
                    moneyTransferred = true;
                }
            }
        }
        return moneyTransferred;
    }

}
