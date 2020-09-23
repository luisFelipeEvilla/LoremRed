/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MathUtils;

/**
 *
 * @author Usuario
 */
public class Launcher extends javax.swing.JFrame {

    /**
     * Creates new form Launcher
     */
    public Launcher() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        panelInicio.setVisible(false);
    }

    public void animar() {
        float longitudActual = logo.getWidth();
        float longitudInterpolada = longitudActual;
        int longitudFinal = (int) (longitudActual / 2);
        while (longitudInterpolada > longitudFinal) {
            if (longitudActual > longitudFinal) {
                longitudActual -= 3;
            }
            /*else {
                longitudActual = longitudFinal;
            }*/
            longitudInterpolada = MathUtils.lerp(longitudInterpolada, longitudActual, 0.01f);
            logo.setPreferredSize(new Dimension(Math.round(longitudInterpolada), logo.getHeight()));
            logo.revalidate();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
            panelInicio.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelInicio = new Interfaz.PanelInicio();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setBackground(new java.awt.Color(0, 0, 0));
        logo.setPreferredSize(new java.awt.Dimension(1000, 500));
        logo.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Recursos/32c864c9-9f39-40a3-863d-cdc9e1a07d43_200x200.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 500));
        logo.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInicio.setMinimumSize(new java.awt.Dimension(500, 500));
        panelInicio.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 300, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo;
    private Interfaz.PanelInicio panelInicio;
    // End of variables declaration//GEN-END:variables
}
