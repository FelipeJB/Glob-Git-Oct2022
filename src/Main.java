package src;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank MorganStanley = new Bank("Morgan Stanley");
        System.out.println("Welcome to " + MorganStanley.getName());
        Scanner myScanner = new Scanner(System.in);
        int bankAuth = 0;
        do {
            System.out.println("Select your option");
            System.out.println("    1. Administrator");
            System.out.println("    2. User");
            System.out.println("    3. Exit");
            bankAuth = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (bankAuth < 1 || bankAuth > 3) {
                System.out.println("Invalid option. Insert a number between 1 and 3\n");
            } else if (bankAuth >= 1 && bankAuth <= 3) {
                switch (bankAuth) {
                    case 1:
                        int authenticationBank = 0;
                        do {
                            System.out.println("Enter user name");
                            String tempUser = myScanner.nextLine();
                            myScanner = new Scanner(System.in);
                            System.out.println("Enter password");
                            String tempPassword = myScanner.nextLine();
                            myScanner = new Scanner(System.in);
                            if (tempUser.equals(MorganStanley.BankMs.getUser()) && tempPassword.equals(MorganStanley.BankMs.getPassword())) {
                                System.out.println("Authentication Successful.\n");
                                System.out.println("Welcome " + MorganStanley.BankMs.getUser() + ".\n");
                                authenticationBank = 1;
                            } else {
                                System.out.println(("User name / Password not matching. Try again.\n"));
                            }
                        } while (authenticationBank == 0);

                        int optionBank = 0;
                        do {
                            System.out.println("Select your option");
                            System.out.println("    1. Print list of users");
                            System.out.println("    2. Exit");
                            optionBank = myScanner.nextInt();
                            myScanner = new Scanner(System.in);
                            if (optionBank < 1 || optionBank > 2) {
                                System.out.println("Invalid option. Insert a number between 1 and 2\n");
                            } else if (optionBank >= 1 && optionBank <= 2) {
                                switch (optionBank) {
                                    case 1:
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.myBankAccount.getBalance() + ".\n");
                                        break;
                                    case 2:
                                        System.out.println("Have a great day!");
                                        break;
                                }
                            }
                        } while (optionBank != 2);
                        break;
                    case 2:
                        int authentication = 0;
                        do {
                            System.out.println("Enter user name");
                            String tempUser = myScanner.nextLine();
                            myScanner = new Scanner(System.in);
                            System.out.println("Enter password");
                            String tempPassword = myScanner.nextLine();
                            myScanner = new Scanner(System.in);
                            if (tempUser.equals(MorganStanley.Ana.getUser()) && tempPassword.equals(MorganStanley.Ana.getPassword())) {
                                System.out.println("Authentication Successful.\n");
                                System.out.println("Welcome " + MorganStanley.Ana.getUser() + ".\n");
                                authentication = 1;
                            } else {
                                System.out.println(("User name / Password not matching. Try again.\n"));
                            }
                        } while (authentication == 0);

                        int option;
                        do {
                            System.out.println("Select your option");
                            System.out.println("    1. Current balance");
                            System.out.println("    2. Deposit");
                            System.out.println("    3. Withdraw");
                            System.out.println("    4. Transfer");
                            System.out.println("    5. Exit");
                            option = myScanner.nextInt();
                            myScanner = new Scanner(System.in);
                            if (option < 1 || option > 5) {
                                System.out.println("Invalid option. Insert a number between 1 and 3\n");
                            } else if (option >= 1 && option <= 5) {
                                switch (option) {
                                    case 1:
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.myBankAccount.getBalance() + ".\n");
                                        break;
                                    case 2:
                                        System.out.println("Insert deposit amount (USD)");
                                        float moneyAmount = myScanner.nextFloat();
                                        myScanner = new Scanner(System.in);
                                        MorganStanley.Ana.myBankAccount.depositMoney(moneyAmount);
                                        System.out.println("Current Balance: USD " + MorganStanley.Ana.myBankAccount.getBalance() + ".\n");
                                        break;
                                    case 3:
                                        System.out.println("Insert withdraw amount (USD)");
                                        float moneyAmountW = myScanner.nextFloat();
                                        myScanner = new Scanner(System.in);
                                        if (moneyAmountW > MorganStanley.Ana.myBankAccount.balance) {
                                            System.out.println("Withdraw amount cannot be higher than balance account.\n");
                                            System.out.println("Current Balance: USD " + MorganStanley.Ana.myBankAccount.getBalance() + ".\n");
                                        } else {
                                            MorganStanley.Ana.myBankAccount.withdrawMoney(moneyAmountW);
                                            System.out.println("Current Balance: USD " + MorganStanley.Ana.myBankAccount.getBalance() + ".\n");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Testing Transfer!");
                                        break;
                                    case 5:
                                        System.out.println("Have a great day!");
                                        break;
                                }
                            }
                        } while (option != 5);

                }
            }
        } while (bankAuth != 3);
    }
}
