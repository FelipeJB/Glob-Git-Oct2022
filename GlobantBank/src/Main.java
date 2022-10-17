import org.globant.GlobantBankData.BankDataBase;
import org.globant.GlobantBankData.SavingsAccount;
import org.globant.GlobantBankLogic.BankAdminSession;
import org.globant.GlobantBankLogic.BankUserSession;
import org.globant.GlobantBankLogic.Reader;

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

                    boolean userIterator = true;
                    int attempt = 0;

                    while (userIterator && attempt < 3){

                        String user;
                        int password;

                        System.out.println("Type in your user name:");
                        user = Reader.StringScanner();
                        System.out.println("Type in you password:");
                        password = Reader.intScanner();

                        BankUserSession userSession = new BankUserSession(user, password);

                        if(userSession.getAuthenticationStatus()){
                            System.out.println(userSession.getIndex());
                            SavingsAccount currentUser = BankDataBase.getAllAccounts().get(userSession.getIndex());

                            while(userIterator){
                                int userOption;

                                System.out.println("Welcome " + userSession.getUser() + "!");
                                System.out.println("\tAccount Number\t|\tBalance");
                                System.out.println("\t\t" + currentUser.getAccountNumber() + "\t\t|\t" + currentUser.getBalance());
                                System.out.println(" ");
                                System.out.println("Please choose an option:");
                                System.out.println(" 1. Make a Deposit  |  2. Withdraw  |  3. Transfer Money  |  4. Exit");

                                userOption = Reader.intScanner();

                                if (userOption > 0 && userOption < 5){
                                    if (userOption == 1){
                                        float deposit;

                                        System.out.println("How much do you wish to deposit?");
                                        deposit = Reader.floatScanner();

                                        if (deposit > 0){
                                            userSession.deposit(deposit);
                                            System.out.println("Transaction Completed!");
                                        } else {
                                            System.out.println("Transaction failed: Invalid amount");
                                        }
                                    } else if (userOption == 2) {
                                        float withdraw;

                                        System.out.println("How much do you wish to withdraw?");
                                        withdraw = Reader.floatScanner();

                                        System.out.println(userSession.withdraw(withdraw));
                                    } else if (userOption == 3) {
                                        float transferAmount;
                                        int recipientAccount;

                                        System.out.println("How much do you wish to transfer?");
                                        transferAmount = Reader.floatScanner();
                                        if (transferAmount > 0) {
                                            System.out.println("Please type in the account you wish to transfer funds to:");
                                            recipientAccount = Reader.intScanner();

                                            System.out.println(userSession.transfer(transferAmount, recipientAccount));
                                        } else {
                                            System.out.println("Invalid amount.");
                                        }
                                    } else {
                                        System.out.println("Going back to Main Menu.");
                                        userIterator = false;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid username and/or password");
                            attempt++;
                        }
                    }
                } else if (option == 2) {

                    boolean adminIterator = true;

                    while (adminIterator){

                        int adminAttempt;
                        BankAdminSession adminSession = new BankAdminSession();
                        System.out.println("Please enter the Admin Password:");

                        adminAttempt = Reader.intScanner();

                        adminSession.setAuthentication(adminAttempt);
                        
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