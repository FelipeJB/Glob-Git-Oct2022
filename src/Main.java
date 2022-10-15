import org.globant.bank.Account;
import org.globant.bank.Bank;
import org.globant.bank.Client;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Client client = new Client("oarestrepo22", 6289);
        bank.addUserToBank(client);
        client = new Client("daniparra", 2289);
        bank.addUserToBank(client);
        client = new Client("luisafer", 0516);
        client.savingsAccount.addMoney(10000);
        System.out.println(client.savingsAccount.addMoney(10000));
        System.out.println(client.savingsAccount.withdrawMoney(100));
        System.out.println(client.savingsAccount.withdrawMoney(1100));
        System.out.println(client.savingsAccount.getBalance());
        bank.addUserToBank(client);


        //System.out.println(bank.clientList);
        //System.out.println(bank.getAllClients());
    }
}
