package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank globantBank = new Bank("Globant Bank");
        System.out.println("Welcome to " + globantBank.getName());
        Scanner myScanner = new Scanner(System.in);
        int bankAuth;
        do {
            System.out.println("Select your profile");
            System.out.println("    1. Administrator");
            System.out.println("    2. Client");
            System.out.println("    3. Exit");
            bankAuth = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (bankAuth < 1 || bankAuth > 3 ) {
                System.out.println("Invalid option. Insert a number between 1 and 3\n");
            } else if (bankAuth >= 1 && bankAuth <= 3) {
                switch (bankAuth) {
                    case 1:
                        globantBank.bankUserLogin();
                        globantBank.clientInformation();
                        break;
                    case 2:
                        globantBank.clientUserLogin();
                        int option;
                        do {
                            System.out.println("Select your option");
                            System.out.println("    1. Check current balance");
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
                                        System.out.println("Your current balance is USD " + globantBank.Ana.anaAccount.getBalance() + ".\n");
                                        break;
                                    case 2:
                                        globantBank.userDeposit();
                                        break;
                                    case 3:
                                        globantBank.userWithdraw();
                                        break;
                                    case 4:
                                        globantBank.userTransfer();
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