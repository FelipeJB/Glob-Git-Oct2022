package org.globant.GlobantBankData;

import java.util.ArrayList;
import java.util.List;

public class BankDataBase {

    private List<SavingsAccount> allAccounts = new ArrayList<>();
    private List<User> allUsers = new ArrayList<>();

    public BankDataBase(SavingsAccount newAccount, User newUser){

        this.allAccounts.add(newAccount);
        this.allUsers.add(newUser);

    }

    public void addNewEntry(SavingsAccount newAccount, User newUser){

        this.allAccounts.add(newAccount);
        this.allUsers.add(newUser);

    }

    public int deleteEntry(int index){
        if (index + 1 > allAccounts.size() && index < 0){
            return 1;
        } else {
            allUsers.remove(index);
            allAccounts.remove(index);
            return 0;
        }
    }
}
