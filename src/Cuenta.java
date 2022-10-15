package src;

public class Cuenta extends Persona  {


    private Double cuenta;
    private double saldo;

    public Cuenta ( Double cuenta, double inicial) {
        super( cuenta,saldo);
        this.cuenta = cuenta;
        this.saldo = inicial;
    } // Fin del constructor cuenta

    public void depositar(double cantidad) {
        saldo = saldo + cantidad;
    } // Fin del método depositar

    public void retirar(double cantidad) {
        saldo = saldo - cantidad;
    } // Fin del método retry

    public double saldo() {
        return saldo;
    } // Fin del método saldo
}
