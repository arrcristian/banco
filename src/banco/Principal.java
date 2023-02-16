/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import presentacion.IniciarSesion;
import presentacion.Registro;
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
