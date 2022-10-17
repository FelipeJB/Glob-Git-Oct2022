package taeacademy.globantbank.data;

import java.time.LocalDate;

public class Account {

    int accountNumber;
    LocalDate openingDate = LocalDate.now();
    float accountBalance = 0;

    Account(int number){
        this.accountNumber = number;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public LocalDate getOpeningDate(){
        return this.openingDate;
    }

    public float getAccountBalance(){
        return this.accountBalance;
    }

    public void setAccountBalance(float balance){ this.accountBalance = balance;}
}