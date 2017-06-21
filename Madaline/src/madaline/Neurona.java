package madaline;

public abstract class Neurona {
    protected double[] pesos;
    protected double umbral;

    public Neurona(double[] pesos, int umbral) {
        this.pesos = pesos;
        setUmbral(umbral);
    }
        
    public void entrenar(double[][] entradas, int[] salidas) {
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
    
    protected double combinacion(double[] entradas) {
        double suma = pesos[0] * umbral;
        for (int i = 0; i < entradas.length; i++) {
            suma += pesos[i+1] * entradas[i];
        }
        return suma;
    }
    
    public abstract int calcularSalida(double[] entradas);
    
    public abstract int funcionActivacion(double salida);
    
    protected abstract void ajustarPesos(double[] entradas, int salidaDeseada);

    public double[] getPesos() {
        return pesos;
    }
        
    public void setUmbral(double u) {
        umbral = u;
    }
}
