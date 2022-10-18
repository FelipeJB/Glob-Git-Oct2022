package src;

import java.util.Objects;

public class Client {
    // tipo de dato cuenta: account  - variables primitivas String/ Double / Int
    private Account savingAccount;
    private String user;
    private String password;

    // contructor
    public Client(Account savingAccount, String user, String password) {
        this.savingAccount = savingAccount;
        this.user = user;
        this.password = password;
    }


    //Metodos propios de la clase  para retirar//
    // scope lAS NUEVAS VARIABLES ALCANCE LIMITADO SOLO EXISTEN DENTRO DEL METODOS UNA VEZ SE EJECUTA BLOQUE DE CODIGO DESAPARECE - COMO CALCULADORA
    // amount  = cantidad a retirtar se comprueba que el valor sea positivo  y tenga suficiente dinero

    public boolean withdraw(double amount) {
        // Verifica que la cantidad a retirar sea mayor a cero
        if (amount > 0) {
            // Calula el monto final a retirar de la cuenta teniendo en cuenta los impuestos correspondientes
            // (Condición en linea) que verifica si amount es menor que 1000
            double finalWithDraw = amount < 1000 ? amount + 200 : amount + 200 + amount*0.15;
            // Verifica que haya sufuciente dinero para retirar
            if (this.savingAccount.getBalance() > finalWithDraw) {
                // Calcula el nuevo balance de la cuenta
                double newBalance = this.savingAccount.getBalance() - finalWithDraw;
                // Asigna el nuevo balance a la cuenta
                this.savingAccount.setBalance(newBalance);
                return true;
            }
        }
        return false;
    }

    //metodo para depositar
// VOID no tiene retorno
    public void deposit(double amount) {
        double newBalance = this.savingAccount.getBalance() + amount;
        this.savingAccount.setBalance(newBalance);
    }

    public boolean transfer(double amount) {
        if (amount > 0) {
            if (this.savingAccount.getBalance() > amount + 100) {
                double newBalance = this.savingAccount.getBalance() - amount - 100;
                this.savingAccount.setBalance(newBalance);
                return true;
            }

        }
        return false;
    }


    // getters and setters

    public Account getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Account savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!Objects.equals(savingAccount, client.savingAccount)) return false;
        return Objects.equals(user, client.user);
    }

    @Override
    public int hashCode() {
        int result = savingAccount != null ? savingAccount.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Client{" + "savingAccount=" + savingAccount + ", user='" + user + '\'' + ", password='" + password + '\'' + '}';
    }
}
