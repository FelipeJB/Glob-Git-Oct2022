package src.org.globantBank.data;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Client> clientList;
    private ArrayList<Admin> adminList;

    public Bank(String name) {
        this.name = name;
        this.clientList = new ArrayList<>();
        this.adminList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void addClient(Client client) {
        this.clientList.add(client);
    }
    public void addAdmin(Admin admin) {
        this.adminList.add(admin);
    }

    public Client isClient(String user, String password){
        Client authClient = new Client();
        for (Client client : clientList) {
            if (client.authenticateClient(user, password)) {
                authClient = client;
            }
        }
        return authClient;
    }
    public Admin isAdmin(String user, String password){
        Admin authAdmin = new Admin();
        for (Admin admin : adminList) {
            if (admin.authenticateAdmin(user, password)) {
                authAdmin = admin;
            }
        }
        return authAdmin;
    }
    public Account clientTotransfer(int account){
        Account clientToTrans = new Account();
        for (Client client : clientList) {
            if (client.getSavingsAccount().getNumber() == account){
                clientToTrans = client.getSavingsAccount();

            }

        }
        return clientToTrans;


    }

}
