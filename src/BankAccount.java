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
        return moneyAmount;
    }

    public float withdrawMoney(float moneyAmount) {
        if (balance > moneyAmount) {
            balance = this.balance - moneyAmount;
            return 0;
        } else {
            return balance;
        }
    }
    public float transferMoneyOut(float moneyAmount) {
        float taxPlus = (float) ((15.0 / 100) * moneyAmount);
        if (moneyAmount < 1000 && moneyAmount > 0) {
            balance = this.balance - moneyAmount - 200;
        } else if (moneyAmount >= 1000 ){
            balance = this.balance - moneyAmount - 200 - taxPlus;
        }
        return balance;
    }
}
