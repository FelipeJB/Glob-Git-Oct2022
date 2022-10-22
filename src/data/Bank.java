package src.data;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Client> clientList;

    public void addClient(Client client) {
        clientList.add(client);
    }
    public ArrayList<Client> getClients()  {
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i));
        }
        return clientList;
    }
    public Bank(String bankName){
        this.name = bankName;
        clientList = new ArrayList<Client>();
    }
}
