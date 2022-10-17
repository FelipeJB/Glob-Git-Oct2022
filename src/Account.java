import java.util.Date;

public class Account {
    public int id;
    public Date openingDate;
    public float balance;
    public static int idCounter;

    public Account(float balance, Date openingDate ) {
        this.id = idCounter;
        idCounter++;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public StringBuilder withdraw(float amount){
        float tax = 200;
        if (amount>1000){
            tax += amount * 15 / 100;
        }

        float totalCost = amount + tax;
        if (totalCost < this.balance){
            return null;
        }
        this.balance -= totalCost;

        StringBuilder receipt = new StringBuilder();
        receipt.append("tax applied: ").append(tax).append("\n");
        receipt.append("withdrawn value: ").append(amount).append("\n");
        receipt.append("New balance account: ").append(this.balance).append("\n");

        return receipt;
    }

    public String addMoney(float amount){
        this.balance += amount;
        return "money added successfully \n Your new balance is: " + this.balance ;
    }

    public Boolean retrieveMoney(float amount){
        if (this.balance < amount){
            return false;
        }
        this.balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "id:" + id +
                " Opening date: " + openingDate +
                " Balance: $" + balance + "\n";
    }
}