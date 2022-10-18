import java.time.LocalDate;

public class Account {
    private int accountNumber;
    private LocalDate openingDate;
    private double balanceAccount;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.openingDate = LocalDate.now();
        this.balanceAccount = 0;

    }

    public double getBalanceAccount() {
        return balanceAccount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", openingDate=" + openingDate +
                ", balanceAccount=" + balanceAccount +
                '}';
    }
    public void addMoney (double amount){
        balanceAccount = amount + balanceAccount;
        System.out.println("Successful consignment");
        System.out.println("This is your new balance " + " $" + balanceAccount);
    }


    public void withdrawMoney (double amount) {
        if (amount <= balanceAccount) {
            balanceAccount -= amount;
            System.out.println("Successful withdrawal");
            System.out.println("This is your new balance " + " $" + balanceAccount);
        }
        else {
            System.out.println("Your balance is insufficient");
        }

    }
}
