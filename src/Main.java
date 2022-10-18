package src;


import java.util.Scanner;

// El algoritmo inicia creando un scanner, pide datos e imprime por pantalla, lee el nombre de usuario yu lo pone en name


// print / read scanner / o pop ups JOptionPane se inicializa desde aqui
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Escriba el nombre del usuario");
        String name = scan.nextLine();
        System.out.println("Escriba la contraseña ");
        String password  = scan.nextLine();
        System.out.println("Escriba el saldo incial de la cuenta");
        double balance = scan.nextDouble();

            // llamaando metodos
        // Creamos la client
        Account account1 = new Account("154516466", balance);
        Client client1 = new Client(account1, name, password);




        // Consultamos el saldo
        System.out.println("Total actual en la cuenta: $" + account1.getBalance());

        // Hacemos un ingreso en la cuenta
        System.out.println("Escriba el saldo a depositar en la cuenta");
        double income = scan.nextDouble();
        client1.deposit(income);
        System.out.println("Se ingresaron $ " + income + " en la cuenta, saldo actual: $" + account1.getBalance());

        // retirar

        System.out.println("Escriba el saldo a retirar de la cuenta");
        double withdrawal = scan.nextDouble();
        client1.withdraw(withdrawal);
        System.out.println("Se retiraron $ " + withdrawal + " en la cuenta, y $ " + (withdrawal < 1000 ?  200 : (200 + withdrawal*0.15) )+ " en impuestos,  saldo actual: $" + account1.getBalance());

        System.out.println("Escriba el saldo a transferir");
        double transferred= scan.nextDouble();
        client1.transfer (transferred);
        System.out.println("Se transfirieron $" + transferred+ " de la cuenta, $100 en impuestos, saldo actual: $" + account1.getBalance());
    }

}


