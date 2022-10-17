import java.util.ArrayList;

public class Bank {
    public ArrayList<Client> clientsList;

    public Bank(ArrayList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public StringBuilder listedClients(){
        StringBuilder list = new StringBuilder();
        for (Client client : clientsList) {
            list.append(client);
        }
        return list;
    }
}
