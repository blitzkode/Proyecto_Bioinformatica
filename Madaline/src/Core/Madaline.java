package Core;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="mad")
@XmlType(propOrder = {"nom", "ads"})
public class Madaline {
    private String nom;
    private NeuronaAdaline[] ads;
    
    public Madaline() {
        
    }
    
    public Madaline(int adalines) {
        this.ads = new NeuronaAdaline[adalines];
    }
    
    public Madaline(double[][] pesosAdalines) {
        this(pesosAdalines.length);
        inicializarAdalines(pesosAdalines);
        this.nom = "";
    }
    
    public Madaline(String nombre, double [][] pesosAdalines) {
        this(pesosAdalines);
        this.nom = nombre;
    }
    
    private void inicializarAdalines(double[][] pesosAdalines) {
        for (int i=0; i<ads.length; i++) {
            ads[i] = new NeuronaAdaline(pesosAdalines[i]);
        }
    }
    
    public void entrenar(byte[][] entradas, byte[] salidasDeseadas) {
        boolean error = false;
        do {
            for (int i = 0; i < entradas.length; i++) {
                byte m = calcularSalida(entradas[i]); // salida del madaline
                byte d = salidasDeseadas[i]; // salida deseada
                error = (m != d);
                if (error) {
                    ajustarPesos(entradas[i], d);
                    break;
                }
            }
        } while (error);        
    }
    
    public void entrenar(byte [] entrada, byte salidaDeseada) {
        entrenar(new byte[][] {entrada}, new byte[] {salidaDeseada});
    }
    
    protected void ajustarPesos(byte[] entradas, byte salidaDeseada) {
        int c = adalineGanador(entradas, salidaDeseada);
        ads[c].ajustarPesos(entradas, salidaDeseada);
    }
    
    protected int adalineGanador(byte[] entradas, byte salidaDeseada) {
        double[] salidas = salidasAdalines(entradas);
        int pos_ganador = 0;
        double cercanoACero = Integer.MAX_VALUE;
        for (int i = 0; i < salidas.length; i++) {
            if ( ads[i].calcularSalida(entradas) != salidaDeseada && // adaline con salida erronea
                    Math.abs(salidas[i]) < cercanoACero) {
                cercanoACero = Math.abs(salidas[i]);
                pos_ganador = i;
            }
        }
        return pos_ganador;
    }
    
    public byte calcularSalida(byte[] entradas) {
        byte[] salidas = new byte[ads.length];
        for (int i = 0; i < salidas.length; i++) {
            salidas[i] = ads[i].calcularSalida(entradas);
        }
        return funcionMayoria(salidas);
    }
    
    public double[] salidasAdalines(byte[] entradas) {
        double[] salidas = new double[ads.length];
        for (int i = 0; i < salidas.length; i++) {
            salidas[i] = ads[i].salidaOriginal(entradas);
        }
        return salidas;
    }
    
    protected byte funcionMayoria(byte[] entradas) {
        int mas = 0, menos = 0;
        for (int entrada : entradas) {
            if (entrada == 1) mas++;
            else menos++;
        }
        return (byte) (mas >= menos ? 1 : -1);
    }
    
    public double[][] getPesos() {
        double[][] pesos = new double[ads.length][];
        for (int i=0; i<ads.length; i++) {
            pesos[i] = ads[i].getPesos();
        }
        return pesos;
    }
    
    @Override
    public String toString() {
        return toString(4);
    }
    
    public String toString(int decimales) {
        String cadena = "";
        for (int i = 0; i < ads.length; i++) {
            cadena += String.format("Adaline %d: %s\n", 
                    (i+1), ads[i].toString(decimales));
        }
        return cadena;
    }

    @XmlElementWrapper(name = "ads")
    @XmlElement(name="ad")
    public NeuronaAdaline[] getAds() {
        return ads;
    }

    public void setAdalines(NeuronaAdaline[] adalines) {
        this.ads = adalines;
    }
    
    @XmlAttribute(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNombre(String nombre) {
        this.nom = nombre;
    }
    
}
