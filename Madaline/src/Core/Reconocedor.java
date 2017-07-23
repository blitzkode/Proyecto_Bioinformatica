package Core;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Maneja una lista de redes Madaline que reconocen un caracter cada una
 * @author fyetka
 */
@XmlRootElement(name="bd")
public class Reconocedor {
    private ArrayList<Madaline> mads = new ArrayList();
    
    public Reconocedor() {
        
    }
    
    /**
     * Retorna el caracter asociado a un patrón
     * @param patron Patrón a reconocer
     * @return caracter (letra o número) reconocido
     */
    public String reconocerCaracter(byte[] patron) {
        String caracter = "";
        
        for (Madaline neurona : mads) {
            int salida = neurona.calcularSalida(patron);
            if (salida == 1) {
                caracter = neurona.getNom();
                break;
            }
        }
        
        return caracter;
    }
    
    /**
     * Entrena al Madaline correspondiente a un caracter para que reconozca un
     * patrón y a los demás para que lo reconozcan como inválido. Se diferencia
     * entre mayúsculas y minúsculas.
     * @param caracter Caracter a reconocer
     * @param patron Patrón asociado al caracter
     */
    public void entrenar(String caracter, byte [] patron) {
        for (Madaline madaline : mads) {
            madaline.entrenar(patron,
                    (byte) (madaline.getNom().equals(caracter) ? 1 : -1) );
        }
    }

    public void iniciarMadalinesDefault(String[] caracteres) {
        ArrayList<Madaline> madalines_default = new ArrayList<>();
        
        double[][] pesos = new double[5][100*100+1];
        for (String caracter : caracteres) {
            madalines_default.add(new Madaline(caracter, pesos));
        }
        
        this.mads = madalines_default;
    }
    
    @XmlElementWrapper(name="mads")
    @XmlElement(name="mad")
    public ArrayList<Madaline> getMads() {
        return mads;
    }

    public void setMads(ArrayList<Madaline> madalines) {
        this.mads = madalines;
    }
    
    
}
