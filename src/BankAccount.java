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
        balance = this.balance + moneyAmount;
        return balance;
    }

    public float withdrawMoney(float moneyAmount) {
        float taxPlus = (float) ((15.0 / 100) * moneyAmount);
        float discount = 200 - taxPlus;
        if (moneyAmount < 1000 && moneyAmount > 0) {
            balance = this.balance - moneyAmount - 200;
        } else if (moneyAmount >= 1000 ){
            balance = this.balance - moneyAmount - discount;
        }
        return balance;
        }

    public float transferMoneyOut(float moneyAmount) {
        float lowerLimit = this.balance - moneyAmount - 100;
        if (balance > moneyAmount && lowerLimit >= 0) {
            balance = this.balance - moneyAmount - 100;
            System.out.println("Your transfer is confirmed!\n");
            return balance;
        } else {
            System.out.println("Transfer amount plus tax must be higher than balance account.");
            return 0;
        }
    }
}
