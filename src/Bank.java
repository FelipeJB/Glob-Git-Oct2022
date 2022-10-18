package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Bank {

    public String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    Client BankMs = new Client(111, "Morgan Stanley", "admin", "Bank");
    Client Ana = new Client(123, "Ana Gonzalez", "Ana", "Ken");
    Client Maria = new Client(456, "Maria Bautista", "Maria", "Isaac");

    public void clientInformation(){
        int optionBank = 0;
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("Select your option");
            System.out.println("    1. Print list of clients");
            System.out.println("    2. Exit");
            optionBank = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (optionBank < 1 || optionBank > 2) {
                System.out.println("Invalid option. Insert a number between 1 and 2\n");
            } else if (optionBank >= 1 && optionBank <= 2) {
                switch (optionBank) {
                    case 1:
                        System.out.println("List of clients:\n");
                        String anaUser = Ana.getName();
                        float anaAccountNumber = Ana.anaAccount.getAccountNumber();
                        LocalDate anaOpeningDate = Ana.anaAccount.getOpeningDate();
                        float anaBalance = Ana.anaAccount.getBalance();
                        System.out.println("Client name: " + anaUser + " |" + " Account number: " + anaAccountNumber + " |" + " Opening date: "+ anaOpeningDate + " |" + " Balance: USD" + anaBalance + ".\n");
                        String mariaUser = Maria.getName();
                        float mariaAccountNumber = Maria.mariaAccount.getAccountNumber();
                        LocalDate mariaOpeningDate = Maria.mariaAccount.getOpeningDate();
                        float mariaBalance = Maria.mariaAccount.getBalance();
                        System.out.println("Client name: " + mariaUser + " | " + " Account number: " + mariaAccountNumber + " |" + " Opening date: " + mariaOpeningDate + " |" + " Balance: USD" + mariaBalance + ".\n");
                        break;
                    case 2:
                        System.out.println("Have a great day!\n");
                        break;
                }
            }
        } while (optionBank != 2);
    }

    public void bankUserLogin() {
        int authenticationBank = 0;
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("Enter user name");
            String tempUser = myScanner.nextLine();
            myScanner = new Scanner(System.in);
            System.out.println("Enter password");
            String tempPassword = myScanner.nextLine();
            myScanner = new Scanner(System.in);
            if (tempUser.equals(BankMs.getUser()) && tempPassword.equals(BankMs.getPassword())) {
                System.out.println("Authentication Successful.\n");
                System.out.println("Welcome " + BankMs.getUser() + ".\n");
                authenticationBank = 1;
            } else {
                System.out.println(("User name / Password not matching. Try again.\n"));
            }
        } while (authenticationBank == 0);
    }

    public void clientUserLogin() {
        int authentication = 0;
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("Enter user name");
            String tempUser = myScanner.nextLine();
            myScanner = new Scanner(System.in);
            System.out.println("Enter password");
            String tempPassword = myScanner.nextLine();
            myScanner = new Scanner(System.in);
            if (tempUser.equals(Ana.getUser()) && tempPassword.equals(Ana.getPassword())) {
                System.out.println("Authentication Successful.\n");
                System.out.println("Welcome " + Ana.getUser() + ".\n");
                authentication = 1;
            } else {
                System.out.println(("User name / Password not matching. Try again.\n"));
            }
        } while (authentication == 0);
    }

    public void userDeposit(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Important notice:");
        System.out.println("Adding money to the account does not have any cost.");
        System.out.println("Your current balance is USD " + Ana.anaAccount.getBalance() + ".\n");
        System.out.println("Insert deposit amount (USD)");
        float moneyAmount = myScanner.nextFloat();
        // myScanner = new Scanner(System.in);
        Ana.anaAccount.depositMoney(moneyAmount);
        System.out.println("Current Balance: USD " + Ana.anaAccount.getBalance() + ".\n");
    }

    public void userWithdraw() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Important notice:");
        System.out.println("Withdrawals tax is USD 200 for amounts less than USD 1000.");
        System.out.println("Withdrawals of USD 1000 or more, withdrawals tax is USD 200 plus 15% of the amount to withdraw.");
        System.out.println("Your current balance is USD " + Ana.anaAccount.getBalance() + ".\n");
        System.out.println("Insert withdraw amount (USD)");
        float moneyAmountW = myScanner.nextFloat();
        // myScanner = new Scanner(System.in);
        if (moneyAmountW > Ana.anaAccount.balance) {
            System.out.println("Withdraw amount cannot be higher than balance account.\n");
            System.out.println("Current Balance: USD " + Ana.anaAccount.getBalance() + ".\n");
        } else {
            Ana.anaAccount.withdrawMoney(moneyAmountW);
            System.out.println("Current Balance: USD " + Ana.anaAccount.getBalance() + ".\n");
        }
    }

    public void userTransfer() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Important notice:");
        System.out.println("Transferring money to another account generates a tax of USD 100.");
        System.out.println("Your current balance is USD " + Ana.anaAccount.getBalance() + ".\n");
        System.out.println("Insert transfer amount (USD)");
        float moneyAmountTransfer = myScanner.nextFloat();
        // myScanner = new Scanner(System.in);
        float transfer = Ana.anaAccount.transferMoneyOut(moneyAmountTransfer);
        if (transfer != 0) {
            Maria.mariaAccount.depositMoney(moneyAmountTransfer);
            System.out.println("Current Balance: USD " + Ana.anaAccount.getBalance() + ".\n");
        } else {
            System.out.println("Transfer cannot be completed.\n");
            System.out.println("Current Balance: USD " + Ana.anaAccount.getBalance() + ".\n");
        }
    }




}
