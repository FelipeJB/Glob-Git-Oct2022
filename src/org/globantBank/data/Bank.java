package src.org.globantBank.data;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Client> clientList;
    private ArrayList<Admin> adminList;

    public Bank(String name) {
        this.name = name;
        this.clientList = new ArrayList<>();
    }

}
