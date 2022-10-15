package org.globant.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String name;
    public List<Client> clientList ;

    public Bank(){
        name = "GLOBANT BANK";
        clientList = new ArrayList<>();
    }

    public void addUserToBank(Client user){
        clientList.add(user);
    }
    public String getAllClients(){
        return "***** " + name + " CLIENT LIST ***** \n"
                + clientList;
    }



}
