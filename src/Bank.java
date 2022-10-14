package src;

import java.util.ArrayList;

public class Bank {
    public String bankName;
    public ArrayList<Client> myClients;

    public void addClient(Client client) {
        myClients.add(client);
    }
    public ArrayList<Client> getClients()  {
        for (int i = 0; i < myClients.size(); i++) {
            System.out.println(myClients.get(i));
        }
        return myClients;
    }
    public Bank(String bankName){
        this.bankName = bankName;
        myClients = new ArrayList<Client>();
    }
}
