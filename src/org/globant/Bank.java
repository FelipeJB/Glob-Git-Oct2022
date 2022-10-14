package org.globant;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public String bankName;
    public static ArrayList<Client> myClients;


    public Bank(String bankName, ArrayList<Client> myClients) {
        this.bankName = bankName;
        this.myClients = myClients;
    }

    public void addClient(Client client){
        myClients.add(client);
    }

    public void printClients(){
        for (Client client : this.myClients) {
            System.out.println("Cliente: " + client.userName + " Cuenta N°: " + client.userSavingAccount.accountNumber + " Balance: " + client.userSavingAccount.balance + " Fecha de creacion: " + client.userSavingAccount.creationDate);
        }
    }



}
