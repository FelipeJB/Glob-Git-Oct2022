public class account {
    public int id;
    public String openingDate;
    public Double balance;
    public int idCounter;

    public account(int number, String openingDate, Double balance) {
        this.id = number;
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

    public String addMoney(){

        return null;
    }

    public String transferMoney(){

        return null;
    }
}
