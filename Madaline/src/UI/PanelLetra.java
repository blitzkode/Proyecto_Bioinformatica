package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelLetra extends javax.swing.JPanel {

    private String letra;
    private int tamFuente;
    
    public PanelLetra() {
        setBackground(Color.white);
        letra = "";
        tamFuente = 50;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, tamFuente));
        int x = (getWidth() - tamFuente) / 2;
        int y = (getHeight() + tamFuente) / 2;
        g2.drawString(letra, x, y);
    }
    
    public void dibujarLetra(String letra) {
        this.letra = letra;
        repaint();
    }
    
}
