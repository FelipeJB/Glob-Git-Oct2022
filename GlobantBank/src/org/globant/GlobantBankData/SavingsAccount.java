package org.globant.GlobantBankData;

import java.time.LocalDate;

public class SavingsAccount {

    public static int counter = 1332;

    private int accountNumber;
    private float balance;
    private LocalDate creationDate;

    // ----------- GETTERS --------------



    public SavingsAccount(float balance){

        int randomNumber = (int) (Math.random() * (19 - 10 + 1) + 10);

        this.balance = balance;
        this.creationDate = LocalDate.now();
        this.accountNumber = counter + randomNumber;
        counter = counter + randomNumber;

    }

    public int updateBalance(float amount){
        if (this.balance + amount < 0){
            return 1;
        } else {
            this.balance = this.balance + amount;
            return 0;
        }
    }

}
