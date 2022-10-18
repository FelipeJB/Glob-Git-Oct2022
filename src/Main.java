import org.globant.bank.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setting the input
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        byte action;
        byte internalOptions;
        do {
            System.out.println("Welcome to Bank-App!");
            System.out.println("Do you have an account?\n 1. Log in\n 2. Create an account\n 3. List of our clients\n 0. Exit");
            action = input.nextByte();
            switch (action) {
                case 1:
                    System.out.println("Enter your user name: ");
                    String userName = input.next();
                    System.out.println("Enter your password: ");
                    String password = input.next();
                    if (bank.clientsValidator(userName, password)) {
                        do {
                            System.out.println("Welcome!" + " What do you want to do today?\n 1. Add money\n 2. Retrieve money\n 3. Transfer money\n 0. Exit");
                            internalOptions = input.nextByte();
                            switch (internalOptions) {
                                case 1:
                                    System.out.println("Enter the amount to save: ");
                                    double amountToSave = input.nextDouble();
                                    bank.addMoney(amountToSave);
                                    break;
                                case 2:
                                    System.out.println("Enter the amount to retrieve?");
                                    double amountToRetrieve = input.nextDouble();
                                    bank.withdrawMoney(amountToRetrieve);
                                    break;
                                case 3:
                                    System.out.println("How much money do you want to transfer?");
                                    double amountToTransfer = input.nextDouble();
                                    System.out.println("Enter the account number to whom you want to send the money");
                                    double accountToTransfer = input.nextDouble();
                                    bank.transferMoney(accountToTransfer, amountToTransfer);
                                    break;
                            }
                        } while (internalOptions != 0);
                    } else {
                        System.out.println("You don´t have an account yet, press option 2 to create an account.\n");
                    }
                    break;
                case 2:
                    bank.clientCreator();
                    break;
                case 3:
                    bank.getClientsLists();
            }
        } while(action != 0);
    }
}