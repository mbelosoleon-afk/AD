package JDBCAnime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {


    private static Connection con = null;
    private static String url = "jdbc:postgresql://10.0.9.111:5432/probas";
    private static String usuario = "postgres";
    private static String contra = "admin";

    static Connection conexion() {

        try {
            con = DriverManager.getConnection(url, usuario, contra);
            System.out.println("Conexión hecha");
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.getStackTrace();
        }
        return con;
    }
}
