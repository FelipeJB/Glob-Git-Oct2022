import org.globant.bank.Bank;
import org.globant.bank.Client;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Client client = new Client("oarestrepo22", 6289);
        bank.addUserToBank(client);
        client.savingsAccount.depositMoney(1000);
        client.savingsAccount.withdrawMoney(100);

        client = new Client("daniparra", 2289);
        bank.addUserToBank(client);
        client.savingsAccount.depositMoney(2000);







        //System.out.println(bank.clientList);
        //System.out.println(bank.getAllClients());
    }
}
