package org.globantbank.mainlogic;

import org.globantbank.data.Bank;
import org.globantbank.data.BankAccount;
import org.globantbank.data.Client;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(00001, LocalDate.of(2022, 10, 15), 0);
        BankAccount account2 = new BankAccount(00002, LocalDate.of(2022, 10, 15), 10000);
        Client client1 = new Client(account1, "jhon", 1234);
        Client client2 = new Client(account2, "harol", 12345);
        Bank bank = new Bank();
        bank.clients.add(client1);
        bank.clients.add(client2);

        Scanner scan = new Scanner(System.in);
        int option;
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to JD org.globantbank.data.Bank, what you want to do?");
            System.out.println("   1. List all users information");
            System.out.println("   2. Withdraw money");
            System.out.println("   3. Add money");
            System.out.println("   4. Transfer money");
            System.out.println("   5. Exit");
            try {
                option = scan.nextInt();
                scan = new Scanner(System.in);
                if (option < 1 || option > 6) {
                    System.out.println("Only the options 1 -5 are available at the moment");
                } else if (option >= 1 && option <= 5) {
                    switch (option) {
                        case 1:
                            listClients(bank);
                            break;
                        case 2:
                            withdrawMoney(bank);
                            break;
                        case 3:
                            addMoney(bank);
                            break;
                        case 4:
                            transferMoney(bank);
                            break;
                        case 5:
                            System.out.println("You choose to exit the program");
                            exit = true;
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("You wrote the wrong information, please try again");
                scan.nextLine();
            }
        }
    }
    public static void listClients(Bank bank) {
        System.out.println(bank.getAllClientsInfo());
    }
    public static void withdrawMoney(Bank bank) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Write the account number that will withdraw the money");
            int accountNumber = scan.nextInt();
            scan = new Scanner(System.in);
            bank.findAccount(accountNumber);


            System.out.println("Enter the amount to withdraw");
            float amountToWithdraw = scan.nextInt();
            if (bank.withdrawMoney(accountNumber, amountToWithdraw)) {
                System.out.println("Your new balance is: " + bank.findAccount(accountNumber).account.balance);
            } else {
                System.out.println("The account doesn't have enough funds");
            }
        } catch (NullPointerException e) {
            System.out.println("You wrote the wrong information, please try again");;
        }
    }

    public static void addMoney(Bank bank) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the account to add money");
            int accountNumber = scan.nextInt();
            scan = new Scanner(System.in);
            bank.findAccount(accountNumber);
            System.out.println("Enter the amount to add");
            int amountToAdd = scan.nextInt();
            bank.addMoney(accountNumber, amountToAdd);
            System.out.println("Your new balance is: " + bank.findAccount(accountNumber).account.balance);
        } catch (NullPointerException e) {
            System.out.println("You wrote the wrong information, please try again");;
        }
    }

    public static void transferMoney(Bank bank) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the account that will transfer the money");
            int senderAccount = scan.nextInt();
            scan = new Scanner(System.in);
            System.out.println("Enter the account that will receive the money");
            int receiverAccount = scan.nextInt();
            scan = new Scanner(System.in);
            System.out.println("Enter the amount to transfer");
            int amountToTransfer = scan.nextInt();

            if (bank.transferMoney(senderAccount, receiverAccount, amountToTransfer)) {
                System.out.println("You transferred " + amountToTransfer + " your new balance is " + bank.findAccount(senderAccount).account.balance);
            } else {
                System.out.println("The account doesn't have enough funds");
            }
        } catch (NullPointerException e) {
            System.out.println("You wrote the wrong information, please try again");;
        }
    }
}



