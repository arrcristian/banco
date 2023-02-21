/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
    public Cliente iniciarSesion(Cliente cliente);
    public Cliente actualizarDatos(Cliente cliente);
}
