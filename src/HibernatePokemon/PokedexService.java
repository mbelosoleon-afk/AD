package HibernatePokemon;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PokedexService {
    public static void crearPokemon(String nome, double peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex novoPokemon = new Pokedex();
            novoPokemon.setNome(nome);
            novoPokemon.setPeso(peso);
            novoPokemon.setMisc(misc);
            session.save(novoPokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo Pokemon: " + e.getMessage());
        }
    }
    public Pokedex lerPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o gato: " + e.getMessage());
            return null;
        }
    }
    public List<Pokedex> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokedex", Pokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los Pokedex: " + e.getMessage());
            return null;
        }
    }
    public void actualizarPokemon(Long id, String nome, double peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokemon = session.get(Pokedex.class, id);
            if (pokemon != null) {
                pokemon.setNome(nome);
                pokemon.setPeso(peso);
                pokemon.setMisc(misc);
                session.update(pokemon);
            } else {
                System.out.println("Pokemon non encontrado para actualizar.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo Pokemon: " + e.getMessage());
        }
    }
    public void eliminarPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokemon = session.get(Pokedex.class, id);
            if (pokemon != null) {
                session.delete(pokemon);
            } else {
                System.out.println("non se atopou o Pokemon");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun Pokemon Y.Y: " + e.getMessage());
        }
    }
}
