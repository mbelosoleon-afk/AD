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
            stmt.executeUpdate(sql);
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
    static void actualizar(String nome,String descripcion, String data, String puntuacion) {
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
                String nome = filas.getNString(1);
                String descripcion = filas.getNString(2);
                Date data = filas.getDate(3);
                int puntuacion = filas.getInt(4);
                System.out.println(nome + " " + descripcion + " " + data + " " + puntuacion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
