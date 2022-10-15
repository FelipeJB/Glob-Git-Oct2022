package org.globant.globantBank.main;

import org.globant.globantBank.data.Bank;
import org.globant.globantBank.data.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();

        String option;

        System.out.println("Welcome to Globant Bank!");
        System.out.println("How can we help you today?");

        do {
            System.out.println("Menu:");
            System.out.println("1. List all bank accounts");
            System.out.println("2. Sign up");
            System.out.println("3. Log in");
            System.out.println("4. Exit");

            option = scan.nextLine();
            scan = new Scanner(System.in);

            switch (option){
                case "1":
                    printUsers(bank);
                    break;
                case "2":
                    signUp(bank);
                    break;
                case "3":
                    logIn(bank);
                    break;
                case "4":
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Please enter a valid option: 1 - 4");
                    System.out.println();
                    break;
            }
        } while (!option.equals("4"));
    }

    // List available accounts
    public static void printUsers(Bank bank){
        if (bank.clients.isEmpty()){
            System.out.println("At the moment, there are no registered clients");
        } else {
            ArrayList<String> usersInfo = bank.getClientsInfo();
            for (int i = 0; i < usersInfo.size(); i++) {
                System.out.println(usersInfo.get(i));
            }
        }
        System.out.println();
    }

    // Register new users
    public static void signUp(Bank bank){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Please insert your user name:");
            String userName = scan.nextLine();
            scan = new Scanner(System.in);

            System.out.println("Please insert your password:");
            String password = scan.nextLine();
            scan = new Scanner(System.in);

            System.out.println("Please insert your account funds");
            float accountBalance = scan.nextFloat();
            scan = new Scanner(System.in);

            Client createdClient = bank.createAccount(userName, password, accountBalance);

            System.out.println("Account successfully created");
            System.out.println("Account number: " + createdClient.account.accountNumber);
            System.out.println();
        } catch (java.util.InputMismatchException e) {
            System.out.println("The account was not registered. Please verify the provided information");
            System.out.println();
        }
    }

    // Log in
    public static void logIn(Bank bank){
        Scanner scan = new Scanner(System.in);
        boolean canLogIn;
        try{
            System.out.println("Please insert you account number:");
            int accountNumber = scan.nextInt();
            scan = new Scanner(System.in);

            System.out.println("Please insert your password:");
            String password = scan.nextLine();
            scan = new Scanner(System.in);

            canLogIn = bank.logIn(accountNumber, password);

            if(canLogIn){
                Client loggedClient = bank.findAccountByAccountNumber(accountNumber);
                System.out.println();
                System.out.println("Welcome Mr./Ms " + loggedClient.userName);
                actionsForLoggedUsers(bank, accountNumber);
            } else {
                System.out.println("Log in procedure failed. Please verify the provided information");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Log in procedure failed. Please verify the provided information");
            System.out.println();
        }
    }

    // Menu for logged users
    public static void actionsForLoggedUsers(Bank bank, int accountNumber){
        Scanner scan = new Scanner(System.in);
        String option;

        do {
            System.out.println("How can we help you today?");
            System.out.println("1. Verify your current funds");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Transfer money");
            System.out.println("5. Go back");

            option = scan.nextLine();
            scan = new Scanner(System.in);

            switch (option){
                case "1":
                    verifyCurrentFunds(bank, accountNumber);
                    break;
                case "2":
                    addMoney(bank, accountNumber);
                    break;
                case "3":
                    withdrawMoney(bank, accountNumber);
                    break;
                case "4":
                    transferMoney(bank, accountNumber);
                    break;
                case "5":
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Please enter a valid option: 1 - 5");
                    System.out.println();
                    break;
            }
        } while (!option.equals("5"));
    }

    public static void verifyCurrentFunds(Bank bank, int accountNumber){
        Client client = bank.findAccountByAccountNumber(accountNumber);
        System.out.println("Current funds: " + client.account.accountBalance);
        System.out.println();
    }

    public static void addMoney(Bank bank, int accountNumber){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("How much money would you like to deposit today?");
            float moneyAmountToBeAdded = scan.nextInt();
            scan = new Scanner(System.in);

            bank.addMoney(accountNumber, moneyAmountToBeAdded);
            System.out.println("Money successfully added");
            verifyCurrentFunds(bank, accountNumber);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Procedure failed. Please verify the provided information");
            System.out.println();
        }
    }

    public static void withdrawMoney(Bank bank, int accountNumber){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("How much money would you like to withdraw today?");
            float amountToBeWithdrawn = scan.nextInt();
            scan = new Scanner(System.in);

            boolean moneyWithdrawn = bank.withdrawMoney(accountNumber, amountToBeWithdrawn);

            if (moneyWithdrawn){
                System.out.println("Money successfully withdrawn");
                verifyCurrentFunds(bank, accountNumber);
            } else {
                System.out.println("There are no enough funds to continue with your request");
                System.out.println();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Procedure failed. Please verify the provided information");
            System.out.println();
        }
    }

    public static void transferMoney(Bank bank, int accountNumber){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Please enter the receiver account number:");
            int accountNumberReceiver = scan.nextInt();
            scan = new Scanner(System.in);

            System.out.println("How much money would you like to transfer today?");
            float amountToBeTransferred = scan.nextInt();
            scan = new Scanner(System.in);

            boolean moneyTransferred = bank.transferMoney(accountNumber, accountNumberReceiver, amountToBeTransferred);

            if (moneyTransferred){
                System.out.println("Money successfully transferred");
                verifyCurrentFunds(bank, accountNumber);
            } else {
                System.out.println("Procedure failed. Please verify the provided information");
                System.out.println();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Procedure failed. Please verify the provided information");
            System.out.println();
        }
    }
}
