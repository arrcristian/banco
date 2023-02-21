/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import dominio.Transferencia;

/**
 *
 * @author Cristian
 */
public class TransferenciaForm extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private Cliente cliente;
    /**
     * Creates new form Transferencia
     */
    public TransferenciaForm(IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, Cliente cliente) {
        this.cliente = cliente;
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }
    
      public Transferencia extraerDatosTransferencia() throws PersistenciaException {
        float monto = Float.parseFloat(txtMonto.getText());
        String fechaActual = LocalDateTime.now().toString();
        int cuentaDestino = Integer.parseInt(txtCuentaDestino.getText());
        Transferencia transferencia = new Transferencia(fechaActual, monto, 134, cuentaDestino);
        return transferencia;
       
    }
       public void transferir(){
            try {
            Transferencia transferencia = this.extraerDatosTransferencia();
            this.cuentasDAO.transferir(transferencia);
            JOptionPane.showMessageDialog(null, "Transferencia realizada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error no se realizó la transferencia");
        }
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTransferencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbCuenta = new javax.swing.JComboBox<>();
        txtCuentaDestino = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTransferencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTransferencia.setText("Transferencia");

        jLabel1.setText("Cuenta");

        jLabel2.setText("Monto");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel3.setText("Cuenta Destino");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuentaDestino)
                            .addComponent(txtMonto)
                            .addComponent(cbCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAceptar)
                            .addComponent(lblTransferencia))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransferencia)
                    .addComponent(btnRegresar))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnAceptar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        transferir();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Sesión s = new Sesión(clientesDAO, cuentasDAO, cliente);
        dispose();
        s.setVisible(true);
        Sesión.txtCliente.setText(IniciarSesion.txtId.getText());
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTransferencia;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
