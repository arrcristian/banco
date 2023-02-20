/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import presentacion.IniciarSesion;
import presentacion.Inicio;
import presentacion.Registro;

/**
 *
 * @author Cristian
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IConexionBD generadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/bank",
                "root",
                "cristian");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexiones);
        new Inicio(clientesDAO,cuentasDAO).setVisible(true);
    }
    
}
