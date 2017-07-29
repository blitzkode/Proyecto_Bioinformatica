package UI;

import Core.Controlador;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

public class Mantenimiento extends javax.swing.JFrame {
    private Lienzo lienzoDibujo;
    private Controlador aplicacion;
    private javax.swing.JFrame padre;
    
    
    public Mantenimiento(Controlador aplicacion, javax.swing.JFrame padre) {
        initComponents();
        setLocationRelativeTo(null);
        this.aplicacion = aplicacion;
        this.padre = padre;
        
        lienzoDibujo = new Lienzo();
        lienzoDibujo.setSize(pnlDibujo.getSize());
        pnlDibujo.add(lienzoDibujo);
        
        spGrosorStateChanged(new javax.swing.event.ChangeEvent(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDibujo = new javax.swing.JPanel();
        tfResultado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        spGrosor = new javax.swing.JSpinner();
        pbProgreso = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitAbrir = new javax.swing.JMenuItem();
        mitGuardar = new javax.swing.JMenuItem();
        mitSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mitDeshacer = new javax.swing.JMenuItem();
        mitLimpiar = new javax.swing.JMenuItem();
        mitReconocer = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mitGuardarPatron = new javax.swing.JMenuItem();
        mitEntrenamientoFast = new javax.swing.JMenuItem();
        mitEntrManual = new javax.swing.JMenuItem();

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

        tfResultado.setEditable(false);
        tfResultado.setBackground(new java.awt.Color(255, 255, 255));
        tfResultado.setFocusable(false);

        jLabel2.setText("Caracter reconocido");

        jToolBar1.setFloatable(false);
        jToolBar1.add(jSeparator1);

        jLabel1.setText("Ancho de línea");
        jToolBar1.add(jLabel1);
        jToolBar1.add(jSeparator2);

        spGrosor.setModel(new javax.swing.SpinnerNumberModel(14, 1, null, 1));
        spGrosor.setFocusable(false);
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

        jMenu1.setText("Archivo");

        mitAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mitAbrir.setText("Abrir");
        mitAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(mitAbrir);

        mitGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mitGuardar.setText("Guardar como");
        mitGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mitGuardar);

        mitSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mitSalir.setText("Salir");
        mitSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mitSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        mitDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mitDeshacer.setText("Deshacer trazo");
        mitDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitDeshacerActionPerformed(evt);
            }
        });
        jMenu2.add(mitDeshacer);

        mitLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mitLimpiar.setText("Limpiar lienzo");
        mitLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitLimpiarActionPerformed(evt);
            }
        });
        jMenu2.add(mitLimpiar);

        jMenuBar1.add(jMenu2);

        mitReconocer.setText("Reconocimiento");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Reconocer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mitReconocer.add(jMenuItem3);

        mitGuardarPatron.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mitGuardarPatron.setText("Guardar patrón");
        mitGuardarPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitGuardarPatronActionPerformed(evt);
            }
        });
        mitReconocer.add(mitGuardarPatron);

        mitEntrenamientoFast.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mitEntrenamientoFast.setText("Entrenamiento por lotes");
        mitEntrenamientoFast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEntrenamientoFastActionPerformed(evt);
            }
        });
        mitReconocer.add(mitEntrenamientoFast);

        mitEntrManual.setText("Entrenamiento manual");
        mitEntrManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEntrManualActionPerformed(evt);
            }
        });
        mitReconocer.add(mitEntrManual);

        jMenuBar1.add(mitReconocer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pbProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlDibujo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pbProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spGrosorStateChanged
        int grosor = Integer.parseInt(spGrosor.getValue().toString());
        lienzoDibujo.setGrosor(grosor);
    }//GEN-LAST:event_spGrosorStateChanged

    private void spGrosorMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_spGrosorMouseWheelMoved
        int movimientos = evt.getWheelRotation();
        int total = Integer.parseInt(spGrosor.getValue().toString()) - movimientos;
        spGrosor.setValue(total);
        spGrosorStateChanged(new javax.swing.event.ChangeEvent(this));
    }//GEN-LAST:event_spGrosorMouseWheelMoved

    private void mitDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitDeshacerActionPerformed
        lienzoDibujo.deshacerTrazo();
    }//GEN-LAST:event_mitDeshacerActionPerformed

    private void mitLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitLimpiarActionPerformed
        lienzoDibujo.limpiarContenido();
        tfResultado.setText("");
    }//GEN-LAST:event_mitLimpiarActionPerformed

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
        if (padre != null)
            padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mitSalirActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String letra = aplicacion.reconocerImagen(lienzoDibujo.getImagen());
        tfResultado.setText(letra);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mitGuardarPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitGuardarPatronActionPerformed
        String letra = JOptionPane.showInputDialog(this, "Caracter asociado");
        if ( !letra.isEmpty() ) {
            new Thread(() -> {
                try {
                    pbProgreso.setIndeterminate(true);
                    aplicacion.guardarCaracter(lienzoDibujo.getImagen(), letra);
                    pbProgreso.setIndeterminate(false);
                } catch (JAXBException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar");
                }
            }).start();
        }
    }//GEN-LAST:event_mitGuardarPatronActionPerformed

    private void mitEntrenamientoFastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEntrenamientoFastActionPerformed
            new Thread(() -> {
                try {
                    pbProgreso.setIndeterminate(true);
                    int imagenes_entrenadas = aplicacion.entrenamientoPorLotes();
                    pbProgreso.setIndeterminate(false);
                    JOptionPane.showMessageDialog(null,
                            String.format("Se %s %d %s en total.",
                                    imagenes_entrenadas==1 ? "procesó":"procesaron",
                                    imagenes_entrenadas,
                                    imagenes_entrenadas==1 ? "imagen":"imágenes")
                    );
                } catch (JAXBException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al entrenar");
                }
            }).start();
    }//GEN-LAST:event_mitEntrenamientoFastActionPerformed

    private void mitGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitGuardarActionPerformed
        JFileChooser selector = new JFileChooser("img");
        selector.showSaveDialog(this);
        File archivo = selector.getSelectedFile();
        
        if (archivo == null) {
            return;
        }
        if ( !archivo.getName().matches("[a-zA-Z0-9]*.jpg") ) {
            JOptionPane.showMessageDialog(this, "El nombre de archivo "+ archivo.getName() +" no es válido");
            return;
        }
        
        BufferedImage imagen = lienzoDibujo.getImagen();
        
        try {
            ImageIO.write(imagen, "jpg", archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la imagen");
        }
    }//GEN-LAST:event_mitGuardarActionPerformed

    private void mitAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAbrirActionPerformed
        JFileChooser selector = new JFileChooser("img");
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        
        if (archivo == null) {
            return;
        }
        if ( !archivo.getName().matches("[a-zA-Z0-9]*.jpg") ) {
            JOptionPane.showMessageDialog(this, "El nombre de archivo "+ archivo.getName() +" no es válido");
            return;
        }
        try {
            BufferedImage imagen = ImageIO.read(archivo);
            lienzoDibujo.setImagen(imagen);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la imagen");
        }
    }//GEN-LAST:event_mitAbrirActionPerformed

    private void mitEntrManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEntrManualActionPerformed
        String letra = JOptionPane.showInputDialog(this, "Letra a entrenar");
        byte validez = Byte.parseByte(JOptionPane.showInputDialog(this,
                "Validez del patrón.\nVálido (1), Inválido (-1)"));
        BufferedImage imagen = lienzoDibujo.getImagen();
        new Thread(() -> {
            aplicacion.entrenamientoManual(imagen, letra, validez);
        }).start();
    }//GEN-LAST:event_mitEntrManualActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mitAbrir;
    private javax.swing.JMenuItem mitDeshacer;
    private javax.swing.JMenuItem mitEntrManual;
    private javax.swing.JMenuItem mitEntrenamientoFast;
    private javax.swing.JMenuItem mitGuardar;
    private javax.swing.JMenuItem mitGuardarPatron;
    private javax.swing.JMenuItem mitLimpiar;
    private javax.swing.JMenu mitReconocer;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JProgressBar pbProgreso;
    private javax.swing.JPanel pnlDibujo;
    private javax.swing.JSpinner spGrosor;
    private javax.swing.JTextField tfResultado;
    // End of variables declaration//GEN-END:variables

}
