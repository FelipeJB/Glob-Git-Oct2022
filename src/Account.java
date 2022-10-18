package src;

import java.time.LocalDateTime;
 // ESTRUCTURA GENERAL DE LAS CLASES
public class Account {

  // declarar variables  y tipo de datos atributos / caracteristicas / "NO SE EJECUTA"
    private String accountNumber;
    private LocalDateTime openingDate;
    private double balance;

    // metodo constructor Se  // ejecutan cuando los llamo
    // publico privado o protegido metodos de acceso
 // Local date para dia de la creacion de la cuenta bancaria
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.openingDate = LocalDateTime.now();
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
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

  // comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return accountNumber.equals(account.accountNumber);
    }
   // Define el Apuntador de la variable - espacio memoria
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }


     // convierte la informacion de la cuenta a una cadena de texto y mostrarlo por consola o pantalla
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", openingDate=" + openingDate +
                ", balance=" + balance +
                '}';
    }
}