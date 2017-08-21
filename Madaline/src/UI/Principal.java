package UI;

import Core.Controlador;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    Controlador aplicacion;
    int modo_juego;
    javax.swing.JFrame padre;
    Lienzo lienzo;
    
    public Principal(Controlador aplicacion, javax.swing.JFrame padre) {
        this.aplicacion = aplicacion;
        this.padre = padre;
        lienzo = new Lienzo();
    }
    
    protected void salir() {
        padre.setVisible(true);
        dispose();
    }
    
    protected void entrenar() {
        try {
            String actual = aplicacion.getLetraActual();
            File directorio = new File(aplicacion.RUTA_IMG, actual);
            boolean mayus = actual.equals(actual.toUpperCase()) && 
                            !actual.matches("[0-9]");
            
            String nombre = String.format("%s%s_%d.jpg",
                                            actual,
                                            mayus ? "M" : "",
                                            directorio.list().length+1);
            File archivo = new File(directorio, nombre);
            lienzo.guardarImagen(archivo);
            aplicacion.entrenamiento();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    aplicacion.commit();
                }
            }).start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar");
        }
    }
    
    protected void cargarFondoLienzo() {
        try {
            BufferedImage fondo = ImageIO.read(new File("src/Iconos/rejilla.jpg"));
            lienzo.setFondo(fondo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
