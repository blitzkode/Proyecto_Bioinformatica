
package UI;

import javax.swing.JButton;
import static UI.Start.click;
import static UI.Start.puntero;


public class ElegirJuego extends javax.swing.JFrame {

    Principal parent;
    public ElegirJuego(Principal parent) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.parent = parent;
        setOpaque();
        setWallpaper();

    }
    
     private void setWallpaper(){
        Wallpaper wall = new Wallpaper("/Iconos/wall_dificultad.jpg");
        wall.setSize(pnl_fondo.getSize());
        pnl_fondo.add(wall);
    }
    
    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_facil,btn_normal}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fondo = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        btn_practicar = new javax.swing.JButton();
        btn_facil = new javax.swing.JButton();
        btn_normal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        btn_practicar.setText("PRACTICAR");

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

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btn_facil, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btn_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_facil)
                    .addComponent(btn_normal)
                    .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
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

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
         pnl_botones.setLocation((getWidth() - pnl_botones.getWidth()) / 2,
                (getHeight() - pnl_botones.getHeight()) / 2);
    }//GEN-LAST:event_formComponentResized

    private void btn_facilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_facilMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_facilMouseEntered

    private void btn_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facilActionPerformed
        click.play();
//        this.parent.modo_juego = 0;
        setVisible(false);
    }//GEN-LAST:event_btn_facilActionPerformed

    private void btn_normalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_normalMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_normalMouseEntered

    private void btn_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_normalActionPerformed
        click.play();
//        this.parent.modo_juego = 1;
        setVisible(false);
    }//GEN-LAST:event_btn_normalActionPerformed

//    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ElegirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ElegirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ElegirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ElegirJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ElegirJuego().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_facil;
    private javax.swing.JButton btn_normal;
    private javax.swing.JButton btn_practicar;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_fondo;
    // End of variables declaration//GEN-END:variables
}
