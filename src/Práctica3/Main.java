package Práctica3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final String archivo1 = "/home/dam/Mauro DAM/AD/serial.txt";
        final String archivo2 = "/home/dam/Mauro DAM/AD/serialT.txt";
        //Parte 1

        Producto p1 = new Producto("Manzana", 1, 2.0);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo1))) {

            System.out.println("Escribiendo en el fichero");
            oos.writeObject(p1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo1))) {

            System.out.println("Leyendo el objeto");
            Producto p2 = (Producto) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Parte 2

        Producto p3 = new Producto("Pera", 1, 2.0);
        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(archivo2))) {

            System.out.println("Escribiendo en el fichero transient");
            oos2.writeObject(p1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(archivo2))) {

            System.out.println("Leyendo el objeto transient");
            Producto p4 = (Producto) ois2.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
