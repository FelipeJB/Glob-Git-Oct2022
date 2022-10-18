import java.util.ArrayList;
import java.util.List;

public class Bank extends Client{
    //variables nativas
    float initialAccount = 0;


    public Bank(int numberAccount, float balance, String opening, String name, String password) {
        super(numberAccount, balance, opening, name, password);
    }

    //metodos
    /*public float addMoney(float money){
        balance = initialAccount += money;
        return balance;
    }*/

    /*public float withdrawMoney(float money){
        if(balance > money){
            balance = initialAccount -= money;
        } else if (money < 1000) {
            balance = initialAccount -= money + 200;
        } else if (money > 1000) {
            balance = initialAccount -= money * 15/100 + 200;
        } else if (balance < money) {
            System.out.println("There aren't enough funds");
        }
        return balance;
    }*/

    /*public float transferMoney(Account numberAccount, Account balance,float money){
        if(numberAccount == numberAccount){

        }
    }*/
}

