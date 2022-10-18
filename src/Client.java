public class Client extends Account{

    //variables nativas
    public String name;
    public String password;
    float initialAccount;

    //constructores
    public Client(int numberAccount, float balance, String opening, String name, String password) {
        super(numberAccount, balance, opening);
        this.name = name;
        this.password = password;
    }

    //metodos

    public float addMoney(float money){
        balance = initialAccount += money;
        return balance;
    }

    public float withdrawMoney(float money){
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
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberAccount(){
        return numberAccount;
    }

    public float getBalance(){
        return balance;
    }

    public String getDate(){
        return opening;
    }

}
