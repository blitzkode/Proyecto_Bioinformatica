package madaline;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        prueba();
    }

    public static void prueba() {
        double[][] entradas = {
            { 1, 1, 1, 1,-1,-1,-1,-1,-1},
            {-1, 1, 1,-1, 1,-1,-1, 1,-1},
            {-1, 1,-1,-1, 1,-1, 1, 1,-1},
            {-1, 1,-1,-1, 1,-1,-1, 1,-1},
            {-1,-1, 1,-1,-1, 1,-1, 1, 1},
            {-1, 1,-1, 1,-1,-1, 1,-1,-1},
            { 1,-1,-1,-1, 1,-1,-1,-1, 1},
            {-1, 1,-1,-1, 1, 1,-1, 1,-1},
            {-1,-1,-1, 1,-1,-1, 1, 1, 1},
            {-1, 1,-1,-1, 1, 1,-1,-1,-1}
        };
        
//        double[][] pesos_adalines = new double[3][entradas[0].length+1];
//        for (int i = 0; i < pesos_adalines.length; i++) {
//            Arrays.fill(pesos_adalines[i], 0);
//        }

        double[][] pesos_adalines = {
            {-0.0096, 0.0496, 0.1904, 0.2496, 0.2496, -0.2496, 0.0096, 0.5136, -0.0496, -0.1904},
            {0.0080, -0.2080, -0.0320, 0.2320, -0.2320, -0.0080, 0.2320, -0.0320, 0.4320, 0.0320},
            {-0.1000, 0.1000, -0.1000, 0.1000, 0.1000, -0.1000, 0.1000, 0.1000, -0.1000, 0.1000}
        };
        
        Madaline madaline = new Madaline(pesos_adalines);
        
//        double[][] entradas = {
//            {-1, -1},
//            {-1,  1},
//            { 1, -1},
//            { 1,  1},
//        };
        //int[] salidas = {-1,1,1,-1};
        int[] salidas = {1,1,1,-1,1,-1,-1,-1,1,-1};
        madaline.entrenar(entradas, salidas);
        System.out.println(madaline.pesosToString(4));
        
        double[] prueba = {-1,-1,-1,1,1,1,1,-1,-1};
        System.out.println("Res: "+madaline.calcularSalida(prueba));
        double[] prueba2 = {-1,1,-1,-1,1,1,-1,-1,1};
        System.out.println("Res: "+madaline.calcularSalida(prueba2));
    }
    
}
