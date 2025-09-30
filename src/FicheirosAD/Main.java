package FicheirosAD;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        mContido("/home/dam/arquivosdir/");
    }
    public static String eDirectorio(String ruta) {
        File archivo = new File(ruta);
        if(archivo.isDirectory()){
            return "é un directorio";
        }else{
            return "non é un directorio";
        }
    }
    public static String eFicheiro(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return "é un ficheiro";
        } else {
            return "non é un ficheiro";
        }
    }
    public static void creaDirectorio(String ruta){
        File directorio = new File(ruta);
        if(!directorio.exists()){
            boolean crear = directorio.mkdir();
            if(crear){
                System.out.println("Directorio creado");
            }else{
                System.out.println("No se creó el directorio");
            }
        }else{
            System.out.println("El directorio ya existe");
        }
    }
    public static void creaArchivo(String dirName,String fileName){
        File ruta = new File(dirName);
        File archivo = new File(ruta,fileName);
        try{
            if(archivo.createNewFile()){
                System.out.println("Archivo creado: "+ archivo.getAbsolutePath());
            }else{
                System.out.println("El archivo ya existe: "+ archivo.getAbsolutePath());
            }
        }catch(IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }
    public static void modoAcceso(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        if(archivo.exists()){
            if(archivo.canRead()){
                System.out.println("El archivo se puede escribir");
            }else{
                System.out.println("El archivo no se puede escribir");
            }if(archivo.canRead()){
                System.out.println("El archivo se puede leer");
            }else{
                System.out.println("El archivo no se puede leer");
            }
        }else{
            System.out.println("El archivo no existe");
        }
    }
    public static long calculaLonxitude(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        return archivo.getFreeSpace();
    }
    public static void mLectura(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        boolean resultado = archivo.setReadOnly();
        if(resultado){
            System.out.println("EL archivo ahora es solo de lectura");
        }else{
            System.out.println("no se puedieron cambiar los permisos");
        }
    }
    public static void mEscritura(String dirName,String fileName){
        File archivo = new File(dirName,fileName);
        boolean resultado = archivo.setWritable(true);
        if(resultado){
            System.out.println("Ahora se puede escribir en el archivo");
        }else{
            System.out.println("no se puedieron cambiar los permisos");
        }
    }
    public static void borraFicheiro(String ruta){
        File archivo = new File(ruta);
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("El archivo no existe");
        }
    }
    public static void borraDirectorio(String ruta){
        File directorio = new File(ruta);
        if(directorio.exists()){
            directorio.delete();
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("El archivo no existe");
        }
    }
    public static void mContido(String dirName){
        File ruta = new File(dirName);
        File[] archivos = ruta.listFiles();
        if(ruta.exists() && ruta.isDirectory()){
            for(File archivo: archivos){
                if(archivo.isFile()){
                    System.out.println("Archivo "+ archivo.getName());
                }else if(archivo.isDirectory()){
                    System.out.println("Directorio "+ archivo.getName());
                    mContido(archivo.getPath());
                }
            }
        }else{
            System.out.println("No se pudieron listar");
        }
    }
}