package procesador_imagenes;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;


public class ProcesarImagen {

    private final int IMG_WIDTH = 100; //ancho
    private final int IMG_HEIGHT = 100; //alto
    
    
    public byte[] ProcesoImagen(BufferedImage img) {
        byte A[] ;

        img = Filtrar_Gris(img);

        img = Cambiar_Tamaño(img);
        
        int V[]=getArray(img);
        
        A=getAdaline(V);

        return A;
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

            A[i] = R[k]>128 ? (byte) 1:-1;
            
            k += 3;

        }
        return A;

    }


}
