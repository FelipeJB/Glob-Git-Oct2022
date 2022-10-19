package src;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.BankAccount.allAccounts;

public class Bank {

    public String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    public static List<Client> allClients = new ArrayList<>();
    public static List<Client> getAllClients() { return allClients; }

    public static List<BankAccount> allBankAccounts = new ArrayList<>();
    public static List<BankAccount> getAllBankAccounts() { return allBankAccounts; }


    Administrator BankAdmin = new Administrator("Globant Bank", "admin", "Bank");
    Client Ana = new Client(123, "Ana Buvinghausen", "Ana", "Ken");
    Client Maria = new Client(456, "Maria Bautista", "Maria", "Isaac");


    // allAccounts.add(Ana.anaAccount);


    public void clientInformation(){
        int optionBank;
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
                        allClients.add(Ana);
                        allClients.add(Maria);
                        allBankAccounts.add(Ana.anaAccount);
                        allBankAccounts.add(Maria.mariaAccount);
                        List<Client> clients = getAllClients();
                        List<BankAccount> bankAccounts = getAllBankAccounts();
                        System.out.println("User \t Account Number \t Opening Date \t Balance (USD)");
                        for (int i= 0; i < clients.size(); i++){
                            Client currentClient = clients.get(i);
                            BankAccount currentBankAccount = bankAccounts.get(i);
                            System.out.print(currentClient.getUser() + "\t");
                            System.out.print("\t\t" + currentClient.getAccountNumber() + "\t");
                            System.out.print("\t\t" + currentBankAccount.getOpeningDate() + "\t");
                            System.out.print("\t\t" + currentBankAccount.getBalance() + "\n");
                        }
                        System.out.println(" ");
                        System.out.println("End of list of users\n");
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
            if (tempUser.equals(BankAdmin.getUser()) && tempPassword.equals(BankAdmin.getPassword())) {
                System.out.println("Authentication Successful.\n");
                System.out.println("Welcome " + BankAdmin.getName() + ".\n");
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
                System.out.println("Welcome " + Ana.getName() + ".\n");
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
        Ana.anaAccount.depositMoney(moneyAmount);
        System.out.println("Your deposit is confirmed!\n");
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
        if (moneyAmountW > Ana.anaAccount.getBalance()) {
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
