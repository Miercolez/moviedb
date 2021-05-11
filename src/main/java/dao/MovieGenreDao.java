package dao;

import models.MovieGenre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieGenreDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void NewMovieGenre(MovieGenre movieGenre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(movieGenre);
        em.getTransaction().commit();

        em.close();
    }
}
