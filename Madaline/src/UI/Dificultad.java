/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JButton;
import static UI.Start.click;
import static UI.Start.puntero;

/**
 *
 * @author Diego Baes
 */
public class Dificultad extends javax.swing.JDialog {
    Principal parent;
    
    public Dificultad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.parent = (Principal) parent;
        setWallpaper();
        setOpaque();
        setResizable(false);
        setLocationRelativeTo(null);
        
    }   

    private void setWallpaper(){
        Wallpaper wall = new Wallpaper("/Iconos/wall_dificultad.jpg");
        wall.setSize(pnl_fondo.getSize());
        pnl_fondo.add(wall);
    }
    
    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_facil,btn_normal,btn_dificil}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        pnl_fondo = new javax.swing.JPanel();
        btn_facil = new javax.swing.JButton();
        btn_normal = new javax.swing.JButton();
        btn_dificil = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setAlwaysOnTop(true);
        setUndecorated(true);

        pnl_fondo.setBackground(new java.awt.Color(134, 234, 31));

        btn_facil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_2.png"))); // NOI18N
        btn_facil.setAlignmentY(0.0F);
        btn_facil.setAutoscrolls(true);
        btn_facil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_1.png"))); // NOI18N
        btn_facil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_3.png"))); // NOI18N
        btn_facil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_facilMouseEntered(evt);
            }
        });
        btn_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facilActionPerformed(evt);
            }
        });

        btn_normal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/normal_2.png"))); // NOI18N
        btn_normal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/normal_1.png"))); // NOI18N
        btn_normal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/normal_3.png"))); // NOI18N
        btn_normal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_normalMouseEntered(evt);
            }
        });
        btn_normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_normalActionPerformed(evt);
            }
        });

        btn_dificil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dificil_2.png"))); // NOI18N
        btn_dificil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dificil_1.png"))); // NOI18N
        btn_dificil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dificil_3.png"))); // NOI18N
        btn_dificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dificilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_dificil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_facil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(172, 172, 172))
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(btn_facil, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dificil, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facilActionPerformed
        click.play();
        this.parent.modo_juego = 0;
        setVisible(false);
    }//GEN-LAST:event_btn_facilActionPerformed

    private void btn_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_normalActionPerformed
        click.play();
        this.parent.modo_juego = 1;
        setVisible(false);
    }//GEN-LAST:event_btn_normalActionPerformed

    private void btn_dificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dificilActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btn_dificilActionPerformed

    private void btn_facilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_facilMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_facilMouseEntered

    private void btn_normalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_normalMouseEntered
      puntero.play();
    }//GEN-LAST:event_btn_normalMouseEntered

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
            java.util.logging.Logger.getLogger(Dificultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dificultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dificultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dificultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dificultad dialog = new Dificultad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dificil;
    private javax.swing.JButton btn_facil;
    private javax.swing.JButton btn_normal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel pnl_fondo;
    // End of variables declaration//GEN-END:variables
}
