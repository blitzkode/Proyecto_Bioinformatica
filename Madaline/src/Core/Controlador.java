package Core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;
import procesador_imagenes.ProcesarImagen;

/**
 * Clase principal de la aplicación. Contiene los métodos a ser usados por
 * cualquier interfaz.
 * @author fyetka
 */
public class Controlador {
    private Reconocedor reconocedor;
    private String RUTA_BD = "xmlsrc/basededatos.xml"; // Ubicación de la BD
    private String RUTA_IMG = "img"; // Ubicación de las imagenes de entrenamiento
    
    /**
     * Constructor por defecto. Si no se encuentra el archivo XML con los pesos
     * de los Madalines se crea un nuevo Reconocedor con los pesos por defecto.
     */
    public Controlador() {
        try {
            this.reconocedor = ReconocedorDataAccess.leerBD(this.RUTA_BD);
        } catch (JAXBException ex) {
            this.reconocedor = new Reconocedor();
            this.reconocedor.iniciarMadalinesDefault();
        }
    }
    
    /**
     * Obtiene el caracter dibujado en una imagen binaria.
     * @param imagen Matriz binaria que representa a la imagen
     * @return Caracter reconocido ([a-zA-Z0-9]). Devuelve una cadena vacía si
     *          la imagen no corresponde a un caracter
     */
    public String reconocerImagen(BufferedImage imagen) {
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        String caracter = reconocedor.reconocerCaracter(patron);
        return caracter;
    }
    
    /**
     * Guarda una imagen binaria para ser reconocida como la representación de
     * un caracter.
     * @param imagen Matriz binaria que representa a la imagen
     * @param caracter Caracter correspondiente a la imagen (se distinguen
     *                  mayúsculas de minúsculas)
     */
    public void guardarCaracter(BufferedImage imagen, String caracter) throws JAXBException {
        entrenarCaracter(imagen, caracter);
        commit();
    }
    
    private void entrenarCaracter(BufferedImage imagen, String caracter) {
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        new Thread(() -> {
            reconocedor.entrenar(caracter, patron);
        }).start();
    }
    
    private void commit() throws JAXBException {
        ReconocedorDataAccess.escribirBD(reconocedor, RUTA_BD);
    }
    
    public int entrenamientoPorLotes() throws JAXBException {
        int imagenes_entrenadas = 0;
        for (String caracter : new String[] {"A", "B", "C"}) {
            File directorio = new File(RUTA_IMG, caracter);
            String[] contenido = directorio.list();
            for (String archivoImagen : contenido) {
                try {
                    BufferedImage imagen = ImageIO.read(new File(directorio, archivoImagen));
                    entrenarCaracter(imagen, caracter);
                    imagenes_entrenadas++;
                } catch (IOException ex) {
                }
            }
        }
        commit();
        return imagenes_entrenadas;
    }
    
    public void guardarImagen(BufferedImage imagen, File archivo) throws IOException {
        ImageIO.write(imagen, "jpg", archivo);
    }
}
