import java.util.ArrayList;

public class Bank {

    public ArrayList<Client> clientsList;
    public ArrayList<Account> accountsList;

    public Bank(ArrayList<Client> clientsList, ArrayList<Account> accountsList) {
        this.clientsList = clientsList;
        this.accountsList = accountsList;
    }

    public StringBuilder listedClients(){
        StringBuilder list = new StringBuilder();
        for (Client client : clientsList) {
            list.append(client);
        }
        return list;
    }

    public StringBuilder listedAccounts(){
        StringBuilder list = new StringBuilder();
        for (Account account : accountsList) {
            list.append(account);
        }
        return list;
    }

    public String transferMoney(Account accountOne, Account accountTwo, float amount){
        if (accountOne.retrieveMoney(amount)){
            accountTwo.addMoney(amount);
            return "transaction is successful";
        }else {
            return "You do not have enough money on your account";
        }
    }
}
