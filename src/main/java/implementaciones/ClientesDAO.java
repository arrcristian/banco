/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cristian
 */
public class ClientesDAO implements IClientesDAO{

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;
    
    public ClientesDAO(IConexionBD manejadorConexion) {
        this.MANEJADOR_CONEXIONES = manejadorConexion;
    }
    @Override
    public Cliente registrar(Cliente cliente) throws PersistenciaException {
      
        String codigoSQL = "INSERT INTO "
                + "clientes(nombre,apellido_paterno,apellido_materno,edad, contraseña,fecha_nacimiento,calle,numero_casa,colonia) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL,
                        Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellido_paterno());
            comando.setString(3, cliente.getApellido_materno());
            comando.setInt(4, cliente.getEdad());
            comando.setString(5, cliente.getContraseña());
            comando.setString(6, cliente.getFecha_nacimiento());
            comando.setString(7, cliente.getCalle());
            comando.setString(8, cliente.getNumero_casa());
            comando.setString(9, cliente.getColonia());

            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt("GENERATED_KEY");
                cliente.setId(llavePrimaria);
                return cliente;
            }
            LOG.log(Level.WARNING, "Se insertó el cliente pero no se generó el id");
            throw new PersistenciaException("Se insertó el cliente pero no se generó el id");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar al cliente: " + ex.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente: " + ex.getMessage());

        }
    }

    @Override
    public int verificarUsuario(String cliente) {
        ResultSet rs = null;
        String codigoSQL = "select count(id) from clientes where nombre =?";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setString(1, cliente);
            
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
    public boolean iniciarSesion(Cliente cliente) {
        ResultSet rs = null;
        String codigoSQL = "select id,contraseña from clientes where id = ?";
        try (Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, cliente.getId());
            
            rs = comando.executeQuery();
            if(rs.next()){
                if(cliente.getContraseña().equals(rs.getString("contraseña"))){
                    cliente.setId(rs.getInt("id"));
                    return true;
                } else {
                    return false;
                }     
            }
    } catch(Exception ex){
        LOG.log(Level.SEVERE, "No se pudo iniciar sesión: " + ex.getMessage());
    
    }
return false;
    
    }

    
}
