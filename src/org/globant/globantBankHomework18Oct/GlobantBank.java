import java.util.ArrayList;
import java.util.Objects;

public class GlobantBank {
    //----------                                                     All new users will be here:
    public ArrayList<User> listOfAllUsers;

    //----------                                                     Constructor
    public GlobantBank() {
        this.listOfAllUsers = new ArrayList<User>();
    }

    //----------                                                     Create and send new user
    public User setNewUser(String username, String password) {
        User user = new User(username, password);
        listOfAllUsers.add(user);
        return user;
    }

    public boolean logInAuthentication(String username, String password) {

        for (int i = 0; i < listOfAllUsers.size(); i++) {
            if (Objects.equals(listOfAllUsers.get(i).username, username) && Objects.equals(listOfAllUsers.get(i).password, password)) {
                return true;
            }
        }
        return false;
    }


    public float setDepositMoney(String username, float amount) {
        float userBalance = 0;
        for (int i = 0; i < listOfAllUsers.size(); i++) {
            if (Objects.equals(listOfAllUsers.get(i).username, username)) {
                listOfAllUsers.get(i).savingsAccount.balance = listOfAllUsers.get(i).savingsAccount.depositMoney(amount);
                userBalance = listOfAllUsers.get(i).savingsAccount.getBalance();
                //System.out.println(amount);
                System.out.println(userBalance);
            }
        }
        return userBalance;
    }

    public float setWithdrawMoney(String username, float amount) {
        float userBalance = 0;
        for (int i = 0; i < listOfAllUsers.size(); i++) {
            if (Objects.equals(listOfAllUsers.get(i).username, username)) {
                listOfAllUsers.get(i).savingsAccount.balance = listOfAllUsers.get(i).savingsAccount.withdrawMoney(amount);
                userBalance = listOfAllUsers.get(i).savingsAccount.getBalance();
                //System.out.println(amount);
                System.out.println(userBalance);
            }
        }
        return userBalance;
    }
    //This is for transfers of money to other accounts
    public float setWithdrawMoney(String username, float amount, float tax) {
        float userBalance = 0;
        for (int i = 0; i < listOfAllUsers.size(); i++) {
            if (Objects.equals(listOfAllUsers.get(i).username, username)) {
                listOfAllUsers.get(i).savingsAccount.balance = listOfAllUsers.get(i).savingsAccount.withdrawMoney(amount, tax);
                userBalance = listOfAllUsers.get(i).savingsAccount.getBalance();
                //System.out.println(amount);
                System.out.println(userBalance);
            }
        }
        return userBalance;
    }

        //----------                                                     Return all users information
        public ArrayList<String> getAllUsersInformation () {
            ArrayList<String> allUsersInformation = new ArrayList<String>();

            for (int i = 0; i < listOfAllUsers.size(); i++) {
                allUsersInformation.add("Account Id: " + listOfAllUsers.get(i).savingsAccount.accountId +
                        "  Account Username: " + listOfAllUsers.get(i).username +
                        "  Account Opening Date: " + listOfAllUsers.get(i).savingsAccount.openingDate +
                        "  Account Balance: " + listOfAllUsers.get(i).savingsAccount.balance);
            }
            return allUsersInformation;
        }
    }
