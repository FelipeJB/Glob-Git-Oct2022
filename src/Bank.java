package src;

public class Bank {

    public String name;

    Bank(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    Client BankMs = new Client(111, "Morgan Stanley", "admin", "Bank");
    Client Ana = new Client(123, "Ana Gonzalez", "Ana", "Ken");
    Client Maria = new Client(456, "Maria Bautista", "Maria", "Isaac");
}
