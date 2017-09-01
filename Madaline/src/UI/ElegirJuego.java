package UI;

import Core.Controlador;
import javax.swing.JButton;
import static UI.Start.click;
import static UI.Start.puntero;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ElegirJuego extends javax.swing.JFrame {

    Controlador aplicacion;
    javax.swing.JFrame padre;
    Wallpaper wall, texto_jugar;

    public ElegirJuego(javax.swing.JFrame padre, Controlador aplicacion) {
        initComponents();
        maximizar();
        
        this.padre = padre;
        this.aplicacion = aplicacion;
        
        setOpaque();
        setWallpaper();
        setwhitepanel();

    }
    
    private void maximizar() {
        if (System.getProperty("os.name").equals("Linux")) { 
            // Maximizar ventana en linux
            Toolkit tk = Toolkit.getDefaultToolkit();  
            int xSize = ((int) tk.getScreenSize().getWidth());  
            int ySize = ((int) tk.getScreenSize().getHeight());  
            setSize(xSize,ySize);            
        }
        else {
            setExtendedState(MAXIMIZED_BOTH);
        }
    }

    private void setWallpaper() {
        wall = new Wallpaper("/Iconos/wallpaper_elegir.gif", pnl_fondo);
        texto_jugar = new Wallpaper("/Iconos/texto_juegos.png", pnl_texto, true);
    }

    private void setwhitepanel() {

        for (JPanel panel : new JPanel[]{pnl_botones,pnl_texto}) {

            panel.setOpaque(false);
        }
    }

    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_facil, btn_normal}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fondo = new javax.swing.JPanel();
        pnl_texto = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        btn_facil = new javax.swing.JButton();
        btn_normal = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        pnl_fondo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnl_fondoComponentResized(evt);
            }
        });

        pnl_texto.setBackground(new java.awt.Color(26, 26, 206));

        pnl_botones.setBackground(new java.awt.Color(37, 176, 145));
        pnl_botones.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnl_botonesComponentResized(evt);
            }
        });

        btn_facil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_2.png"))); // NOI18N
        btn_facil.setAlignmentY(0.0F);
        btn_facil.setAutoscrolls(true);
        btn_facil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_1.png"))); // NOI18N
        btn_facil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/facil_1.png"))); // NOI18N
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
        btn_normal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/normal_1.png"))); // NOI18N
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
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btn_facil, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(btn_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_facil)
                    .addComponent(btn_normal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_textoLayout = new javax.swing.GroupLayout(pnl_texto);
        pnl_texto.setLayout(pnl_textoLayout);
        pnl_textoLayout.setHorizontalGroup(
            pnl_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_textoLayout.setVerticalGroup(
            pnl_textoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_textoLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        btn_volver.setText("Atras");
        btn_volver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnl_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addComponent(pnl_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        pnl_texto.setLocation((pnl_fondo.getWidth() - pnl_texto.getWidth()) / 2,
                (pnl_fondo.getHeight() - pnl_texto.getHeight()) / 2);

    }//GEN-LAST:event_formComponentResized

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        pnl_texto.setLocation((pnl_fondo.getWidth() - pnl_texto.getWidth()) / 2,
                (pnl_fondo.getHeight() - pnl_texto.getHeight()) / 2);
        pnl_botones.setLocation((pnl_texto.getWidth() - pnl_botones.getWidth()) / 2,
                (pnl_texto.getHeight() - pnl_botones.getHeight()) / 2);
    }

    private void btn_facilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_facilMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_facilMouseEntered

    private void btn_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facilActionPerformed
        click.play();
        new Jugar(aplicacion, this);
        setVisible(false);
    }//GEN-LAST:event_btn_facilActionPerformed

    private void btn_normalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_normalMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_normalMouseEntered

    private void btn_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_normalActionPerformed
        click.play();
        new Practicar(aplicacion, this);
        setVisible(false);
    }//GEN-LAST:event_btn_normalActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void pnl_fondoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_fondoComponentResized
        pnl_botones.setLocation((pnl_texto.getWidth() - pnl_botones.getWidth()) / 2,
                (pnl_texto.getHeight() - pnl_botones.getHeight()) / 2);
        pnl_texto.setLocation((pnl_fondo.getWidth() - pnl_texto.getWidth()) / 2,
                (pnl_fondo.getHeight() - pnl_texto.getHeight()) / 2);
    }//GEN-LAST:event_pnl_fondoComponentResized

    private void pnl_botonesComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_botonesComponentResized

    }//GEN-LAST:event_pnl_botonesComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_facil;
    private javax.swing.JButton btn_normal;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_fondo;
    private javax.swing.JPanel pnl_texto;
    // End of variables declaration//GEN-END:variables
}
