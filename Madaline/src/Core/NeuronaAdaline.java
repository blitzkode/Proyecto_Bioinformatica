package Core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ad")
public class NeuronaAdaline {
    private double[] ps;
    private static final double UMBRAL = 1;
    private static final double E = 0.0001; // tasa de aprendizaje

    public NeuronaAdaline() {
        
    }
    
    public NeuronaAdaline(double[] pesos) {
        this.ps = pesos;
    }
    
    public double salidaOriginal(byte[] entradas) {
        return propagacion(entradas);
    }

    public void entrenar(byte[][] entradas, byte[] salidas) {
        boolean error = false;
        do {
            for (int i = 0; i < entradas.length; i++) {
                byte y = calcularSalida(entradas[i]); // salida de la neurona
                byte d = salidas[i]; // salida deseada
                error = (y != d);
                if (error) {
                    ajustarPesos(entradas[i], d);
                    break;
                }
            }
        } while (error);
    }
    
    protected double propagacion(byte[] entradas) {
        double suma = ps[0] * UMBRAL;
        for (int i = 0; i < entradas.length; i++) {
            suma += ps[i+1] * entradas[i];
        }
        return suma;
    }
    
    public byte calcularSalida(byte[] entradas) {
        return funcionActivacion(propagacion(entradas));
    }
    
    public byte funcionActivacion(double x) {
        return (byte) (x < 0 ? -1 : 1);
    }

    protected void ajustarPesos(byte[] entradas, byte salidaDeseada) {
        double y = propagacion(entradas);
        ps[0] += (E * (salidaDeseada - y) * UMBRAL);
        
        for (int i = 0; i < entradas.length; i++) {
            ps[i+1] += (E * (salidaDeseada - y) * entradas[i]);
        }
    }
    
    public String toString(int decimales) {
        String cadena = "";
        for (int i=0; i<ps.length; i++) {
            cadena += String.format("W%d= %."+decimales+"f ", i, ps[i]);
        }
        return cadena;
    }
    
    @XmlElementWrapper(name = "ps")
    @XmlElement(name="p")
    public double[] getPs() {
        return ps;
    }

    public void setPs(double[] ps) {
        this.ps = ps;
    }
}
