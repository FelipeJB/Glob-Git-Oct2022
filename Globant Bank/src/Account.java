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
        System.out.println("Deposito exitoso");
        System.out.println("Este es su nuevo saldo " + " $" + balanceAccount);
    }


    public void withdrawMoney (double amount) {
        if (amount <= balanceAccount) {
            balanceAccount -= amount;
            System.out.println("Retiro exitoso");
            System.out.println("Este es su nuevo saldo " + " $" + balanceAccount);
        }
        else {
            System.out.println("Su saldo es insuficiente");
        }

    }
}
