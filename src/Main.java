package src;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import java.time.LocalDate;
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
                        MorganStanley.clientInformation();
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
                                System.out.println("Invalid option. Insert a number between 1 and 5\n");
                            } else if (option >= 1 && option <= 5) {
                                switch (option) {
                                    case 1:
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        break;
                                    case 2:
                                        System.out.println("Important notice:");
                                        System.out.println("Adding money to the account does not have any cost.");
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        System.out.println("Insert deposit amount (USD)");
                                        float moneyAmount = myScanner.nextFloat();
                                        myScanner = new Scanner(System.in);
                                        MorganStanley.Ana.anaAccount.depositMoney(moneyAmount);
                                        System.out.println("Your deposit is confirmed!\n");
                                        System.out.println("Current Balance: USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        break;
                                    case 3:
                                        System.out.println("Important notice:");
                                        System.out.println("Withdrawals tax is USD 200 for amounts less than USD 1000.");
                                        System.out.println("Withdrawals of USD 1000 or more, withdrawals tax is USD 200 plus 15% of the amount to withdraw.");
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        System.out.println("Insert withdraw amount (USD)");
                                        float moneyAmountW = myScanner.nextFloat();
                                        myScanner = new Scanner(System.in);
                                        if (moneyAmountW > MorganStanley.Ana.anaAccount.balance) {
                                            System.out.println("Withdraw amount cannot be higher than balance account.\n");
                                            System.out.println("Current Balance: USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        } else {
                                            MorganStanley.Ana.anaAccount.withdrawMoney(moneyAmountW);
                                            System.out.println("Your withdraw is confirmed!\n");
                                            System.out.println("Current Balance: USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Important notice:");
                                        System.out.println("Transferring money to another account tax is USD 100.");
                                        System.out.println("Your current balance is USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        System.out.println("Insert transfer amount (USD)");
                                        float moneyAmountTransfer = myScanner.nextFloat();
                                        myScanner = new Scanner(System.in);
                                        MorganStanley.Ana.anaAccount.transferMoneyOut(moneyAmountTransfer);
                                        MorganStanley.Maria.mariaAccount.depositMoney(moneyAmountTransfer);
                                        System.out.println("Your transfer is confirmed!\n");
                                        System.out.println("Current Balance: USD " + MorganStanley.Ana.anaAccount.getBalance() + ".\n");
                                        break;
                                    case 5:
                                        System.out.println("Have a great day!\n");
                                        break;
                                }
                            }
                        } while (option != 5);
                        break;
                    case 3:
                        System.out.println("Have a great day!\n");
                        break;
                }
            }
        } while (bankAuth != 3);
    }
}
