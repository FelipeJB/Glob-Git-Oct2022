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

        System.out.println(" «« Welcome to " + bank.getBankName() + " »» ");

        do {
            System.out.println("\n Choose one option : \n" +
                    " 1. Bank's collaborator \n" +
                    " 2. Customer \n" +
                    " 3. Exit \n");

            try{
                String selectedOptionStr = scan.nextLine();
                selectedOption = Integer.parseInt(selectedOptionStr);
            }catch (java.lang.NumberFormatException e) {
                System.out.println("\n Try again \n");
            }

            if (selectedOption != 3) {
                switch (selectedOption) {
                    case 1:
                        System.out.println("******** Collaborator's section ********\t");
                        int selectedByCollaborator = loginForCollaborator();
                        if (selectedByCollaborator > 3 && selectedByCollaborator < 6) {
                            triggerActionSelectedByCollaborator(selectedByCollaborator, bank);
                        } else {
                            System.out.println(comingBackMessage());
                        }
                        break;
                    case 2:
                        System.out.println("******** Customer's section ********\t");
                        User user = loginForCustomer(bank);
                        if (user != null) {
                            int selectedByCustomer = showCustomerOptions();
                            if (selectedByCustomer > 3 && selectedByCustomer < 8) {
                                triggerActionSelectedByCustomer(selectedByCustomer, bank, user);
                            } else {
                                System.out.println(comingBackMessage());
                            }
                        } else {
                            System.out.println("\n Try again \n");
                            System.out.println(comingBackMessage());
                        }
                        break;
                    default:
                        System.out.println("-------- Incorrect option --------\t");
                        break;
                }
            }
        } while (selectedOption != 3);
    }

    private static void createInitialAccounts(Bank bank) {
        Account newAccount = new Account(new Date(), 1500.0);
        User newUser = new User("lilo", "abc", newAccount);
        bank.addCustomer(newUser);
        Account newAccount1 = new Account(new Date(), 500.0);
        User newUser1 = new User("mike", "abc", newAccount1);
        bank.addCustomer(newUser1);
    }

    private static String comingBackMessage() {
        return ">>>>>>>> Coming back to principal menu <<<<<<<<";
    }

    // --------- collaborator section --------- //

    private static int loginForCollaborator() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type your password");
        String password = scan.nextLine();

        if (password.equals("globant")) {
            return showCollaboratorOptions();
        }
        System.out.println("\n Try again \n");
        return 0;
    }

    private static int showCollaboratorOptions() {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("\n Options for collaborator : \n" +
                    " 4. Open new account \n" +
                    " 5. Customers information \n" +
                    " 6. Go back \n");

            String selectedOptionStr = scan.nextLine();
            return Integer.parseInt(selectedOptionStr);
        }catch (java.lang.NumberFormatException e) {
            return 0;
        }
    }

    private static void triggerActionSelectedByCollaborator(int selectedByCollaborator, Bank bank) {
        if (selectedByCollaborator == 4) {
            String message = triggerAddCustomer(bank);
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

    // --------- customer section --------- //
    private static User loginForCustomer(Bank bank) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type username");
        String username = scan.nextLine();

        System.out.println("Type password");
        String password = scan.nextLine();

        for (User customer : bank.getBankCustomers()) {
            if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                return customer;
            }
        }

        return null;
    }

    private static int showCustomerOptions() {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("\n Options for customer : \n" +
                    " 4. Withdraw money \n" +
                    " 5. Deposit money \n" +
                    " 6. Transfer money \n" +
                    " 7. Check my account info \n" +
                    " 8. Go back \n");

            String selectedOptionStr = scan.nextLine();
            return Integer.parseInt(selectedOptionStr);
        }catch (java.lang.NumberFormatException e) {
            return 0;
        }
    }

    private static void triggerActionSelectedByCustomer(int selectedByCustomer, Bank bank, User user) {
        String message = "";

        if (selectedByCustomer == 4) {
            message = triggerWithdrawMoney(user);
            System.out.println(">>>>>>>> " + message + " <<<<<<<< \n");
            System.out.println(comingBackMessage());
        }
        if (selectedByCustomer == 5) {
            message = triggerDepositMoney(user);
            System.out.println(">>>>>>>> " + message + " <<<<<<<< \n");
            System.out.println(comingBackMessage());
        }
        if (selectedByCustomer == 6) {
            message = triggerTransferMoney(bank, user);
            System.out.println(">>>>>>>> " + message + " <<<<<<<< \n");
            System.out.println(comingBackMessage());
        }
        if (selectedByCustomer == 7) {
            System.out.println("My account info: \n");
            System.out.println(user + "\n");
            System.out.println(comingBackMessage());
        }
    }

    private static String triggerWithdrawMoney(User user) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type amount to withdraw");
            Double amountToWithdraw = scan.nextDouble();

            boolean statusWithdraw = user.getSavingsAccount().withdraw(amountToWithdraw);

            if (statusWithdraw) {
                return "Successful withdraw";
            } else {
                return "Failed withdraw check your balance";
            }
        } catch (java.util.InputMismatchException e) {
            return "Failed withdraw";
        }
    }

    private static String triggerDepositMoney(User user) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type amount to deposit");
            Double amountToDeposit = scan.nextDouble();

            boolean statusDeposit = user.getSavingsAccount().deposit(amountToDeposit);

            if (statusDeposit) {
                return "Successful deposit";
            } else {
                return "Failed deposit";
            }
        } catch (java.util.InputMismatchException e) {
            return "Failed deposit";
        }
    }

    private static String triggerTransferMoney(Bank bank, User user) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type account to transfer");
            int accountToTransfer = scan.nextInt();

            System.out.println("Type amount to transfer");
            Double amountToTransfer = scan.nextDouble();

            boolean statusDeposit = false;
            for (User customer : bank.getBankCustomers()) {
                if (accountToTransfer == customer.getSavingsAccount().getAccountNumber() && accountToTransfer != user.getSavingsAccount().getAccountNumber()) {

                    boolean statusTransfer = user.getSavingsAccount().transfer(amountToTransfer);

                    if (statusTransfer) {
                        statusDeposit = customer.getSavingsAccount().deposit(amountToTransfer);
                    }

                    if (statusTransfer && statusDeposit) {
                        return "Successful transfer";
                    } else {
                        return "Failed transfer";
                    }

                }
            }

            return "Failed transfer";
        } catch (java.util.InputMismatchException e) {
            return "Failed transfer";
        }
    }
}
