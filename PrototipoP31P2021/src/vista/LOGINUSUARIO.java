/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import dominio.Hash;
import dominio.SqlUsuarios;
import dominio.Usuarios;

/**
 *
 * @author leone
 */
public class LOGINUSUARIO extends javax.swing.JFrame {
        private CONTENEDOR_MDI formMDI;

    public LOGINUSUARIO() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(0, 0, 102));
        panel1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");

        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
                SqlUsuarios loginDAO = new SqlUsuarios();
                Usuarios loginConsulta = new Usuarios();
                loginConsulta.setId(Integer.parseInt(txtUsuario.getText()));
                loginConsulta = loginDAO.query(loginConsulta);
                String pass = new String(txtPassword.getPassword());
                String nuevoPass = Hash.sha1(pass);//ENCRIPTAMOS LAS CONTRASE??A
        
        if (nuevoPass.equals(loginConsulta.getPassword())) {
           formMDI = new CONTENEDOR_MDI();
            formMDI.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed
    
    private void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LOGINUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGINUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGINUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGINUSUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGINUSUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Panel panel1;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
