package madaline;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Maneja una lista de redes Madaline que reconocen un caracter cada una
 * @author fyetka
 */
@XmlRootElement(name="basededatos")
public class Reconocedor {
    private ArrayList<Madaline> madalines = new ArrayList();
    
    public Reconocedor() {
        
    }
    
    /**
     * Retorna el caracter asociado a un patrón
     * @param patron Patrón a reconocer
     * @return caracter (letra o número) reconocido
     */
    public String reconocerCaracter(int[] patron) {
        String caracter = "";
        
        for (Madaline neurona : madalines) {
            int salida = neurona.calcularSalida(patron);
            if (salida == 1) {
                caracter = neurona.getNombre();
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
    public void entrenar(String caracter, int [] patron) {
        for (Madaline madaline : madalines) {
            if ( madaline.getNombre().equals(caracter) ) {
                madaline.entrenar(patron, 1);
            }
            else {
                madaline.entrenar(patron, -1);
            }
        }
    }

    public void iniciarMadalinesDefault() {
        ArrayList<Madaline> madalines_default = new ArrayList<>();
        //TODO
        madalines_default.add(new Madaline("A", 
                new double[][] {
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0}
                }
        ));
        
        this.madalines = madalines_default;
    }
    
    @XmlElementWrapper(name="madalines")
    @XmlElement(name="madaline")
    public ArrayList<Madaline> getMadalines() {
        return madalines;
    }

    public void setMadalines(ArrayList<Madaline> madalines) {
        this.madalines = madalines;
    }
    
    
}
