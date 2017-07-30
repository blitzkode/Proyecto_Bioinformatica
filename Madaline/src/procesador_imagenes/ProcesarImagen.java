package procesador_imagenes;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ProcesarImagen {
    private static final int IMG_WIDTH = 100; //ancho
    private static final int IMG_HEIGHT = 100; //alto

    public static byte[] ProcesoImagen(BufferedImage img) {
        img = Filtrar_Gris(img);
        
        //adaptamos a 100x100 para obtener cantidad fija de pixeles
        img = Cambiar_Tamaño(img);

        //obtenemos array imagen original
        int V[] = getArray(img);

        //transformamos datos a adaline 
        byte A[] = getAdaline(V);

        //obtenemos cordenadas para el corte
        int x = getX(A);
        int y = getY(A);
        int w = getLimWidth(A);
        int h = getLimHeight(A);

        //cortamos
        img = getCorte(img, x, y, w - x, h - y);
        
        //escalamos corte a 100x100
        img = Cambiar_Tamaño(img);
        
//        try {
//            ImageIO.write(img, "jpg", new File("C:\\Users\\Diego Baes\\Desktop\\test22.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //obtenemos array imagen nueva
        int V2[] = getArray(img);

        //transformamos datos nuevos a adaline
        byte A2[] = getAdaline(V2);

        return A2;
    }

    private static int getX(byte A[]) {
        int lim = 0;
        boolean find = false;

        while (!find && lim < IMG_WIDTH) {

            for (int i = 0; i < IMG_WIDTH; i++) {
                if (A[(i * IMG_WIDTH) + lim] == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;
            }

        }

        return lim;

    }

    private static int getY(byte A[]) {
        int lim = 0;
        boolean find = false;
        while (!find && lim < IMG_HEIGHT) {
            for (int i = 0; i < IMG_WIDTH; i++) {
                if (A[i + (IMG_HEIGHT * lim)] == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;
            }
        }

        return lim;

    }

    private static int getLimWidth(byte A[]) {
        int lim = 0;
        boolean find = false;

        for (int j = IMG_WIDTH - 1; j >= 0 && !find; j--) {
            for (int i = 0; i < IMG_HEIGHT; i++) {

                if (A[i * IMG_WIDTH + j] == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;

            }
        }

        lim = IMG_WIDTH - lim;
        return lim;

    }

    private static int getLimHeight(byte A[]) {
        int lim = 0;

        boolean find = false;

        for (int i = IMG_HEIGHT - 1; i >= 0 && !find; i--) {
            for (int j = IMG_WIDTH - 1; j >= 0; j--) {
                if (A[i * IMG_WIDTH + j] == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;

            }

        }
       

        lim = IMG_HEIGHT - lim;

        return lim;

    }

    private static BufferedImage getCorte(BufferedImage image, int x, int y, int w, int h) {
        BufferedImage out = image.getSubimage(x, y, w, h);

        return out;
    }
  
    private static BufferedImage Cambiar_Tamaño(BufferedImage originalImage) {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_3BYTE_BGR : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    private static int[] getArray(BufferedImage img) {
        Raster raster = img.getData();
        DataBufferByte data = (DataBufferByte) img.getRaster().getDataBuffer();

        byte[] byteArray = data.getData();

        int[] array = raster.getPixels(0, 0, img.getWidth(), img.getHeight(), new int[byteArray.length]);

        return array;
    }

    private static BufferedImage Filtrar_Gris(BufferedImage img) {
        BufferedImage img2 = img;
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(img, img2);
        return img2;
    }

    private static byte[] getAdaline(int R[]) {
        byte A[] = new byte[IMG_HEIGHT * IMG_WIDTH];

        int k = 0;
        for (int i = 0; i < A.length; i++) {

            A[i] = R[k] > 180 ? (byte) -1 : 1;
            k += 3;

        }
        return A;

    }
    
    //obtener image de arreglo bytes
    private static BufferedImage getNewImage(byte bytes[]) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException ex) {
            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;

    }
    
    

}
