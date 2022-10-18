package org.globant.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String name;
    public List<Client> clientList ;

    public Bank(){
        name = "GLOBANT BANK";
        clientList = new ArrayList<>();
    }

    public void addUserToBank(Client user){
        clientList.add(user);
    }
    public String getAllClients(){
        return "***** " + name + " CLIENT LIST ***** \n"
                + clientList;
    }

    //TRANSACTIONS
    public String withdrawTransaction (double amount, Account account){
       return account.withdrawMoney(amount);
    }

    public String depositTransaction(double amount, Account account){
        return  account.depositMoney(amount);
    }

    public void transferTransaction(double amount, Account sendingAccount, Account receivingAccount){
        receivingAccount.receiveMoney(amount);
        System.out.println(sendingAccount.sendMoney(amount));

    }

    public Client getUser(String userName){
        Client clientFound = null;
        for(int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if(client.user == userName){
               clientFound = client;
               break;
            }
        }
        return clientFound;
    }

    public Client validateUser(String userName, int password){
        Client clientFound = null;
        for(int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if(client.user == userName && client.password == password){
                clientFound = client;
                break;
            }
        }
        return clientFound;
    }
}




















