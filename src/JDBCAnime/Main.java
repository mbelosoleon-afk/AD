package JDBCAnime;
import java.sql.*;

public class Main extends Conexion {
    public static void main(String[] args) {
        System.out.println("Añadiendo a la base de datos");
        AnimeService.crear("Naruto", "Anime de ninjas","2002-10-03","100");
        System.out.println("Leer todos os rexistros");
        AnimeService.leer();
        System.out.println("Actualizar o rexistro");
        AnimeService.actualizar("Anime shonen","2002-10-03","99","Naruto");
        System.out.println("Leer o dato que añadimos");
        AnimeService.leerId("Naruto");
        System.out.println("Eliminar o rexistro");
        AnimeService.borrar("Naruto");
        System.out.println("Leer todos os rexistros");
        AnimeService.leer();
    }
}