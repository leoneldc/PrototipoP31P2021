/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.SedesDAO;
import dominio.Sedes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leone
 */
public class Mantenimiento_Sedes extends javax.swing.JInternalFrame {
DefaultTableModel modelo1; 
    /**
     * Creates new form Mantenimiento_Sedes
     */
    public Mantenimiento_Sedes() {
        initComponents();
        limpio.setVisible(false);
        modelo1=new DefaultTableModel();   //ASIGNAMOS UN NUEVO DEFAULTABLEMODEL AL OBJETO MODELO1
        modelo1.addColumn("CODIGO");      //LE AÑADIMOS COLUMNAS AL OBJETO MODELO
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("ESTADO");
        tabla1.setModel(modelo1);
        String datos[]= new String[3];
        SedesDAO dao = new  SedesDAO();
        List<Sedes> sedes = dao.select();
        for (Sedes sede : sedes) {       
               datos[0]=sede.getCodigo();
               datos[1]=sede.getNombre();
               datos[2]=sede.getEstatus();
               modelo1.addRow(datos);
               tabla1.setModel(modelo1);
               }
    }
    public void limpiar() {
        txt_codigo.setText("");
        txt_nombre.setText("");
        activo.setSelected(false);
        inactivo.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ESTADO = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        limpio = new javax.swing.JRadioButton();
        btn_buscar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        jLabel4.setText("CODIGO:");

        jLabel5.setText("NOMBRE:");

        jLabel6.setText("ESTATUS:");

        ESTADO.add(activo);
        activo.setText("ACTIVO");

        ESTADO.add(inactivo);
        inactivo.setText("INACTIVO");

        ESTADO.add(limpio);

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(activo)
                                .addGap(18, 18, 18)
                                .addComponent(inactivo)
                                .addGap(18, 18, 18)
                                .addComponent(limpio))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_nombre)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_guardar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(activo)
                        .addComponent(inactivo)
                        .addComponent(limpio)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
                
                SedesDAO sedesDAO = new SedesDAO();
                Sedes sedeConsultar = new Sedes();
                sedeConsultar.setCodigo(txt_codigo.getText());
                sedeConsultar = sedesDAO.query(sedeConsultar);
                txt_nombre.setText(sedeConsultar.getNombre());
                if ("1".equals(sedeConsultar.getEstatus()) ) {
                activo.setSelected(true);
                }
                if ("0".equals(sedeConsultar.getEstatus())) {
                inactivo.setSelected(true);
                }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

            if (txt_codigo.getText().length() != 0&&txt_nombre.getText().length() != 0&&activo.isSelected()||inactivo.isSelected()) {
            SedesDAO sedesDAO = new SedesDAO();
            Sedes sedeInsertar = new Sedes();
            sedeInsertar.setCodigo(txt_codigo.getText());
            sedeInsertar.setNombre(txt_nombre.getText());
            if (activo.isSelected()) {
            sedeInsertar.setEstatus("1");
            }
            if (inactivo.isSelected()) {
            sedeInsertar.setEstatus("0");
            }
            sedesDAO.insert(sedeInsertar);
            JOptionPane.showMessageDialog(null, "Modulo registrado correctamente");
            }
            
 /*-----------------------------------------------------------------------------------------------*/
            
            modelo1=new DefaultTableModel();   //ASIGNAMOS UN NUEVO DEFAULTABLEMODEL AL OBJETO MODELO1
        modelo1.addColumn("CODIGO");      //LE AÑADIMOS COLUMNAS AL OBJETO MODELO
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("ESTADO");
        tabla1.setModel(modelo1);
        String datos[]= new String[3];
        SedesDAO dao = new  SedesDAO();
        List<Sedes> sedes = dao.select();
        for (Sedes sede : sedes) {       
               datos[0]=sede.getCodigo();
               datos[1]=sede.getNombre();
               datos[2]=sede.getEstatus();
               modelo1.addRow(datos);
               tabla1.setModel(modelo1);
               }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Sedes sedesEliminar = new Sedes();
        SedesDAO sedesDAO = new SedesDAO();
        sedesEliminar.setCodigo(txt_codigo.getText());
        sedesDAO.delete(sedesEliminar);
        JOptionPane.showMessageDialog(null, "Perfil Eliminado.");    
        
 /*-----------------------------------------------------------------------------------------------*/
            
            modelo1=new DefaultTableModel();   //ASIGNAMOS UN NUEVO DEFAULTABLEMODEL AL OBJETO MODELO1
        modelo1.addColumn("CODIGO");      //LE AÑADIMOS COLUMNAS AL OBJETO MODELO
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("ESTADO");
        tabla1.setModel(modelo1);
        String datos[]= new String[3];
        SedesDAO dao = new  SedesDAO();
        List<Sedes> sedes = dao.select();
        for (Sedes sede : sedes) {       
               datos[0]=sede.getCodigo();
               datos[1]=sede.getNombre();
               datos[2]=sede.getEstatus();
               modelo1.addRow(datos);
               tabla1.setModel(modelo1);
               }
                limpiar();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        SedesDAO sedesDAO = new SedesDAO();
        Sedes sedeActualizar = new Sedes();
        sedeActualizar.setCodigo(txt_codigo.getText());
        sedeActualizar.setNombre(txt_nombre.getText());
        if (activo.isSelected()) {
            sedeActualizar.setEstatus("1");
            }
            if (inactivo.isSelected()) {
            sedeActualizar.setEstatus("0");
           }
        sedesDAO.update(sedeActualizar);
        JOptionPane.showMessageDialog(null, "Modulo actualizado correctamente");
        
 /*-----------------------------------------------------------------------------------------------*/
            
            modelo1=new DefaultTableModel();   //ASIGNAMOS UN NUEVO DEFAULTABLEMODEL AL OBJETO MODELO1
        modelo1.addColumn("CODIGO");      //LE AÑADIMOS COLUMNAS AL OBJETO MODELO
        modelo1.addColumn("NOMBRE");
        modelo1.addColumn("ESTADO");
        tabla1.setModel(modelo1);
        String datos[]= new String[3];
        SedesDAO dao = new  SedesDAO();
        List<Sedes> sedes = dao.select();
        for (Sedes sede : sedes) {       
               datos[0]=sede.getCodigo();
               datos[1]=sede.getNombre();
               datos[2]=sede.getEstatus();
               modelo1.addRow(datos);
               tabla1.setModel(modelo1);
               }
                limpiar();
    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ESTADO;
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton limpio;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
