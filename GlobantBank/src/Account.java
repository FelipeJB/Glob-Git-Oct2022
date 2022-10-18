import java.time.LocalDate;

public class Account {

    private int accountNumber;

    private double balance;

    private LocalDate openingDate;


    public static int counter = 1;

    public Account(double balance) {

        int numberForAccount;

        this.balance = balance;
        this.openingDate = LocalDate.now();
        this.accountNumber = counter;
        counter++;

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                '}';
    }

    public int withdraw(int amount){
        balance -= amount;
        return amount;
    }

    public int deposit(int amount){
        balance += amount;
        return amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


}