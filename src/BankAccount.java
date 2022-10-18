package src;
import java.time.LocalDate;

public class BankAccount {
    public float accountNumber;
    public LocalDate openingDate;
    public float balance;

    BankAccount(float accountNumber, LocalDate openingDate, float balance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public float getAccountNumber() { return this.accountNumber; }
    public LocalDate getOpeningDate() { return this.openingDate; }
    public float getBalance() {return this.balance; }

    public float depositMoney(float moneyAmount) {
        if (moneyAmount <= 0) {
            System.out.println("Invalid value. Transfer value must be higher than zero.\n");
            return 0;
        } else {
            balance = this.balance + moneyAmount;
            System.out.println("Your deposit is confirmed!\n");
            return balance;
        }
    }

    public float withdrawMoney(float moneyAmount) {
        float tax = 200;
        float taxPlus = (float) ((15.0 / 100) * moneyAmount);
        float lowerLimit1 = this.balance - moneyAmount - tax;
        float lowerLimit2 = lowerLimit1 - taxPlus;
        if (moneyAmount < 1000 && moneyAmount > 0 && lowerLimit1 >= 0) {
            balance = lowerLimit1;
            System.out.println("Your withdraw is confirmed!\n");
            return balance;
        } else if (moneyAmount >= 1000 && lowerLimit2 >= 0){
            balance = lowerLimit1 - taxPlus;
            System.out.println("15% of withdraw amount tax = USD " + taxPlus);
            System.out.println("Your withdraw is confirmed!\n");
            return balance;
        } else if (moneyAmount <= 0){
            System.out.println("Invalid value. Withdraw value must be higher than zero.\n");
            return 0;
        } else {
            System.out.println("Transfer amount plus tax must be higher than balance account.");
            return 0;
        }
    }

    public float transferMoneyOut(float moneyAmount) {
        float tax = 100;
        float lowerLimit = this.balance - moneyAmount - tax;
        if (balance > moneyAmount && lowerLimit >= 0 && moneyAmount != 0) {
            balance = this.balance - moneyAmount - tax;
            System.out.println("Your transfer is confirmed!\n");
            return balance;
        } else if (moneyAmount <= 0){
            System.out.println("Invalid value. Transfer value must be higher than zero.");
            return 0;
        } else {
            System.out.println("Transfer amount plus tax must be higher than balance account.");
            return 0;
        }
    }
}
