/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Controlador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Start extends javax.swing.JFrame {

    Controlador aplicacion;
    
     
    ImageIcon img1;
    Icon icon;
    
    public Start() {
        initComponents();
        setLocationRelativeTo(null);
        btn_entrenar.setVisible(false);
        setOpaque();
        cargarLogo();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                Splash s = new Splash();
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                aplicacion = new Controlador();
                s.dispose();
                setVisible(true);
            }
        }).start();
    }

    private void setOpaque(){
        
        btn_practicar.setOpaque(false);
        btn_practicar.setContentAreaFilled(false);
        btn_practicar.setBorderPainted(false);
        
        btn_reto.setOpaque(false);
        btn_reto.setContentAreaFilled(false);
        btn_reto.setBorderPainted(false);
        
        btn_salir.setOpaque(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setBorderPainted(false);
    }
    
    private void cargarLogo(){
        img1 = new ImageIcon(getClass().getResource("/Iconos/logo Scribe.png"));
        icon = new ImageIcon(img1.getImage().getScaledInstance(txt_logo.getWidth(), txt_logo.getHeight(), Image.SCALE_DEFAULT));
        txt_logo.setIcon(icon);
        
        img1 = new ImageIcon(getClass().getResource("/Iconos/wall_start.jpg"));
        icon = new ImageIcon(img1.getImage().getScaledInstance(txt_wallpaper.getWidth(), txt_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        txt_wallpaper.setIcon(icon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        btn_entrenar = new javax.swing.JButton();
        txt_logo = new javax.swing.JLabel();
        txt_wallpaper = new javax.swing.JLabel();
        btn_reto = new javax.swing.JButton();
        btn_practicar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_2.png"))); // NOI18N
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_1.png"))); // NOI18N
        btn_salir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_3.png"))); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_entrenar.setText("entrenamiento");
        btn_entrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrenarActionPerformed(evt);
            }
        });

        btn_reto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_2.png"))); // NOI18N
        btn_reto.setToolTipText("Jugar");
        btn_reto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_1.png"))); // NOI18N
        btn_reto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_3.png"))); // NOI18N
        btn_reto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retoActionPerformed(evt);
            }
        });

        btn_practicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_2.png"))); // NOI18N
        btn_practicar.setToolTipText("Practicar");
        btn_practicar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_1.png"))); // NOI18N
        btn_practicar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btn_entrenar))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(btn_reto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txt_wallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(btn_salir))
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(btn_entrenar))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btn_reto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txt_wallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_retoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retoActionPerformed
        setVisible(false);
        new Principal(aplicacion, this);
        
    }//GEN-LAST:event_btn_retoActionPerformed

    private void btn_entrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrenarActionPerformed
       setVisible(false);
       new Mantenimiento(aplicacion, this).setVisible(true);
        
    }//GEN-LAST:event_btn_entrenarActionPerformed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrenar;
    private javax.swing.JButton btn_practicar;
    private javax.swing.JButton btn_reto;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel txt_logo;
    private javax.swing.JLabel txt_wallpaper;
    // End of variables declaration//GEN-END:variables
}
