package UI;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Lienzo extends JPanel {
    private ArrayList<Linea> lineas = new ArrayList<>();
    private Color color;
    private int grosor;
    private Point pincel;
    private BufferedImage imagen;
    private String letra_fondo;
    private int tamFuente;
    private boolean dibujaLetra;
    private String ultima_ubicacion = "img";
    
    public Lienzo() {
        this.color = Color.BLACK;
        this.setBackground(Color.white);
        this.grosor = 14;
        this.letra_fondo = "";
        this.tamFuente = 100;
        this.dibujaLetra = false;
        
        EventHandler manejador = new EventHandler();
        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);
    }

    public BufferedImage getImagen() {
        BufferedImage imagen_dibujo = new BufferedImage(this.getWidth(),
                                this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        boolean ante = dibujaLetra;
        dibujaLetra = false;
        this.paint(imagen_dibujo.getGraphics());
        dibujaLetra = ante;
        return imagen_dibujo;
    }
    
    public void setImagen(BufferedImage imagen) {
        limpiarContenido();
        this.imagen = imagen;
        repaint();
    }
    
    public void abrirImagen() {
        JFileChooser selector = new JFileChooser(ultima_ubicacion);
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        
        if (archivo == null) {
            return;
        }
        ultima_ubicacion = archivo.getPath();
        if ( !archivo.getName().matches("[a-zñA-ZÑ0-9_]*.jpg") ) {
            JOptionPane.showMessageDialog(this, "El nombre de archivo "+ archivo.getName() +" no es válido");
            return;
        }
        try {
            BufferedImage imagen_archivo = ImageIO.read(archivo);
            setImagen(imagen_archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la imagen");
        }
    }
    
    public void guardarImagen() {
        JFileChooser selector = new JFileChooser(ultima_ubicacion);
        selector.showSaveDialog(this);
        File archivo = selector.getSelectedFile();
        
        if (archivo == null) {
            return;
        }
        ultima_ubicacion = archivo.getPath();
        if ( !archivo.getName().matches("[a-zñA-ZÑ0-9_]*.jpg") ) {
            JOptionPane.showMessageDialog(this, "El nombre de archivo "+ archivo.getName() +" no es válido");
            return;
        }
        
        BufferedImage imagen_archivo = getImagen();
        
        try {
            ImageIO.write(imagen_archivo, "jpg", archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la imagen");
        }
    }
    
    public void setLetra(String letra) {
        this.letra_fondo = letra;
        repaint();
    }
    
    public void dibujarLetra(boolean dibujar) {
        this.dibujaLetra = dibujar;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (dibujaLetra) {
            Composite anterior = draw.getComposite();
            Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f);
            draw.setComposite(c);
            draw.setColor(Color.BLACK);
            draw.setFont(new Font("Arial", Font.BOLD, tamFuente));
            int x = (getWidth() - tamFuente) / 2;
            int y = (getHeight() + tamFuente) / 2;
            draw.drawString(letra_fondo, x, y);
            draw.setComposite(anterior);
        }
        if (imagen != null) {
            draw.drawImage(imagen, 0, 0, this);
        }
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
        this.imagen = null;
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
