import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<SavingAccount> savingAccounts;

    public Bank(String name){
        this.name = name;
        users = new ArrayList<>();
        savingAccounts = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addSavingAccount(SavingAccount savingAccount){
        this.savingAccounts.add(savingAccount);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
    public ArrayList<SavingAccount> getAccounts() {
        return this.savingAccounts;
    }
    public String getName(){
        return this.name;
    }
}