/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wallpaper extends JPanel{
    
    String nombre;
    
    
    public Wallpaper (String nombre){
        this.nombre = nombre;
        this.setBackground(Color.white);
    }
    
    @Override
    public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        Dimension tam=getSize();
        
        ImageIcon imagen=new ImageIcon(getClass().getResource(nombre));
        
        
        g.drawImage(imagen.getImage(), 0, 0, tam.width,tam.height,null);
        setOpaque(false);
       String ext = nombre.substring(nombre.length()-3);
       
        if (ext.equals("gif")) {
            timer.start();
        }
        
    }
    
     Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            repaint();
            
        }
    });
    
}
