package org.globant.model;

import java.util.Date;

public class Account {
    public int id;
    public Date openingDate;
    public float balance;
    public static int idCounter;

    public Account(float balance, Date openingDate ) {
        this.id = idCounter;
        idCounter++;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public String withdraw(float amount){
        if(amount == 0){
            return "The amount can not be 0";
        }
        float tax = 200;
        if (amount>1000){
            tax += (amount * 15 / 100);
        }

        float totalCost = amount + tax;
        if (totalCost > this.balance){
            return "You do not have enough money";
        }
        this.balance -= totalCost;

        return "Tax applied: " + tax + "\n" +
                "Withdrawn value: " + amount + "\n" +
                "New balance account: " + this.balance + "\n";
    }

    public String addMoney(float amount){
        this.balance += amount;
        return "money added successfully \nYour new balance is: $" + this.balance ;
    }

    public Boolean retrieveMoney(float amount){
        if (this.balance < amount){
            return false;
        }
        this.balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "id:" + id +
                " Opening date: " + openingDate +
                " Balance: $" + balance + "\n";
    }
}