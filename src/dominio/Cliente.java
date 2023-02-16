/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;



/**
 *
 * @author Cristian
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;
    public String colonia;
    public String calle;
    public String numero_casa;
    public String contraseña;
    public int edad;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento, String colonia, String calle, String numero_casa, String contraseña, int edad) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.colonia = colonia;
        this.calle = calle;
        this.numero_casa = numero_casa;
        this.contraseña = contraseña;
        this.edad = edad;
    }

    public Cliente(int id, String nombre, String apellido_paterno, String apellido_materno, String fecha_nacimiento, String colonia, String calle, String numero_casa, String contraseña, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.colonia = colonia;
        this.calle = calle;
        this.numero_casa = numero_casa;
        this.contraseña = contraseña;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }


    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

   
    
    
}
