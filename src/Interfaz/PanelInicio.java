/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class PanelInicio extends javax.swing.JPanel {

    Color defaultColor = new Color(153, 153, 153);

    public PanelInicio() {
        initComponents();
        usuario.setForeground(defaultColor);
    }

    public void cambiar() {
        CardLayout cl = (CardLayout) getLayout();
        cl.next(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        ingreso = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        registro = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setLayout(new java.awt.CardLayout());

        ingreso.setBackground(new java.awt.Color(255, 255, 255));
        ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ingreso.setMaximumSize(new java.awt.Dimension(500, 500));
        ingreso.setMinimumSize(new java.awt.Dimension(500, 500));
        ingreso.setPreferredSize(new java.awt.Dimension(500, 500));
        ingreso.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INICIAR SESION");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(180, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        ingreso.add(jButton1, gridBagConstraints);

        usuario.setColumns(20);
        usuario.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(153, 153, 153));
        usuario.setText("Usuario");
        usuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        usuario.setOpaque(false);
        usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuarioFocusLost(evt);
            }
        });
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 41, 0);
        ingreso.add(usuario, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("¿Aun no tienes cuenta?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        ingreso.add(jLabel4, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("INICIAR SESION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 45, 0);
        ingreso.add(jLabel2, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Recursos/user.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 26, 4);
        ingreso.add(jLabel5, gridBagConstraints);

        add(ingreso, "ingreso");

        registro.setBackground(new java.awt.Color(51, 255, 51));

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        add(registro, "registro");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cambiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        cambiar();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked

    }//GEN-LAST:event_usuarioMouseClicked

    private void usuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioFocusLost
        if ("".equals(usuario.getText())) {
            usuario.setForeground(defaultColor);
            usuario.setText("Usuario");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioFocusLost

    private void usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMousePressed
        if ("Usuario".equals(usuario.getText()) && defaultColor.equals(usuario.getForeground())) {
            //usuario.setCaretPosition(0);
            usuario.setText("");
            usuario.setForeground(new Color(51, 51, 51));
        }
    }//GEN-LAST:event_usuarioMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ingreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel registro;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
