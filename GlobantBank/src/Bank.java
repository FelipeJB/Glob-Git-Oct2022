import java.util.ArrayList;

public class Bank {

    private ArrayList<Client> clients = new ArrayList<Client>();

    public Bank(){
        var client0 = new Client(5000, "Emilio", 2011);
        var client1 = new Client(6000, "Rivas", 2012);
        var client2 = new Client(8000, "Elsy", 2013);
        var client3 = new Client(500, "Jordan", 2014);
        var client4 = new Client(4500, "Lazo", 2015);
        var client5 = new Client(5000, "Fabricio", 2016);

        clients.add(client0);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
    }


}
