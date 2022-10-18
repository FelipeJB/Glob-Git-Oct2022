public class SavingAccount extends Account{
    private float withdrawTaxFix = 200;
    private float withdrawTaxPerc = 0.15f;
    private float transferTaxFix = 100;
    private float withdrawTaxLim = 1000;
    private User owner;

    public SavingAccount(String accountNumber, float balance){
        super(accountNumber,balance);
    }

    public SavingAccount(String accountNumber, float balance, float withdrawTaxFix, float withdrawTaxPercentage, float transferTaxFix){
        super(accountNumber,balance);
        this.transferTaxFix = transferTaxFix;
        this.withdrawTaxFix = withdrawTaxFix;
        this.withdrawTaxPerc = withdrawTaxPerc;
    }

    public boolean checkFundsTransfer(float amountToRetrieve){
        float totalTax = amountToRetrieve + this.transferTaxFix;
        return this.getBalance() >= totalTax ? true : false;
    }

    public void withdrawBalanceTransfer(float amount){
        this.setBalance(this.getBalance() - amount -this.transferTaxFix);
    }

    private float calcTaxWithdraw(float amount){
        return 0;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return this.owner;
    }

    public boolean checkFundsWithdraw(float amount) {
        float totalWithdraw;
        if(amount >= this.withdrawTaxLim){
            totalWithdraw = amount + withdrawTaxFix + amount*withdrawTaxPerc;
        }else{
            totalWithdraw = amount + withdrawTaxFix;
        }
        return this.getBalance() >= totalWithdraw ? true : false;
    }

    public void withdrawBalance(float amount) {
        float totalWithdraw;
        if(amount >= this.withdrawTaxLim){
            totalWithdraw = amount + withdrawTaxFix + amount*withdrawTaxPerc;
        }else{
            totalWithdraw = amount + withdrawTaxFix;
        }
        this.setBalance(this.getBalance() - totalWithdraw);
    }
}