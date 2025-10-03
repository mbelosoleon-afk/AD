package Práctica3;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XML {
    public static void main(String[] args) {
        final String archivo = "/home/dam/Mauro DAM/AD/XML.xml";

        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try(FileWriter fw = new FileWriter(archivo)) {

            XMLStreamWriter writer = factory.createXMLStreamWriter(fw);

            writer.writeStartDocument("1.0"); //creamos la cabecera del XML

            writer.writeStartElement("autores"); //creamos el elemento raiz autores

            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1"); //creamos el elemento autor con su atributo codigo

            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas"); //creamos el elemento nome con su valor
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de Montecristo"); // creamos el elemento titulo con su valor
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables"); // creamos el elemento titulo con su valor
            writer.writeEndElement();

            writer.writeEndElement(); // cerramos el elemento autor

            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeEndElement(); // cerramos el elemento raiz autores

        }catch (IOException | XMLStreamException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
