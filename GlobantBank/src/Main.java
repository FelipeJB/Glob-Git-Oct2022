import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Welcome to Globant Bank!");
        System.out.println("Please enter your username");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.println("Please enter your password");
        int password = scan.nextInt();
        Client loginUser = null;
        for(int i = 0; i < bank.getClients().size(); i++){
            if (user.equals(bank.getClients().get(i).getUser()) && password == bank.getClients().get(i).getPassword()){
               loginUser = bank.getClients().get(i);
            }
        }
        if (loginUser == null){
            System.out.println("Your data is not correct, please try again");
        } else {
            System.out.println("Welcome" + user + "!" + "You already sign in correctly");
            int userOption = 0;
            while(userOption != 5){
                System.out.println("Menu options");
                System.out.println("1. To deposit money in your account");
                System.out.println("2. To withdraw money in your account");
                System.out.println("3. To transfer money");
                System.out.println("4. To print the client list");
                System.out.println("5. To logout");
                userOption = scan.nextInt();
                if (userOption == 1){
                    System.out.println("How much do you want to deposit?");
                    double moneyDeposit = scan.nextDouble();
                    loginUser.getSavingsAccount().deposit(moneyDeposit);
                } else if (userOption == 2) {
                    System.out.println("How much do you want to withdraw?");
                    double moneyWithdraw = scan.nextDouble();
                    loginUser.getSavingsAccount().withdraw(moneyWithdraw);
                } else if (userOption == 3) {
                    System.out.println("Please enter your target account");
                    int targetAccount = scan.nextInt();
                    System.out.println("What amount do you want to transfer?");
                    double moneyTransfer = scan.nextDouble();
                    bank.transferMoney(loginUser.getSavingsAccount().getAccountNumber(), targetAccount, moneyTransfer);
                    System.out.println("Your transfer has been successful");
                } else if (userOption == 4) {
                    bank.toString();
                    System.out.println("Clients List" + bank.toString());
                } else if (userOption == 5) {
                    System.out.println("Log out successfully made");
                }
            }
        }
    }
}