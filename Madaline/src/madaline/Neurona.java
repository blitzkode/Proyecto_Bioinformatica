package madaline;

public abstract class Neurona {
    protected double[] pesos;
    protected double umbral;

    public Neurona(double[] pesos, int umbral) {
        this.pesos = pesos;
        setUmbral(umbral);
    }
        
    public void entrenar(int[][] entradas, int[] salidas) {
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
        double suma = pesos[0] * umbral;
        for (int i = 0; i < entradas.length; i++) {
            suma += pesos[i+1] * entradas[i];
        }
        return suma;
    }
    
    public int calcularSalida(int[] entradas) {
        return funcionActivacion(propagacion(entradas));
    }
    
    public abstract int funcionActivacion(double x);
    
    protected abstract void ajustarPesos(int[] entradas, int salidaDeseada);

    public String toString(int decimales) {
        String cadena = "";
        for (int i=0; i<pesos.length; i++) {
            cadena += String.format("W%d= %."+decimales+"f ", i, pesos[i]);
        }
        return cadena;
    }
    
    public double[] getPesos() {
        return pesos;
    }
        
    public void setUmbral(double u) {
        umbral = u;
    }
}
