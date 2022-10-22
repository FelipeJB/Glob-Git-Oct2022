package src.org.globantBank.view;

import src.org.globantBank.data.Admin;
import src.org.globantBank.data.Bank;
import src.org.globantBank.data.Client;
import src.org.globantBank.persistence.DataInitializer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank myBank = DataInitializer.loadBank();
        Scanner scan = new Scanner(System.in);
        boolean isAuthValid = false;

        do {
            System.out.println("Welcome to " + myBank.getName() + "");
            System.out.println("Please enter your Username: ");
            String user = scan.next();
            scan = new Scanner(System.in);
            System.out.println("Please enter your Password: ");
            String password = scan.next();
            scan = new Scanner(System.in);

            Admin loggedAdmin = myBank.isAdmin(user, password);
            if (loggedAdmin.getUser() != null){
                displayAdminView();
                isAuthValid = true;
            } else {
                Client loggedClient = myBank.isClient(user, password);
                if (loggedClient.getUser()!= null){
                    displayClientView();
                    isAuthValid = true;
                } else {
                    System.out.println("User not found! \n");
                }
            }
        } while (!isAuthValid);

    }

    public static void displayAdminView(){
        System.out.println("Soy Admin");
    }

    public static void displayClientView(){
        System.out.println("Soy cliente");
    }
}
