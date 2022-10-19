package org.globant.globantBankData;

import java.time.LocalDate;

public class SavingsAccount {

    public static int counter = 1332;

    private int accountNumber;
    private float balance;
    private LocalDate creationDate;


    // ----------- CONSTRUCTOR -----------------

    public SavingsAccount(float balance){

        int randomNumber = (int) (Math.random() * (19 - 10 + 1) + 10);

        this.balance = balance;
        this.creationDate = LocalDate.now();
        this.accountNumber = counter + randomNumber;
        counter = counter + randomNumber;

    }

    // ----------- GETTERS --------------

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public float getBalance(){
        return this.balance;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    // ------------- METHODS -----------------

    public boolean updateBalance(float amount){
        float balancePlaceHolder;
        boolean result;

        balancePlaceHolder = this.balance;  // -------------- CHECK THIS LATER ---------------
        if (balancePlaceHolder + amount < 0){
            result = false;
        } else {
            this.balance = this.getBalance() + amount;
            result = true;
        }
        return result;
    }

}
