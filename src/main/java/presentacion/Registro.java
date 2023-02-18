package presentacion;

import cifrados.CifrarContrasena;
import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validadores.Validadores;

/**
 *
 * @author Cristian
 */
public class Registro extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(Registro.class.getName());
    private final IClientesDAO clientesDAO;
    private final Validadores validadores = new Validadores();
    /**
     * Creates new form Registro
     */
    public Registro(IClientesDAO clientesDAO) {
        this.setTitle("Registro");
        this.clientesDAO = clientesDAO;
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }
    
 
    private Cliente extraerDatosFormulario() {
        
        String contraseña = new String(txtContrasena.getPassword());
        String nuevaContraseña = CifrarContrasena.md5(contraseña);
        String nombre = this.txtNombre.getText();
        String apellido_paterno = this.txtApellidoPaterno.getText();
        String apellido_materno = this.txtApellidoMaterno.getText();
        String calle = this.txtCalle.getText();
        String colonia = this.txtColonia.getText();
        String numeroCasa = this.txtNumero.getText();
        String fecha_nacimiento = this.txtFechaNacimiento.getText();
        int edad = calcularEdad(txtFechaNacimiento.getText());
        Cliente cliente = new Cliente(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, colonia, calle, numeroCasa, nuevaContraseña, edad);
        return cliente;
    }
    
    public int calcularEdad(String fechaNacimiento) {
         LocalDate fechaNac = LocalDate.parse(this.txtFechaNacimiento.getText());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNac, fechaActual);
        return periodo.getYears();
    }
    
    private void mostrarMensajeClienteGuardado(Cliente cliente) {
        JOptionPane.showMessageDialog(this, "Te has registrado, tu ID es: " + cliente.getId());
    }
    
    private void mostrarMensajeErrorAlGuardar() {
        JOptionPane.showMessageDialog(this, "No fue posible registrarse", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void guardar() {
        
        try {
            Cliente cliente = this.extraerDatosFormulario();
            Cliente clienteGuardado = this.clientesDAO.registrar(cliente);
            this.mostrarMensajeClienteGuardado(clienteGuardado);
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorAlGuardar();
        }
    }
    
    private boolean verificarContrasena(){
         String contraseña = new String(txtContrasena.getPassword());
         String confirmarContraseña = new String(txtConfirmarContrasena.getPassword());
         if(contraseña.equals(confirmarContraseña)){
                String nuevaContraseña = CifrarContrasena.md5(contraseña); 
                return false;
            }
            else {
               return true;
            }
    }
    private boolean verificarCamposVacios() {
        
        String contraseña = new String(txtContrasena.getPassword());
        String confirmarContraseña = new String(txtConfirmarContrasena.getPassword());
        if(txtNombre.getText().equals("") || contraseña.equals("") ||
        confirmarContraseña.equals("") || txtFechaNacimiento.getText().equals("") ||
        txtApellidoMaterno.equals("") || txtApellidoPaterno.equals("") ||
        txtCalle.equals("") || txtColonia.equals("") || txtNumero.equals("")){
            return true;
        } 
        return false;
    }
    
    public void reiniciarCampos(){
        txtConfirmarContrasena.setText("");
        txtContrasena.setText("");
        txtFechaNacimiento.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtNumero.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContrasena = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        lblConfirmarContrasena = new javax.swing.JLabel();
        txtConfirmarContrasena = new javax.swing.JPasswordField();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblContrasena.setText("Contraseña");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel4.setText("REGISTRO");

        lblConfirmarContrasena.setText("Confirmar Contraseña");

        lblNombre.setText("Nombre(s)");

        lblApellidoPaterno.setText("Apellido Paterno");

        lblApellidoMaterno.setText("Apellido Materno");

        lblCalle.setText("Calle");

        lblNumero.setText("Número");

        lblColonia.setText("Colonia");

        lblFechaNacimiento.setText("Fecha de Nacimiento");

        btnRegresar.setText("<- Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCalle)
                                    .addComponent(lblNumero)
                                    .addComponent(lblColonia))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConfirmar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNumero)
                                        .addComponent(txtCalle)
                                        .addComponent(txtColonia, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblConfirmarContrasena)
                                    .addComponent(lblContrasena))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContrasena)
                                    .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaNacimiento)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblApellidoPaterno)
                                            .addComponent(lblNombre))
                                        .addComponent(lblApellidoMaterno)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellidoPaterno)
                                    .addComponent(txtApellidoMaterno)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3)))))
                .addContainerGap(205, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColonia)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalle)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmarContrasena))
                .addGap(39, 39, 39)
                .addComponent(btnConfirmar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
         if(verificarCamposVacios() == true){
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
         
        else if(verificarContrasena() == true){
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
        else if(clientesDAO.verificarUsuario(txtNombre.getText()) != 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con el siguiente nombre: " + txtNombre.getText() );
        }
        else if(validadores.validarFecha(txtFechaNacimiento.getText()) == false){
             JOptionPane.showMessageDialog(null, "Fomato de Fecha incorrecto, el formato es: yyyy/MM/dd" + txtNombre.getText() );
         }
        
         if(clientesDAO.verificarUsuario(txtNombre.getText()) == 0 && verificarCamposVacios() == false && verificarContrasena() == false && validadores.validarFecha(txtFechaNacimiento.getText()) == true){
             String contrasena = new String(txtContrasena.getPassword());
        if(validadores.validarContrasena(contrasena)){
            guardar();
            dispose();
            reiniciarCampos();
        } else {
             JOptionPane.showMessageDialog(null, "La contraseña debe contener 8 caracteres");
        }
            
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Inicio(clientesDAO).setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblConfirmarContrasena;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
