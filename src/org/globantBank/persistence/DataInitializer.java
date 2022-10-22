package src.org.globantBank.persistence;

import src.org.globantBank.data.Admin;
import src.org.globantBank.data.Bank;
import src.org.globantBank.data.Client;

public class DataInitializer {
    public static Bank loadBank() {
        Bank myBank = new Bank("Bancolombia");
        loadClientsToBank(myBank);
        loadAdminsToBank(myBank);
        return myBank;
    }
    private static void loadClientsToBank(Bank bank) {
        Client client1 = new Client("John Arango", "j.arango", "12345");
        Client client2 = new Client("Johnny", "j.johnny", "23456");
        bank.addClient(client1);
        bank.addClient(client2);
    }
    private static void loadAdminsToBank(Bank bank) {
        Admin admin1 = new Admin("JohnDoe", "12345");
        bank.addAdmin(admin1);
    }
}
