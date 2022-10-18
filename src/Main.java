import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our market");
        //Setting bank
        Bank bank = new Bank("Globant");

        Scanner myScanner = new Scanner(System.in);


        int option;
        do {
            System.out.println("\nSelect the option you want");
            System.out.println(" 1. Add a client");
            System.out.println(" 2. Show clients");
            System.out.println(" 3. Transfer money");
            System.out.println(" 4. Withdraw money");
            System.out.println(" 5. Add money");
            System.out.println(" 6. Exit");

            option = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (option < 1 || option > 6) {
                System.out.println("Option not available, select another one from 1 to 3.");
            } else if (option == 1) {
                System.out.println("Write the username");
                String username = String.valueOf(myScanner.nextLine());
                System.out.println("Write the password");
                String password = String.valueOf(myScanner.nextLine());
                System.out.println("Write the opening fee");
                float money = myScanner.nextFloat();
                System.out.println(bank.addClient(username, password, money));
            } else if (option == 2) {
                bank.showClients();
            } else if (option == 3) {
                System.out.println("Write the number account from");
                int originAccount = myScanner.nextInt();
                System.out.println("Write the number account to transfer");
                int targetAccount = myScanner.nextInt();
                System.out.println("Write the amount to transfer");
                float money = myScanner.nextFloat();
                System.out.println(bank.transferMoney(originAccount, targetAccount, money));
            } else if (option == 4) {
                System.out.println("Write the number account");
                int account = myScanner.nextInt();
                System.out.println("Write the amount to withdraw");
                float money = myScanner.nextFloat();
                System.out.println(bank.withdrawMoney(account, money));
            } else if (option == 5) {
                System.out.println("Write the number account");
                int account = myScanner.nextInt();
                System.out.println("Write the amount to add");
                float money = myScanner.nextFloat();
                System.out.println(bank.addMoney(account, money));
            }
        } while (option != 6);
    }
}