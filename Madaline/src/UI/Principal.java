package UI;

import Core.Controlador;

public class Principal extends javax.swing.JFrame {
    Controlador aplicacion;
    int modo_juego;
    javax.swing.JFrame padre;
    
    public Principal(Controlador aplicacion, javax.swing.JFrame padre) {
        this.aplicacion = aplicacion;
        this.padre = padre;
    }
    
    protected void salir() {
        padre.setVisible(true);
        dispose();
    }
}
