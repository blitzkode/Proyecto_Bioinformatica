package procesador_imagenes;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
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
        img = Cambiar_Tamaño(img, IMG_WIDTH, IMG_HEIGHT);

        //obtenemos array imagen original
        int V[] = getArray(img);

        //transformamos datos a adaline 
        byte A[] = getAdaline(V,IMG_WIDTH);

        //obtenemos cordenadas para el corte
        int x = getX(A);
        int y = getY(A);
        int w = getLimWidth(A) - x;
        int h = getLimHeight(A) - y;

        saveimg(img, "incial");

        img = getCorte(img, x, y, w, h);

        saveimg(img, "media");

        //escalamos corte a 100 altura, manteniendo proporcion ancho
        img = Cambiar_Tamaño(img, (int) (IMG_HEIGHT * w) / h> IMG_WIDTH ? IMG_WIDTH : (int) (IMG_HEIGHT * w) / h, IMG_HEIGHT);
        
        
        saveimg(img, "final");

        //obtenemos array imagen nueva
        int V2[] = getArray(img);

        //transformamos datos nuevos a adaline
        byte A2[] = getAdaline(V2,img.getWidth());
                
        return A2;
    }
    

    private static void saveimg(BufferedImage img, String name) {
        try {
            ImageIO.write(img, "jpg", new File("C:\\Users\\Diego Baes\\Desktop\\" + name + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private static BufferedImage Cambiar_Tamaño(BufferedImage originalImage, int width, int height) {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_3BYTE_BGR : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
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

    private static byte[] getAdaline(int R[], int w) {
        byte A[] = new byte[IMG_HEIGHT * IMG_WIDTH];

        
        int pta = (IMG_WIDTH - w) % 2 == 0 ? (IMG_WIDTH - w) / 2 : (IMG_WIDTH - w + 1) / 2;
        
        
        for (int i = 0; i < IMG_HEIGHT; i++) {
            for (int j = 0; j < pta; j++) {
                A[i*IMG_WIDTH+j]=-1;
            }
        }
        
        int k = 0;
        for (int i = 0; i < IMG_HEIGHT; i++) {
            for (int j = pta; j < pta+w; j++) {
                A[i*IMG_WIDTH+j] = R[k] > 180 ? (byte) -1 : 1;
                k += 3;
            }

        }
        
        for (int i = 0; i < IMG_HEIGHT; i++) {
            for (int j = pta+w; j < IMG_WIDTH; j++) {
                A[i*IMG_WIDTH+j]=-1;
            }
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

    private static byte[] extractBytes(BufferedImage bufferedImage) throws IOException {
        // open image
//        File imgPath = new File(ImageName);
//        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }

    private static void mostrar(byte[] A) {
        System.out.println(" ****************MUESTRA**************** ");
        for (int i = 0; i < IMG_HEIGHT; i++) {
            System.out.println("");
            for (int j = 0; j < IMG_WIDTH; j++) {
                System.out.print(A[i*IMG_WIDTH+j]== -1 ? 0 : 1);
            }
        }
    }

}
