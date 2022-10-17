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
                        MorganStanley.bankUserLogin();
                        MorganStanley.clientInformation();
                        break;
                    case 2:
                        MorganStanley.clientUserLogin();
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
                                        MorganStanley.userDeposit();
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
                                        MorganStanley.userTransfer();
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
