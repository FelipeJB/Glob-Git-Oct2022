import org.globant.GlobantBankLogic.BankAdminSession;
import org.globant.GlobantBankLogic.BankUserSession;
import org.globant.GlobantBankLogic.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean iterator = true;

        System.out.println("*******************************");
        System.out.println("***** WELCOME TO GLOBANK ******");
        System.out.println("*******************************");
        System.out.println(" ");

        while(iterator){

            int option;

            System.out.println("Please choose an option:");
            System.out.println(" 1. Access Account  |  2. Admin Access  |  3. Exit");

            option = Reader.intScanner();

            if (option > 0 && option < 4){
                if (option == 1){
                    System.out.println("coming soon");
                } else if (option == 2) {

                    boolean adminIterator = true;

                    while (adminIterator){

                        int attempt;
                        BankAdminSession adminSession = new BankAdminSession();
                        System.out.println("Please enter the Admin Password:");

                        attempt = Reader.intScanner();

                        adminSession.setAuthentication(attempt);
                        
                        if (adminSession.getAttempt() > 2){
                            System.out.println("Too many incorrect attempts");
                            System.out.println(" ");
                            adminSession.setAttempt(0);
                            adminIterator = false;
                        }


                        while(adminIterator && adminSession.getAuthentication()){
                            
                            int adminOption;

                            System.out.println(" ");
                            System.out.println("Please choose an option:");
                            System.out.println(" 1. Create an user  |  2. Delete an user  |  3. List all users  |  4. Exit Admin panel");
                            
                            adminOption = Reader.intScanner();
                            
                            if (adminOption > 0 && adminOption < 5){
                                if (adminOption == 1) {
                                    String userName;
                                    int password;
                                    float balance;

                                    System.out.println("Please type in the user name to create:");
                                    userName = Reader.StringScanner();;
                                    System.out.println("Please have the user type in a password:");
                                    password = Reader.intScanner();
                                    System.out.println("Please type in the user's account balance:");
                                    balance = Reader.floatScanner();
                                    
                                    adminSession.createUser(userName, password, balance);
                                    System.out.println("User: " + userName + " created.");
                                    
                                } else if (adminOption == 2) {
                                    int id;

                                    System.out.println("Please enter the user id of the user you wish to delete:");
                                    id = Reader.intScanner();
                                    
                                    if (adminSession.deleteUser(id)){
                                        adminSession.deleteUser(id);
                                        System.out.println("User deleted successfully.");
                                    } else {
                                        System.out.println("User not found.");
                                    }
                                } else if (adminOption == 3) {
                                    adminSession.listAllUsers();
                                } else {
                                    System.out.println("Going back to Main Menu.");
                                    adminIterator = false;
                                }
                            }
                            
                        }

                    }


                } else {
                    System.out.println("Good Bye!");
                    iterator = false;
                }
            }
        }

    }
}