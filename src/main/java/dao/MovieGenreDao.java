package dao;

import models.MovieGenre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MovieGenreDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void closeEmf() {
        emf.close();
    }

    public void AddGenre(MovieGenre movieGenre) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(movieGenre);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("This genre already exist in the database.");
        }
        em.close();
    }

    public void ShowAllGenre() {
        EntityManager em = emf.createEntityManager();

        List<MovieGenre> movieGenres = em.createNamedQuery("MovieGenre.findAll", MovieGenre.class).getResultList();

        if (movieGenres.size() != 0) {
            movieGenres.forEach(System.out::println);
        } else {
            System.out.println("There is no movie genres to be shown.");
        }

        em.close();
    }
}
