package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Bank {

    public String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    Client BankMs = new Client(111, "Morgan Stanley", "admin", "Bank");
    Client Ana = new Client(123, "Ana Gonzalez", "Ana", "Ken");
    Client Maria = new Client(456, "Maria Bautista", "Maria", "Isaac");

    public void clientInformation(){
        int optionBank = 0;
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("Select your option");
            System.out.println("    1. Print list of clients");
            System.out.println("    2. Exit");
            optionBank = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (optionBank < 1 || optionBank > 2) {
                System.out.println("Invalid option. Insert a number between 1 and 2\n");
            } else if (optionBank >= 1 && optionBank <= 2) {
                switch (optionBank) {
                    case 1:
                        System.out.println("List of clients:\n");
                        String anaUser = Ana.getName();
                        float anaAccountNumber = Ana.anaAccount.getAccountNumber();
                        LocalDate anaOpeningDate = Ana.anaAccount.getOpeningDate();
                        float anaBalance = Ana.anaAccount.getBalance();
                        System.out.println("Client name: " + anaUser + " |" + " Account number: " + anaAccountNumber + " |" + " Opening date: "+ anaOpeningDate + " |" + " Balance: " + anaBalance + ".\n");
                        String mariaUser = Maria.getName();
                        float mariaAccountNumber = Maria.mariaAccount.getAccountNumber();
                        LocalDate mariaOpeningDate = Maria.mariaAccount.getOpeningDate();
                        float mariaBalance = Maria.mariaAccount.getBalance();
                        System.out.println("Client name: " + mariaUser + " | " + " Account number: " + mariaAccountNumber + " |" + " Opening date: " + mariaOpeningDate + " |" + " Balance: " + mariaBalance + ".\n");
                        break;
                    case 2:
                        System.out.println("Have a great day!\n");
                        break;
                }
            }
        } while (optionBank != 2);
    }




}
