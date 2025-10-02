package JDBCAnime;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AnimeService {
    static void crear(String nome, String descripcion, String data, String puntuacion) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES " +
                "(?,?,?,?)";
        try (Connection conexion = Conexion.conexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            System.out.println("Conexion hecha");
            stmt.setString(1, nome);
            stmt.setString(2, descripcion);
            stmt.setDate(3, Date.valueOf(data));
            stmt.setInt(4, Integer.parseInt(puntuacion));
            stmt.execute();
            System.out.println("Datos insertados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static void borrar(String nome){
        String sql = "DELETE FROM anime WHERE nome = ?";
        try (Connection conexion = Conexion.conexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            System.out.println("Conexion hecha");
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Datos borrados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static void actualizar(String descripcion,String data, String puntuacion, String nome) {
        String sql = "UPDATE anime SET descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        try (Connection conexion = Conexion.conexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            System.out.println("Conexion hecha");
            stmt.setString(1, descripcion);
            stmt.setDate(2, Date.valueOf(data));
            stmt.setInt(3, Integer.parseInt(puntuacion));
            stmt.setString(4, nome);
            stmt.executeUpdate();
            System.out.println("Datos actualizados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static void leer(){
        String sql = "SELECT * FROM anime";
        try (Connection conexion = Conexion.conexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            System.out.println("Conexion hecha");
            ResultSet filas = stmt.executeQuery();
            System.out.println("Datos leídos " + filas);
            while(filas.next()){
                String nome = filas.getString(1);
                String descripcion = filas.getString(2);
                Date data = filas.getDate(3);
                int puntuacion = filas.getInt(4);
                System.out.println(nome + " " + descripcion + " " + data + " " + puntuacion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static void leerId(String nome){
        String sql = "SELECT * FROM anime WHERE nome = ?";
        try (Connection conexion = Conexion.conexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)){

            stmt.setString(1, nome);
            ResultSet fila = stmt.executeQuery();

            if(fila.next()){
                String nombre = fila.getString(1);
                String descripcion = fila.getString(2);
                Date data = fila.getDate(3);
                int puntuacion = fila.getInt(4);

                System.out.println(" " + nombre + " " + descripcion + " " + data + " " + puntuacion);
            }else {
                System.out.println("No se encontró la búsqueda");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
