package procesador_imagenes;

import java.awt.Graphics2D;
import java.awt.Image;
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
import javax.swing.ImageIcon;

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
//        byte A[] = getAdaline(V,IMG_WIDTH);

        //obtenemos cordenadas para el corte
        int x = getX(V,IMG_WIDTH);
        int y = getY(V,IMG_WIDTH,IMG_HEIGHT);
        int w = getLimWidth(V,IMG_WIDTH,IMG_HEIGHT) - x;
        int h = getLimHeight(V,IMG_WIDTH,IMG_HEIGHT) - y;
        
//        System.out.println("X: "+ x+ " Y: "+ y + " W: "+w+" H: "+h);

//        saveimg(img, "incial");
        
        if (x+w==0) {
            return getAdalineLimpio();
        
        } 
        
        img = getCorte(img, x, y, w, h);
        

//        saveimg(img, "media");

        //escalamos corte a 100 altura, manteniendo proporcion ancho
        img = Cambiar_Tamaño(img, (int) (IMG_HEIGHT * w) / h> IMG_WIDTH ? IMG_WIDTH : (int) (IMG_HEIGHT * w) / h, IMG_HEIGHT);
        
        
//        saveimg(img, "final");

        //obtenemos array imagen nueva
        int V2[] = getArray(img);

        //transformamos datos nuevos a adaline
        byte A2[] = getAdaline(V2,img.getWidth());
                
        return A2;
    }
   
    private static byte[] getAdalineLimpio(){
        
        byte A[]= new byte[IMG_HEIGHT*IMG_WIDTH];
        
        for (int i = 0; i < A.length; i++) {
            A[i]=-1;
        }
        
        return A;
    }
    
    public static BufferedImage getRecorteIMG(BufferedImage img){
        
        int V[] = getArray(img);

        int x = getX(V,img.getWidth());
        int y = getY(V,img.getWidth(),img.getHeight());
        int w = getLimWidth(V,img.getWidth(),img.getHeight()) - x;
        int h = getLimHeight(V,img.getWidth(),img.getHeight()) - y;
        
        img = getCorte(img, x, y, w, h);
        
        return img;
        
    }
    
    private static byte getByteValor(int R[], int i){
        return R[i*3] > 180 ? (byte) -1 : 1;
    }
    

    public static void saveimg(BufferedImage img, String name) {
        try {
            ImageIO.write(img, "jpg", new File("C:\\Users\\Diego Baes\\Desktop\\" + name + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int getX(int A[], int width) {
        int lim = 0;
        boolean find = false;

        while (!find && lim < width) {

            for (int i = 0; i < width; i++) {
                if (getByteValor(A, (i * width) + lim)==1) {
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

    private static int getY(int A[], int width, int height) {
        int lim = 0;
        boolean find = false;
        while (!find && lim < height) {
            for (int i = 0; i < width; i++) {
                if (getByteValor(A,i + (height * lim)) == 1) {
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

    private static int getLimWidth(int A[], int width,int height) {
        int lim = 0;
        boolean find = false;

        for (int j = width - 1; j >= 0 && !find; j--) {
            for (int i = 0; i < height; i++) {

                if (getByteValor(A,i * width + j) == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;

            }
        }

        lim = width - lim;
        return lim;

    }

    private static int getLimHeight(int A[], int width, int height) {
        int lim = 0;

        boolean find = false;

        for (int i = height - 1; i >= 0 && !find; i--) {
            for (int j = width - 1; j >= 0; j--) {
                if (getByteValor(A,i * width + j) == 1) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                lim++;

            }

        }

        lim = height - lim;

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
        byte A[] = new byte[IMG_WIDTH*IMG_HEIGHT];

        
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
