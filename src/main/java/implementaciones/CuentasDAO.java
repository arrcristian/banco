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
    public Cuenta registrar(Cuenta cuenta) throws PersistenciaException {
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
                System.out.println("Cuenta registrado exitosamente");
            } else {
                System.out.println("Error al abrir cuenta");
            }
            throw new PersistenciaException("Se insertó la cuenta pero no se generó el id");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta: " + ex.getMessage());
            throw new PersistenciaException("No se pudo agregar la cuenta: " + ex.getMessage());

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
    public Transferencia transferir() {
        Transferencia transferencia = new Transferencia();
        Connection conexion;
        try {
            conexion = MANEJADOR_CONEXIONES.crearConexion();
            CallableStatement cs = conexion.prepareCall("{call transferir(?,?,?)}");
            cs.setFloat(1, transferencia.getMonto());
            cs.setFloat(2, transferencia.getIdCuentaOrigen());
            cs.setFloat(3, transferencia.getIdCuentaDestino());
            cs.execute();
            return transferencia;
        } catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
    }
    
    
    
}
