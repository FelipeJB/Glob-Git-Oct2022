import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Bank -> Client -> Account
 * ----------
 * Class:
 * Methods:
 */

public class Client {
    private String userName;
    private String password;
    private long accountNumber;
    private String accountOpeningDate;
    private float accountBalance;

    // Getters and setters
    // THINK ABOUT HOW TO IMPLEMENT SECURITY
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public void setAccountNumber(long newAccountNumber){
        this.accountNumber = newAccountNumber;
    }

    public String getAccountOpeningDate(){
        return this.accountOpeningDate;
    }

    public void setAccountOpeningDate(){
        this.accountOpeningDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public float getAccountBalance(){
        return this.accountBalance;
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


