/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Cristian
 */
public class Cuenta {
    
    private int id;
    private String fechaHoraApertura;
    private String estado;
    private float saldo;
    private String numeroCuenta;
    private int titular;

    public Cuenta() {
    }

    public Cuenta(String fechaHoraApertura, String estado, float saldo, String numeroCuenta, int titular) {
        this.fechaHoraApertura = fechaHoraApertura;
        this.estado = estado;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
    }

    public Cuenta(int id, String fechaHoraApertura, String estado, float saldo, String numeroCuenta, int titular) {
        this.id = id;
        this.fechaHoraApertura = fechaHoraApertura;
        this.estado = estado;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHoraApertura() {
        return fechaHoraApertura;
    }

    public void setFechaHoraApertura(String fechaHoraApertura) {
        this.fechaHoraApertura = fechaHoraApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }
    
    



}
