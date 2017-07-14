package madaline;

public class Main {

    public static void main(String[] args) {
        //Controlador aplicacion = new Controlador();
        prueba();
    }

    public static void prueba() {
        int[][] entradas = {
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
 
        double[][] pesos_adalines = {
            {-0.0096, 0.0496, 0.1904, 0.2496, 0.2496, -0.2496, 0.0096, 0.5136, -0.0496, -0.1904},
            {0.0080, -0.2080, -0.0320, 0.2320, -0.2320, -0.0080, 0.2320, -0.0320, 0.4320, 0.0320},
            {-0.1000, 0.1000, -0.1000, 0.1000, 0.1000, -0.1000, 0.1000, 0.1000, -0.1000, 0.1000}
        };
        
        Madaline madaline = new Madaline(pesos_adalines);

        int[] salidas = {1,1,1,-1,1,-1,-1,-1,1,-1};
        madaline.entrenar(entradas, salidas);
        System.out.println(madaline.toString(4));
        
        int[] prueba = {-1,-1,-1,1,1,1,1,-1,-1};
        System.out.println("Res: "+madaline.calcularSalida(prueba));
        int[] prueba2 = {-1,1,-1,-1,1,1,-1,-1,1};
        System.out.println("Res: "+madaline.calcularSalida(prueba2));
    }
    
}
