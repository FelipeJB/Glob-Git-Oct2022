import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bank = new Bank();
        System.out.println("Hi! Welcome to Globant Bank");
        System.out.println("Please enter your username");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.println("Please enter your password");
        int password = scan.nextInt();
        Client loginUser = null;
        for (int i = 0; i < bank.getClients().size(); i++){
            if (user.equals(bank.getClients().get(i).getUser()) && password == bank.getClients().get(i).getPassword()){
               loginUser = bank.getClients().get(i);
            }
        }
        if (loginUser == null){
            System.out.println("Your data doesn´t mach, please try again");
        } else {
            System.out.println("Hi " + user + "! " + " You´ve entered correctly");
            var userOption = 0;
            while (userOption != 5) {
                System.out.println("This is the menu options");
                System.out.println("1 To add money in your account");
                System.out.println("2 To withdraw money in your account");
                System.out.println("3 To transfer money to others account");
                System.out.println("4 To print a client list");
                System.out.println("5 To logout");
                userOption = scan.nextInt();
                if (userOption == 1) {
                    System.out.println("What amount do you want to add?");
                    var moneyAdd = scan.nextDouble();
                    loginUser.getSavingAccount().addMoney(moneyAdd);
                } else if (userOption == 2) {
                    System.out.println("What amount do you want to withdraw?");
                    var moneyRetrieve = scan.nextDouble();
                    loginUser.getSavingAccount().withdrawMoney(moneyRetrieve);
                } else if (userOption == 3) {
                    System.out.println("Please enter your target account");
                    var targetAccount = scan.nextInt();
                    System.out.println("What amount do you want to transfer?");
                    var moneyTransfer = scan.nextDouble();
                    bank.transferMoney(loginUser.getSavingAccount().getAccountNumber(), targetAccount, moneyTransfer);
                    System.out.println("Your transfer has been successful");
                } else if (userOption == 4 ) {
                    bank.toString();
                    System.out.println("Clients List " + bank.toString());
                } else if (userOption == 5) {
                    System.out.println("Your logout has been success");
                }
            }


        }


    }

}