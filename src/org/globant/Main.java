package org.globant;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**Creacion de banco*/
        ArrayList<Client> myClients = new ArrayList<>();
        Bank bank = new Bank("Globant", myClients);

        /**Creacion de cuentas ya existentes*/
        Account account1 = new Account(1001, 1000, new Date());
        Account account2 = new Account(1002, 2000, new Date());
        Account account3 = new Account(1003, 3000, new Date());
        Account account4 = new Account(1004, 0, new Date());

        /**Creacion de clientes ya existentes*/
        Client client1 = new Client("Juan", "1111", account1);
        Client client2 = new Client("Pedro", "2222", account2);
        Client client3 = new Client("Maria", "3333", account3);
        Client client4 = new Client("Jose", "4444", account4);



        /**Agregando clientes ya existentes al banco*/
        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);


        Scanner myScanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("Bienvenido al banco " + bank.bankName);
            System.out.println("1. Agregar cliente");
            System.out.println("2. Ver lista de clientes existentes");
            System.out.println("3. Ingresar numero cuenta para realizar transacciones(Agregar, retirar o transferir dinero)");
            System.out.println("4. Salir");

            option = myScanner.nextInt();
            myScanner = new Scanner(System.in);

            switch (option) {
                case 1:
                    Client newClient = new Client("", "", null);
                    newClient.createClient();
                    break;
                case 2:
                    bank.printClients();
                    break;
                case 3:
                    System.out.println("Ingrese su numero de cuenta");
                    int accountNumber = myScanner.nextInt();
                    myScanner = new Scanner(System.in);

                    for (Client client : bank.myClients) {
                        /**Esto es un for each
                            for (type var : array){
                              statements using var;
                            }*/

                        int option2;
                        if (accountNumber == client.userSavingAccount.accountNumber) {

                            do {

                                System.out.println("Bienvenido " + client.userName);
                                System.out.println("1. Depositar");
                                System.out.println("2. Retirar");
                                System.out.println("3. Tranferir dinero a otra cuenta");
                                System.out.println("4. Salir");
                                option2 = myScanner.nextInt();
                                myScanner = new Scanner(System.in);
                                switch (option2) {
                                    case 1:
                                        System.out.println("Ingrese el el monto de dinero a agregar");
                                        int amountToAdd = myScanner.nextInt();
                                        myScanner = new Scanner(System.in);
                                        client.userSavingAccount.addMoney(amountToAdd);
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el el monto de dinero a retirar");
                                        int amountToRetire = myScanner.nextInt();
                                        myScanner = new Scanner(System.in);
                                        client.userSavingAccount.withdrawMoney(amountToRetire);
                                        break;
                                    case 3:
                                        System.out.println("Ingrese el numero de cuenta a la que desea transferir dinero");
                                        int accountNumberToTransfer = myScanner.nextInt();
                                        myScanner = new Scanner(System.in);

                                        for (Client clientToTransfer : bank.myClients) {
                                            if (accountNumberToTransfer == clientToTransfer.userSavingAccount.accountNumber) {

                                                System.out.println("Ingrese el monto de dinero a transferir");
                                                int amountToTransfer = myScanner.nextInt();
                                                myScanner = new Scanner(System.in);
                                                client.userSavingAccount.transferMoney(amountToTransfer, accountNumberToTransfer);
                                            } else {
                                                System.out.println("El numero de cuenta ingresado no existe");
                                                break;
                                            }
                                        }
                                        break;

                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            } while (option2 != 4);
                        }else{
                            System.out.println("El numero de cuenta ingresado no existe");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while(option != 4);

    }
}


















