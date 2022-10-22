package src.org.globantBank.view;

import src.org.globantBank.data.Bank;
import src.org.globantBank.persistence.DataInitializer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank myBank = DataInitializer.loadBank();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to " + myBank.getName() + "");
        System.out.println("Please enter your Username: ");
        String user = scan.next();
        scan = new Scanner(System.in);
        System.out.println("Please enter your Password: ");
        String password = scan.next();
        scan = new Scanner(System.in);
    }
}
