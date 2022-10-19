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

    public String withdraw(double amount){
        if(amount <= this.balance){
            this.balance -= amount;
            String message = "Successful withdrawal, This is your balance now: " + this.balance;
            return message;
        }
        else {
            String message = "Your balance is insufficient";
            return message;
        }
    }

    public String deposit(double amount){
        this.balance += amount;
        String message = "Successful consignment, This is your balance now: " + this.balance;
        return message;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }


}