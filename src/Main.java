package src;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank("Morgan Stanley");
        System.out.println("Welcome to " + myBank.getName());
        // System.out.println(myBank.Ana.myBankAccount.getOpeningDate());
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter user name");
        myBank.Ana.user = myScanner.nextLine();
        myScanner = new Scanner(System.in);
        System.out.println("Enter password");
        myBank.Ana.password = myScanner.nextLine();
        myScanner = new Scanner(System.in);
        System.out.println("Welcome " + myBank.Ana.getUser());

        int option;
        do {
            System.out.println("Select your option");
            System.out.println("    1. Deposit");
            System.out.println("    2. Withdraw");
            System.out.println("    3. Transfer");
            System.out.println("    4. Exit");
            option = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (option < 1 || option > 4) {
                System.out.println("Invalid option. Insert a number between 1 and 3\n");
            } else if (option >= 1 && option <= 4) {
                switch (option) {
                    case 1:
                        System.out.println("Insert deposit amount (USD)");
                        float moneyAmount = myScanner.nextFloat();
                        myScanner = new Scanner(System.in);
                        myBank.Ana.myBankAccount.depositMoney(moneyAmount);
                        System.out.println("Current Balance: USD " + myBank.Ana.myBankAccount.getBalance());
                        break;
                }

            }

        } while (option !=4 );


    }
}
