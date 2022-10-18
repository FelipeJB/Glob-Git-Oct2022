import org.globant.bank.Account;
import org.globant.bank.Bank;
import org.globant.bank.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client loggedClient ;
        Scanner input = new Scanner(System.in);

        bank.createUser("oscar", "1234");
//        client = bank.validateUser("oscar", "1234");
//        System.out.println(client);

        int option = 0;
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

                    System.out.println(bank.createUser(userName, password));
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

                    if(loggedClient != null){
                        System.out.println("User not found\n");
                    } else {
                        System.out.println("\nWelcome " + userName + " to Globant Bank\n\n\n" +
                                "  1. Deposit money\n" +
                                "  2. Withdraw money\n" +
                                "  3. Transfer money\n" +
                                "  4. Exit \n");
                        option = input.nextInt();
                        input = new Scanner(System.in);

                        switch(option){
                            case 1:
                                System.out.println(loggedClient);
                                break;
                        }

                        do{
                            switch(option){
                                case 1:
                                    System.out.println("Enter amount to deposit");
                                    double amount = input.nextDouble();
                                    input = new Scanner(System.in);
                                    bank.depositTransaction(1000, loggedClient.savingsAccount);
                                    break;
                            }
                        }while(option !=4);

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
//
    }
}
