/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author Cristian
 */
public interface IClientesDAO {
    
    public Cliente registrar (Cliente cliente) throws PersistenciaException;
    public int verificarUsuario(String usuario);
    public boolean validarContrasena(String contrasena);
    public boolean validarFecha(String fecha);
    public boolean iniciarSesion(Cliente cliente);
}
