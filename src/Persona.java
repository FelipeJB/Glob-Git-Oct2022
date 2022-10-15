package src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Persona {
    private final String nombre;
    private String apellido;
    private Integer id;

    private Double cuenta;
    private Double saldo;
    private String username;
    private String clave;
    private DateFormat format = new SimpleDateFormat("DD/MM/YYYY");



      public Persona(String nombre, String apellido, Integer id, Double Cuenta, Double saldo, String username, String clave, DateFormat format) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.cuenta = Cuenta;
        this.saldo = saldo;
        this.username = username;
        this.clave = clave;
        this.format = format;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getId() {
        return id;
    }

    public Double getCuenta() {
        return cuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getUsername() {
        return username;
    }

    public String getClave() {
        return clave;
    }

    public DateFormat getFormat() {
        return format;
    }
}
