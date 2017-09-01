package UI;

import java.awt.Color;
import javax.swing.JPanel;

public class AnimatedWallpaper {

    int total_patrones = 1;
    int total_colores = 7;
    JPanel pnl_main;
    Wallpaper wall;
    String directorios[];
    Color colores[];
    Color col_arranque;

    public AnimatedWallpaper(JPanel pnl_main) {
        this.pnl_main = pnl_main;
//        directorios = new String[total_patrones * total_colores];
//        colores = new Color[total_colores];
//        CargarDirectorios();
//        CargarColores();
        setWallpaper();
    }

    private void setWallpaper() {
//        int ptr = getRandom();
//        wall = new Wallpaper(directorios[ptr], pnl_main);
        wall = new Wallpaper("/Iconos/wall_principal.jpg", pnl_main);
     
//        col_arranque=getColorW(ptr);
        wall.setSize(pnl_main.getSize());
        pnl_main.add(wall);
    }

    private void CargarDirectorios() {
        for (int i = 0; i < total_colores; i++) {

            for (int j = 0; j < total_patrones; j++) {
                directorios[i] = "/Iconos/wallcolor" + (i + 1) + "_" + (j + 1) + ".gif";
            }

        }
    }

    private void CargarColores() {
        colores[0] = new Color(35, 156, 168);
        colores[1] = new Color(180, 187, 0);
        colores[2] = new Color(93, 170, 238);
        colores[3] = new Color(245, 186, 15);
        colores[4] = new Color(182, 130, 223);
        colores[5] = new Color(239, 199, 62);
        colores[6] = new Color(215, 118, 158);
    }

    private int getRandom() {
        return (int) (Math.random() * total_patrones*total_colores);
    }

    private Color getColorW(int index) {

        index = (index + 1) % 2 == 0 ? ((index + 1) / total_patrones) - 1 : index / total_patrones;

        return colores[index];
    }

    public void CambiarWallpaper() {
//        int ptr = getRandom();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                wall.transicion(directorios[ptr], 400,
//                        col_arranque, getColorW(ptr));
//            }
//        }).start();
//        col_arranque=getColorW(ptr);
    }

}
