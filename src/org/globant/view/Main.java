package org.globant.view;

import org.globant.model.Account;
import org.globant.controller.Bank;
import org.globant.model.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank( new ArrayList<>());

        bank.addInitialClients();

        boolean runMenu = true;
        while (runMenu){
            System.out.println("Select an option!" +
                    "\n 1. Login" +
                    "\n 2. Create account" +
                    "\n 3. See all clients" +
                    "\n 4. Exit");
            int option = input.nextInt();
            input = new Scanner(System.in);

            switch (option) {
                case 1:
                    System.out.println("Enter the account id");
                    int checkAccountId = input.nextInt();
                    input = new Scanner(System.in);

                    System.out.println("Enter your name");
                    String checkUserName = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("Enter your password");
                    String checkPassword = input.nextLine();
                    input = new Scanner(System.in);

                    Client chosenClient = bank.searchClient(checkAccountId);

                    if (!chosenClient.validateLogin(checkUserName,checkPassword)){
                        System.out.println("Some fields are not correct");
                        break;
                    }

                    boolean runSubMenu = true;
                    while (runSubMenu){
                        System.out.println("\n" + chosenClient.userName +
                                " Select an option!" +
                                "\n 1. Withdraw" +
                                "\n 2. Add money" +
                                "\n 3. Transfer" +
                                "\n 4. Check account" +
                                "\n 5. Exit");
                        int subMenuOption = input.nextInt();
                        input = new Scanner(System.in);

                        float amount;
                        switch (subMenuOption){
                            case 1:
                                System.out.println("Enter the amount to withdraw");
                                amount = input.nextFloat();
                                input = new Scanner(System.in);

                                System.out.println( chosenClient.account.withdraw(amount) );
                                break;
                            case 2:
                                System.out.println("Enter the amount to add");
                                amount = input.nextFloat();
                                input = new Scanner(System.in);

                                System.out.println( chosenClient.account.addMoney(amount) );
                                break;
                            case 3:
                                System.out.println("Enter the id of the account ");
                                int idToTransfer = input.nextInt();
                                input = new Scanner(System.in);

                                if(idToTransfer == chosenClient.account.id){
                                    System.out.println("You can not select your own account to transfers");
                                    break;
                                }

                                System.out.println("Enter the amount to transfer");
                                amount = input.nextFloat();
                                input = new Scanner(System.in);

                                Account secondAccount = bank.searchClient( idToTransfer ).account;
                                if(secondAccount != null){
                                    System.out.println( bank.transferMoney(chosenClient.account, secondAccount, amount) );
                                }else {
                                    System.out.println("The chosen account does not exist.");
                                }
                                break;
                            case 4:
                                System.out.println( chosenClient.account.toString() );
                                break;
                            case 5:
                                System.out.println("Have a nice day :)");
                                runSubMenu = false;
                                break;
                            default:
                                System.out.println("Incorrect option");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the name");
                    String newUserName = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("Enter the password");
                    String newPassword = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("Enter the amount you want to add");
                    float newAmount = input.nextFloat();
                    input = new Scanner(System.in);

                    System.out.println( bank.addClient(newUserName, newPassword, newAmount) );
                    break;
                case 3:
                    System.out.println( bank.listedClients() );
                    break;
                case 4:
                    System.out.println("Have a nice day :)");
                    runMenu = false;
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        }
    }
}