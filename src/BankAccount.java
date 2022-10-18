import java.util.Date;

public class BankAccount {
    public int accountNumber;
    public static int count = 1000;
    public Date openingDate;
    public float balance;

    public BankAccount(float openingMoney) {
        this.openingDate = new Date();
        this.balance = openingMoney;
        this.accountNumber = count;
        count++;
    }

    ;

    public String addMoney(float amount) {
        this.balance += amount;
        return "The new balance is: " + this.balance;
    }

    ;

    public String withdrawMoney(float amount, boolean isTax) {
        if(isTax){
            if (amount > this.balance) {
                return "Insufficient funds for the transaction. Available money is: " + this.balance;
            }
            this.balance -= amount;
            return "The new balance is: " + this.balance;
        }
        if (amount < 1000){
            if (amount + 200 > this.balance) {
                return "Insufficient funds for the transaction plus $200 tax";
            }
            this.balance -= amount + 200;
            return "The new balance is: " + this.balance;
        }
        if (amount + 200 + 0.15*amount > this.balance) {
            return "Insufficient funds for the transaction plus $200 tax plus 15% tax. Available money is: " + this.balance;
        }
        this.balance -= amount + 200 + 0.15*amount;
        return "The new balance is: " + this.balance;
    }


}
