package src;

public class Bank {

    public String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    Client BankMs = new Client(000, "admin", "Bank");
    Client Ana = new Client(123, "Ana", "Ken");
    Client Maria = new Client(456, "Maria", "Isaac");
}
