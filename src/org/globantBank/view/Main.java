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
                    displayClientView(loggedClient, myBank);
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

    public static void displayClientView(Client client, Bank myBank){
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("Hi " + client.getUser() + "\n");
            System.out.println("Please select an option \n");
            System.out.println("1. Get balance ");
            System.out.println("2. Deposit money ");
            System.out.println("3. Withdraw money ");
            System.out.println("4. Transfer money ");
            System.out.println("5. Exit ");
            option = scan.nextInt();

            switch (option){
                case 1:
                    Account accToCheck = client.getSavingsAccount();
                    System.out.println("Your current balance is " + accToCheck.getBalance());
                    break;

                case 2:

                    System.out.println("How much do you want to deposit? ");
                    float depositAmount = scan.nextFloat();
                    Account depositAccount = client.getSavingsAccount();
                    if (depositAccount.depositMoney(depositAmount) > 0) {
                        System.out.println("Deposit successful " + client.getUser() + "\n" + "Your new balance is: $ " + depositAccount.getBalance() + "\n");
                        scan = new Scanner(System.in);
                    } else {
                        System.out.println("Deposit failed, please enter a valid amount" + "\n");
                    }
                    break;

                case 3:
                    System.out.println("How much do you want to Withdraw? ");
                    float withdrawAmount = scan.nextFloat();
                    Account withdrawAccount = client.getSavingsAccount();
                    if (withdrawAccount.withdrawMoney(withdrawAmount) == 0){
                        System.out.println("You can't withdraw more than you have. Remember that the transaction has taxes!");
                        break;
                    };
                    System.out.println("Withdrawal successful " + client.getUser() + "\n" + "Your new balance is: $ " + withdrawAccount.getBalance() + "\n");
                    scan = new Scanner(System.in);
                    break;
                case 4:
                    System.out.println("How much do you want to Transfer?");
                    float transferAmount = scan.nextFloat();
                    System.out.println("Please enter savings account number: ");
                    //Account for test 4002
                    int transferAccount = scan.nextInt();
                    Account clientToTransfer = myBank.clientTotransfer(transferAccount);
                    Account transferFromAccount = client.getSavingsAccount();
                    if (transferFromAccount.transferMoney(transferAmount) == 0){
                        System.out.println("You can't transfer more than you have. Remember that the transaction has taxes!");
                        break;
                    }
                    clientToTransfer.depositMoney(transferAmount);
                    System.out.println("Transfer successful " + client.getUser() + "\n" + "Your new balance is: $ " + transferFromAccount.getBalance() + "\n");
                    scan = new Scanner(System.in);
                    break;
                case 5:
                    break;

            }


        } while (option < 5);
    }
}

