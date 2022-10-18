package org.globant.bank;

import java.util.List;
import java.util.Scanner;

public class BankManager {
    public static Scanner scanner = new Scanner(System.in);
    public static int action;
    public static int whileAction;
    public static Bank bank = new Bank(200, 200, 15, 100);

    public static void main(String[] args) {
        System.out.println("**** Welcome to Globant Bank ****");
        ListUsers(bank.getUsers());
        System.out.println("Enter the User ID please:");
        action = scanner.nextInt();
        User user = bank.existUser(action);
        whileAction = 1;

        if (user.getUserID() < 0) {
            System.out.println("The User ID doesn't exist");
        } else {
            System.out.println("Welcome " + user.getUserName() + "!");

            while (whileAction == 1) {
                System.out.println("Select the option you want to do:");
                System.out.println("Option 1: To deposit money to your account");
                System.out.println("Option 2: To withdraw from your account");
                System.out.println("Option 3: To transfer money to another account");
                System.out.println("Option 4: To check the list of users");
                action = scanner.nextInt();
                if (action > 4) {
                    System.out.println("Wrong code");
                } else {
                    doTransaction(action, user);
                }
                System.out.println("Do you want to continue the transaction?");
                System.out.println("Press '1' if you want to continue");
                whileAction = scanner.nextInt();
            }
        }
        System.out.println("Your transaction is over, come back soon!");
        System.exit(0);
    }

    public static void ListUsers(List<User> userList) {
        for (User user : userList) {
            double balance = user.getSavingsAccount().getBalanceAccount();
            String strUser = "ID: " + user.getUserID() + "; The account Number: " + user.getSavingsAccount().getAccountNumber() + "; Balance: " + balance + "; Name: " + user.getUserName() + "; Password: " + user.getPassword();
            System.out.println("** " + strUser);
        }
    }

    public static void doTransaction(int transaction, User user) {
        double amount = 0.0;
        double balance;
        String responseATH = "";

        switch (transaction) {
            case 1:
                System.out.println("Enter the amount of money to deposit");
                amount = scanner.nextDouble();
                balance = bank.addMoneyToAccount(user, amount);
                System.out.println("Your Balance is: " + balance);
                break;
            case 2:
                System.out.println("Enter the amount you want to withdraw");
                amount = scanner.nextDouble();
                responseATH = bank.withdrawMoney(user, amount);
                balance = user.getSavingsAccount().getBalanceAccount();

                if (responseATH == "") {
                    System.out.println("Insufficient balance.");
                    System.out.println("Your balance is: " + balance);
                } else {
                    System.out.println("Successful transaction... your new balance is: " + responseATH);
                }
                break;
            case 3:
                int account;
                System.out.println("Enter the account number to which you are going to transfer");
                account = scanner.nextInt();
                System.out.println("Please enter the amount to transfer");
                amount = scanner.nextInt();

                User userTo = bank.existAccount(account);

                if (userTo.getUserID() < 0) {
                    System.out.println("Wrong account number, please try again");
                } else {
                    responseATH = bank.transferMoneyToAccount(user, amount, userTo);

                    if (responseATH.isEmpty()) {
                        balance = user.getSavingsAccount().getBalanceAccount();
                        System.out.println("Successful transaction... your new balance is: " + balance);
                    } else {
                        System.out.println(responseATH);
                    }
                }
                break;
            case 4:
                ListUsers(bank.getUsers());
                break;
        }
    }
}
