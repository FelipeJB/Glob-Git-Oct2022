import java.time.LocalDate;

public class Account {
    //variables nativas
    public int numberAccount;
    public double balance;
    public LocalDate opening;


    //constructor
    public Account() {
        this.numberAccount = (int)(Math.random()*10000);
        this.balance = 0;
        this.opening = LocalDate.now();
    }

    //metodos
    public double addMoney(double money){
        balance = balance += money;
        return balance;
    }

    public double withdrawMoney(double money){
        double withTax;
        if (money < 1000) { withTax = balance -= money + 200; }
        else { withTax = balance -= (money * 15/100) + 200; }
        System.out.println("Your withdraw plus the taxes is: $" + withTax);

        if(balance < money) {
            System.out.println("There aren't enough funds");
        } else { balance = balance -= withTax; }
        return balance;
    }

    public double transferMoney(double money){
        double Tax = money + 100;
        if(balance >= Tax){ balance = balance -= Tax;}
        return balance;
    }
}
