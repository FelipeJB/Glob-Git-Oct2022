package org.taeacademy.globantbank.data;

import org.taeacademy.globantbank.data.Client;
import java.util.ArrayList;

public class Bank {

    ArrayList<Client> clientList = new ArrayList<>();

    public ArrayList<Client> getClientList(){
        return this.clientList;
    }

    public void depositFunds(Client currentUser, float amount){
        currentUser.getAccount().setAccountBalance(currentUser.getAccount().getAccountBalance()+amount);
    }

    public boolean withdrawFunds(Client currentUser, float amount){
        if(amount<1000){
            amount += 200;
        }
        else{
            amount += (200 + (amount*0.15));
        }
        if(currentUser.getAccount().getAccountBalance()<amount){
            return false;
        }
        currentUser.getAccount().setAccountBalance(currentUser.getAccount().getAccountBalance()-amount);
        return true;
    }

    public boolean transferFunds(Client currentUser, Client receivingUser, float amount){
        if(currentUser.getAccount().getAccountBalance()<(amount+100)){
            return false;
        }
        currentUser.getAccount().setAccountBalance(currentUser.getAccount().getAccountBalance()-amount-100);
        depositFunds(receivingUser,amount);
        return true;
    }
}