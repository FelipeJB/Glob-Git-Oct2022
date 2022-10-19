import org.globant.bank.Bank;
import org.globant.bank.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client loggedClient ;
        Scanner input = new Scanner(System.in);

        int option;

        do{
            System.out.println("***** WELCOME TO GLOBANT BANK ***** \n"
                    + "  1. Sign in \n"
                    + "  2. Login \n"
                    + "  3. Client list \n"
                    + "  4. Exit");

            option = input.nextInt();
            input = new Scanner(System.in);

            switch(option){
                case 1:
                    System.out.println("*****  CREATE USER  *****\n" +
                            "  > Create user name: " );
                    String userName = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("  > Create user password");
                    String password = input.nextLine();
                    input = new Scanner(System.in);
                    bank.createUser(userName, password);
                    System.out.println("USUARIO CREADO");
                    break;

                case 2:
                    System.out.println("*****  LOGIN  ***** \n" +
                            "  > Write your user name");
                    userName = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("  > Write your password");
                    password = input.nextLine();
                    input = new Scanner(System.in);

                    loggedClient = bank.validateUser(userName, password);

                    if(loggedClient == null){
                        System.out.println("User not found\n");
                    } else {
                        do{
                            System.out.println("\n *** WELCOME TO YOUR ACCOUNT ***\n" +
                                                   "  > " + userName + ", what do you want to do?\n\n" +
                                    "  1. Deposit money\n" +
                                    "  2. Withdraw money\n" +
                                    "  3. Transfer money\n" +
                                    "  4. Balance\n" +
                                    "  5. Back to menu\n" +
                                    "  6. Exit");

                            option = input.nextInt();
                            input = new Scanner(System.in);

                            switch(option){
                                case 1:
                                    System.out.println("******* DEPOSIT MONEY ******* \n" +
                                            " > Enter amount to deposit");
                                    double amountToDeposit = input.nextDouble();
                                    input = new Scanner(System.in);
                                    System.out.println(bank.depositTransaction(amountToDeposit, loggedClient.savingsAccount) + "\n");
                                    break;
                                case 2:
                                    System.out.println("******* WITHDRAW MONEY ******* \n" +
                                            "\n > Enter amount to withdrawn");
                                    int amountToWithdrawn = input.nextInt();
                                    input = new Scanner(System.in);
                                    System.out.println(bank.withdrawTransaction(amountToWithdrawn, loggedClient.savingsAccount));
                                    break;
                                case 3:
                                    System.out.println("******* TRANSFER MONEY ******* \n" +
                                            " \n> Enter amount to be transferred");
                                    int amountToTransfer = input.nextInt();
                                    input = new Scanner(System.in);
                                    System.out.println("***** TRANSFER MONEY ***** \n" +
                                            "  > Enter the account number  ");
                                    int accountNumber = input.nextInt();
                                    input = new Scanner(System.in);
                                    System.out.println(bank.transferTransaction(amountToTransfer, loggedClient.savingsAccount, accountNumber));
                                    break;
                                case 4:
                                    System.out.println(bank.getBalanceAccount(loggedClient.savingsAccount));
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Thank you for using the services of globant bank.");
                                    System.exit(0);
                            }
                        }while(option !=6);
                    }
                    break;
                case 3:
                    System.out.println(bank.getAllClients());
                    break;
                case 4:
                    System.out.println("Thank you for using the services of globant bank.");
                    System.exit(0);
            }
        }while(option != 4);
    }
}
