package org.globant.GlobantBankData;

import java.util.ArrayList;
import java.util.List;

public class BankDataBase {

    private List<SavingsAccount> allAccounts = new ArrayList<>();
    private List<User> allUsers = new ArrayList<>();

    // ----------- GETTERS --------------

    public List<SavingsAccount> getAllAccounts(){
        return this.allAccounts;
    }

    public List<User> getAllUsers(){
        return this.allUsers;
    }

    // ------------- CONSTRUCTOR -------------

    public BankDataBase(SavingsAccount newAccount, User newUser){

        this.allAccounts.add(newAccount);
        this.allUsers.add(newUser);

    }

    // -------------- METHODS -----------------

    public void addNewEntry(SavingsAccount newAccount, User newUser){

        this.allAccounts.add(newAccount);
        this.allUsers.add(newUser);

    }

    public boolean deleteEntry(int index){
        if (index + 1 > allAccounts.size() && index < 0){
            return false;
        } else {
            allUsers.remove(index);
            allAccounts.remove(index);
            return true;
        }
    }

    public boolean modifyEntryBalance(int index, float amount){

        SavingsAccount updatedAccount = this.allAccounts.get(index);

        if (updatedAccount.updateBalance(amount)){
            updatedAccount.updateBalance(amount);
            this.allAccounts.set(index, updatedAccount);
            return true;
        } else {
            return false;
        }

    }
}
