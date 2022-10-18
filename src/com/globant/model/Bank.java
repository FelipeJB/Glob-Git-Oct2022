package com.globant.model;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients;
    private String password;

    public Bank() {
        this.clients = new ArrayList<>();
        this.password = "admin";
    }

    public void createNewClient(Client client){
        this.clients.add(client);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

}
