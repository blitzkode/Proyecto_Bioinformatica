package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Wallpaper extends JPanel {
    ImageIcon imagen;
    JPanel container;
    String nombre;
    Color trans;

    boolean cuadrado = false;

    public Wallpaper(String nombre, JPanel contenedor) {
        this.setBackground(Color.white);
        
        this.container = contenedor;
        this.container.add(this);
        this.container.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(container.getSize());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
        
        setImagen(nombre);
    }

    public Wallpaper(String nombre, JPanel contenedor, boolean cuadrado) {
        this(nombre, contenedor);
        this.cuadrado = cuadrado;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Dimension tam = getSize();

        g.drawImage(imagen.getImage(), 0, 0,
                    cuadrado ? tam.height : tam.width,
                    tam.height, this);

        if (trans != null) {
            g.setColor(trans);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        
        setOpaque(false);
        String ext = nombre.substring(nombre.length() - 3);

    }
    
    /**
     * Cambia la imagen de fondo con una transición suave. Se debe llamar a
     * este método dentro de un hilo.
     * @param nuevo Ruta de la nueva imagen de fondo
     * @param t1 Duración del cambio de opacidad en milisegundos
     * @param color1 Primer color de la transición
     * @param color2 Segundo color de la transición
     */
    public void transicion(String nuevo, int t1, Color color1, Color color2) {
        int inc = 5, // incremento de la opacidad
            delay = (int) (t1 / (255 / inc));
        
        trans = color1;
        for (int alfa = 0; alfa < 256; alfa += inc) {
            cambiarAlfaTrans(alfa);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {}
        }
        
        setImagen(nuevo);
        
        while ( !trans.equals(color2) ) {
            int inc_r, inc_g, inc_b;
            inc_r = incrementoColor(trans.getRed(), color2.getRed());
            inc_g = incrementoColor(trans.getGreen(), color2.getGreen());
            inc_b = incrementoColor(trans.getBlue(), color2.getBlue());
            trans = new Color(
                    trans.getRed() + inc_r,
                    trans.getGreen() + inc_g, 
                    trans.getBlue() + inc_b
            );
            repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {}
        }
        
        for (int alfa = 255; alfa >= 0; alfa -= inc) {
            cambiarAlfaTrans(alfa);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {}
        }
    }
    
    private int incrementoColor(int color_a, int color_b) {
        int inc = 5;
        int dif = color_b - color_a;
        return Math.abs(dif) < inc ? dif : (dif / Math.abs(dif)) * inc;
    }
    
    private void cambiarAlfaTrans(int alfa) {
        trans = new Color(
                    trans.getRed(),
                    trans.getGreen(), 
                    trans.getBlue(),
                    alfa
            );
        repaint();
    }

    public void setImagen(String nombre) {
        this.imagen = new ImageIcon(getClass().getResource(nombre));
        this.nombre = nombre;
    }

}
