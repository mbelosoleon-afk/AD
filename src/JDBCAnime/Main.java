package JDBCAnime;
import java.sql.*;

public class Main extends Conexion {
    public static void main(String[] args) {
        System.out.println("Añadiendo a la base de datos");
        AnimeService.crear("Naruto", "Anime de ninjas","2002-10-03","100");
        AnimeService.leer();
        AnimeService.actualizar("Anime shonen","2002-10-03","99","Naruto");
        AnimeService.leer();
        AnimeService.borrar("Naruto");
        AnimeService.leer();
    }
}

