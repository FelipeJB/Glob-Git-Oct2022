import java.util.Date;

public class SavingsAccount {
    public static int accountsIdCounter;
    public int accountId;
    Date openingDate;
    float balance;

    public SavingsAccount() {
        accountsIdCounter = accountId + 1;
        this.accountId = accountsIdCounter;
        this.openingDate = new Date();
        this.balance = 0;
    }
    public float depositMoney(float money){
      return this.balance + money;
    }

    public float withdrawMoney(float money){
            if (money < 1000){
                this.balance = this.balance - (money + 200);
            }
            if (money > 1000){
                float firstTax = money + 200;
                float secondTax = (float) (money * 0.15);
                this.balance = this.balance - (firstTax + secondTax);
            }
        return getBalance();
    }

    public float withdrawMoney(float money, float tax){
        if (tax == 100){
            this.balance = this.balance - (money + 100);
        }
        return getBalance();
    }

    public float getBalance(){
        return this.balance;
    }
}
