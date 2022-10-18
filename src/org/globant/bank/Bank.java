package org.globant.bank;

import org.globant.client.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    Scanner input = new Scanner(System.in);
    List <Client> clients = new ArrayList<Client>();
    Client client = new Client();

    LocalDateTime date = LocalDateTime.now();

    public void addMoney(double amount){
        double adder = client.getBalance() + amount;
        client.setBalance(adder);
        System.out.println("The money has been added successfully.");
        System.out.println("Your current balance is: " + client.getBalance());
    }
    public void withdrawMoney(double amount){
        double AMOUNT_WITH_TAX = amount + 200;

        if(AMOUNT_WITH_TAX > client.getBalance()){
            System.out.println("You can't retrieve more money than you have.");
            System.out.println("Your current balance is: " + client.getBalance());
        } else if(AMOUNT_WITH_TAX > 1000){
            double fifteenPercent = amount * 0.15;
            client.setBalance(client.getBalance() - AMOUNT_WITH_TAX - fifteenPercent);
            System.out.println("The money has been retrieved successfully");
            System.out.println("Your current balance is: " + client.getBalance());
        } else {
            client.setBalance(client.getBalance() - AMOUNT_WITH_TAX);
            System.out.println("The money has been retrieved successfully");
            System.out.println("Your current balance is: " + client.getBalance());
        }
    }
    public void transferMoney(double accountNumber, double amount){
        for (int i = 0; i < clients.size(); i++) {
            if(accountNumber == clients.get(i).getAccountNumber()){
                double maybe = clients.get(i).getBalance() + amount;
            }
        }
    }
    public void getClientsLists(){
            System.out.println("List of clients: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("User: " + clients.get(i).getUser());
            System.out.println("Account number: " + clients.get(i).getAccountNumber());
            System.out.println("Date: " + clients.get(i).getOpeningDate());
        }
    }
    public void addClientToList(Client client){
        clients.add(client);
    }
    public boolean clientsValidator(String username, String password){
        client.setUser(username);
        client.setPassword(password);
        for (int i = 0; i < clients.size(); i++) {
            if(client.getUser() == clients.get(i).getUser() && client.getPassword() == clients.get(i).getPassword()){
                return true;
            }
        }
        return false;
    }
    public void clientCreator(){
            System.out.println("Enter your name: ");
            client.setUser(input.next());
            System.out.println("Enter your password: ");
            client.setPassword(input.next());
            client.setAccountNumber(Math.random() * 10);
            client.setBalance(0);
            client.setOpeningDate(date);
            addClientToList(client);
            System.out.println("Your account has been successfully created!");
            getClientsLists();
    }
}
