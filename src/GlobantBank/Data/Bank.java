package GlobantBank.Data;

import java.util.ArrayList;

public class Bank {
    ArrayList<User> userList = new ArrayList<>();

    public void createdUser(int userID, String name, String userName, String password){

        User user = new User(userID,name,userName,password);
        userList.add(user);
    }

    public void showClients () {
        for (int i=0; i<userList.size(); i++){
            System.out.println(userList.get(i));
        }
    }

    public User searchUser(int userID){
        User locatedUser = null;
        int counter = 0;
        while (counter<userList.size() && locatedUser == null){
            User user = this.userList.get(counter);
            if (user.userID == userID){
                locatedUser = user;
            }
            counter ++;
        }
        return locatedUser;
    }

    public User searchAccount(int accountNumber){
        User transferUser = null;
        int counter = 0;
        while (counter<userList.size() && transferUser == null){
            User user = this.userList.get(counter);
            if (user.savingAccount.accountNumber == accountNumber){
                transferUser = user;
            }
            counter ++;
        }
        return transferUser;
    }
}
