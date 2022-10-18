import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Bank {
    public ArrayList<Client> clientsList;
    public ArrayList<Account> accountsList;

    public Bank(ArrayList<Client> clientsList, ArrayList<Account> accountsList) {
        this.clientsList = clientsList;
        this.accountsList = accountsList;
    }

    public String addClient(String userName, String password, float balance ){
        this.clientsList.add(new Client(userName, password, balance));
        return userName + " added successfully";
    }

    public StringBuilder listedClients(){
        StringBuilder list = new StringBuilder("                      Clients\n\n");
        for (Client client : clientsList) {
            list.append(client);
        }
        return list;
    }

   public Client searchClient(int id){
       for (Client client : clientsList) {
           if(client.account.id == id){
               return client;
           }
       }
       return null;
   }

    public String transferMoney(Account accountOne, Account accountTwo, float amount){
        if (accountOne.retrieveMoney(amount)){
            accountTwo.addMoney(amount);
            return "transaction is successful";
        }else {
            return "You do not have enough money on your account";
        }
    }

    public void addInitialClients(){
        Client client1 = new Client("Daniel Correa", "123", 100000);
        Client client2 = new Client("Jose Macario", "456", 800);
        Client client3 = new Client("Felix Martin", "789", 4000);

        clientsList.add(client1);
        clientsList.add(client2);
        clientsList.add(client3);
    }
}