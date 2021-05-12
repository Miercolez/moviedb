package dao;

import models.MovieGenre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MovieGenreDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void AddGenre(MovieGenre movieGenre) {

        EntityManager em = emf.createEntityManager();
        List<MovieGenre> movieGenress = em.createNamedQuery("MovieGenre.findAll", MovieGenre.class).getResultList();
        try {
            em.getTransaction().begin();
            em.persist(movieGenre);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        em.close();
    }

    public void ShowAllGenre() {
        EntityManager em = emf.createEntityManager();

        List<MovieGenre> movieGenres = em.createNamedQuery("MovieGenre.findAll", MovieGenre.class).getResultList();
        movieGenres.forEach(System.out::println);

        em.close();
    }
}
