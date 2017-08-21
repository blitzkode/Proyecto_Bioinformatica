package UI;

import Core.Controlador;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

public class Start extends javax.swing.JFrame {

    Controlador aplicacion;

    PanelSaludo pnl_saludo;
    Wallpaper wall;
    
    Icon tutor_reposo,tutor_feliz[], tutor_animo[];
     
    int t_feliz=1;
    int t_animo=1;
    
    public static AudioClip click, puntero, instrumental, bienvenida;

    public Start() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);

        CargarSonidos();
        pnl_objetos.setOpaque(false);
        setOpaque();
        setWallpaper();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Splash s = new Splash();
                aplicacion = new Controlador();

                s.dispose();
                setVisible(true);
                
                CargarSaludo();
                timer.start();
                
            }
        }).start();

    }

    private void CargarSonidos() {
        click = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Click.wav"));
        puntero = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Rollover.wav"));
        instrumental = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Background.wav"));
        bienvenida = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/tutor_bienvenida.wav"));
    }

    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_salir}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

        btn_sonido.setOpaque(false);
        btn_sonido.setContentAreaFilled(false);
        btn_sonido.setBorderPainted(false);

    }

    Timer timer = new Timer(8000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CargarBotones();
            timer.stop();
        }
    });
    
    
    
    
    private void CargarBotones() {
        
        pnl_saludo.setVisible(false);
        PanelStart pnl_start = new PanelStart(aplicacion, this);
        pnl_start.setSize(724, 464);
        pnl_start.setLocation((getWidth() - pnl_start.getWidth()) / 2,
                (getHeight() - pnl_start.getHeight()) / 2);
        pnl_objetos.add(pnl_start);
        pnl_objetos.repaint();
        instrumental.loop();
        
    }
   
     
    private void CargarSaludo() {
        bienvenida.play();
        pnl_saludo = new PanelSaludo();
        pnl_saludo.setSize(724, 464);
        pnl_saludo.setLocation((getWidth() - pnl_saludo.getWidth()) / 2,
                (getHeight() - pnl_saludo.getHeight()) / 2);
        pnl_objetos.add(pnl_saludo);
        pnl_objetos.repaint();

    }

    private void setWallpaper() {
        wall = new Wallpaper("/Iconos/wall_start.jpg");
        wall.setSize(pnl_fondo.getSize());
        pnl_fondo.add(wall);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fondo = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        btn_sonido = new javax.swing.JToggleButton();
        pnl_objetos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        pnl_fondo.setBackground(new java.awt.Color(24, 234, 63));
        pnl_fondo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnl_fondoComponentResized(evt);
            }
        });

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

        javax.swing.GroupLayout pnl_objetosLayout = new javax.swing.GroupLayout(pnl_objetos);
        pnl_objetos.setLayout(pnl_objetosLayout);
        pnl_objetosLayout.setHorizontalGroup(
            pnl_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        pnl_objetosLayout.setVerticalGroup(
            pnl_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_objetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir))
                .addContainerGap(451, Short.MAX_VALUE))
            .addComponent(pnl_objetos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_sonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sonidoActionPerformed

        if (btn_sonido.isSelected()) {
            instrumental.stop();
        } else {
            instrumental.loop();
        }

    }//GEN-LAST:event_btn_sonidoActionPerformed

    private void btn_sonidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sonidoMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_sonidoMouseEntered

    private void pnl_fondoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_fondoComponentResized
        wall.setSize(pnl_fondo.getSize());
        pnl_objetos.setLocation((getWidth() - pnl_objetos.getWidth()) / 2,
                (getHeight() - pnl_objetos.getHeight()) / 2);
    }//GEN-LAST:event_pnl_fondoComponentResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        wall.setSize(pnl_fondo.getSize());
        pnl_objetos.setLocation((getWidth() - pnl_objetos.getWidth()) / 2,
                (getHeight() - pnl_objetos.getHeight()) / 2);
    }//GEN-LAST:event_formComponentResized

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
    private javax.swing.JButton btn_salir;
    private javax.swing.JToggleButton btn_sonido;
    private javax.swing.JPanel pnl_fondo;
    private javax.swing.JPanel pnl_objetos;
    // End of variables declaration//GEN-END:variables
}
