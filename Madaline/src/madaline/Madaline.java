package madaline;

public class Madaline {
    private NeuronaAdaline[] capaAdalines;
    private int numAdalines;
    
    public Madaline(int adalines) {
        capaAdalines = new NeuronaAdaline[adalines];
        numAdalines = adalines;
    }
    
    public Madaline(double[][] pesosAdalines) {
        this(pesosAdalines.length);
        inicializarAdalines(pesosAdalines);
    }
    
    protected void inicializarAdalines(double[][] pesosAdalines) {
        for (int i=0; i<numAdalines; i++) {
            capaAdalines[i] = new NeuronaAdaline(pesosAdalines[i]);
        }
    }
    
    public void entrenar(double[][] entradas, int[] salidasDeseadas) {
        boolean error = false;
        int iter = 1;
        do {
            //System.out.println("iteracion " + iter);iter++;
            for (int i = 0; i < entradas.length; i++) {
//                    System.out.print(""+(i+1)+" ");
//                    for (double salidasAdaline : salidasAdalines(entradas[i])) {
//                        System.out.printf("Y= %.4f ", salidasAdaline);
//                    }System.out.println();
                int m = calcularSalida(entradas[i]); // salida del madaline
                int d = salidasDeseadas[i]; // salida deseada
                error = (m != d);
                if (error) {
                    ajustarPesos(entradas[i], d);//System.out.println(this.pesosToString(4));
                    break;
                }
            }
        } while (error);        
    }
    
    protected void ajustarPesos(double[] entradas, int salidaDeseada) {
        int c = adalineGanador(entradas, salidaDeseada);
        capaAdalines[c].ajustarPesos(entradas, salidaDeseada);
    }
    
    protected int adalineGanador(double[] entradas, int salidaDeseada) {
        double[] salidas = salidasAdalines(entradas);
        int pos_ganador = 0;
        double cercanoACero = Integer.MAX_VALUE;
        for (int i = 0; i < salidas.length; i++) {
            if ( capaAdalines[i].calcularSalida(entradas) != salidaDeseada && // adaline con salida erronea
                    Math.abs(salidas[i]) < cercanoACero) {
                cercanoACero = Math.abs(salidas[i]);
                pos_ganador = i;
            }
        }
        return pos_ganador;
    }
    
    public int calcularSalida(double[] entradas) {
        int[] salidas = new int[numAdalines];
        for (int i = 0; i < salidas.length; i++) {
            salidas[i] = capaAdalines[i].calcularSalida(entradas);
            System.out.println(i + ": "+ capaAdalines[i].salidaOriginal(entradas));
        }
        return funcionMayoria(salidas);
    }
    
    public double[] salidasAdalines(double[] entradas) {
        double[] salidas = new double[numAdalines];
        for (int i = 0; i < salidas.length; i++) {
            salidas[i] = capaAdalines[i].salidaOriginal(entradas);
        }
        return salidas;
    }
    
    protected int funcionMayoria(int[] entradas) {
        int mas = 0, menos = 0;
        for (int entrada : entradas) {
            if (entrada == 1) mas++;
            else menos++;
        }
        return (mas >= menos ? 1 : -1);
    }
    
    public double[][] getPesos() {
        double[][] pesos = new double[numAdalines][];
        for (int i=0; i<numAdalines; i++) {
            pesos[i] = capaAdalines[i].getPesos();
        }
        return pesos;
    }
    
    public String pesosToString(int decimales) {
        String cadena = "";
        for (int i = 0; i < numAdalines; i++) {
            cadena += String.format("Adaline %d: %s\n", 
                    (i+1), capaAdalines[i].pesosString(decimales));
        }
        return cadena;
    }
}
