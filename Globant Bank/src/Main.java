import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bank = new Bank();
        System.out.println("Hola! Bienvenido a Globant Bank");
        System.out.println("Por favor ingresa tu nombre de usuario");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.println("Por favor ingresa tu contraseña");
        int password = scan.nextInt();
        Client loginUser = null;
        for (int i = 0; i < bank.getClients().size(); i++){
            if (user.equals(bank.getClients().get(i).getUser()) && password == bank.getClients().get(i).getPassword()){
               loginUser = bank.getClients().get(i);
            }
        }
        if (loginUser == null){
            System.out.println("Tus datos no coinciden, por favor vuelve a intentarlo");
        } else {
            System.out.println("Hola " + user + "! " + " Has ingresado correctamente");
            var userOption = 0;
            while (userOption != 5) {
                System.out.println("El siguiente es el menú de opciones");
                System.out.println("Marque 1 para consignar dinero a su cuenta");
                System.out.println("Marque 2 para retirar dinero de su cuenta");
                System.out.println("Marque 3 para transferir dinero a otras cuentas");
                System.out.println("Marque 4 para conocer su saldo");
                System.out.println("Marque 5 para cerrar sesión");
                userOption = scan.nextInt();
                if (userOption == 1) {
                    System.out.println("Qué valor desea consignar");
                    var moneyAdd = scan.nextDouble();
                    loginUser.getSavingAccount().addMoney(moneyAdd);
                } else if (userOption == 2) {
                    System.out.println("Qué valor desea retirar");
                    var moneyRetrieve = scan.nextDouble();
                    loginUser.getSavingAccount().withdrawMoney(moneyRetrieve);
                } else if (userOption == 3) {
                    System.out.println("Ingrese su cuenta destino");
                    var targetAccount = scan.nextInt();
                    System.out.println("Qué valor desea transferir");
                    var moneyTransfer = scan.nextDouble();
                    bank.transferMoney(loginUser.getSavingAccount().getAccountNumber(), targetAccount, moneyTransfer);
                    System.out.println("Su transferecia se ha realizado con éxito");

                }
            }

        }

        bank.toString();
        System.out.println(bank.toString());
    }

}