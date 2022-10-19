import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private long accountNumber;
    private String accountOpeningDate;
    private float accountBalance;


    // Getters
    public long getAccountNumber(){
        return this.accountNumber;
    }

    public String getAccountOpeningDate(){
        return this.accountOpeningDate;
    }

    public float getAccountBalance(){
        return this.accountBalance;
    }


    // Setters
    public void setAccountNumber(long newAccountNumber){
        // Generating a random Account number
        this.accountNumber = 10000000 + new Random().nextInt(90000000); // TEST THIS
    }

    public void setAccountOpeningDate(){
        // Setting up the creating date as a string
        this.accountOpeningDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public void setAccountBalance(float newAccountBalance){
        this.accountBalance = newAccountBalance;
    }


    // Methods:
    // Add money
    public void addMoney(float moneyToAdd){
        // Test adding negative numbers
        this.setAccountBalance(this.getAccountBalance() + moneyToAdd);
    }

    // Withdraw money
    public void withdrawMoney(float moneyToWithdraw){
        // Check if the money is available
        if (this.getAccountBalance() >= moneyToWithdraw) {

            // Setting taxes
            if (moneyToWithdraw <= 1000.f) {
                this.setAccountBalance(this.getAccountBalance() - (moneyToWithdraw + 200.f));
            } else {
                this.setAccountBalance(this.getAccountBalance() - (moneyToWithdraw + 200.f + (moneyToWithdraw * 0.15f)));
            }

            System.out.println("Money withdrew: " + moneyToWithdraw);
            System.out.println("Current account balance: " + this.getAccountBalance());
        } else {
            System.out.println("Error: the amount selected its not available");
            System.exit(1);
        }
    }

    // Transfer money
    public void transferMoney(long accountNumber, long moneyToTransfer){
        // Checking the money is available
        if (this.getAccountBalance() >= moneyToTransfer) {
            this.setAccountBalance(this.getAccountBalance() - (moneyToTransfer + 100.f)); // 100.f tax

            // Add the money to the target account

            System.out.println("Money transferred: " + moneyToTransfer);
            System.out.println("Current account balance: " + this.getAccountBalance());
        } else {
            System.out.println("Error: the amount selected its not available");
            System.exit(1);
        }
    }
}
