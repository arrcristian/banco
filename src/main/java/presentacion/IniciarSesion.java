/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import cifrados.CifrarContrasena;
import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class IniciarSesion extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion(IClientesDAO clientesDAO) {
        this.setTitle("Iniciar Sesión");
        this.clientesDAO = clientesDAO;
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
  
    }
    
    private Cliente extraerDatosFormulario() {
        
        String contraseña = new String(txtContrasena.getPassword());
        int id = Integer.parseInt(txtId.getText());
        String nuevaContraseña = CifrarContrasena.md5(contraseña);
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setContraseña(nuevaContraseña);
        return cliente;

    }
    
    public boolean inicioSesion(){
        
        try {
            Cliente cliente = this.extraerDatosFormulario();
            if(clientesDAO.iniciarSesion(cliente) == true){
                return true;
            } else {
                  return false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar de sesión");
 
        }
               return false;
    }
    
    private boolean verificarContrasena(){
        try {
        String contraseña = new String(txtContrasena.getPassword());
        String nuevaContraseña = CifrarContrasena.md5(contraseña);
        Cliente cliente = new Cliente();
        cliente.setContraseña(nuevaContraseña);
        return true;

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al iniciar de sesión contraseña");
            return false;
        }

    }
    private boolean verificarCamposVacios() {
        
        String contraseña = new String(txtContrasena.getPassword());
//        String confirmarContraseña = new String(txtConfirmarContraseña.getPassword());
        if(txtId.getText().equals("") || contraseña.equals("")){
            return false;
        } 
        return true;
    }
    
    public void reiniciarCampos(){
        txtContrasena.setText("");
        txtId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Inicia Sesión");

        lblUsuario.setText("ID");

        lblContrasena.setText("Contraseña");

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRegresar.setText("⬅ Regresar");
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
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario)
                            .addComponent(lblContrasena))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(btnIniciarSesion))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(btnIniciarSesion)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        if(verificarCamposVacios() == false){
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
        else if(verificarContrasena() == false){
             JOptionPane.showMessageDialog(null, "Error al iniciar de sesión contraseña");
        }
  
        if(verificarCamposVacios() == true && verificarContrasena() == true && verificarCamposVacios() == true && inicioSesion() == true){
           inicioSesion();
           dispose();
           reiniciarCampos();
//           JOptionPane.showMessageDialog(null, "Has ingresado al sistema");
           new Cuenta(clientesDAO).setVisible(true);
        } else {
                 JOptionPane.showMessageDialog(null, "Error al iniciar, datos incorrectos");
            }
                
  
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Inicio(clientesDAO).setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
