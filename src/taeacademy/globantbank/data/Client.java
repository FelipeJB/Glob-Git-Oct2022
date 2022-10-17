package taeacademy.globantbank.data;

public class Client {

    String userName;
    String password = "qwerty1234";
    Account account;

    public Client(String user, int accountNumber){
        this.userName = user;
        this.account = new Account(accountNumber);
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public Account getAccount(){
        return this.account;
    }

}