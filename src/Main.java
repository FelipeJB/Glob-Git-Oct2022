package src;


import src.globant.bank.Bank;
import src.globant.client.Client;

import java.util.Scanner;

// El algoritmo inicia creando un scanner, pide datos e imprime por pantalla, lee el nombre de usuario yu lo pone en name


// print / read scanner / o pop ups JOptionPane se inicializa desde aqui
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        Client client = new Client();
        System.out.println("Welcome, Do you have an account?");
               byte options;
               byte otherOptions;

      do {
          System.out.println("option 1 : log in");
          System.out.println("option 2 : creating an account");
          System.out.println("option 3 : List clients");
          System.out.println(" option 0 : Exit");
          options = scan.nextByte();
          if (options == 1) {
              System.out.println("Please typer your username");
              String user = scan.next();
              System.out.println(" Please enter your password");
              String password = scan.next();
              if (bank.validator(user, password)) {
                  do {
                      System.out.println(" Welcome to your account");
                      System.out.println(" What are we gonna do today?");
                      System.out.println( " option 1 : Withdraw money");
                      System.out.println( " option 2 : deposit money");
                      System.out.println( " option 3 : Transfer money");
                      System.out.println( "option 0 : Exit application");
                      otherOptions = scan.nextByte();
                      switch (otherOptions) {
                          case 1:
                              System.out.println("How much money do you want to withdraw?");
                              double moneyToWithdraw = scan.nextDouble();
                              client.withdraw(moneyToWithdraw);
                              break;
                          case 2:
                              System.out.println("How much money do you want to  deposit?");
                              double moneyToDeposit = scan.nextDouble();
                              client.deposit(moneyToDeposit);
                              break;
                      }

                  } while (otherOptions != 0 );


              } else {
                  System.out.println("Invalid user press option 2 to create an account");
              }
          }

          if (options == 2) {
              bank.createClient();
          }
          if (options == 3) {
              bank.listClients();
          }
      } while (options != 0);




    }

}


