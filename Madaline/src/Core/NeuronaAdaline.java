package Core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ad")
public class NeuronaAdaline {
    private double[] pesos;
    private static final double UMBRAL = 1;
    private static final double E = 0.0001; // tasa de aprendizaje

    public NeuronaAdaline() {
        
    }
    
    public NeuronaAdaline(double[] pesos) {
        this.pesos = pesos;
        //this.calcularE();
    }
    
    public double salidaOriginal(byte[] entradas) {
        return propagacion(entradas);
    }

    public void entrenar(byte[][] entradas, byte[] salidas) {
//        calcularE();
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
        double suma = pesos[0] * UMBRAL;
        for (int i = 0; i < entradas.length; i++) {
            suma += pesos[i+1] * entradas[i];
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
        pesos[0] += (E * (salidaDeseada - y) * UMBRAL);
        
        for (int i = 0; i < entradas.length; i++) {
            pesos[i+1] += (E * (salidaDeseada - y) * entradas[i]);
        }
    }
    
    public String toString(int decimales) {
        String cadena = "";
        for (int i=0; i<pesos.length; i++) {
            cadena += String.format("W%d= %."+decimales+"f ", i, pesos[i]);
        }
        return cadena;
    }
    
    @XmlElementWrapper(name = "ps")
    @XmlElement(name="p")
    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }
    
//    private void calcularE() {
//        this.e = 1.0/pesos.length;
//    }
}
