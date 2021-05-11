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

        em.getTransaction().begin();
        em.persist(movieGenre);
        em.getTransaction().commit();

        em.close();
    }

    public void ShowAllGenre() {
        EntityManager em = emf.createEntityManager();

        List<MovieGenre> movieGenres = em.createNamedQuery("MovieGenre.findAll", MovieGenre.class).getResultList();
        movieGenres.forEach(System.out::println);

        em.close();
    }

    public void ChangeGenre(Long id, String newName) {
        EntityManager em = emf.createEntityManager();
        MovieGenre movieGenre = em.find(MovieGenre.class, id);

        em.getTransaction().begin();
        movieGenre.setGenre(newName);
        em.getTransaction().commit();


        em.close();
    }

    public void DeleteGenre(Long id) {
        EntityManager em = emf.createEntityManager();
        MovieGenre movieGenre = em.find(MovieGenre.class, id);

        em.getTransaction().begin();
        em.remove(movieGenre);
        em.getTransaction().commit();

        em.close();
    }
}
