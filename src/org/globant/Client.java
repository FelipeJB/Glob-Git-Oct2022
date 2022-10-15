package org.globant;

import java.util.Date;
import java.util.Scanner;

public class Client {
    public String userName;
    public String userPassword;
    public Account userSavingAccount;

    public Client(String userName, String userPassword, Account userSavingAccount) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSavingAccount = userSavingAccount;
    }



    public void createClient() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente");
        String userName = myScanner.nextLine();
        while (userName == null || userName.isEmpty()) {
            System.out.println("El nombre no puede ser nulo o vacio, ingrese uno valido: ");
            userName = myScanner.nextLine();
        }
        this.userName = userName;

        System.out.println("Ingrese el password del cliente (No debe tener mas o menos de 4 digitos: ");
        String userPassword = myScanner.nextLine();
        while (userPassword.length() > 4 || userPassword.length() < 4) {
            System.out.println("El password no puede tener mas de 4 digitos, ingrese uno valido: \"");
            userPassword = myScanner.nextLine();
        }
        this.userPassword = userPassword;

        int accountNumber = 0;
        for (Client client : Bank.myClients) { //recorre la lista de clientes y si numero de cuenta es igual al numero de cuenta del cliente que se esta creando, se le suma 1 al numero de cuenta
            accountNumber = client.userSavingAccount.accountNumber;
        }
        accountNumber += 1;

        Account userSavingAccount = new Account(accountNumber, 0, new Date());
        this.userSavingAccount = userSavingAccount;

        Bank.myClients.add(new Client(this.userName, this.userPassword, userSavingAccount));

        System.out.println("El cliente " + userName + " ha sido agregado y se le ha asignado el numero de cuenta: "+ userSavingAccount.accountNumber);

    }



}
