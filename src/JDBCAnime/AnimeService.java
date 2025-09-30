package JDBCAnime;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AnimeService {
    static void crear(String nome, String descripcion, String data, String puntuacion) {
        String sql= "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES " +
                "(?,?,?,?)";
        try (Connection conexion = Conexion.conexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            System.out.println("Conexion hecha");
            stmt.setString(1,nome);
            stmt.setString(2,descripcion);
            stmt.setDate(3,Date.valueOf(data));
            stmt.setInt(4,Integer.parseInt(puntuacion));
            stmt.executeUpdate(sql);
            System.out.println("Datos insertados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }
    public static Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("Petou " + e.getMessage());
            return null;
        }
    }
}
