import java.util.ArrayList;

/**
 * THE ONLY PURPOSE of this class is to hold the bank name and more importantly:
 * HOLD THE LIST OF CLIENTS
 *
 * if that can't be done then this class should be deleted.
 */

public class Bank {
    private String bankName;
    private static ArrayList<Client> clients = new ArrayList<>(); // User list

    // Getters
    public static ArrayList<Client> getClients(){
        return clients;
    }

    //Setters
    public void setClients(Client client){
        clients.add(client); // This one is not being currently used, because it adds to the existing ArrayList
    }

    public Bank(){
        Client client1 = new Client("Christian Martinez", "0123456789");
        Client client2 = new Client("Felipe Rivas", "0123456789");
        Client client3 = new Client("Carolina Colorado", "0123456789");
        Client client4 = new Client("Felipe Jimenez", "0123456789");
        Client client5 = new Client("Jarold Hakins", "0123456789");
        Client client6 = new Client("Sindy Piedrahita", "0123456789");

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
    }
}
