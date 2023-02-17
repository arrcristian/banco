/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import presentacion.IniciarSesion;
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
        new Registro(clientesDAO).setVisible(true);
        new IniciarSesion(clientesDAO).setVisible(true);
    }
    
}
