package src.globant.bank;

import src.globant.client.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// se crea usuario desde 0
// lista va a guardar registros de clientes  -
public class Bank {
     List <Client> clients = new ArrayList<Client>();
     Client client = new Client();

     Scanner input = new Scanner(System.in);
     public void createClient (){
         System.out.println("Enter your name: ");
         client.setUser(input.next());
         System.out.println("Type your password: ");
         client.setPassword(input.next());
         client.setBalance(0);
         client.setAccountNumber(123456);
         client.setOpeningDate(LocalDateTime.now());
         clients.add(client); // estas agregando un cliente a la lista de clientes
         System.out.println( "Client created successfully");
     }
public boolean validator (String name, String password) {
         client.setUser(name);
         client.setPassword(password);
        // recorrer lista de clientes para validar si existe el usuario/
    for (int i = 0; i < clients.size(); i++) {
        if (client.getUser() == clients.get(i).getUser() && client.getPassword()== clients.get(i).getPassword()) {
            return true;
        }
    }
    return false;
}
    public void listClients () {
        System.out.println(" my client list: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("Name : " + clients.get(i).getUser());
            System.out.println("Creation Date : " + clients.get(i).getOpeningDate());
            System.out.println("Account number : " + clients.get(i).getAccountNumber());
        }
    }
}
