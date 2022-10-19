

import java.util.ArrayList;
import java.util.Scanner;

    public class Utils {

        public static Bank createDummyData(Bank bank){
            User user1 = new User("Andres", "1020820700");
            User user2 = new User("Felipe", "1020815826");
            User user3 = new User("Theran", "52273182");
            SavingAccount savingAccount1 = new SavingAccount("298837827387330", 0);
            SavingAccount savingAccount2 = new SavingAccount("298837827387331", 400);
            SavingAccount savingAccount3 = new SavingAccount("298837827387332", 300);
            savingAccount1.setOwner(user1);
            savingAccount2.setOwner(user2);
            savingAccount3.setOwner(user3);
            bank.addUser(user1);
            bank.addUser(user2);
            bank.addUser(user3);
            bank.addSavingAccount(savingAccount1);
            bank.addSavingAccount(savingAccount2);
            bank.addSavingAccount(savingAccount3);
            return bank;
        }

        public static String getString(){
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        public static float getFloat(){
            Scanner scanner = new Scanner(System.in);
            return scanner.nextFloat();
        }

        public static int getInteger(){
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }

        public static void printArrayUsers(ArrayList<User> users){
            int count = 0;
            for(User user : users){
                System.out.println(""+ count +" - username: " + user.getUsername());
                count++;
            }
        }

        public static String getLoginOptionsMenu(){
            System.out.println("Hello, we hope you are doing well :)");
            System.out.println("[1] Log in");
            System.out.println("[2] Sign up");
            System.out.println("[3] Exit");
            System.out.print("Please type an option: ");
            return getString();
        }

        public static String getOptionsAdminMenu(String bankName){
            System.out.printf("Hello, welcome to %s :)\n",bankName);
            System.out.println("[1] Create User");
            System.out.println("[2] Create Account");
            System.out.println("[3] List Users");
            System.out.println("[4] List bank accounts");
            System.out.println("[5] Transfer");
            System.out.println("[6] Add money");
            System.out.println("[7] Get money");
            System.out.println("[e] Exit");
            System.out.print("Please type an option: ");
            return getString();
        }

        public static Bank createBankView() {
            String bankName;
            System.out.print("Please enter the name of the bank: ");
            bankName = getString();
            return new Bank(bankName);
        }

        public static User createUserView() {
            String username;
            String password;
            System.out.print("Please enter the username: ");
            username = getString();
            System.out.print("Please enter the password: ");
            password = getString();
            return new User(username,password);
        }
        public static SavingAccount createAccountView() {
            String accountNumber;
            float balance;
            System.out.print("Please enter the account number: ");
            accountNumber = getString();
            System.out.print("Please enter initial balance: ");
            balance = getFloat();
            return new SavingAccount(accountNumber,balance);
        }

        public static User addOwnerToAccountView(ArrayList<User> users) {
            int index;
            System.out.println("Please choice an User to add as owner of the account: ");
            printArrayUsers(users);
            System.out.print("Enter de index of user: ");
            index = getInteger();
            return users.get(index);
        }

        public static void listUsersView(Bank bank) {
            System.out.printf("Users of the bank %s\n",bank.getName());
            printArrayUsers(bank.getUsers());
            System.out.print("Enter any key to go to main menu");
            getString();
        }

        public static void listBankAccountsView(Bank bank) {
            System.out.printf("Accounts of the bank %s\n",bank.getName());
            printArrayAccounts(bank.getAccounts());
            System.out.print("Enter any key to go to main menu");
            getString();
        }

        private static void printArrayAccounts(ArrayList<SavingAccount> savingAccounts) {
            int count = 0;
            for(SavingAccount savingAccount : savingAccounts){
                System.out.printf("%d - Account #: %s\tBalance: %f\tOwner: %s\n",count,savingAccount.getAccountNumber(),
                        savingAccount.getBalance(), savingAccount.getOwner().getUsername());
                count++;
            }
        }

        public static boolean performTransfer(SavingAccount origin, SavingAccount target, float amount){
            if(origin.checkFundsTransfer(amount)){
                origin.withdrawBalanceTransfer(amount);
                target.addMoney(amount);
                return true;
            }
            return false;
        }

        public static void performTransferView(Bank bank) {
            int indexO, indexT;
            float amount;
            boolean isTransferred = false;
            System.out.println("Please choice the origin Account");
            printArrayAccounts(bank.getAccounts());
            System.out.println("Enter the index of the origin account");
            indexO = getInteger();
            System.out.println("Enter the amount to transfer");
            amount = getFloat();
            System.out.println("Please choice the target Account");
            printArrayAccounts(bank.getAccounts());
            System.out.println("Enter the index of the target account");
            indexT = getInteger();
            isTransferred = performTransfer(bank.getAccounts().get(indexO), bank.getAccounts().get(indexT), amount);
            if(isTransferred){
                System.out.println("The transfer has been performed successfully");
            }else{
                System.out.println("The transfer has not been performed successfully, the origin account doesn't have enough funds.");
            }
        }

        public static void performAddMoney(Bank bank) {
            int index;
            float amount;
            try{
                System.out.println("Please choice an Account");
                printArrayAccounts(bank.getAccounts());
                System.out.println("Enter the index of the account");
                index = getInteger();
                System.out.println("Enter the amount to add");
                amount = getFloat();
                bank.getAccounts().get(index).addMoney(amount);
            }catch (Exception e){
                System.out.println("There was an error trying to add money - msn: " + e);
            }
        }

        public static void performGetMoney(Bank bank) {
            int index;
            float amount;
            try{
                System.out.println("Please choice an Account");
                printArrayAccounts(bank.getAccounts());
                System.out.println("Enter the index of the account");
                index = getInteger();
                System.out.println("Enter the amount to retrieve");
                amount = getFloat();
                if(bank.getAccounts().get(index).checkFundsWithdraw(amount)){
                    bank.getAccounts().get(index).withdrawBalance(amount);
                }else {
                    System.out.println("The bank account doesn't have enough funds to perform this operation.");
                }
            }catch (Exception e){
                System.out.println("There was an error trying to add money - msn: " + e);
            }
        }
    }

