package org.bank;

import org.bank.model.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selectedOption = 0;

        Bank bank = new Bank("Globank");
        createInitialAccounts(bank);
        String message = "";

        System.out.println(" «« Welcome to " + bank.getBankName()  + " »» ");

        do {
            System.out.println("\n Choose one option : \n" +
                    " 1. Bank's collaborator \n" +
                    " 2. Customer \n" +
                    " 3. Exit \n");
            selectedOption = scan.nextInt();

            if (selectedOption != 3) {
                switch (selectedOption) {
                    case 1:
                        System.out.println("******** Collaborator's section ********\t");
                        int selectedByCollaborator = loginForCollaborator();
                        if (selectedByCollaborator > 3 && selectedByCollaborator < 6) {
                            if (selectedByCollaborator == 4) {
                                message = triggerAddCustomer(bank);
                                System.out.println(">>>>>>>> " + message + " <<<<<<<< \n");
                                System.out.println(comingBackMessage());
                            }
                            if (selectedByCollaborator == 5) {
                                System.out.println("OPEN ACCOUNTS: \n");
                                for (User customer : bank.getBankCustomers()) {
                                    System.out.println(customer + "\n");
                                }
                                System.out.println(comingBackMessage());
                            }
                        } else {
                            System.out.println(comingBackMessage());
                        }
                        break;
                    case 2:
                        System.out.println("******** Customer's section ********\t");
                        break;
                    default:
                        System.out.println("-------- Incorrect option --------\t");
                        break;
                }
            }
        } while (selectedOption != 3);
    }

    private static void createInitialAccounts(Bank bank) {
        Account newAccount = new Account(new Date(), 1465.0);
        User newUser = new User("lili", "abc", newAccount);
        bank.addCustomer(newUser);
        Account newAccount1 = new Account(new Date(), 500.0);
        User newUser1 = new User("pepe", "abc", newAccount1);
        bank.addCustomer(newUser1);
    }

    private static String comingBackMessage() {
        return ">>>>>>>> Coming back to principal menu <<<<<<<<";
    }

    private static int loginForCollaborator() {
        System.out.println("Type your password");
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        if (password.equals("globant")) {
            return showCollaboratorOptions();
        }
        System.out.println("\n Try again \n");
        return 0;
    }

    private static int showCollaboratorOptions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Options for collaborator : \n" +
                " 4. Open new account \n" +
                " 5. Customers information \n" +
                " 6. Go back \n");
        return scan.nextInt();
    }

    private static String triggerAddCustomer(Bank bank) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type username");
            String username = scan.nextLine();

            System.out.println("Type password");
            String password = scan.nextLine();

            System.out.println("Type initial balance");
            Double accountBalance = scan.nextDouble();

            Account newAccount = new Account(new Date(), accountBalance);
            User newUser = new User(username, password, newAccount);

            bank.addCustomer(newUser);

            return "Successful creation";
        } catch (java.util.InputMismatchException e) {
            return "Failed creation";
        }
    }
}
