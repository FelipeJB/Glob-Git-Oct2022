import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Bank() {
        var client0 = new Client("José", 1243, 200300);
        var client1 = new Client("Mario", 3452, 900887);
        var client2 = new Client("María", 5467, 456988);
        var client3 = new Client("Lucía", 5678, 500700);
        var client4 = new Client("Juan", 4563, 987543);
        clients.add(client0);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);

    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {

        return clients.toString();
    }

    public void transferMoney(int clientAccount, int transferAccount, double amount){
        Account initAccount = null;
        Account targetAccount = null;
        for(int i = 0; i < clients.size(); i++ ){
            if(clientAccount == clients.get(i).getSavingAccount().getAccountNumber()){
               initAccount = clients.get(i).getSavingAccount();
            }
            if(transferAccount == clients.get(i).getSavingAccount().getAccountNumber()){
               targetAccount = clients.get(i).getSavingAccount();
            }

        }
        initAccount.withdrawMoney(amount);
        targetAccount.addMoney(amount);
        double tax = 0;
        if(amount <= 1000){
            tax = 200;
        } else {
            tax = 200 + (0.15 * amount);
        }
        tax = tax + 100;
        initAccount.withdrawMoney(tax);

    }

}



