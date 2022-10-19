import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Globant Bank");
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        Client actual = new Client();

        int option;
        //Main menu
        do{
            System.out.println("Choose an option:");
            System.out.println("1. Globant Bank Customer");
            System.out.println("2. Bank Admin");
            System.out.println("3. Close the app");
            option = scan.nextInt();

                switch (option){
                    case 1:
                        System.out.println("Entry your clientId");
                        int client = scan.nextInt();
                        Client findClient = bank.findClient(client);
                        if(findClient == null){
                            System.out.println("The client doesn't exist");
                        } else {
                            // Client menu
                            do{
                                System.out.println("Welcome " + actual.getName());
                                System.out.println("Choose an option: ");
                                System.out.println("1. Add money");
                                System.out.println("2. Withdraw money");
                                System.out.println("3. Make a transfer");
                                System.out.println("4. Back");
                                option = scan.nextInt();


                                switch (option){
                                    case 1:
                                        System.out.println("Type the amount you want to add:");
                                        double money = scan.nextDouble();
                                        actual.savingAccount.addMoney(money);
                                        System.out.println("Your new account status is: $" + actual.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Type the amount you want to retrieve:");
                                        money = scan.nextDouble();
                                        actual.savingAccount.withdrawMoney(money);
                                        System.out.println("Your new account status is: $" + actual.getBalance());
                                        break;
                                    case 3:
                                        System.out.println("Type the amount you want to transfer:");
                                        money = scan.nextDouble();
                                        actual.savingAccount.transferMoney(money);
                                        System.out.println("Your current account status is: $" + actual.getBalance());
                                        break;
                                    case 4:
                                        System.out.println("Back to the previous menu");
                                        break;
                                    default:
                                        System.out.println("***You must choose a valid option***");
                                }
                            } while(option != 4);
                        }
                        break;
                    case 2:
                        // Admin menu
                        do{
                            System.out.println("Welcome admin, please choose an option");
                            System.out.println("1. Get a list of all the clients");
                            System.out.println("2. Add a new client");
                            System.out.println("3. Back");
                            option = scan.nextInt();

                                switch (option){
                                     case 1:
                                         System.out.println("------------ Client List ------------");
                                         bank.getClients();
                                         break;
                                     case 2:
                                         System.out.println("Please complete the next information");
                                         System.out.println("Type the client's ID: ");
                                         int id = scan.nextInt();
                                         System.out.println("Type the client's full legal name: ");
                                         String name = scan.next();
                                         System.out.println("Provide an temporal password: ");
                                         String passwd = scan.next();
                                         bank.createClient(id, name, passwd );
                                         break;
                                     case 3:
                                        System.out.println("Back to the previous menu");
                                        break;
                                     default:
                                        System.out.println("***You must choose a valid option***");
                            }
                        } while(option != 3);
                        break;

                    case 3:
                        System.out.println("Thanks for use our app, have a nice day!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("***You must choose a valid option***");
                }
        } while(option != 3);
    }
}
