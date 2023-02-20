package presentacion;

import cifrados.CifrarContrasena;
import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validadores.Validadores;

/**
 *
 * @author Cristian
 */
public class Registro extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(Registro.class.getName());
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final Validadores validadores = new Validadores();
    /**
     * Creates new form Registro
     */
    public Registro(IClientesDAO clientesDAO,ICuentasDAO cuentasDAO) {
        this.setTitle("Registro");
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        initComponents();
        txtFechaNacimiento.getDateEditor().setEnabled(false);
        this.setLocationRelativeTo(null);
        setResizable(false);
    }
    
 
    public Cliente extraerDatosFormulario() {
        
        String contraseña = new String(txtContrasena.getPassword());
        String nuevaContraseña = CifrarContrasena.md5(contraseña);
        String nombre = this.txtNombre.getText();
        String apellido_paterno = this.txtApellidoPaterno.getText();
        String apellido_materno = this.txtApellidoMaterno.getText();
        String calle = this.txtCalle.getText();
        String colonia = this.txtColonia.getText();
        String numeroCasa = this.txtNumero.getText();
        String fecha_nacimiento = ((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText();
        int edad = calcularEdad(fecha_nacimiento);
        Cliente cliente = new Cliente(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, colonia, calle, numeroCasa, nuevaContraseña, edad);
        return cliente;
        
    }
    public boolean verificarEdad(){
        if (extraerDatosFormulario().edad >= 18) {
            return true;

        } else {
            return false;
        }
    }
    
    public int calcularEdad(String fechaNacimiento) {
         LocalDate fechaNac = LocalDate.parse(((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText());
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
        confirmarContraseña.equals("") || ((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText().equals("") ||
        txtApellidoMaterno.equals("") || txtApellidoPaterno.equals("") ||
        txtCalle.equals("") || txtColonia.equals("") || txtNumero.equals("")){
            return true;
        } 
        return false;
    }
    
    public void reiniciarCampos(){
        txtConfirmarContrasena.setText("");
        txtContrasena.setText("");
        ((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtNumero.setText("");

    }
    
    public boolean validarDatos(){
         if(verificarCamposVacios() == true){
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
         else if(validadores.validarNumeroCasa(txtNumero.getText()) == false){
              JOptionPane.showMessageDialog(null, "El número de casa debe contener 5 digitos");
         }
         else if(verificarEdad() == false){
             JOptionPane.showMessageDialog(this, "Registro cancelado, aún eres menor de 18 años"); 
         }
         
        else if(verificarContrasena() == true){
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
        else if(clientesDAO.verificarUsuario(txtNombre.getText()) != 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con el siguiente nombre: " + txtNombre.getText() );
        }
        else if(validadores.validarFecha(((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText()) == false){
             JOptionPane.showMessageDialog(null, "Fomato de Fecha incorrecto, el formato es: yyyy/MM/dd" + txtNombre.getText() );
         }
        
         if(clientesDAO.verificarUsuario(txtNombre.getText()) == 0 && verificarCamposVacios() == false && verificarContrasena() == false && validadores.validarFecha(((JTextField)this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText()) == true
               && validadores.validarNumeroCasa(txtNumero.getText()) == true && verificarEdad() == true){
             String contrasena = new String(txtContrasena.getPassword());
        if(validadores.validarContrasena(contrasena)){
            return true;
        } else {
             JOptionPane.showMessageDialog(null, "La contraseña debe contener 8 caracteres");
        }
            
         }
         return false;
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblContrasena.setText("Contraseña");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Registro");

        lblConfirmarContrasena.setText("Confirmar Contraseña");

        lblNombre.setText("Nombre(s)");

        lblApellidoPaterno.setText("Apellido Paterno");

        lblApellidoMaterno.setText("Apellido Materno");

        lblCalle.setText("Calle");

        lblNumero.setText("Número");

        lblColonia.setText("Colonia");

        lblFechaNacimiento.setText("Fecha de Nacimiento");

        btnRegresar.setText("⬅ Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumero)
                                    .addComponent(txtCalle)
                                    .addComponent(txtColonia, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnConfirmar))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblConfirmarContrasena)
                                    .addComponent(lblContrasena))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
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
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtApellidoPaterno)
                                    .addComponent(txtApellidoMaterno)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnRegresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmarContrasena))
                .addGap(40, 40, 40)
                .addComponent(btnConfirmar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        
        if(validarDatos()){
            guardar();
            dispose();
            reiniciarCampos();
            new Inicio(clientesDAO,cuentasDAO).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Inicio(clientesDAO,cuentasDAO).setVisible(true);
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
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
