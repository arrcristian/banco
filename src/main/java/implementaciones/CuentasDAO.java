/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Transferencia;
import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Cristian
 */
public class CuentasDAO implements ICuentasDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;
    
    public CuentasDAO(IConexionBD manejadorConexion) {
        this.MANEJADOR_CONEXIONES = manejadorConexion;
    }
    @Override
    public Cuenta registrar(Cuenta cuenta)  {
         String codigoSQL = "INSERT INTO "
                + "cuentas(fechaHoraApertura,estado,saldo, numero,IdCliente) VALUES (?,?,?,?,?)";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL,
                        Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cuenta.getFechaHoraApertura());
            comando.setString(2, cuenta.getEstado());
            comando.setFloat(3, cuenta.getSaldo());
            comando.setString(4, cuenta.getNumeroCuenta());
            comando.setInt(5, cuenta.getTitular());


           int filasAfectadas = comando.executeUpdate();
            if (filasAfectadas == 1) {
                System.out.println("Cuenta registrada exitosamente");
                return cuenta;
            } else {
                System.out.println("Error al abrir cuenta");
                return null;
            }
           
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta: " + ex.getMessage());
                            return null;

        }
    }

    @Override
    public int verificarCliente(int cliente) {
        ResultSet rs = null;
        String codigoSQL = "insert into cuentas from clientes where id =?";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, cliente);
            
            rs = comando.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            
            return 1;
            
    } catch(Exception ex){
        return 1;
    
    }
    
   
    }

    @Override
    public Transferencia transferir(Transferencia transferencia) {
        Connection conexion;
        Cuenta cuenta = new Cuenta();
        try {
            conexion = MANEJADOR_CONEXIONES.crearConexion();
            CallableStatement cs = conexion.prepareCall("{CALL transferir(?,?,?)}");
            PreparedStatement comando = conexion.prepareStatement("INSERT into transferencias (fechaRealizacion,monto,cuentaOrigen, cuentaDestino) VALUES (?,?,?,?)");
            cs.setFloat(1, transferencia.getMonto());
            cs.setString(2, transferencia.getCuentaOrigen());
            cs.setString(3, transferencia.getCuentaDestino());
            
            comando.setString(1, transferencia.getFecha());
            comando.setFloat(2, transferencia.getMonto());
            comando.setString(3, transferencia.getCuentaOrigen());
            comando.setString(4, transferencia.getCuentaDestino());
            
            if(transferencia.getMonto() >= cuenta.getSaldo()){
                 cs.executeUpdate();
            comando.executeUpdate();
             return transferencia;
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                return null;
            } 

        } catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    
    
    
}
