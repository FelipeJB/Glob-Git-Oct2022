package com.globant.view;

import com.globant.model.Account;
import com.globant.model.Bank;
import com.globant.model.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan;
        boolean activeSystem = true;
        Bank bank = new Bank();

        System.out.println("*********** WELCOME TO GLOBANT BANK ***********");

        do {
            System.out.println("Please, select your profile: \n 1. Admin \n 2. Client \n 3. Exit");
            scan = new Scanner(System.in);
            int optionGeneral = scan.nextInt();
            switch (optionGeneral){
                case 1:
                    System.out.println("Enter your password: ");
                    scan = new Scanner(System.in);
                    String passwordAdmin = scan.nextLine();

                    if (passwordAdmin.equals(bank.getPassword())){
                        boolean activeSessionAdmin = true;
                        do {
                            System.out.println("Welcome to Admin profile, please select an option: " +
                                            "\n       1. List clients" +
                                            "\n       2. Open new account" +
                                            "\n       3. Close session");
                            scan = new Scanner(System.in);
                            int optionAdmin = scan.nextInt();
                            switch (optionAdmin){
                                case 1:
                                    listClients(bank);
                                    break;
                                case 2:
                                    openNewAccount(bank);
                                    break;
                                case 3:
                                    activeSessionAdmin = false;
                                    break;
                                default:
                                    System.out.println("Invalid option, please try again.");
                                    break;
                            }
                        }while (activeSessionAdmin);

                    }else{
                        System.out.println("Invalid password.");
                    }
                    break;
                case 2:
                    System.out.println("Enter your username: ");
                    scan = new Scanner(System.in);
                    String usernameClient = scan.nextLine();

                    System.out.println("Enter your password: ");
                    scan = new Scanner(System.in);
                    String passwordClient = scan.nextLine();

                    if (searchClient(bank, usernameClient, passwordClient)){
                        boolean activeSessionClient = true;
                        do {
                            System.out.println("Welcome "+usernameClient+", please select an option: " +
                                    "\n       1. Withdraw" +
                                    "\n       2. Add money" +
                                    "\n       3. Transfer money" +
                                    "\n       4. Close session");
                            scan = new Scanner(System.in);
                            int optionClient = scan.nextInt();
                            switch (optionClient){
                                case 1:
                                    System.out.println("Enter the value to withdraw: ");
                                    scan = new Scanner(System.in);
                                    double amountToWithdraw = scan.nextDouble();
                                    withdraw(bank, usernameClient, amountToWithdraw);
                                    break;
                                case 2:
                                    System.out.println("Enter the value to add: ");
                                    scan = new Scanner(System.in);
                                    double amountToAdd = scan.nextDouble();
                                    addMoney(bank, usernameClient, amountToAdd);
                                    break;
                                case 3:
                                    System.out.println("Enter the value to withdraw: ");
                                    scan = new Scanner(System.in);
                                    double amountToTransfer = scan.nextDouble();

                                    System.out.println("Enter the account number to transfer the money: ");
                                    scan = new Scanner(System.in);
                                    int accountToTransfer = scan.nextInt();
                                    transferMoney(bank, usernameClient, amountToTransfer, accountToTransfer);
                                    break;
                                case 4:
                                    activeSessionClient = false;
                                    break;
                                default:
                                    System.out.println("Invalid option, please try again.");
                                    break;
                            }
                        }while (activeSessionClient);

                    }else{
                        System.out.println("Invalid password.");
                    }
                    break;
                case 3:
                    activeSystem = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }

        }while (activeSystem);

    }

    public static void listClients(Bank bank){
        ArrayList<Client> clients = bank.getClients();
        if (bank.getClients().size() > 0){
            for (int i = 0; i < bank.getClients().size(); i++){
                System.out.println("-----Client "+(i+1)+"-----");
                System.out.println("      Username = "+bank.getClients().get(i).getUsername()+
                        "\n      Account number = "+bank.getClients().get(i).getSavingsAccount().getAccountNumber()+
                        "\n      Opening date = "+bank.getClients().get(i).getSavingsAccount().getOpeningDate()+
                        "\n      Balance = "+bank.getClients().get(i).getSavingsAccount().getBalance());
            }
        }else {
            System.out.println("There are no clients. Please open a new account.");
        }

    }

    public static void openNewAccount(Bank bank){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the username: ");
            String username = scan.nextLine();

            scan = new Scanner(System.in);
            System.out.println("Enter the password: ");
            String password = scan.nextLine();

            Account account = new Account();
            Client client = new Client(username, password, account);

            bank.createNewClient(client);

            System.out.println("The client was created successful.");

        }catch (Exception e){
            System.out.println("An error has occurred: \n" + e);
        }
    }

    public static boolean searchClient(Bank bank, String user, String password){
        for (Client client : bank.getClients()) {
            if (client.getUsername().equals(user) && client.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static void withdraw(Bank bank, String user, double amountToWithdraw){
        double tax = 0d;
        for (Client client : bank.getClients()) {
            if (client.getUsername().equals(user)){
                if (client.getSavingsAccount().withdraw(amountToWithdraw)){
                    System.out.println("The withdraw was successful.");
                }else {
                    System.out.println("The transaction was not possible.");
                }
            }
        }
    }

    public static void addMoney(Bank bank, String user, double amountToAdd){
        for (Client client : bank.getClients()) {
            if (client.getUsername().equals(user)){
                if (client.getSavingsAccount().addMoney(amountToAdd)){
                    System.out.println("The addition was successful.");
                }else {
                    System.out.println("The transaction was not possible.");
                }
            }
        }
    }

    public static void transferMoney(Bank bank, String user, double amountToTransfer, int accountToTransfer){
        double tax = 0d;
        for (Client client : bank.getClients()) {
            if (client.getUsername().equals(user)){

            }
        }
    }
}
