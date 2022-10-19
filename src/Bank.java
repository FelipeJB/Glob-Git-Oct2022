import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Client> clientList = new ArrayList<>();

    //metodos
    public void createClient(int clientId, String name, String password){
        Client client = new Client(clientId, name, password);
        clientList.add(client);
    }
    public void getClients(){
        for(int i = 0; i < clientList.size(); i++){
            System.out.println("Name: " +  clientList.get(i).getName());
            System.out.println("Password: " + clientList.get(i).getPassword());
            System.out.println("Number Account: " + clientList.get(i).getNumberAccount());
            System.out.println("Balance: " + clientList.get(i).getBalance());
            System.out.println("Date: " + clientList.get(i).getDate());
            System.out.println("-----------------------------------");
        }
    }
    public Client findAccount(int numberAccount){
        Client accountFounded = null;
        int count = 0;
        while(count < clientList.size() && accountFounded == null){
            Client client = this.clientList.get(count);
            if(client.savingAccount.numberAccount == numberAccount){
                accountFounded = client; 
            }
            count++;
        }
        return accountFounded;
    }
    public Client findClient(int clientId){
        Client clientFounded = null;
        int count = 0;
        while(count < clientList.size() && clientFounded == null){
            Client client = this.clientList.get(count);
            if(client.clientId == clientId){
                clientFounded = client;
            }
            count++;
        }
        return clientFounded;
    }
}

