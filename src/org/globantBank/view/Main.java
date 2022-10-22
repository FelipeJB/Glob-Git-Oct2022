package src.org.globantBank.view;

import src.org.globantBank.data.Account;
import src.org.globantBank.data.Admin;
import src.org.globantBank.data.Bank;
import src.org.globantBank.data.Client;
import src.org.globantBank.persistence.DataInitializer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank myBank = DataInitializer.loadBank();
        Scanner scan = new Scanner(System.in);
        boolean isAuthValid = false;

        do {
            System.out.println("Welcome to " + myBank.getName() + "");
            System.out.println("Please enter your Username: ");
            String user = scan.next();
            scan = new Scanner(System.in);
            System.out.println("Please enter your Password: ");
            String password = scan.next();
            scan = new Scanner(System.in);

            Admin loggedAdmin = myBank.isAdmin(user, password);
            if (loggedAdmin.getUser() != null){
                displayAdminView(loggedAdmin);
            } else {
                Client loggedClient = myBank.isClient(user, password);
                if (loggedClient.getUser()!= null){
                    displayClientView(loggedClient);
                } else {
                    System.out.println("User not found! \n");
                }
            }
        } while (!isAuthValid);

    }

    public static void displayAdminView(Admin admin) {
        Scanner scan = new Scanner(System.in);
        int option;

        do {

            System.out.println("Hi " + admin.getUser() + "\n");
            System.out.println("Please select an option \n");
            System.out.println("1. List clients");
            System.out.println("2. Exit");
            option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("List clients");
                    break;
                case 2:

                    break;
            }


        } while (option < 2);

    }

    public static void displayClientView(Client client){
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("Hi " + client.getUser() + "\n");
            System.out.println("Please select an option \n");
            System.out.println("1. Withdraw money ");
            System.out.println("2. Deposit money ");
            System.out.println("3. Transfer money ");
            System.out.println("4. Exit ");
            option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("How much do you want to Withdraw? ");
                    float withdrawAmmount = scan.nextFloat();
                    Account withdrawAccount = client.getSavingsAccount();
                    withdrawAccount.withdrawMoney(withdrawAmmount);
                    System.out.println("Withdrawal successful " + client.getUser() + "\n" + "Your new balance is: $ " + withdrawAccount.getBalance() + "\n");
                    scan = new Scanner(System.in);
                    break;
                case 2:
                    System.out.println("How much do you want to deposit? ");
                    float depositAmmount = scan.nextFloat();
                    Account depositAccount = client.getSavingsAccount();
                    depositAccount.depositMoney(depositAmmount);
                    System.out.println("Deposit successful " + client.getUser() + "\n" + "Your new balance is: $ " + depositAccount.getBalance() + "\n");
                    scan = new Scanner(System.in);
                    break;
                case 3:
                    System.out.println("Transfer money");
                    break;
                case 4:
                    break;

            }


        } while (option < 4);
    }
}

