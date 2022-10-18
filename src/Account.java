import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    //variables nativas
    public int numberAccount;
    public float balance = 0;
    String opening;


    //constructor
    public Account(int numberAccount, float balance, String openingAccount) {
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.opening = openingAccount;
    }
}
