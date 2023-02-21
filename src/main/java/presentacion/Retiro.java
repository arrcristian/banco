/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Cristian
 */
public class Retiro extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final Cliente cliente;
    /**
     * Creates new form Retiro
     */
    public Retiro(IClientesDAO clientesDAO,ICuentasDAO cuentasDAO,Cliente cliente) {
        this.setTitle("Retiro");
        this.cliente = cliente;
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        initComponents();
        //this.txtMonto.setText(this.clientesDAO.);
//        this.txtMonto.setText("$200");
//        txtMonto.setEditable(false);
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFolio = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        txtFolio = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        lblRetiro = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFolio.setText("Folio");

        lblContrasena.setText("Contraseña");

        lblMonto.setText("Monto");

        btnAceptar.setText("Aceptar");

        lblRetiro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRetiro.setText("Retiro");

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
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMonto)
                    .addComponent(lblContrasena)
                    .addComponent(lblFolio))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContrasena)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFolio))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGap(89, 89, 89)
                        .addComponent(lblRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRetiro)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFolio)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnAceptar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
        new Inicio(clientesDAO,cuentasDAO,cliente).setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblRetiro;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
