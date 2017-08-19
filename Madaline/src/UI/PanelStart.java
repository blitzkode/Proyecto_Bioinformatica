package UI;

import Core.Controlador;
import static UI.Start.click;
import static UI.Start.puntero;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class PanelStart extends javax.swing.JPanel {
    
    Controlador aplicacion;
    Start start;
    
    ImageIcon img1;
    Icon icon;
   
    public PanelStart(Controlador aplicacion, Start start) {
        this.aplicacion=aplicacion;
        this.start=start;
        initComponents();
        setOpaque(false);
        cargarLogo();
        setOpaque();
    }
    
    private void cargarLogo(){
        txt_logo.setSize(689, 329);
        img1 = new ImageIcon(getClass().getResource("/Iconos/logo Scribe.png"));
        
        icon = new ImageIcon(img1.getImage().getScaledInstance(txt_logo.getWidth(), txt_logo.getHeight(), Image.SCALE_DEFAULT));
        txt_logo.setIcon(icon);
    }
    
    private void setOpaque(){
        
        for (JButton boton : new JButton[]{btn_practicar,btn_reto}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }
               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_practicar = new javax.swing.JButton();
        btn_reto = new javax.swing.JButton();
        txt_logo = new javax.swing.JLabel();

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

        txt_logo.setBackground(new java.awt.Color(3, 46, 178));
        txt_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btn_reto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(btn_practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txt_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_practicar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_practicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_practicarMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_practicarMouseEntered

    private void btn_practicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_practicarActionPerformed
        click.play();
        start.setVisible(false);

        new Practicar(aplicacion, start);
    }//GEN-LAST:event_btn_practicarActionPerformed

    private void btn_retoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_retoMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_retoMouseEntered

    private void btn_retoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retoActionPerformed
        click.play();
        start.setVisible(false);
        new Jugar(aplicacion, start);
        

    }//GEN-LAST:event_btn_retoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_practicar;
    private javax.swing.JButton btn_reto;
    private javax.swing.JLabel txt_logo;
    // End of variables declaration//GEN-END:variables
}
