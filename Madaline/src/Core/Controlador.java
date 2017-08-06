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
    private Reconocedor reconocedor_vocales;
    private Reconocedor reconocedor_digitos;
    private Reconocedor reconocedor_actual;
    private String BD_VOCALES = "xmlsrc/bd_vocales.xml"; // Ubicación de la BD
    private String BD_DIGITOS = "xmlsrc/bd_digitos.xml"; // Ubicación de la BD
    private String BD_ACTUAL;
    private String RUTA_IMG = "img"; // Ubicación de las imagenes de entrenamiento
    
    private int puntos;
    private int intentos;
    private ArrayList<String> caracteres_partida;
    private String[] caracteres_actual;
    private static final String[] vocales = {
        "A","E","I","O","U","a","e","i"
    };
    private static final String[] digitos = {
        "0","1","2","3","4","5","6","7","8","9"
    };
    
    /**
     * Constructor por defecto. Si no se encuentra el archivo XML con los pesos
     * de los Madalines se crea un nuevo Reconocedor con los pesos por defecto.
     */
    public Controlador() {
        try {
            this.reconocedor_vocales = ReconocedorDataAccess.leerBD(this.BD_VOCALES);
        } catch (JAXBException ex) {
            this.reconocedor_vocales = new Reconocedor();
            this.reconocedor_vocales.iniciarMadalinesDefault(vocales);
        }
        try {
            this.reconocedor_digitos = ReconocedorDataAccess.leerBD(this.BD_DIGITOS);
        } catch (JAXBException ex) {
            this.reconocedor_digitos = new Reconocedor();
            this.reconocedor_digitos.iniciarMadalinesDefault(digitos);
        }
        // por defecto reconcer vocales
        setModoReconocimiento(0);
    }
    
    /**
     * Establece el modo de reconocimiento de la aplicación.
     * @param modo 0 (vocales), 1 (dígitos)
     */
    public void setModoReconocimiento(int modo) {
        switch (modo) {
            case 0:
                this.reconocedor_actual = this.reconocedor_vocales;
                this.BD_ACTUAL = this.BD_VOCALES;
                this.caracteres_actual = vocales;
                break;
            case 1:
                this.reconocedor_actual = this.reconocedor_digitos;
                this.BD_ACTUAL = this.BD_DIGITOS;
                this.caracteres_actual = digitos;
                break;
        }
    }
    
    public void nuevoJuego() {
        puntos = 0; intentos = 0;
        caracteres_partida = new ArrayList<>();
        
        for (String caracter : caracteres_actual) {
            caracteres_partida.add(caracterAleatorio());
        }
    }
    
    public boolean jugar(BufferedImage imagen) {
        boolean acierto;
        
        String caracter = caracteres_partida.get(0);
        acierto = comparar(imagen, caracter);
        intentos++;
        if (acierto) {
            caracteres_partida.remove(0);
            puntos++;
        }
        return acierto;
    }
    
    public boolean juegoTerminado() {
        return caracteres_partida.isEmpty();
    }
    
    public int getEstrellas() {
        //TODO
        return 3;
    }
    
    private String caracterAleatorio() {
        Random r = new Random();
        String car;
        do {
            car = caracteres_actual[r.nextInt(caracteres_actual.length)];
        } while(caracteres_partida.contains(car));
        return car;
    }
    
    public boolean comparar(BufferedImage imagen, String caracter) {
        String caracter_reconocido = reconocerImagen(imagen);
        if (esAmbiguo(caracter) && caracter.equalsIgnoreCase(caracter_reconocido)) {
            return true;
        }
        return caracter.equals(caracter_reconocido);
    }
    
    /**
     * Obtiene el caracter dibujado en una imagen binaria.
     * @param imagen Matriz binaria que representa a la imagen
     * @return Caracter reconocido ([a-zA-Z0-9]). Devuelve una cadena vacía si
     *          la imagen no corresponde a un caracter
     */
    public String reconocerImagen(BufferedImage imagen) {
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        String caracter = reconocedor_actual.reconocerCaracter(patron);
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
        reconocedor_actual.entrenar(caracter, patron);        
    }
    
    public void entrenamientoManual(BufferedImage imagen, String caracter, byte validez) {
        validez = (byte) (validez < 0 ? -1 : 1);
        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
        reconocedor_actual.entrenar(caracter, patron, validez);
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
            ReconocedorDataAccess.escribirBD(reconocedor_actual, BD_ACTUAL);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
    public int entrenamientoPorLotes() {
        int imagenes_entrenadas = 0;
        for (String caracter : vocales) {
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
        TablaEntrenamiento[] tablas = new TablaEntrenamiento[caracteres_actual.length];
        for (int i=0; i < tablas.length; i++) {
            tablas[i] = new TablaEntrenamiento();
        }
        
        for (int i=0; i < tablas.length; i++) {
            String caracter = caracteres_actual[i];
            
            File directorio = new File(RUTA_IMG, caracter);
            if (directorio.exists()) {
                String[] contenido = directorio.list();
                for (String archivoImagen : contenido) {
                    try {
                        BufferedImage imagen = ImageIO.read(new File(directorio, archivoImagen));
                        byte[] patron = ProcesarImagen.ProcesoImagen(imagen);
                        
                        for (int j = 0; j < tablas.length; j++) {
                            tablas[j].addCaso(patron, (byte)(i == j ? 1 : -1));
                        }
                        
                        imagenes++;
                    } catch (IOException ex) {
                    }
                }
            }
        }
        
        byte[][][] entradas = new byte[tablas.length][][];
        byte[][] salidas = new byte[tablas.length][];
        for (int i = 0; i < tablas.length; i++) {
            entradas[i] = tablas[i].getPatrones();
            salidas[i] = tablas[i].getSalidas();
        }
        reconocedor_actual.entrenar(entradas, salidas);
        commit();
        return imagenes;
    }

    public int getPuntos() {
        return puntos;
    }

    public ArrayList<String> getCaracteres_partida() {
        return caracteres_partida;
    }

    public String getLetraActual() {
        return caracteres_partida.get(0);
    }
    

    public int getIntentos() {
        return intentos;
    }
    
    class Patron {
        byte[] patron;

        public Patron(byte[] patron) {
            this.patron = patron;
        }
    }
    
    class TablaEntrenamiento {
        String letra;
        ArrayList<Patron> patrones = new ArrayList<>();
        ArrayList<Byte> salidas = new ArrayList<>();
        
        public TablaEntrenamiento() {
            
        }
        
        public TablaEntrenamiento(String letra) {
            this.letra = letra;
        }
        
        public void addCaso(byte[] patron, byte salida) {
            patrones.add(new Patron(patron));
            salidas.add(salida);
        }
                
        public byte[][] getPatrones() {
            byte[][] array_patrones = new byte[patrones.size()][];
            for (int i = 0; i < array_patrones.length; i++) {
                array_patrones[i] = patrones.get(i).patron;
            }
            return array_patrones;
        }
        
        public byte[] getSalidas() {
            byte[] array_salidas = new byte[salidas.size()];
            for (int i = 0; i < array_salidas.length; i++) {
                array_salidas[i] = salidas.get(i);
            }
            return array_salidas;
        }

    }
    
}
