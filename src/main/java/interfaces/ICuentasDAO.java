/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;

/**
 *
 * @author Cristian
 */
public interface ICuentasDAO {
    
    public Cuenta registrar (Cuenta cuenta) ;
    public int verificarCliente(int cliente);
    public Transferencia transferir(Transferencia transferencia);

}
