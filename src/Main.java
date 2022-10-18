import GlobantBank.Data.Account;
import GlobantBank.Data.Bank;
import GlobantBank.Data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Bank globantBank = new Bank();

        System.out.println("Welcome to the best bank - GLOBANT BANK!");

        int option;

        do{
            System.out.println("*** Please choose the type of user you are ***" +
                    "\n1. Bank Admin" +
                    "\n2. Client" +
                    "\n3. Exit");
            option= sc.nextInt();

            switch (option){
                case 1:
                    bankAdminMenu(globantBank);
                    break;
                case 2:

                    System.out.println("*** Please enter your user ID: ");
                    int userID = sc.nextInt();
                    User locatedUser = globantBank.searchUser(userID);
                    if (locatedUser == null){
                        System.out.println("User not found!");
                    }else {
                        clientMenu(locatedUser);
                    }
                    break;

                case 3:
                    System.out.println("You have exited the program.\n Have a good day!");
                    break;
                default:
                    System.out.println("Please enter a right option");
            }

        }while (option != 3);

    }

    public static void bankAdminMenu (Bank currentBank) {
        Scanner sc= new Scanner(System.in);

        int option;

        do{
            System.out.println("*** Please choose an option ***" +
                    "\n1. Add new User" +
                    "\n2. List users" +
                    "\n3. Back to previous menu");
            option= sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("*** Please enter the following user information *** ");
                    System.out.println("User ID : ");
                    int userID = sc.nextInt();
                    System.out.println("User full name : ");
                    String name = sc.next();
                    System.out.println("User: ");
                    String userName = sc.next();
                    System.out.println("Temporal password : ");
                    String password = sc.next();

                    currentBank.createdUser(userID,name,userName,password);

                    break;
                case 2:
                    System.out.println("**********  Client List  *************");
                    System.out.printf("|%20s|%20s|%20s|%20s|%20s|%20s|%n", "ID", "FULL NAME", "USER", "ACCOUNT NUMBER", "OPENING DATE", "BALANCE");

                    currentBank.showClients();

                    break;
                case 3:
                    System.out.println("This is the previous !!");
                    break;
                default:
                    System.out.println("Please enter a right option");
            }

        }while (option != 3);

    }
    public static void clientMenu (User currentUser) {
        Scanner sc= new Scanner(System.in);
        int option;

        do{
            System.out.println("*** Please choose an option ***" +
                    "\n1. Make a withdraw" +
                    "\n2. Add money" +
                    "\n3. Transfer money to another bank account - press 3" +
                    "\n4. Back to previous menu");
            option= sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter the amount you want to withdraw:");
                    double amountToWithdraw = sc.nextDouble();
                    Boolean successfulTransaction =currentUser.savingAccount.withdrawMoney(amountToWithdraw);
                    if(successfulTransaction){
                        System.out.println("Money has been successfully withdrawn from your account"+
                                "\nYour current balance is: " + currentUser.savingAccount.balance);
                    }else {
                        System.out.println("There is not enough money in your account," +
                                "\nplease validate your balance and try again"+
                                "\nYour current balance is: " + currentUser.savingAccount.balance);
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount you want to add:");
                    double amount = sc.nextDouble();
                    currentUser.savingAccount.addMoney(amount);
                    System.out.println(currentUser);
                    break;
                case 3:
                    System.out.println("Transfer money");
                    break;
                case 4:
                    System.out.println("This is the previous !");
                    break;
                default:
                    System.out.println("Please enter a right option");
            }

        }while (option != 4);

    }
}
