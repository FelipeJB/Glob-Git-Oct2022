import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Globant Bank");

        Scanner scan = new Scanner(System.in);
        int option;
        do{
            System.out.println("Choose an option:");
            System.out.println("1. Get information of all the clients");
            System.out.println("2. Create your account");
            System.out.println("3. Close the app");
            option = scan.nextInt();
            if(option < 1 || option > 3){
                System.out.println("***You must choose a valid option***");
            } else {
                switch (option){
                    case 1:
                        for(int i = 0; i < list.size(); i++){
                            System.out.println("Name: " +  list.get(i).getName());
                            System.out.println("Password: " + list.get(i).getPassword());
                            System.out.println("Number Account: " + list.get(i).getNumberAccount());
                            System.out.println("Balance: " + list.get(i).getBalance());
                            System.out.println("Date: " + list.get(i).getDate());
                            System.out.println("-----------------------------------");
                        }
                        break;
                    case 2:
                        scan = new Scanner(System.in);
                        System.out.println("Create your account: ");
                        System.out.println("Insert your name:");
                        String name = scan.nextLine();
                        System.out.println("Insert your password: ");
                        String password = scan.nextLine();
                        Client client;
                        list.add(client = new Client(1002,0,"2022/10/28",name,password));
                        int optionMenu;
                        do{
                            System.out.println("1. Add money into your account");
                            System.out.println("2. Withdraw money to your account");
                            System.out.println("3. Transfer money to another account");
                            System.out.println("4. Close the app");
                            optionMenu = scan.nextInt();
                            scan = new Scanner(System.in);
                            if(optionMenu < 1 || optionMenu > 4){
                                System.out.println("***You must choose a valid option");
                            } else {
                                switch (optionMenu){
                                    case 1:
                                        System.out.println("Add your money: ");
                                        int amount = scan.nextInt();
                                        Account.addMoney(amount);
                                        System.out.println("Your new balance status is: $" + client.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Withdraw your funds: ");
                                        amount = scan.nextInt();
                                        client.withdrawMoney(amount);
                                        System.out.println("Your new balance status is: $" + client.getBalance());
                                        break;
                                    case 3:
                                        System.out.println("Transfer your funds: ");
                                        break;
                                    case 4:
                                        System.out.println("Thanks for use our app, have a nice day!");
                                        System.exit(0);
                                        break;
                                }
                            }
                        } while(optionMenu != 4);
                    case 3:
                        System.out.println("Thanks for use our app, have a nice day!");
                        System.exit(0);
                        break;
                }
            }
        } while(option != 3);
    }
}
