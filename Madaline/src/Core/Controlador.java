package Core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
    
    private int puntos;
    private int intentos;
    private ArrayList<String> letras_partida;
    private static final String[] alfabeto = {
        "A","E","I","O","U","a","e","i"
    };
    
    /**
     * Constructor por defecto. Si no se encuentra el archivo XML con los pesos
     * de los Madalines se crea un nuevo Reconocedor con los pesos por defecto.
     */
    public Controlador() {
         
        try {
            this.reconocedor = ReconocedorDataAccess.leerBD(this.RUTA_BD);
        } catch (JAXBException ex) {
            this.reconocedor = new Reconocedor();
            this.reconocedor.iniciarMadalinesDefault(alfabeto);
        }
    }
    
    public void nuevoJuego(int ejercicios) {
        puntos = 0; intentos = 0;
        letras_partida = new ArrayList<>();
        
        for (int i = 0; i < ejercicios; i++) {
            letras_partida.add( letraAleatoria() );
        }
    }
    
    public boolean jugar(BufferedImage imagen) {
        boolean acierto;
        
        String letra = letras_partida.get(0);
        acierto = comparar(imagen, letra);
        intentos++;
        if (acierto) {
            letras_partida.remove(0);
            puntos++;
        }
        return acierto;
    }
    
    private String letraAleatoria() {
        Random r = new Random();
        String letra = alfabeto[ r.nextInt(alfabeto.length) ];
        return letra;
    }
    
    public boolean comparar(BufferedImage imagen, String letra) {
        String letra_reconocida = reconocerImagen(imagen);
        if (esAmbiguo(letra) && letra.equalsIgnoreCase(letra_reconocida)) {
            return true;
        }
        return letra.equals(letra_reconocida);
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
     * @throws javax.xml.bind.JAXBException
     */
    public void guardarCaracter(BufferedImage imagen, String caracter) throws JAXBException {
        entrenarCaracter(imagen, caracter);
        commit();
    }
    
    private void entrenarCaracter(BufferedImage imagen, String caracter) {
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        reconocedor.entrenar(caracter, patron);        
    }
    
    public void entrenamientoManual(BufferedImage imagen, String caracter, byte validez) {
        validez = (byte) (validez < 0 ? -1 : 1);
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        reconocedor.entrenar(caracter, patron, validez);
        commit();
    }
    
    private boolean esAmbiguo(String letra) {
        return (
            letra.equalsIgnoreCase("O") ||
            letra.equalsIgnoreCase("U")
        );
    }
    
    private void commit() {
        try {
            ReconocedorDataAccess.escribirBD(reconocedor, RUTA_BD);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
    public int entrenamientoPorLotes() {
        int imagenes_entrenadas = 0;
        for (String caracter : alfabeto) {
            File directorio = new File(RUTA_IMG, caracter);
            if (directorio.exists()) {
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
        }
        commit();
        return imagenes_entrenadas;
    }
    
    public int entrenamiento() {
        int imagenes = 0;
        ArrayList<LetraEntrenamiento> letras_entrenar = new ArrayList<>();
        
        for (String caracter : alfabeto) {
            letras_entrenar.add(new LetraEntrenamiento(caracter));
            
            File directorio = new File(RUTA_IMG, caracter);
            if (directorio.exists()) {
                String[] contenido = directorio.list();
                for (String archivoImagen : contenido) {
                    try {
                        BufferedImage imagen = ImageIO.read(new File(directorio, archivoImagen));
                        
                        letras_entrenar.get(letras_entrenar.size()-1).addImagenPositiva(imagen);
                        for (int i = 0; i < letras_entrenar.size()-1; i++) {
                            letras_entrenar.get(i).addImagenNegativa(imagen);
                        }
                        
                        imagenes++;
                    } catch (IOException ex) {
                    }
                }
            }
        }
        
        ArrayList<String> letras = new ArrayList<>();
        byte[][][] entradas = new byte[letras_entrenar.size()][][];
        byte[][] salidas = new byte[letras_entrenar.size()][];
        int i=0;
        for (LetraEntrenamiento letra : letras_entrenar) {
            letras.add(letra.getLetra());
            entradas[i] = letra.getPatrones();
            salidas[i] = letra.getSalidas();
            i++;
        }
        reconocedor.entrenar(letras, entradas, salidas);
        commit();
        return imagenes;
    }

    public int getPuntos() {
        return puntos;
    }

    public ArrayList<String> getLetras_partida() {
        return letras_partida;
    }

    public String getLetraActual() {
        return letras_partida.get(0);
    }
    
    public static String[] getAlfabeto() {
        return alfabeto;
    }

    public int getIntentos() {
        return intentos;
    }
    
    class LetraEntrenamiento {
        private String letra;
        private ArrayList<BufferedImage> imagenes_positivas = new ArrayList<>();
        private ArrayList<BufferedImage> imagenes_negativas = new ArrayList<>();
        private byte[][] patrones;
        private byte[] salidas;
        
        public LetraEntrenamiento(String letra) {
            this.letra = letra;
        }
        
        public void addImagenNegativa(BufferedImage imagen) {
            this.imagenes_negativas.add(imagen);
        }
        
        public void addImagenPositiva(BufferedImage imagen) {
            this.imagenes_positivas.add(imagen);
        }
        
        private void calcular() {
            int cant_patrones = imagenes_negativas.size() + imagenes_positivas.size();
            this.patrones = new byte[cant_patrones][];
            this.salidas = new byte[cant_patrones];
            
            int i = 0;
            for (BufferedImage imagen : imagenes_positivas) {
                patrones[i] = ProcesarImagen.ProcesoImagen(imagen);
                salidas[i] = (byte) 1;
                i++;
            }
            for (BufferedImage imagen : imagenes_negativas) {
                patrones[i] = ProcesarImagen.ProcesoImagen(imagen);
                salidas[i] = (byte) -1;
                i++;
            }
            
        }
        
        public byte[][] getPatrones() {
            calcular();
            return patrones;
        }
        
        public byte[] getSalidas() {
            return salidas;
        }

        public String getLetra() {
            return letra;
        }
    }
    
}
