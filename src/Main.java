import org.taeacademy.globantbank.business.Bank;
import org.taeacademy.globantbank.data.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Bank globantBank = new Bank();
        globantBank.initializeBank();

        int option = -1;
        int option2 = -1;

        while(option != 0){
            option = mainMenu();
            switch(option){
                case 0:
                    break;
                case 1:
                    Client currentUser = login(globantBank.getClientList());
                    while(option2 !=0){
                        option2=userMenu();
                        switch (option2){
                            case 0:
                                option = -1;
                                break;
                            case 1:
                                userDeposit(globantBank, currentUser);
                                break;
                            case 2:
                                userWithdraw(globantBank, currentUser);
                                break;
                            case 3:
                                userTransfer(globantBank, currentUser);
                                break;
                        }
                    }
                    option2=-1;
                    break;
                case 2:
                    printClientList(globantBank.getClientList());
                    break;
            }
        }
    }

    // MAIN METHODS
    public static int mainMenu(){
        int option = -1;
        while(option == -1){
            Scanner scan = new Scanner(System.in);
            System.out.println("WELCOME TO GLOBANT BANK\n");
            System.out.println("Please choose an option to begin");
            System.out.println("[1] Login to your account");
            System.out.println("[2] View client list");
            System.out.println("[0] Exit");
            option = optionValidation(scan,2);
        }
        return option;
    }

    public static int optionValidation(Scanner scan, int options){
        int option = -1;
        if(scan.hasNextInt()){
            option = scan.nextInt();
            if(option > -1 && option <=options){
                return option;
            }
            else{
                System.out.println("\nInvalid option please try again\n");
            }
        }
        else{
            System.out.println("\nInvalid option please try again\n");
        }
        return option;
    }

    public static Client login(ArrayList<Client> clients){
        Client client=null;
        while(client == null){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your user name: ");
            String user = scan.nextLine();
            scan = new Scanner(System.in);
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            for(Client currentClient:clients){
                if(user.equals(currentClient.getUserName()) && pass.equals(currentClient.getPassword())){
                    System.out.println("\nHello " + currentClient.getUserName());
                    System.out.println("Your current balance is: $" + currentClient.getAccount().getAccountBalance());
                    System.out.println("How can we help you today?");
                    client=currentClient;
                    return client;
                }
            }
            System.out.println("\nUser not found or invalid password\n");
        }
        return client;
    }

    public static int userMenu(){
        int option = -1;
        while(option == -1){
            Scanner scan = new Scanner(System.in);
            System.out.println("\n[1] Deposit funds");
            System.out.println("[2] Withdraw funds");
            System.out.println("[3] Transfer funds");
            System.out.println("[0] Logout");
            option = optionValidation(scan,3);
        }
        return option;
    }

    public static void userDeposit(Bank bank, Client user){
        boolean valid = false;
        float amount = 0;
        while(!valid){
            System.out.println("Please enter the amount to deposit: ");
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextFloat()){
                amount = scan.nextFloat();
                valid = true;
            }
            else{
                System.out.println("Invalid amount, please try again");
            }
        }
        bank.depositFunds(user,amount);
        System.out.println("Your new balance is $" + user.getAccount().getAccountBalance());
    }

    public static void userWithdraw(Bank bank, Client user){
        boolean valid = false;
        float amount = 0;
        while(!valid){
            System.out.println("Please enter the amount to withdraw: ");
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextFloat()){
                amount = scan.nextFloat();
                valid = true;
            }
            else{
                System.out.println("Invalid amount, please try again");
            }
        }
        boolean success = bank.withdrawFunds(user, amount);
        if(success){
            System.out.println("Your new balance is $" + user.getAccount().getAccountBalance());
        }
        else{
            System.out.println("Insufficient fuds, transaction declined");
        }
    }

    public static void userTransfer(Bank bank, Client user){
        boolean valid = false;
        float amount = 0;
        while(!valid){
            System.out.println("Please enter the amount to transfer: ");
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextFloat()){
                amount = scan.nextFloat();
                valid = true;
            }
            else{
                System.out.println("Invalid amount, please try again");
            }
        }
        ArrayList<Client> shortList = (ArrayList<Client>) bank.getClientList().clone();
        shortList.remove(user);
        Client destinationUser = selectDestination(shortList);
        boolean success = bank.transferFunds(user, destinationUser, amount);
        if(success){
            System.out.println("Your new balance is $" + user.getAccount().getAccountBalance());
        }
        else{
            System.out.println("Insufficient fuds, transaction declined");
        }
    }

    public static Client selectDestination(ArrayList<Client> clientList){
        System.out.println("MY CONTACTS\n");
        for(int i = 0; i < clientList.size(); i++){
            System.out.println("[" + (i+1) + "] " + clientList.get(i).getUserName());
        }
        System.out.println("\nPlease select destination account\n");
        Scanner scan = new Scanner(System.in);
        return clientList.get(optionValidation(scan,clientList.size())-1);
    }

    public static void printClientList(ArrayList<Client> clientList){
        System.out.println("CLIENT\t\t\t\t\t\tACCOUNT\t\t\tOPENED ON");
        for(Client currentClient: clientList){
            if(currentClient.getUserName().length()>19) {
                System.out.println(currentClient.getUserName() + "\t\t" + currentClient.getAccount().getAccountNumber() + "\t\t\t" + currentClient.getAccount().getOpeningDate());
            }
            else{
                System.out.println(currentClient.getUserName() + "\t\t\t\t" + currentClient.getAccount().getAccountNumber() + "\t\t\t" + currentClient.getAccount().getOpeningDate());
            }
        }
    }
}