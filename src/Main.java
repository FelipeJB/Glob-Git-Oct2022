import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GlobantBank bank = new GlobantBank();
        System.out.println("Welcome to the GlobantBank");

        Scanner myScanner = new Scanner(System.in);

        int option;
    //--------------                                             First options in the program
        do {
            System.out.println("***** User options: *****");
            System.out.println("1. Create a new account.");
            System.out.println("2. Log in to your account.");
            System.out.println();
            System.out.println("***** Bank administrator options: *****");
            System.out.println("3. Print all users information");

            option = myScanner.nextInt();
            myScanner.reset();

            switch (option){
                case 1:
                    createNewUser(bank);
                    break;
                case 2:
                    logInToTheUserAccount(bank);
                    break;
                case 3:
                    printAllUsersInformation(bank);
                    break;
                default:
                    System.out.println("Select a correct number");
                    break;
            }
        } while ( option != 5 );
    }

    private static void logInToTheUserAccount(GlobantBank bank) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Write your username: ");
            String username = myScanner.next();
                myScanner.reset();
        System.out.println("Write your password: ");
            String password = myScanner.next();
                myScanner.reset();

        boolean isAuthenticated = bank.logInAuthentication(username, password);

        if (isAuthenticated == false) {
            System.out.println("We couldn't find your account, try to login again.");
            return;
        }

        int option;
        do {
            System.out.println("***** User options: *****");
            System.out.println("1. Deposit money.");
            System.out.println("2. Withdraw money.");
            System.out.println("3. Transfer money to other account.");

            option = myScanner.nextInt();
            myScanner.reset();

            switch (option){
                case 1:
                    depositMoney(bank, username);
                    break;
                case 2:
                    withdrawMoney(bank, username);
                    break;
                case 3:
                    TransferMoneyToOtherAccount(bank, username);
                    break;
                default:
                    System.out.println("Select a correct number");
                    break;
            }
        } while ( option != 4 );

    }

    private static void TransferMoneyToOtherAccount(GlobantBank bank, String username){
        Scanner myScanner = new Scanner(System.in);
            System.out.println("Write the username of the account you want to send the money to: ");
                String usernameToSendTheMoneyTo = myScanner.next();
                    myScanner.reset();
            System.out.println("Write the amount of money to send: ");
                float amount = myScanner.nextInt();
                    myScanner.reset();

        float userBalanceUpdated = bank.setWithdrawMoney(username, amount, 100);
        depositMoney(bank, usernameToSendTheMoneyTo, amount);

        System.out.println(username + " Your new balance is " + userBalanceUpdated);
        System.out.println();

    }

    private static void withdrawMoney(GlobantBank bank, String username){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Write the amount you want to withdraw from your account: ");
        float amount = myScanner.nextFloat();
        myScanner.reset();
        //System.out.println(amount);
        float userBalanceUpdated = bank.setWithdrawMoney(username, amount);

        System.out.println(username + " Your new balance is " + userBalanceUpdated);
        System.out.println();

    }

    private static void depositMoney(GlobantBank bank, String username){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Write the amount you want to deposit to your account: ");
            float amount = myScanner.nextFloat();
                myScanner.reset();
            //System.out.println(amount);
            float userBalanceUpdated = bank.setDepositMoney(username, amount);

            System.out.println(username + " Your new balance is " + userBalanceUpdated);
            System.out.println();

    }
    private static void depositMoney(GlobantBank bank, String username, float amount){

        float userBalanceUpdated = bank.setDepositMoney(username, amount);
        System.out.println();
        System.out.println(" The money was transferred.");
        System.out.println();

    }

    private static void createNewUser(GlobantBank bank){
        Scanner myScanner = new Scanner(System.in);
            System.out.println("Write your username: ");

        String username = myScanner.next();
            myScanner.reset();

            System.out.println("Write your password: ");
        String password = myScanner.next();
            myScanner.reset();

        User user = bank.setNewUser(username, password);
            System.out.println("Hello: " + user.username + "  Log in to start using your account.");
    }
    //--------------                                             Option for bank administrators
    private static void printAllUsersInformation(GlobantBank bank){
        ArrayList<String> usersInformation = bank.getAllUsersInformation();
            System.out.println("These are all the user accounts in this bank.");
            System.out.println();
            System.out.println(usersInformation);
            System.out.println();
    }
}


