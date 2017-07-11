package madaline;

public class NeuronaAdaline extends Neurona {
    private double e; // tasa de aprendizaje

    public NeuronaAdaline(double[] pesos) {
        super(pesos, 1);
        this.e = 1.0/pesos.length;
    }
    
    public double salidaOriginal(int[] entradas) {
        return propagacion(entradas);
    }

    @Override
    public int funcionActivacion(double x) {
        return (x < 0 ? -1 : 1);
    }

    @Override
    protected void ajustarPesos(int[] entradas, int salidaDeseada) {
        double y = propagacion(entradas);
        pesos[0] += (e * (salidaDeseada - y) * umbral);
        
        for (int i = 0; i < entradas.length; i++) {
            pesos[i+1] += (e * (salidaDeseada - y) * entradas[i]);
        }
    }
    
}
