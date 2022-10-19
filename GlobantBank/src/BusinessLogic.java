import java.util.Scanner;

public class BusinessLogic {
    // Methods
    // Opening
    public static void openingMessage(){
            System.out.println("Welcome to Globant Bank :)");
    }

    // Choose user
    public static int choosingUser(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("What's your name? Please choose from the following options:");
        System.out.println("1. Christian Martinez");
        System.out.println("2. Felipe Rivas");
        System.out.println("3. Carolina Colorado");
        System.out.println("4. Felipe Jimenez");
        System.out.println("5. Jarold Hakins");
        System.out.println("6. Sindy Piedrahita");

        String userPick = myObj.nextLine();

        if (userPick.equals("1") || userPick.equals("2") || userPick.equals("3") || userPick.equals("4") || userPick.equals("5") || userPick.equals("6")){
        } else {
            System.out.println("Not Valid. Please type the correct number");
            System.exit(1);
        }

        int numericChoice = Integer.parseInt(userPick);
        System.out.println("You have Selected: " + numericChoice);
        return numericChoice;
    }

    public static void accountOperations(int numericChoice) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Which of the following operation do you what to perform:");
        System.out.println("1. Know your account balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Add Money");
        System.out.println("4. Transfer Money");

        String userPick = myObj.nextLine();
        int accountChoice = Integer.parseInt(userPick);

        if (accountChoice == 1) {
            // Client.AccountMethod
        } else if (accountChoice == 2) {
            // Client.AccountMethod
        } else if (accountChoice == 3) {
            // Client.AccountMethod
        } else if (accountChoice == 4) {
            // Client.AccountMethod
        } else {
            System.out.println("Not Valid. Please type the correct number");
            System.exit(1);
        }
    }
}
