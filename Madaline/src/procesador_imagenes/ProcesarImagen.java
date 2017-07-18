package procesador_imagenes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ProcesarImagen {

    private final int IMG_WIDTH = 100; //ancho
    private final int IMG_HEIGHT = 100; //alto

    public byte[] ProcesoImagen(BufferedImage img) {

        img = Filtrar_Gris(img);

        //obtenemos array imagen original
        int V[] = getArray(img);

        //transformamos datos a adaline (se puede optimizar)
        byte A[] = getAdaline(V);

        //obtenemos cordenadas para el corte
        int x = getX(A);
        int y = getY(A);
        int w = getLimWidth(A);
        int h = getLimHeight(A);

        //cortamos
        img = getCorte(img, x, y, w, h);

        //escalamos corte a 100x100
        img = Cambiar_Tamaño(img);

        //obtenemos array imagen nueva
        int V2[] = getArray(img);

        //transformamos datos nuevos a adaline
        byte A2[] = getAdaline(V2);

        return A2;
    }

    private int getX(byte A[]) {
        int lim = 0;
        boolean find = false;

        while (!find&&lim<IMG_WIDTH) {

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

    private int getY(byte A[]) {
        int lim = 0;
        boolean find = false;
        while (!find&&lim<IMG_HEIGHT) {
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

    private int getLimWidth(byte A[]) {
        int lim = 0;
        boolean find = false;

        while (!find&&lim<IMG_HEIGHT) {
            for (int i = 0; i < IMG_HEIGHT; i++) {
                if (A[(IMG_WIDTH-1)*(i+1)-lim]==1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;
            }

        }
        lim=IMG_WIDTH-lim;
        return lim;

    }

    private int getLimHeight(byte A[]) {
        int lim = 0;

        boolean find = false;
        while (!find&&lim<IMG_WIDTH) {
            for (int i = IMG_WIDTH; i >= 0; i--) {
                if (A[(i+1)*(IMG_WIDTH*IMG_HEIGHT-lim)-1] == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim--;
            }
        }
        
        lim=IMG_WIDTH-lim;

        return lim;

    }

    private BufferedImage getCorte(BufferedImage image, int x, int y, int w, int h) {
        BufferedImage out = image.getSubimage(x, y, w, h);
        return out;
    }

    private BufferedImage Cambiar_Tamaño(BufferedImage originalImage) {

        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    private int[] getArray(BufferedImage img) {
        Raster raster = img.getData();
        DataBufferByte data = (DataBufferByte) img.getRaster().getDataBuffer();

        byte[] byteArray = data.getData();

        int[] array = raster.getPixels(0, 0, img.getWidth(), img.getHeight(), new int[byteArray.length]);

        return array;
    }

    private BufferedImage Filtrar_Gris(BufferedImage img) {
        BufferedImage img2 = img;
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(img, img2);
        return img2;
    }

    private byte[] getAdaline(int R[]) {
        byte A[] = new byte[IMG_HEIGHT * IMG_WIDTH];

        int k = 0;
        for (int i = 0; i < A.length; i++) {

            A[i] = R[k] > 128 ? (byte) 1 : -1;

            k += 3;

        }
        return A;

    }
    
    //obtener image de arreglo bytes
    private BufferedImage getNewImage(byte bytes[]) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException ex) {
            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;

    }
    
    

}
