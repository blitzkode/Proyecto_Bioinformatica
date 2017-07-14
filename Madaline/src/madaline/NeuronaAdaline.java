package madaline;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="adaline")
public class NeuronaAdaline {
    private double[] pesos;
    private static final double UMBRAL = 1;
    private double e; // tasa de aprendizaje

    public NeuronaAdaline() {
        
    }
    
    public NeuronaAdaline(double[] pesos) {
        this.pesos = pesos;
        this.calcularE();
    }
    
    public double salidaOriginal(int[] entradas) {
        return propagacion(entradas);
    }

    public void entrenar(int[][] entradas, int[] salidas) {
        calcularE();
        boolean error = false;
        do {
            for (int i = 0; i < entradas.length; i++) {
                int y = calcularSalida(entradas[i]); // salida de la neurona
                int d = salidas[i]; // salida deseada
                error = (y != d);
                if (error) {
                    ajustarPesos(entradas[i], d);
                    break;
                }
            }
        } while (error);
    }
    
    protected double propagacion(int[] entradas) {
        double suma = pesos[0] * UMBRAL;
        for (int i = 0; i < entradas.length; i++) {
            suma += pesos[i+1] * entradas[i];
        }
        return suma;
    }
    
    public int calcularSalida(int[] entradas) {
        return funcionActivacion(propagacion(entradas));
    }
    
    public int funcionActivacion(double x) {
        return (x < 0 ? -1 : 1);
    }

    protected void ajustarPesos(int[] entradas, int salidaDeseada) {
        double y = propagacion(entradas);
        pesos[0] += (e * (salidaDeseada - y) * UMBRAL);
        
        for (int i = 0; i < entradas.length; i++) {
            pesos[i+1] += (e * (salidaDeseada - y) * entradas[i]);
        }
    }
    
    public String toString(int decimales) {
        String cadena = "";
        for (int i=0; i<pesos.length; i++) {
            cadena += String.format("W%d= %."+decimales+"f ", i, pesos[i]);
        }
        return cadena;
    }
    
    @XmlElementWrapper(name = "pesos")
    @XmlElement(name="peso")
    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }
    
    private void calcularE() {
        this.e = 1.0/pesos.length;
    }
}
