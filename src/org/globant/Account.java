package org.globant;

import java.util.Date;

public class Account {
    public  int accountNumber;
    public float balance;
    public Date creationDate;


    public Account(int accountNumber, float balance, Date creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public void addMoney(float amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("Se han agregado " + amount + " a la cuenta " + this.accountNumber);
        }else{
            System.out.println("No se adminten cantidades negativas");
        }
    }

    public void withdrawMoney(float amount){
        if (amount > 0){
            if (amount < 1000){
                if (this.balance - amount - 200 >= 0){
                    this.balance -= amount + 200;
                    System.out.println("Se han retirado " + amount + " de la cuenta " + this.accountNumber +" y se han cobrado 200 de comision");
                }else{
                    System.out.println("No se puede retirar esa cantidad de dinero");
                }
            }else{
                if (this.balance - amount - 200 - (amount * 0.15) >= 0){
                    this.balance -= amount + 200 + (amount * 0.15);
                    System.out.println("Se han retirado " + amount + " de la cuenta " + this.accountNumber+ ", se han cobrado 200 de comision y " + (amount * 0.15) + " de impuestos");
                }else{
                    System.out.println("No se puede retirar esa cantidad de dinero");
                }
            }
        }else{
            System.out.println("No se adminten cantidades negativas");
        }
    }

    public void transferMoney(float amount, int account){
        if (amount > 0){
            this.balance -= amount + 100;

            for (Client client : Bank.myClients){
                if (client.userSavingAccount.accountNumber == account){  //si el numero de cuenta del cliente es igual al numero de cuenta que se le pasa como parametro
                    client.userSavingAccount.balance += amount;
                }
            }
            System.out.println("Se han transferido " + amount + " desde la cuenta " + this.accountNumber + " a la cuenta " + account + " y se ha cobrado una comision de 100");
        }else{
            System.out.println("No se adminten cantidades negativas");
        }
    }

}
