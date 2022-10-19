package org.globant.globantBankData;

import java.util.ArrayList;
import java.util.List;

public class Bank {

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

    public static boolean deleteEntry(int id){
        for (int i = 0; i < getAllAccounts().size(); i++) {
            if (allUsers.get(i).getId() == id) {
                allUsers.remove(i);
                allAccounts.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean modifyEntryBalance(int index, float amount){
        SavingsAccount updatedAccount = allAccounts.get(index);

        if (updatedAccount.updateBalance(amount)){
            allAccounts.set(index, updatedAccount);
            return true;
        } else {
            return false;
        }
    }

    public static int findAccountIndex(int accountNumber){
        for (int i = 0; i < allAccounts.size(); i++){
            if (allAccounts.get(i).getAccountNumber() == accountNumber){
                return i;
            }
        }
        return -1;
    }
}
