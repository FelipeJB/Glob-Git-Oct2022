import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank( new ArrayList<>(), new ArrayList<>() );

        bank.addInitialClients();

        boolean runMenu = true;
        while (runMenu){
            System.out.println("Select an option!" +
                    "\n 1. Login" +
                    "\n 2. Create account" +
                    "\n 4. Exit");
            int option = input.nextInt();
            input = new Scanner(System.in);

            switch (option) {
                case 1:
                    break;
                case 2:
                    System.out.println("Enter the name");
                    String newUserName = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("Enter the password");
                    String newPassword = input.nextLine();
                    input = new Scanner(System.in);

                    System.out.println("Enter the amount you want to add");
                    float newAmount = input.nextFloat();
                    input = new Scanner(System.in);

                    System.out.println( bank.addClient(newUserName, newPassword, newAmount) );
                    break;
                case 3:
                    System.out.println( bank.listedClients() );
                    break;
                case 4:
                    System.out.println("Have a nice day :)");
                    runMenu = false;
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
        }
    }
}