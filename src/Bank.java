package src;

import java.util.ArrayList;

public class Bank {
    public String bankName;
    public ArrayList<Client> myClients;

    public void addClient(Client client) {
        myClients.add(client);
    }
    public ArrayList<Client> getClients()  {

        return myClients;
    }
    public Bank(String bankName){
        this.bankName = bankName;
        myClients = new ArrayList<Client>();
    }
}
