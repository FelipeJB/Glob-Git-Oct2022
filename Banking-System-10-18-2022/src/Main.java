import java.util.ArrayList;

/**
 * Banking system that:
 * 1. Many users, so it needs an option to print all users
 * 2. Each client has an account, user, and password
 * 3. Each account has an account number, opening date, and a balance
 * 4. User should be able to make a withdrawl, add money, transfer money to another bank account
 * 5. Transactions are TAXED (Check image for reference).
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> users = new ArrayList<>();

        Client ChristianMartinez = new Client();
        users.add(ChristianMartinez);

        ChristianMartinez.setUserName("Christian Martinez");
        System.out.println(users.get(0).getUserName()); // This works, so we can iterate over the users and find if exists

        System.out.println(ChristianMartinez.getUserName());
        ChristianMartinez.setPassword("eeee1234567890");
        System.out.println(ChristianMartinez.getPassword());
        ChristianMartinez.setAccountNumber(1234513133690L);
        System.out.println(ChristianMartinez.getAccountNumber());
        ChristianMartinez.setAccountOpeningDate();
        System.out.println(ChristianMartinez.getAccountOpeningDate());
        ChristianMartinez.setAccountBalance(200.0f);
        System.out.println(ChristianMartinez.getAccountBalance());

        // Testing Methods
        ChristianMartinez.addMoney(10f);
        System.out.println(ChristianMartinez.getAccountBalance());
        ChristianMartinez.withdrawMoney(5f);
        System.out.println(ChristianMartinez.getAccountBalance());

        //Adding another client

    }
}
