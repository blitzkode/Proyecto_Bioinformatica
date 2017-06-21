package madaline;

public class NeuronaAdaline extends Neurona {
    private double e; // tasa de aprendizaje

    public NeuronaAdaline(double[] pesos) {
        super(pesos, 1);
        this.e = 1.0/pesos.length;
    }
    
    public double salidaOriginal(double[] entradas) {
        return combinacion(entradas);
    }
    
    @Override
    public int calcularSalida(double[] entradas) {
        return funcionActivacion(combinacion(entradas));
    }

    @Override
    public int funcionActivacion(double salida) {
        return (salida < 0 ? -1 : 1);
    }

    @Override
    protected void ajustarPesos(double[] entradas, int salidaDeseada) {
        double y = combinacion(entradas);
        pesos[0] += (e * (salidaDeseada - y) * umbral);
        
        for (int i = 0; i < entradas.length; i++) {
            pesos[i+1] += (e * (salidaDeseada - y) * entradas[i]);
        }
    }
    
    public String pesosString(int decimales) {
        String cadena = "";
        for (int i=0; i<pesos.length; i++) {
            cadena += String.format("W%d= %."+decimales+"f ", i, pesos[i]);
        }
        return cadena;
    }

}
