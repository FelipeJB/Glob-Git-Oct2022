import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

public class Bank {
    public String name;
    ArrayList<Client> clientsList;
    List<Integer> existingAccounts;

    public Bank(String name) {
        this.name = name;
        this.clientsList = new ArrayList<>();
        this.existingAccounts = new ArrayList<>();
    }

    public String addClient(String username, String password, float openingMoney) {
        for (int i = 0; i < clientsList.size(); i++) {
            if (clientsList.get(i).username.contentEquals(username)) {
                return "The username already exists, try another one.";
            }
        }
        Client client = new Client(username, password, openingMoney);
        this.clientsList.add(client);
        this.existingAccounts.add(client.bankAccount.accountNumber);
        return client.username + " has been successfully created";

    }

    public void showClients() {
        Formatter fmt = new Formatter();
        fmt.format("%-16s %-15s %-14s %-20s\n", "Username", "Account number", "Balance", "Opening date");
        for (int i = 0; i < this.clientsList.size(); i++) {
            fmt.format( "%-16s %-15d %-12.2f %-20s\n",this.clientsList.get(i).username, this.clientsList.get(i).bankAccount.accountNumber,  this.clientsList.get(i).bankAccount.balance,  this.clientsList.get(i).bankAccount.openingDate.toString());
        }
        System.out.println(fmt);
    }

    public String addMoney(int numberAccount, float amount) {
        if (this.checkAccountExists(numberAccount)) {
            int accountIndex = this.existingAccounts.indexOf(numberAccount);
            Client client = this.clientsList.get(accountIndex);
            return client.bankAccount.addMoney(amount);
        }
        return "Bank account not found";
    }
    public String withdrawMoney(int numberAccount, float amount) {
        if (this.checkAccountExists(numberAccount)) {
            int accountIndex = this.existingAccounts.indexOf(numberAccount);
            Client client = this.clientsList.get(accountIndex);
            return client.bankAccount.withdrawMoney(amount, false);
        }
        return "Bank account not found";
    }
    public String transferMoney(int originAccount, int targetAccount, float amount) {
        if (this.checkAccountExists(originAccount) && this.checkAccountExists(targetAccount)) {
            int originAccountIndex = this.existingAccounts.indexOf(originAccount);
            Client originClient = this.clientsList.get(originAccountIndex);
           String withdrawTransferTax =  originClient.bankAccount.withdrawMoney(100, true);
            String withdrawMoneyMessage = originClient.bankAccount.withdrawMoney(amount, false);
            if (withdrawMoneyMessage.contains("Insufficient")) {
                if(!withdrawTransferTax.contains("Insufficient")){
                    originClient.bankAccount.addMoney(100);
                }
                return withdrawMoneyMessage;
            }
            int targetAccountIndex = this.existingAccounts.indexOf(targetAccount);
            Client targetClient = this.clientsList.get(targetAccountIndex);
            targetClient.bankAccount.addMoney(amount);
            return "Successful transaction";
        }

        return "Bank account not found";
    }

    public Boolean checkAccountExists(int account) {
        if (this.existingAccounts.contains(account)) {
            return true;
        }
        return false;
    }

}
