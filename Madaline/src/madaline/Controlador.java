package madaline;

import javax.xml.bind.JAXBException;

public class Controlador {
    private Reconocedor reconocedor;
    private String RUTA_BD = "xmlsrc/basededatos.xml";
    
    public Controlador() {
        try {
            this.reconocedor = ReconocedorDataAccess.leerBD(this.RUTA_BD);
        } catch (JAXBException ex) {
            this.reconocedor = new Reconocedor();
            this.reconocedor.iniciarMadalinesDefault();
        }
        
    }
    
    public String reconocerImagen(int [][] imagen) {
        //TODO procesar imagen
        String caracter = reconocedor.reconocerLetra(new int[] {});
        return caracter;
    }
    
}
