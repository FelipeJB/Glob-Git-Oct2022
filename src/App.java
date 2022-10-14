package src;

public class App {

    public static void main(String[] args) {

        Bank bancolombia = new Bank("Bancolombia");
        bancolombia.addClient(new Client("John", "123456"));
        bancolombia.addClient(new Client("Jane", "234567"));
        System.out.println(bancolombia.getClients());

    }
}
