package madaline;

import java.awt.event.MouseEvent;

public class MainWindow extends javax.swing.JFrame {
    private Lienzo lienzoDibujo;
    private Controlador aplicacion;
    
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
        aplicacion = new Controlador();
        
        lienzoDibujo = new Lienzo();
        lienzoDibujo.setSize(pnlDibujo.getSize());
        lienzoDibujo.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                lienzoDibujo.mousePressed(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lienzoDibujo.mouseExited(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
        });
        lienzoDibujo.addMouseMotionListener(new java.awt.event.MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                lienzoDibujo.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                lienzoDibujo.mouseMoved(e);
            }
        });
        pnlDibujo.add(lienzoDibujo);
        
        spGrosorStateChanged(new javax.swing.event.ChangeEvent(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDibujo = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btDeshacer = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        spGrosor = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlDibujoLayout = new javax.swing.GroupLayout(pnlDibujo);
        pnlDibujo.setLayout(pnlDibujoLayout);
        pnlDibujoLayout.setHorizontalGroup(
            pnlDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlDibujoLayout.setVerticalGroup(
            pnlDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        jLabel2.setText("Caracter");

        jToolBar1.setFloatable(false);

        btDeshacer.setText("Deshacer");
        btDeshacer.setFocusable(false);
        btDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btDeshacer);

        btLimpiar.setText("Limpiar");
        btLimpiar.setFocusable(false);
        btLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btLimpiar);
        jToolBar1.add(jSeparator1);

        jLabel1.setText("Ancho de línea");
        jToolBar1.add(jLabel1);
        jToolBar1.add(jSeparator2);

        spGrosor.setModel(new javax.swing.SpinnerNumberModel(5, 1, null, 1));
        spGrosor.setPreferredSize(new java.awt.Dimension(50, 23));
        spGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spGrosorStateChanged(evt);
            }
        });
        spGrosor.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                spGrosorMouseWheelMoved(evt);
            }
        });
        jToolBar1.add(spGrosor);

        jButton1.setText("Imagen");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDibujo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        lienzoDibujo.limpiarContenido();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void spGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spGrosorStateChanged
        int grosor = Integer.parseInt(spGrosor.getValue().toString());
        lienzoDibujo.setGrosor(grosor);
    }//GEN-LAST:event_spGrosorStateChanged

    private void btDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeshacerActionPerformed
        lienzoDibujo.deshacerTrazo();
    }//GEN-LAST:event_btDeshacerActionPerformed

    private void spGrosorMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_spGrosorMouseWheelMoved
        int movimientos = evt.getWheelRotation();
        int total = Integer.parseInt(spGrosor.getValue().toString()) - movimientos;
        spGrosor.setValue(total);
        spGrosorStateChanged(new javax.swing.event.ChangeEvent(this));
    }//GEN-LAST:event_spGrosorMouseWheelMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeshacer;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlDibujo;
    private javax.swing.JSpinner spGrosor;
    // End of variables declaration//GEN-END:variables

}
