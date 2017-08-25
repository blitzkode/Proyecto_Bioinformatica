package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wallpaper extends JPanel {

    JPanel container;
    String nombre;

    boolean cuadrado = false;

    public Wallpaper(String nombre, JPanel contenedor) {
        this.nombre = nombre;
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
    }

    public Wallpaper(String nombre, JPanel contenedor, boolean cuadrado) {
        this(nombre, contenedor);
        this.cuadrado = cuadrado;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Dimension tam = getSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource(nombre));

        g.drawImage(imagen.getImage(), 0, 0, cuadrado ? tam.height : tam.width, tam.height, null);

        setOpaque(false);
        String ext = nombre.substring(nombre.length() - 3);

        if (ext.equals("gif")) {
            timer.start();
        }

    }

    Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            repaint();

        }
    });

}
