package org.globant.GlobantBankData;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static int counter = 1;

    private String userName;
    private String password;
    private int id;
    private SavingsAccount account;

    public User(String userName, String password, float balance) {
        this.userName = userName;
        this.password = password;
        this.account = new SavingsAccount(balance);

        this.id = counter;
        counter++;


    }

}
