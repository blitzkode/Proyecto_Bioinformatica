
package UI;

import Core.Controlador;
import javax.swing.JButton;
import static UI.Start.click;
import static UI.Start.puntero;


public class ElegirJuego extends javax.swing.JFrame {
    Controlador aplicacion;
    javax.swing.JFrame padre;
    
    public ElegirJuego(javax.swing.JFrame padre, Controlador aplicacion) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        this.padre = padre;
        this.aplicacion = aplicacion;
        
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
        btn_facil = new javax.swing.JButton();
        btn_normal = new javax.swing.JButton();
        btn_practicar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        pnl_botones.setBackground(new java.awt.Color(37, 176, 145));

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

        btn_practicar.setText("PRACTICAR");

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_facil, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btn_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_facil)
                    .addComponent(btn_normal)
                    .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_volver.setText("volver al futuro");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_facil;
    private javax.swing.JButton btn_normal;
    private javax.swing.JButton btn_practicar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_fondo;
    // End of variables declaration//GEN-END:variables
}
