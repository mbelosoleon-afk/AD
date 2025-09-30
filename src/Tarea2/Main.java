package Tarea2;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String archivo = "/home/dam/Mauro DAM/AD/texto3.txt";
        String cadena = "O tempo está xélido";

        escribir(archivo, cadena);
        System.out.println("Tamaño final del archivo: " + new File(archivo).length() + " bytes");
        leer(archivo);
    }
    public static void escribir(String archivo, String cadea) {
        try (FileOutputStream fos = new FileOutputStream(archivo);
             DataOutputStream dos = new DataOutputStream(fos)) {

            for(int i=0; i<3; i++){
                System.out.println("Escribiendo la cadena: o tempo está xélido");
                dos.writeUTF(cadea);
                System.out.println("Tamaño de ficheiro: " + dos.size() + " bytes");
            }
        }   catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    public static void leer(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             DataInputStream dis = new DataInputStream(fis)) {
            while(dis.available() > 0) {
                System.out.println("quedan " + dis.available() + " bytes por leer");
                String cadenaLeida = dis.readUTF();
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}