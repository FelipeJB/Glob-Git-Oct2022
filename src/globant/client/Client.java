package src.globant.client;

import java.time.LocalDateTime;
import java.util.Objects;

public class Client {
    // tipo de dato cuenta: account  - variables primitivas String/ Double / Int
     private String user;
    private String password;
    private Integer accountNumber;
    private LocalDateTime openingDate;
    private double balance;

    // contructor

    public Client () {

    }

    public Client(String user, String password, Integer accountNumber, LocalDateTime openingDate, double balance) {
        this.user = user;
        this.password = password;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    //Metodos propios de la clase  para retirar//
    // scope lAS NUEVAS VARIABLES ALCANCE LIMITADO SOLO EXISTEN DENTRO DEL METODOS UNA VEZ SE EJECUTA BLOQUE DE CODIGO DESAPARECE - COMO CALCULADORA
    // amount  = cantidad a retirtar se comprueba que el valor sea positivo  y tenga suficiente dinero

    public void withdraw(double amount) {
        // Verifica que la cantidad a retirar sea mayor a cero
        if (amount > 0) {
            // Calula el monto final a retirar de la cuenta teniendo en cuenta los impuestos correspondientes
            // (Condición en linea) que verifica si amount es menor que 1000
            double finalWithDraw = amount < 1000 ? amount + 200 : amount + 200 + amount*0.15;
            // Verifica que haya sufuciente dinero para retirar
            if (balance > finalWithDraw) {
                // Calcula el nuevo balance de la cuenta
                double newBalance = balance  - finalWithDraw;
                // Asigna el nuevo balance a la cuenta
                balance = newBalance;
                System.out.println(" Withdraw made succesfully");
            }
        }
        System.out.println("Unable to make withdraw");
    }

    //metodo para depositar
// VOID no tiene retorno
    public void deposit(double amount) {
      balance = balance + amount;
                System.out.println("Deposit made succesfully");
        System.out.println("Your current balance is : " + balance);

            }

    public boolean transfer(double amount) {
        if (amount > 0) {
            if (balance > amount + 100) {
                double newBalance = balance - amount - 100;
                balance = newBalance;
                return true;
            }


        }
        return false;
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

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

