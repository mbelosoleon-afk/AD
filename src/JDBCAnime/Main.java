package JDBCAnime;
import java.sql.*;

public class Main extends Conexion {
    public static void main(String[] args) {
        animeService.crear("Naruto", "Anime de ninjas","2002-10-03","100");
    }
}

