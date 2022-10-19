import java.util.ArrayList;

public class Bank {

    private ArrayList<Client> clients = new ArrayList<Client>();

    public Bank(){
        Client client0 = new Client(5000, "Emilio", 2011);
        Client client1 = new Client(6000, "Rivas", 2012);
        Client client2 = new Client(8000, "Elsy", 2013);
        Client client3 = new Client(500, "Jordan", 2014);
        Client client4 = new Client(4500, "Lazo", 2015);
        Client client5 = new Client(5000, "Fabricio", 2016);

        clients.add(client0);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
    }

    public ArrayList<Client> getClients() {
        return this.clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "clients=" + clients +
                '}';
    }

    public void transferMoney(int clientAccount, int transferAccount, double amount){
        Account initAccount = null;
        Account targetAccount = null;
        for (int i = 0; i < clients.size(); i++){
            if(clientAccount == clients.get(i).getSavingsAccount().getAccountNumber()){
                initAccount = clients.get(i).getSavingsAccount();
                for (int j = 0; j < clients.size(); j++){
                    if (transferAccount == clients.get(j).getSavingsAccount().getAccountNumber()){
                        targetAccount = clients.get(j).getSavingsAccount();
                        initAccount.withdraw(amount);
                        targetAccount.deposit(amount);
                    }
                }
            }

        }

        double tax = 0;
        if(amount <= 1000){
            tax = 200;
        } else {
            tax = 200 + (0.15 * amount);
        }
        tax = tax + 100;
        initAccount.withdraw(tax);
    }




}
