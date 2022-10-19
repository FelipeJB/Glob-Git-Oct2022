package org.globant.bank;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Bank {
    String name;
    public List<Client> clientList ;

    public Bank(){
        name = "GLOBANT BANK";
        clientList = new ArrayList<>();
    }

   public String createUser(String userName, String password){
        Client client = new Client( userName, password);
        clientList.add(client);
                return "\n Customer " +userName + " successfully created\n";
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

    public String transferTransaction(double amount, Account sendingAccount, int accountNumber){
        Client receivingClient;

        for(int i = 0; i < clientList.size(); i++){
            if(clientList.get(i).savingsAccount.accountNumber == (accountNumber)) {
                receivingClient = clientList.get(i);
                receivingClient.savingsAccount.receiveMoney(amount);
                return sendingAccount.sendMoney(amount);
            }
        }
        return "THE ACCOUNT " + accountNumber + " not exist\n";
    }

    public Client getUser(double accountNumber){
        Client accountFound = null;
        for(int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if(client.savingsAccount.equals(accountNumber)){
               accountFound = client;
               break;
            }
        }
        return accountFound;
    }

    public Client validateUser(String userName, String password){
        Client clientFound = null;
        for(int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if(client.user.equals(userName) && client.password.equals(password)){
                clientFound = client;
            }
        }
        return clientFound;
    }

    public String getBalanceAccount(Account accountToCheckBalance){
        return  accountToCheckBalance.getBalance() +"\n" ;
    }
}




















