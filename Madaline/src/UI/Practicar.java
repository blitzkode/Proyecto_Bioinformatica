package UI;

import Core.Controlador;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import static UI.Start.puntero;
import java.applet.AudioClip;

public class Practicar extends Principal {
    Lienzo lienzo;
    PanelLetra panelLetra;
    
    int n_apoyo=4,n_exito=4;
    
    AudioClip correct, fail, succes,apoyo[], exito[];

    public Practicar(Controlador aplicacion, javax.swing.JFrame padre) {
        super(aplicacion, padre);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

        lienzo = new Lienzo();
        pnlContenedorLienzo.add(lienzo);
        panelLetra = new PanelLetra();
        pnl_ayuda.add(panelLetra);

        setVisible(true);
        
        setwhitepanel();
        setwallpaper();
        setOpaque();
        CargarSonidos();

        cargarFondoLienzo();
        
        new Dificultad(this, true).setVisible(true);

        aplicacion.setModoReconocimiento(modo_juego);

    }
    
    private void CargarSonidos(){
        correct = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Correct.wav"));
        fail = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Fail.wav"));
        succes = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Succes.wav"));
        
        
        apoyo = new AudioClip[n_apoyo];
        exito = new AudioClip[n_exito];
        
        apoyo[0]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/apoyo_1.wav"));
        exito[0]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/exito_1.wav"));
        
        apoyo[1]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/apoyo_2.wav"));
        exito[1]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/exito_2.wav"));
        
        apoyo[2]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/apoyo_3.wav"));
        exito[2]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/exito_3.wav"));
        
        apoyo[3]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/apoyo_4.wav"));
        exito[3]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/exito_4.wav"));
    }
    

    private void cargarFondoLienzo() {
        try {
            BufferedImage fondo = ImageIO.read(new File("src/Iconos/rejilla.jpg"));
            lienzo.setFondo(fondo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_pulsa, btn_salir, btn_clean, btn_rojo,
            btn_verde, btn_lila, btn_marron, btn_mas, btn_menos, btn_naranja}) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

        tbtCuadricula.setOpaque(false);
        tbtCuadricula.setContentAreaFilled(false);
        tbtCuadricula.setBorderPainted(false);
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
        tbtCuadricula = new javax.swing.JToggleButton();
        pnl_ayuda = new javax.swing.JPanel();
        pnlContenedorLienzo = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        btn_pulsa = new javax.swing.JButton();
        pnl_resultados = new javax.swing.JPanel();
        txt_modolibre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitAbrir = new javax.swing.JMenuItem();
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
        btn_lila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_lilaMouseEntered(evt);
            }
        });
        btn_lila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lilaActionPerformed(evt);
            }
        });

        btn_marron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_2.png"))); // NOI18N
        btn_marron.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_1.png"))); // NOI18N
        btn_marron.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3d2601_3.png"))); // NOI18N
        btn_marron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_marronMouseEntered(evt);
            }
        });
        btn_marron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marronActionPerformed(evt);
            }
        });

        btn_naranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_2.png"))); // NOI18N
        btn_naranja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_1.png"))); // NOI18N
        btn_naranja.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/e79e00_3.png"))); // NOI18N
        btn_naranja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_naranjaMouseEntered(evt);
            }
        });
        btn_naranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_naranjaActionPerformed(evt);
            }
        });

        btn_verde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_2.png"))); // NOI18N
        btn_verde.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_1.png"))); // NOI18N
        btn_verde.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/63b82a_3.png"))); // NOI18N
        btn_verde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_verdeMouseEntered(evt);
            }
        });
        btn_verde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verdeActionPerformed(evt);
            }
        });

        btn_rojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_2.png"))); // NOI18N
        btn_rojo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800.png"))); // NOI18N
        btn_rojo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_3.png"))); // NOI18N
        btn_rojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_rojoMouseEntered(evt);
            }
        });
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
        btn_clean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cleanMouseEntered(evt);
            }
        });
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });

        btn_menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_2.png"))); // NOI18N
        btn_menos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_1.png"))); // NOI18N
        btn_menos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_3.png"))); // NOI18N
        btn_menos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_menosMouseEntered(evt);
            }
        });
        btn_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosActionPerformed(evt);
            }
        });

        btn_mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_2.png"))); // NOI18N
        btn_mas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_1.png"))); // NOI18N
        btn_mas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas_3.png"))); // NOI18N
        btn_mas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_masMouseEntered(evt);
            }
        });
        btn_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masActionPerformed(evt);
            }
        });

        tbtCuadricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/regilla_2.png"))); // NOI18N
        tbtCuadricula.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/regilla_1.png"))); // NOI18N
        tbtCuadricula.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/regilla_3.png"))); // NOI18N
        tbtCuadricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtCuadriculaActionPerformed(evt);
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
                    .addComponent(tbtCuadricula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_funcionesLayout.setVerticalGroup(
            pnl_funcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_funcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_mas)
                .addGap(18, 18, 18)
                .addComponent(btn_menos)
                .addGap(18, 18, 18)
                .addComponent(btn_clean)
                .addGap(18, 18, 18)
                .addComponent(tbtCuadricula, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_2.png"))); // NOI18N
        btn_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_1.png"))); // NOI18N
        btn_salir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir_3.png"))); // NOI18N
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

        btn_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_2.png"))); // NOI18N
        btn_pulsa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_pulsa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_1.png"))); // NOI18N
        btn_pulsa.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pulsa_3.png"))); // NOI18N
        btn_pulsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pulsaMouseEntered(evt);
            }
        });
        btn_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pulsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btn_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addGap(19, 19, 19))
        );

        pnl_resultados.setBackground(new java.awt.Color(132, 236, 159));

        txt_modolibre.setFont(new java.awt.Font("Dizzy Edge DEMO", 0, 36)); // NOI18N
        txt_modolibre.setForeground(new java.awt.Color(255, 96, 5));
        txt_modolibre.setText("MODO LIBRE");

        javax.swing.GroupLayout pnl_resultadosLayout = new javax.swing.GroupLayout(pnl_resultados);
        pnl_resultados.setLayout(pnl_resultadosLayout);
        pnl_resultadosLayout.setHorizontalGroup(
            pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultadosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(txt_modolibre)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnl_resultadosLayout.setVerticalGroup(
            pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultadosLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txt_modolibre)
                .addContainerGap(53, Short.MAX_VALUE))
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

        mitAbrir.setText("Abrir imagen");
        mitAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(mitAbrir);

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
        salir();
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
        String caracter = aplicacion.reconocerImagen(imagen);
        panelLetra.dibujarLetra(caracter);
    }//GEN-LAST:event_btn_pulsaActionPerformed

    private void pnl_ayudaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_ayudaComponentResized
        panelLetra.setSize(pnl_ayuda.getSize());
    }//GEN-LAST:event_pnl_ayudaComponentResized

    private void mitGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitGuardarActionPerformed
        lienzo.guardarImagen();
    }//GEN-LAST:event_mitGuardarActionPerformed

    private void mitMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitMantenimientoActionPerformed
        new Mantenimiento(aplicacion, null).setVisible(true);
    }//GEN-LAST:event_mitMantenimientoActionPerformed

    private void mitAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAbrirActionPerformed
        lienzo.abrirImagen();
    }//GEN-LAST:event_mitAbrirActionPerformed

    private void pnl_mainComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_mainComponentResized
        wall.setSize(pnl_main.getSize());
    }//GEN-LAST:event_pnl_mainComponentResized

    private void tbtCuadriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtCuadriculaActionPerformed
        lienzo.activarFondo(tbtCuadricula.isSelected());
    }//GEN-LAST:event_tbtCuadriculaActionPerformed
    private void btn_rojoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rojoMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_rojoMouseEntered

    private void btn_verdeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verdeMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_verdeMouseEntered

    private void btn_naranjaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_naranjaMouseEntered
      puntero.play();
    }//GEN-LAST:event_btn_naranjaMouseEntered

    private void btn_marronMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_marronMouseEntered
      puntero.play();
    }//GEN-LAST:event_btn_marronMouseEntered

    private void btn_lilaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lilaMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_lilaMouseEntered

    private void btn_masMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_masMouseEntered
      puntero.play();
    }//GEN-LAST:event_btn_masMouseEntered

    private void btn_menosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menosMouseEntered
      puntero.play();
    }//GEN-LAST:event_btn_menosMouseEntered

    private void btn_cleanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cleanMouseEntered
     puntero.play();
    }//GEN-LAST:event_btn_cleanMouseEntered

    private void btn_guiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guiaMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_guiaMouseEntered

    private void btn_pulsaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pulsaMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_pulsaMouseEntered

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_salirMouseEntered

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
    private javax.swing.JButton btn_lila;
    private javax.swing.JButton btn_marron;
    private javax.swing.JButton btn_mas;
    private javax.swing.JButton btn_menos;
    private javax.swing.JButton btn_naranja;
    private javax.swing.JButton btn_pulsa;
    private javax.swing.JButton btn_rojo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_verde;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mitAbrir;
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
    private javax.swing.JToggleButton tbtCuadricula;
    private javax.swing.JLabel txt_modolibre;
    // End of variables declaration//GEN-END:variables

}
