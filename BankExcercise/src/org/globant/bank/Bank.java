package org.globant.bank;

import java.util.List;

public class Bank {
    private int withdrawTaxLessThousand;
    private int withdrawTaxMoreThousand;
    private int plusPercentageTax;
    private int transferTax;
    private List<User> userList;

    public Bank(int withdrawTaxLessThousand, int withdrawTaxMoreThousand, int plusPercentageTax, int transferTax) {
        this.withdrawTaxLessThousand = withdrawTaxLessThousand;
        this.withdrawTaxMoreThousand = withdrawTaxMoreThousand;
        this.plusPercentageTax = plusPercentageTax;
        this.transferTax = transferTax;
        createUsers();
    }

    public double addMoneyToAccount(User user, double amount){
        SavingsAccount account  = user.getSavingsAccount();
        account.setBalanceAccount(amount);
        updateUser(user);
        return account.getBalanceAccount();
    }

    public String withdrawMoney(User user, double amount){
        String result = "";

        SavingsAccount account  = user.getSavingsAccount();
        amount = applyTax(amount);
        boolean money = account.withdrawAccount(amount);
        if (money){
            updateUser(user);
            result = String.valueOf(account.getBalanceAccount());
        }
        return result;
    }

    public String transferMoneyToAccount(User userFrom, double amount, User userTo) {
        String result = "";

        if(userFrom.getUserID() == userTo.getUserID()){
            result ="You can't transfer to your own account";
        }else {
            SavingsAccount accountFrom = userFrom.getSavingsAccount();
            boolean resFromAccount = accountFrom.withdrawAccount(amount + transferTax);

            if (resFromAccount == false) {
                result = "Origin account doesn't have enough money in its balance to transfer " + amount + " + " + transferTax + "$";
            } else {
                updateUser(userFrom);
                userTo.getSavingsAccount().setBalanceAccount(amount);
                updateUser(userTo);
            }
        }
        return result;
    }

    public List<User> getUsers() {
        return userList;
    }

    public User existUser(int userID) {
        User result = new User(-1, "", "", -1, 0);

        int i = 0;
        while (i < userList.size()) {
            User user = userList.get(i);

            if (user.getUserID() == userID) {
                result = user;
                i = userList.size();
            } else {
                i++;
            }
        }
        return result;
    }

    public User existAccount(int accountNumber) {
        User result = new User(-1, "", "", -1, 0);
        int i = 0;
        while (i < userList.size()) {
            User user = userList.get(i);
            SavingsAccount account = user.getSavingsAccount();

            if (account.getAccountNumber() == accountNumber) {
                result = user;
                i = userList.size();
            } else {
                i++;
            }
        }
        return result;
    }

    private void createUsers() {
        int n = 10;

        for (int i = 1; i <= n; i++) {
            User user = new User(i, "Nombre" + i + " Apellido" + i, "123456", i + 10, 0.0);
            userList.add(user);
        }
    }

    private double applyTax(double amount) {
        if (amount <= 1000) {
            return amount + withdrawTaxLessThousand ;
        } else {
            double percentage = (amount * plusPercentageTax) / 100;
            return amount + withdrawTaxMoreThousand  + percentage;
        }
    }

    private String updateUser(User userToBeUpdate) {
        int i = 0;
        String answerATH = "User doesn't exist";
        while (i < userList.size()) {
            User user = userList.get(i);

            if (user.getUserID() == userToBeUpdate.getUserID()) {
                userList.set(i, user);
                i = userList.size();
                answerATH = "";
            } else {
                i++;
            }
        }

        return answerATH;
    }
}
