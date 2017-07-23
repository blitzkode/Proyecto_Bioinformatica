package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Lienzo extends JPanel {
    private ArrayList<Linea> lineas = new ArrayList<>();
    private Color color;
    private int grosor;
    private Point pincel;
    
    public Lienzo() {
        this.color = Color.BLACK;
        this.setBackground(Color.white);
        this.grosor = 14;
        
        EventHandler manejador = new EventHandler();
        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);
    }

    public BufferedImage getImagen() {
        BufferedImage imagen = new BufferedImage(this.getWidth(),
                                this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        this.paint(imagen.getGraphics());
        return imagen;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Linea l : lineas) {
            draw.setStroke(new BasicStroke(l.grosor,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
            draw.setColor(l.color);
            draw.draw(l.shape);
        }
        if (pincel != null) {
            draw.setStroke(new BasicStroke());
            draw.setColor(color);
            draw.fillOval(pincel.x - grosor/2, pincel.y - grosor/2, grosor, grosor);
        }
    }
    
    public void limpiarContenido() {
        this.lineas = new ArrayList<>();
        repaint();
    }

    public void deshacerTrazo() {
        if (lineas.isEmpty()) return;
        
        lineas.remove(lineas.size()-1);
        repaint();
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }
    
    public void aumentarGrosor() {
        this.grosor += (this.grosor == 30 ? 0 : 4);
    }
    
    public void disminuirGrosor() {
        this.grosor -= (this.grosor == 14 ? 0 : 4);
    }

    public int getGrosor() {
        return this.grosor;
    }
    
    
    class EventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            Path2D linea = new Path2D.Float();
            linea.moveTo(e.getX(), e.getY());
            linea.lineTo(e.getX(), e.getY());
            lineas.add(new Linea(linea, color, grosor));
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            pincel = null;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            lineas.get(lineas.size()-1).shape.lineTo(e.getX(), e.getY());
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            pincel = new Point(e.getX(), e.getY());
            repaint();
        }
        
        //<editor-fold defaultstate="collapsed" desc="Eventos no usados">
        @Override
        public void mouseClicked(MouseEvent e) {}
        
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}
        //</editor-fold>
    }
}

class Linea {
    Path2D shape;
    Color color;
    int grosor;

    public Linea(Path2D shape, Color color, int grosor) {
        this.shape = shape;
        this.color = color;
        this.grosor = grosor;
    }
    
}
