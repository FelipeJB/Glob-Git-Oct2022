package org.globant.GlobantBankLogic;

import org.globant.GlobantBankData.BankDataBase;
import org.globant.GlobantBankData.SavingsAccount;
import org.globant.GlobantBankData.User;

import java.util.List;

public class BankAdminSession {

    private boolean authentication;

    // ------------- CONSTRUCTOR -------------

    public BankAdminSession(String password){
        String pass = "123"; // I know this should be an environment variable

        if (password == pass){
            this.authentication = true;
        } else {
            this.authentication = false;
        }
    }

    // ----------- GETTERS --------------

    public boolean authenticationGetter(){
        return this.authentication;
    }

    // -------------- METHODS -----------------

    public void createUser(String userName, String password, float balance){
        if (this.authentication){
            User newUser = new User(userName, password, balance);
            BankDataBase.addNewEntry(newUser.getAccount(), newUser);
        }
    }

    public boolean deleteUser(int id){
        return BankDataBase.deleteEntry(id);
    }

    public void listAllUsers(){
        System.out.println("  id  |  User Name  |  Account  |  Creation Date  |  Balance");

        List<SavingsAccount> accounts = BankDataBase.getAllAccounts();
        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            SavingsAccount currentAccount = accounts.get(i);

            System.out.print("  " + currentUser.getId() + "  ");
            System.out.print("  " + currentUser.getUserName() + "  ");
            System.out.print("  " + currentUser.getId() + "  ");
            System.out.print("  " + currentAccount.getAccountNumber() + "  ");
            System.out.print("  " + currentAccount.getCreationDate() + "  ");
            System.out.println("  $" + currentAccount.getBalance() + "  ");
        }
    }
}
