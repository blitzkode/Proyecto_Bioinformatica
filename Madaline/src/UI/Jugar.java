package UI;

import Core.Controlador;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;
import static UI.Start.puntero;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Jugar extends Principal {
    
    PanelLetra panelLetra;   
    Icon tutor_reposo,tutor_feliz[], tutor_animo[];
     
    int t_feliz=1;
    int t_animo= 1;
    
    int n_apoyo = 4;
    int n_exito = 4;
    
    AudioClip correct, fail, succes,apoyo[], exito[];

    public Jugar(Controlador aplicacion, javax.swing.JFrame padre) {
        super(aplicacion, padre);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.aplicacion = aplicacion;
        this.padre = padre;
        
        pnlContenedorLienzo.add(lienzo);
        panelLetra = new PanelLetra();
        pnl_ayuda.add(panelLetra);
        
        jLabel4.setVisible(false);
        txt_dificultad.setVisible(false);
        txt_nivel.setVisible(false);
        setVisible(true);
        
        setwhitepanel();
        setwallpaper();
        setOpaque();
        CargarSonidos();
        cargarFondoLienzo();
        CargarTutor();
        setTutorReposo();
        
        new Dificultad(this, true).setVisible(true);

        aplicacion.setModoReconocimiento(modo_juego);
        reiniciarJuego();

    }
  
    private void CargarTutor() {
        ImageIcon image = new ImageIcon(getClass().getResource("/Iconos/tutor_reposo.gif"));
        tutor_reposo = new ImageIcon(image.getImage().getScaledInstance(txt_tutor.getWidth(), txt_tutor.getHeight(), Image.SCALE_DEFAULT));
        
        tutor_feliz = new Icon[t_feliz];
        tutor_animo = new Icon[t_animo];

        for (int i = 0; i < t_feliz; i++) {
            image = new ImageIcon(getClass().getResource("/Iconos/tutor_feliz" + (i + 1) + ".gif"));
            tutor_feliz[i] = new ImageIcon(image.getImage().getScaledInstance(txt_tutor.getWidth(), txt_tutor.getHeight(), Image.SCALE_DEFAULT));
        }

        for (int i = 0; i < t_animo; i++) {
            image = new ImageIcon(getClass().getResource("/Iconos/tutor_animo" + (i + 1) + ".gif"));
            tutor_animo[i] = new ImageIcon(image.getImage().getScaledInstance(txt_tutor.getWidth(), txt_tutor.getHeight(), Image.SCALE_DEFAULT));
        }
        
    }
    
    private void setTutorReposo(){
        txt_tutor.setIcon(tutor_reposo);
    }
    
    private void setTutorFeliz(){
        txt_tutor.setIcon(tutor_feliz[0]);
        timer.start();
    }
    
    private void setTutorAnimo(){
        txt_tutor.setIcon(tutor_animo[0]);
        timer.start();
    }
    
    Timer timer = new Timer(2000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setTutorReposo();
            timer.stop();
        }
    });
    
    
    private void CargarSonidos(){
        correct = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Correct.wav"));
        fail = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Fail.wav"));
        succes = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Succes.wav"));
        
               
        apoyo = new AudioClip[n_apoyo];
        exito = new AudioClip[n_exito];
        
        for (int i = 0; i < n_apoyo; i++) {
            apoyo[i]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/apoyo_"+(i+1)+".wav"));
        }
        
        for (int i = 0; i < n_exito; i++) {
            exito[i]=java.applet.Applet.newAudioClip(getClass().getResource("/Audio/exito_"+(i+1)+".wav"));
        }
            
        
    }
    
    private void setOpaque() {

        for (JButton boton : new JButton[]{btn_pulsa, btn_salir, btn_clean, btn_rojo, btn_negro,
            btn_verde, btn_lila, btn_marron, btn_mas, btn_menos, btn_naranja, btn_siguiente,
            btn_deshacer }) {

            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
        }

        tbtCuadricula.setOpaque(false);
        tbtCuadricula.setContentAreaFilled(false);
        tbtCuadricula.setBorderPainted(false);

        tbtGuia.setOpaque(false);
        tbtGuia.setContentAreaFilled(false);
        tbtGuia.setBorderPainted(false);

    }

    private void siguienteLetra() {
        panelLetra.dibujarLetra(aplicacion.getLetraActual());
        lienzo.limpiarContenido();
        lienzo.setLetra(aplicacion.getLetraActual());
    }
    
    public void reiniciarJuego() {
        txt_puntos.setText("PUNTOS: 0");
        txt_intentosf.setText("INTENTOS FALLIDOS: 0");
        btn_pulsa.setEnabled(true);
        aplicacion.nuevoJuego();
        siguienteLetra();
    }

    private void setwhitepanel() {

        for (JPanel panel : new JPanel[]{pnl_opciones, pnl_botones, pnl_resultados,pnl_funciones,pnl_colores,pnl_tutor}) {

            panel.setOpaque(false);
        }
    }
    
    
    
    Wallpaper wall;
    private void setwallpaper() {
        wall = new Wallpaper("/Iconos/wall_principal.jpg", pnl_main);
    }
    
    private void cambiarWallpaper(){
        wall.transicion(null, WIDTH, new Color(238,167,25,0), Color.orange);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        pnl_opciones = new javax.swing.JPanel();
        pnl_colores = new javax.swing.JPanel();
        btn_rojo = new javax.swing.JButton();
        btn_lila = new javax.swing.JButton();
        btn_marron = new javax.swing.JButton();
        btn_naranja = new javax.swing.JButton();
        btn_negro = new javax.swing.JButton();
        btn_verde = new javax.swing.JButton();
        pnl_funciones = new javax.swing.JPanel();
        btn_clean = new javax.swing.JButton();
        btn_menos = new javax.swing.JButton();
        btn_mas = new javax.swing.JButton();
        tbtGuia = new javax.swing.JToggleButton();
        tbtCuadricula = new javax.swing.JToggleButton();
        btn_deshacer = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        pnl_ayuda = new javax.swing.JPanel();
        pnlContenedorLienzo = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        btn_siguiente = new javax.swing.JButton();
        btn_pulsa = new javax.swing.JButton();
        pnl_tutor = new javax.swing.JPanel();
        txt_tutor = new javax.swing.JLabel();
        pnl_resultados = new javax.swing.JPanel();
        txt_dificultad = new javax.swing.JLabel();
        txt_puntos = new javax.swing.JLabel();
        txt_intentosf = new javax.swing.JLabel();
        txt_nivel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitAbrir = new javax.swing.JMenuItem();
        mitGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mitMantenimiento = new javax.swing.JMenuItem();
        mitEntrenar = new javax.swing.JMenuItem();

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

        btn_negro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_2.png"))); // NOI18N
        btn_negro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800.png"))); // NOI18N
        btn_negro.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ff1800_3.png"))); // NOI18N
        btn_negro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_negroMouseEntered(evt);
            }
        });
        btn_negro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_negroActionPerformed(evt);
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

        javax.swing.GroupLayout pnl_coloresLayout = new javax.swing.GroupLayout(pnl_colores);
        pnl_colores.setLayout(pnl_coloresLayout);
        pnl_coloresLayout.setHorizontalGroup(
            pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_coloresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_lila, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_marron, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_naranja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_verde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_negro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_coloresLayout.setVerticalGroup(
            pnl_coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_coloresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_negro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_rojo)
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

        tbtGuia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help_2.png"))); // NOI18N
        tbtGuia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help_1.png"))); // NOI18N
        tbtGuia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help_3.png"))); // NOI18N
        tbtGuia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbtGuiaMouseEntered(evt);
            }
        });
        tbtGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtGuiaActionPerformed(evt);
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

        btn_deshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_2.png"))); // NOI18N
        btn_deshacer.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_1.png"))); // NOI18N
        btn_deshacer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menos_3.png"))); // NOI18N
        btn_deshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deshacerMouseEntered(evt);
            }
        });
        btn_deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deshacerActionPerformed(evt);
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
                    .addComponent(tbtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tbtCuadricula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_deshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btn_deshacer)
                .addGap(18, 18, 18)
                .addComponent(btn_clean)
                .addGap(18, 18, 18)
                .addComponent(tbtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tbtCuadricula, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(pnl_opcionesLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_opcionesLayout.setVerticalGroup(
            pnl_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_funciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addGap(23, 23, 23))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_ayudaLayout.setVerticalGroup(
            pnl_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
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
            .addGap(0, 348, Short.MAX_VALUE)
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
        btn_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_siguienteMouseEntered(evt);
            }
        });
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
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

        pnl_tutor.setBackground(new java.awt.Color(69, 225, 109));

        txt_tutor.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout pnl_tutorLayout = new javax.swing.GroupLayout(pnl_tutor);
        pnl_tutor.setLayout(pnl_tutorLayout);
        pnl_tutorLayout.setHorizontalGroup(
            pnl_tutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tutorLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(txt_tutor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        pnl_tutorLayout.setVerticalGroup(
            pnl_tutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tutorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_tutor, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_botonesLayout = new javax.swing.GroupLayout(pnl_botones);
        pnl_botones.setLayout(pnl_botonesLayout);
        pnl_botonesLayout.setHorizontalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botonesLayout.createSequentialGroup()
                        .addComponent(btn_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addComponent(pnl_tutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_botonesLayout.setVerticalGroup(
            pnl_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_tutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(txt_nivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_resultadosLayout.createSequentialGroup()
                        .addComponent(txt_puntos)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(pnlContenedorLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnl_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_mainLayout.setVerticalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_mainLayout.createSequentialGroup()
                                .addComponent(pnl_resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(pnl_mainLayout.createSequentialGroup()
                                .addComponent(pnl_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlContenedorLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnl_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Opciones");

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
        jMenu1.add(jSeparator1);

        mitMantenimiento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mitMantenimiento.setText("Mantenimiento");
        mitMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitMantenimientoActionPerformed(evt);
            }
        });
        jMenu1.add(mitMantenimiento);

        mitEntrenar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mitEntrenar.setText("Entrenar");
        mitEntrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEntrenarActionPerformed(evt);
            }
        });
        jMenu1.add(mitEntrenar);

        jMenuBar1.add(jMenu1);

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
        boolean acierto = aplicacion.jugar(imagen);
        int puntos = aplicacion.getPuntos();
        int intentos = aplicacion.getIntentos();
        txt_puntos.setText("PUNTOS: " + puntos);
        txt_intentosf.setText("INTENTOS FALLIDOS: " + intentos);
        if (acierto) {
            btn_siguiente.setEnabled(true);
            btn_pulsa.setEnabled(false);
            correct.play();
            exito[(int) (Math.random() * n_exito)].play();
            setTutorFeliz();
        } else {
            fail.play();
            apoyo[(int) (Math.random() * n_apoyo)].play();
            setTutorAnimo();
        }
        if (aplicacion.juegoTerminado()) {
            btn_siguiente.setEnabled(false);
            succes.play();
            Resultados rst = new Resultados(this, true, aplicacion.getEstrellas(), puntos, intentos);
            rst.setVisible(true);
        }
    }//GEN-LAST:event_btn_pulsaActionPerformed

    private void pnl_ayudaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnl_ayudaComponentResized
        panelLetra.setSize(pnl_ayuda.getSize());
    }//GEN-LAST:event_pnl_ayudaComponentResized

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed
        siguienteLetra();
        btn_pulsa.setEnabled(true);
        btn_siguiente.setEnabled(false);
    }//GEN-LAST:event_btn_siguienteActionPerformed

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
//        wall.setSize(pnl_main.getSize());
    }//GEN-LAST:event_pnl_mainComponentResized

    private void tbtGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtGuiaActionPerformed
        lienzo.dibujarLetra(tbtGuia.isSelected());
    }//GEN-LAST:event_tbtGuiaActionPerformed

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

    private void btn_siguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siguienteMouseEntered
     puntero.play();
    }//GEN-LAST:event_btn_siguienteMouseEntered

    private void btn_pulsaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pulsaMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_pulsaMouseEntered

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
       puntero.play();
    }//GEN-LAST:event_btn_salirMouseEntered

    private void tbtGuiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtGuiaMouseEntered
        puntero.play();
    }//GEN-LAST:event_tbtGuiaMouseEntered

    private void mitEntrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEntrenarActionPerformed
        super.entrenar();
    }//GEN-LAST:event_mitEntrenarActionPerformed

    private void btn_negroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_negroMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_negroMouseEntered

    private void btn_negroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_negroActionPerformed
        lienzo.setColor(Color.black);
    }//GEN-LAST:event_btn_negroActionPerformed

    private void btn_deshacerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deshacerMouseEntered
        puntero.play();
    }//GEN-LAST:event_btn_deshacerMouseEntered

    private void btn_deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deshacerActionPerformed
        lienzo.deshacerTrazo();
    }//GEN-LAST:event_btn_deshacerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_deshacer;
    private javax.swing.JButton btn_lila;
    private javax.swing.JButton btn_marron;
    private javax.swing.JButton btn_mas;
    private javax.swing.JButton btn_menos;
    private javax.swing.JButton btn_naranja;
    private javax.swing.JButton btn_negro;
    private javax.swing.JButton btn_pulsa;
    private javax.swing.JButton btn_rojo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JButton btn_verde;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mitAbrir;
    private javax.swing.JMenuItem mitEntrenar;
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
    private javax.swing.JPanel pnl_tutor;
    private javax.swing.JToggleButton tbtCuadricula;
    private javax.swing.JToggleButton tbtGuia;
    private javax.swing.JLabel txt_dificultad;
    private javax.swing.JLabel txt_intentosf;
    private javax.swing.JLabel txt_nivel;
    private javax.swing.JLabel txt_puntos;
    private javax.swing.JLabel txt_tutor;
    // End of variables declaration//GEN-END:variables

}
