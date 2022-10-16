import org.globant.bank.Bank;
import org.globant.bank.Client;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Client client1 = new Client("oarestrepo22", 6289);
        bank.addUserToBank(client1);
        System.out.println(client1.savingsAccount.depositMoney(1000));
        //System.out.println(client1.savingsAccount.withdrawMoney(500));

        Client client2 = new Client("daniparra", 2289);
        bank.addUserToBank(client2);
        System.out.println(client2.savingsAccount.depositMoney(2000));
        System.out.println("TRANSFERENCIA BANCARIA");
        bank.transferTransaction(800, client1.savingsAccount, client2.savingsAccount);

        client1.savingsAccount.getBalance();
        client2.savingsAccount.getBalance();



        //System.out.println(bank.clientList);
        //System.out.println(bank.getAllClients());
    }
}
