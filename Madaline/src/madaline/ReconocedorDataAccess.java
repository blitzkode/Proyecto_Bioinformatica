package madaline;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReconocedorDataAccess {

    /**
     * Genera un objeto Reconocedor a partir de la información de las neuronas 
     * Madaline almacenada en un fichero XML
     * @param rutaFichero Ubicación del fichero XML ("carpeta/fichero.xml")
     * @return objeto Reconocedor
     * @throws JAXBException 
     */
    public static Reconocedor leerBD(String rutaFichero) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Reconocedor.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        return (Reconocedor) unmarshaller.unmarshal(new File(rutaFichero));
    }
    
    /**
     * Guarda la información del Reconocedor en un fichero XML
     * @param reconocedor objeto Reconocedor
     * @param rutaFichero Ubicación del fichero XML ("carpeta/fichero.xml")
     * @throws JAXBException 
     */
    public static void escribirBD(Reconocedor reconocedor, String rutaFichero) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Reconocedor.class);
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(reconocedor, new File(rutaFichero));
    }
}
