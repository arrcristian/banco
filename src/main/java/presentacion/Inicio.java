/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;

/**
 *
 * @author Cristian
 */
public class Inicio extends javax.swing.JFrame {

     private final IClientesDAO clientesDAO;
    /**
     * Creates new form Inicio
     */
    public Inicio(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
        initComponents();
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

        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarme = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRegistrarme.setText("Registrarme");
        btnRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarmeActionPerformed(evt);
            }
        });

        btnRetiro.setText("Retiro sin Cuenta");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Seleccione una opción");

        btnSalir.setForeground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir del Sistema");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addComponent(btnRetiro)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRegistrarme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(btnIniciarSesion)
                .addGap(27, 27, 27)
                .addComponent(btnRegistrarme)
                .addGap(30, 30, 30)
                .addComponent(btnRetiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        new IniciarSesion(clientesDAO).setVisible(true);
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        // TODO add your handling code here:
        new Registro(clientesDAO).setVisible(true);
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btnRetiroActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
