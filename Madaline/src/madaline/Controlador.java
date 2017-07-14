package madaline;

import javax.xml.bind.JAXBException;

/**
 * Clase principal de la aplicación. Contiene los métodos a ser usados por
 * cualquier interfaz.
 * @author fyetka
 */
public class Controlador {
    private Reconocedor reconocedor;
    //TODO Procesador de imagen
    private String RUTA_BD = "xmlsrc/basededatos.xml"; // Ubicación de la BD
    
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
    public String reconocerImagen(int[][] imagen) {
        //TODO procesar imagen
        String caracter = reconocedor.reconocerCaracter(new int[] {});
        return caracter;
    }
    
    /**
     * Guarda una imagen binaria para ser reconocida como la representación de
     * un caracter.
     * @param imagen Matriz binaria que representa a la imagen
     * @param caracter Caracter correspondiente a la imagen (se distinguen
     *                  mayúsculas de minúsculas)
     */
    public void guardarCaracter(int [][] imagen, String caracter) {
        //TODO procesar imagen
        reconocedor.entrenar(caracter, new int[] {});
        try {
            ReconocedorDataAccess.escribirBD(reconocedor, this.RUTA_BD);
        } catch (JAXBException ex) {
            
        }
    }
}
