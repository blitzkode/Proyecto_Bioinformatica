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
import java.applet.AudioClip;
import javax.swing.JButton;

public class Start extends javax.swing.JFrame {

    Controlador aplicacion;
    
    public static AudioClip click, puntero, instrumental;
    ImageIcon img1;
    Icon icon;
    
    public Start() {
        initComponents();
        setLocationRelativeTo(null);
        
        CargarSonidos();
        
        setOpaque();
        setWallpaper();
        cargarLogo();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                Splash s = new Splash();
                aplicacion = new Controlador();
                
                s.dispose();
                setVisible(true);
                instrumental.loop();
            }
        }).start();
        
    }
    
     
    private void CargarSonidos(){
        click = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Click.wav"));
        puntero = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Rollover.wav"));
        instrumental = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Background.wav"));
    }

    private void setOpaque(){
        
        for (JButton boton : new JButton[]{btn_practicar,btn_reto,btn_salir}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }
        
        btn_sonido.setOpaque(false);
        btn_sonido.setContentAreaFilled(false);
        btn_sonido.setBorderPainted(false);
        
    }
    
    private void cargarLogo(){
        img1 = new ImageIcon(getClass().getResource("/Iconos/logo Scribe.png"));
        icon = new ImageIcon(img1.getImage().getScaledInstance(txt_logo.getWidth(), txt_logo.getHeight(), Image.SCALE_DEFAULT));
        txt_logo.setIcon(icon);
    }
    
    
    private void setWallpaper(){
        Wallpaper wall = new Wallpaper("/Iconos/wall_start.jpg");
        wall.setSize(pnl_fondo.getSize());
        pnl_fondo.add(wall);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fondo = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        txt_logo = new javax.swing.JLabel();
        btn_reto = new javax.swing.JButton();
        btn_practicar = new javax.swing.JButton();
        btn_sonido = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_fondo.setBackground(new java.awt.Color(24, 234, 63));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/x_1.png"))); // NOI18N
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/x_2.png"))); // NOI18N
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salirMouseEntered(evt);
            }
        });
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        txt_logo.setBackground(new java.awt.Color(3, 46, 178));

        btn_reto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_2.png"))); // NOI18N
        btn_reto.setToolTipText("Jugar");
        btn_reto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_1.png"))); // NOI18N
        btn_reto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/jugar_3.png"))); // NOI18N
        btn_reto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_retoMouseEntered(evt);
            }
        });
        btn_reto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retoActionPerformed(evt);
            }
        });

        btn_practicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_2.png"))); // NOI18N
        btn_practicar.setToolTipText("Practicar");
        btn_practicar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_1.png"))); // NOI18N
        btn_practicar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/practicar_3.png"))); // NOI18N
        btn_practicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_practicarMouseEntered(evt);
            }
        });
        btn_practicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_practicarActionPerformed(evt);
            }
        });

        btn_sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sound_1.png"))); // NOI18N
        btn_sonido.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sound_2.png"))); // NOI18N
        btn_sonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sonidoMouseEntered(evt);
            }
        });
        btn_sonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sonidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_reto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_retoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retoActionPerformed
        click.play();
        setVisible(false);
        
        new Jugar(aplicacion, this);
       
    }//GEN-LAST:event_btn_retoActionPerformed

    private void btn_practicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_practicarActionPerformed
        click.play();
        setVisible(false);
        
        new Practicar(aplicacion, this);
    }//GEN-LAST:event_btn_practicarActionPerformed

    private void btn_retoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_retoMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_retoMouseEntered

    private void btn_practicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_practicarMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_practicarMouseEntered

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_sonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sonidoActionPerformed
     
        if (btn_sonido.isSelected()) {
            instrumental.stop();
        } else{ 
            instrumental.loop();
        }
        
    }//GEN-LAST:event_btn_sonidoActionPerformed

    private void btn_sonidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sonidoMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_sonidoMouseEntered

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
    private javax.swing.JButton btn_practicar;
    private javax.swing.JButton btn_reto;
    private javax.swing.JButton btn_salir;
    private javax.swing.JToggleButton btn_sonido;
    private javax.swing.JPanel pnl_fondo;
    private javax.swing.JLabel txt_logo;
    // End of variables declaration//GEN-END:variables
}
