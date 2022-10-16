package org.globant.GlobantBankData;

import java.util.ArrayList;
import java.util.List;

public class BankDataBase {

    private static List<SavingsAccount> allAccounts = new ArrayList<>();
    private static List<User> allUsers = new ArrayList<>();

    // ------------- CONSTRUCTOR -------------
//
//    public BankDataBase(SavingsAccount newAccount, User newUser){
//
//        allAccounts.add(newAccount);
//        allUsers.add(newUser);
//
//    }

    // ----------- GETTERS --------------

    public static List<SavingsAccount> getAllAccounts(){
        return allAccounts;
    }

    public static List<User> getAllUsers(){
        return allUsers;
    }

    // -------------- METHODS -----------------

    public static void addNewEntry(SavingsAccount newAccount, User newUser){

        allAccounts.add(newAccount);
        allUsers.add(newUser);

    }

    public static boolean deleteEntry(int index){
        if (index + 1 > allAccounts.size() && index < 0){
            return false;
        } else {
            allUsers.remove(index - 1);
            allAccounts.remove(index - 1);
            return true;
        }
    }

    public static boolean modifyEntryBalance(int index, float amount){

        SavingsAccount updatedAccount = allAccounts.get(index);

        if (updatedAccount.updateBalance(amount)){
            updatedAccount.updateBalance(amount);
            allAccounts.set(index, updatedAccount);
            return true;
        } else {
            return false;
        }

    }
}
