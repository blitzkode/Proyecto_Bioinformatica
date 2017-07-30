package UI;

import Core.Controlador;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    Controlador aplicacion;
    Lienzo lienzo;
    PanelLetra panelLetra;
    javax.swing.JFrame padre;

    public Principal(Controlador aplicacion, javax.swing.JFrame padre) {
        initComponents();
//        btnresultados.setVisible(false);
        setExtendedState(MAXIMIZED_BOTH);
        this.aplicacion = aplicacion;
        this.padre = padre;

        lienzo = new Lienzo();
        pnlContenedorLienzo.add(lienzo);
        panelLetra = new PanelLetra();
        pnl_ayuda.add(panelLetra);

        setVisible(true);

        setwhitepanel();
        setwallpaper();
        setOpaque();

        new Dificultad(this, true).setVisible(true);

        aplicacion.nuevoJuego(5);
        siguienteLetra();

    }

    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_pulsa, btn_salir, btn_clean, btn_rojo,
            btn_verde, btn_lila, btn_marron, btn_mas, btn_menos, btn_naranja, btn_siguiente}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

    }

    private void siguienteLetra() {
        panelLetra.dibujarLetra(aplicacion.getLetraActual());
        lienzo.limpiarContenido();
        lienzo.setLetra(aplicacion.getLetraActual());
    }

    private void setwhitepanel() {

        for (JPanel panel : new JPanel[]{pnl_opciones, pnl_botones, pnl_resultados,pnl_funciones,pnl_colores}) {

            panel.setOpaque(false);
        }
    }
    Wallpaper wall = new Wallpaper("/Iconos/wall_principal.jpg");
    private void setwallpaper() {
        
        wall.setSize(pnl_main.getSize());
        pnl_main.add(wall);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        pnl_opciones = new javax.swing.JPanel();
        pnl_colores = new javax.swing.JPanel();
        btn_lila = new javax.swing.JButton();
        btn_marron = new javax.swing.JButton();
        btn_naranja = new javax.swing.JButton();
        btn_verde = new javax.swing.JButton();
        btn_rojo = new javax.swing.JButton();
        pnl_funciones = new javax.swing.JPanel();
        btn_clean = new javax.swing.JButton();
        btn_menos = new javax.swing.JButton();
        btn_mas = new javax.swing.JButton();
        btn_guia = new javax.swing.JButton();
        pnl_ayuda = new javax.swing.JPanel();
        pnlContenedorLienzo = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        btn_siguiente = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_pulsa = new javax.swing.JButton();
        btnresultados = new javax.swing.JButton();
        pnl_resultados = new javax.swing.JPanel();
        txt_dificultad = new javax.swing.JLabel();
        txt_puntos = new javax.swing.JLabel();
        txt_intentosf = new javax.swing.JLabel();
        txt_nivel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitGuardar = new javax.swing.JMenuItem();
        mitMantenimiento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(132, 236, 159));

        pnl_main.setBackground(new java.awt.Color(255, 102, 102));
        pnl_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnl_main.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnl_mainComponentResized(evt);
            }
        });

        pnl_opciones.setBackground(new java.awt.Color(132, 236, 159));

        pnl_colores.setBackground(new java.awt.Color(132, 236, 159));

        btn_lila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/7d028c_2.png"))); // NOI18N
        btn_lila.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/7d028c_1.png"))); // NOI18N
        btn_lila.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/7d028c_3.png"))); // NOI18N
        btn_lila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lilaActionPerformed(evt);
            }
        });

        btn_marron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_2.png"))); // NOI18N
        btn_marron.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_1.png"))); // NOI18N
        btn_marron.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_3.png"))); // NOI18N
        btn_marron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marronActionPerformed(evt);
            }
        });

        btn_naranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_2.png"))); // NOI18N
        btn_naranja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_1.png"))); // NOI18N
        btn_naranja.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_3.png"))); // NOI18N
        btn_naranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_naranjaActionPerformed(evt);
            }
        });

        btn_verde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_2.png"))); // NOI18N
        btn_verde.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_1.png"))); // NOI18N
        btn_verde.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_3.png"))); // NOI18N
        btn_verde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verdeActionPerformed(evt);
            }
        });

        btn_rojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_2.png"))); // NOI18N
        btn_rojo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800.png"))); // NOI18N
        btn_rojo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_3.png"))); // NOI18N
        btn_rojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rojoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_coloresLayout = new javax.swing.GroupLayout(pnl_colores);
        pnl_colores.setLayout(pnl_coloresLayout);
        pnl_coloresLayout.setHorizontalGroup(
            pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_coloresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_lila, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btn_marron, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btn_naranja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btn_verde, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_coloresLayout.setVerticalGroup(
            pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_coloresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_rojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_verde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_naranja)
                .addGap(18, 18, 18)
                .addComponent(btn_marron, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_lila, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_funciones.setBackground(new java.awt.Color(132, 236, 159));

        btn_clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clean_2.png"))); // NOI18N
        btn_clean.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clean_1.png"))); // NOI18N
        btn_clean.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clean_3.png"))); // NOI18N
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });

        btn_menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_2.png"))); // NOI18N
        btn_menos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_1.png"))); // NOI18N
        btn_menos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_3.png"))); // NOI18N
        btn_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosActionPerformed(evt);
            }
        });

        btn_mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_2.png"))); // NOI18N
        btn_mas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_1.png"))); // NOI18N
        btn_mas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_3.png"))); // NOI18N
        btn_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masActionPerformed(evt);
            }
        });

        btn_guia.setText("GUIA");
        btn_guia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_funcionesLayout = new javax.swing.GroupLayout(pnl_funciones);
        pnl_funciones.setLayout(pnl_funcionesLayout);
        pnl_funcionesLayout.setHorizontalGroup(
            pnl_funcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_funcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_funcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clean, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_funcionesLayout.setVerticalGroup(
            pnl_funcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_funcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_mas)
                .addGap(24, 24, 24)
                .addComponent(btn_menos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_clean)
                .addGap(18, 18, 18)
                .addComponent(btn_guia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_opcionesLayout = new javax.swing.GroupLayout(pnl_opciones);
        pnl_opciones.setLayout(pnl_opcionesLayout);
        pnl_opcionesLayout.setHorizontalGroup(
            pnl_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_funciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnl_opcionesLayout.setVerticalGroup(
            pnl_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_funciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_ayuda.setBackground(new java.awt.Color(255, 255, 255));
        pnl_ayuda.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnl_ayudaComponentResized(evt);
            }
        });

        javax.swing.GroupLayout pnl_ayudaLayout = new javax.swing.GroupLayout(pnl_ayuda);
        pnl_ayuda.setLayout(pnl_ayudaLayout);
        pnl_ayudaLayout.setHorizontalGroup(
            pnl_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        pnl_ayudaLayout.setVerticalGroup(
            pnl_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlContenedorLienzo.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorLienzo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnlContenedorLienzoComponentResized(evt);
            }
        });

        javax.swing.GroupLayout pnlContenedorLienzoLayout = new javax.swing.GroupLayout(pnlContenedorLienzo);
        pnlContenedorLienzo.setLayout(pnlContenedorLienzoLayout);
        pnlContenedorLienzoLayout.setHorizontalGroup(
            pnlContenedorLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContenedorLienzoLayout.setVerticalGroup(
            pnlContenedorLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnl_botones.setBackground(new java.awt.Color(132, 236, 159));

        btn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/siguiente_2.png"))); // NOI18N
        btn_siguiente.setEnabled(false);
        btn_siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/siguiente_1.png"))); // NOI18N
        btn_siguiente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/siguiente_3.png"))); // NOI18N
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_2.png"))); // NOI18N
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_1.png"))); // NOI18N
        btn_salir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_3.png"))); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_2.png"))); // NOI18N
        btn_pulsa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_pulsa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_1.png"))); // NOI18N
        btn_pulsa.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_3.png"))); // NOI18N
        btn_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pulsaActionPerformed(evt);
            }
        });

        btnresultados.setText("jButton1");
        btnresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_pulsa)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btnresultados)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnresultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addGap(19, 19, 19))
        );

        pnl_resultados.setBackground(new java.awt.Color(132, 236, 159));

        txt_dificultad.setFont(new java.awt.Font("Dizzy Edge DEMO", 0, 18)); // NOI18N
        txt_dificultad.setForeground(new java.awt.Color(255, 96, 5));
        txt_dificultad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_dificultad.setText("DIFICULTAD: FACIL");

        txt_puntos.setFont(new java.awt.Font("Dizzy Edge DEMO", 0, 36)); // NOI18N
        txt_puntos.setForeground(new java.awt.Color(255, 96, 5));
        txt_puntos.setText("PUNTOS: 0");

        txt_intentosf.setFont(new java.awt.Font("Dizzy Edge DEMO", 0, 18)); // NOI18N
        txt_intentosf.setForeground(new java.awt.Color(255, 96, 5));
        txt_intentosf.setText("INTENTOS FALLIDOS: 0");

        txt_nivel.setFont(new java.awt.Font("Dizzy Edge DEMO", 1, 58)); // NOI18N
        txt_nivel.setForeground(new java.awt.Color(255, 96, 5));
        txt_nivel.setText("27");

        jLabel4.setFont(new java.awt.Font("Dizzy Edge DEMO", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 96, 5));
        jLabel4.setText("NIVEL");

        javax.swing.GroupLayout pnl_resultadosLayout = new javax.swing.GroupLayout(pnl_resultados);
        pnl_resultados.setLayout(pnl_resultadosLayout);
        pnl_resultadosLayout.setHorizontalGroup(
            pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultadosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_dificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_intentosf)
                    .addGroup(pnl_resultadosLayout.createSequentialGroup()
                        .addComponent(txt_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txt_puntos)))
                .addGap(52, 52, 52))
        );
        pnl_resultadosLayout.setVerticalGroup(
            pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnl_resultadosLayout.createSequentialGroup()
                        .addComponent(txt_puntos)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_intentosf)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_mainLayout = new javax.swing.GroupLayout(pnl_main);
        pnl_main.setLayout(pnl_mainLayout);
        pnl_mainLayout.setHorizontalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addComponent(pnlContenedorLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addComponent(pnl_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_mainLayout.setVerticalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl_resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlContenedorLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnl_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");

        mitGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mitGuardar.setText("Guardar imagen");
        mitGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mitGuardar);

        mitMantenimiento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mitMantenimiento.setText("Mantenimiento");
        mitMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitMantenimientoActionPerformed(evt);
            }
        });
        jMenu1.add(mitMantenimiento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        padre.setVisible(true);
        dispose();

    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        lienzo.limpiarContenido();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masActionPerformed
        lienzo.aumentarGrosor();
    }//GEN-LAST:event_btn_masActionPerformed

    private void btn_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menosActionPerformed
        lienzo.disminuirGrosor();
    }//GEN-LAST:event_btn_menosActionPerformed

    private void pnlContenedorLienzoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlContenedorLienzoComponentResized
        lienzo.setSize(pnlContenedorLienzo.getSize());
    }//GEN-LAST:event_pnlContenedorLienzoComponentResized

    private void btn_rojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rojoActionPerformed
        lienzo.setColor(new Color(255, 24, 0));
    }//GEN-LAST:event_btn_rojoActionPerformed

    private void btn_verdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verdeActionPerformed
        lienzo.setColor(new Color(99, 184, 42));
    }//GEN-LAST:event_btn_verdeActionPerformed

    private void btn_naranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_naranjaActionPerformed
        lienzo.setColor(new Color(231, 158, 5));
    }//GEN-LAST:event_btn_naranjaActionPerformed

    private void btn_marronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marronActionPerformed
        lienzo.setColor(new Color(61, 38, 1));
    }//GEN-LAST:event_btn_marronActionPerformed

    private void btn_lilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lilaActionPerformed
        lienzo.setColor(new Color(125, 2, 140));
    }//GEN-LAST:event_btn_lilaActionPerformed

    private void btn_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pulsaActionPerformed
        BufferedImage imagen = lienzo.getImagen();
        boolean acierto = aplicacion.jugar(imagen);
        txt_puntos.setText("PUNTOS: " + aplicacion.getPuntos());
        txt_intentosf.setText("INTENTOS FALLIDOS: " + (aplicacion.getIntentos() - aplicacion.getPuntos()));
        if (acierto) {
            btn_siguiente.setEnabled(true);
            btn_pulsa.setEnabled(false);
        }
    }//GEN-LAST:event_btn_pulsaActionPerformed

    private void pnl_ayudaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_ayudaComponentResized
        panelLetra.setSize(pnl_ayuda.getSize());
    }//GEN-LAST:event_pnl_ayudaComponentResized

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed
        if (!aplicacion.getLetras_partida().isEmpty()) {
            siguienteLetra();
            btn_pulsa.setEnabled(true);
        }
        btn_siguiente.setEnabled(false);
    }//GEN-LAST:event_btn_siguienteActionPerformed

    private void btn_guiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guiaActionPerformed
        lienzo.dibujarLetra(true);
    }//GEN-LAST:event_btn_guiaActionPerformed
    private void mitGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitGuardarActionPerformed
        JFileChooser selector = new JFileChooser("img");
        selector.showSaveDialog(this);
        File archivo = selector.getSelectedFile();

        if (archivo == null) {
            return;
        }
        if (!archivo.getName().matches("[a-zA-Z0-9]*.jpg")) {
            JOptionPane.showMessageDialog(this, "El nombre de archivo " + archivo.getName() + " no es válido");
            return;
        }

        BufferedImage imagen = lienzo.getImagen();

        try {
            ImageIO.write(imagen, "jpg", archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la imagen");
        }
    }//GEN-LAST:event_mitGuardarActionPerformed

    private void mitMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitMantenimientoActionPerformed
        new Mantenimiento(aplicacion, null).setVisible(true);
    }//GEN-LAST:event_mitMantenimientoActionPerformed

    private void pnl_mainComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_mainComponentResized
        wall.setSize(pnl_main.getSize());
    }//GEN-LAST:event_pnl_mainComponentResized

    private void btnresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresultadosActionPerformed

        Resultados rst = new Resultados(this, true);
        rst.setVisible(true);
        rst.setstars(4);

    }//GEN-LAST:event_btnresultadosActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new Principal(new Controlador()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_guia;
    private javax.swing.JButton btn_lila;
    private javax.swing.JButton btn_marron;
    private javax.swing.JButton btn_mas;
    private javax.swing.JButton btn_menos;
    private javax.swing.JButton btn_naranja;
    private javax.swing.JButton btn_pulsa;
    private javax.swing.JButton btn_rojo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JButton btn_verde;
    private javax.swing.JButton btnresultados;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mitGuardar;
    private javax.swing.JMenuItem mitMantenimiento;
    private javax.swing.JPanel pnlContenedorLienzo;
    private javax.swing.JPanel pnl_ayuda;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_colores;
    private javax.swing.JPanel pnl_funciones;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_opciones;
    private javax.swing.JPanel pnl_resultados;
    private javax.swing.JLabel txt_dificultad;
    private javax.swing.JLabel txt_intentosf;
    private javax.swing.JLabel txt_nivel;
    private javax.swing.JLabel txt_puntos;
    // End of variables declaration//GEN-END:variables

    private Icon ImageIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JLabel ImageIcon(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
