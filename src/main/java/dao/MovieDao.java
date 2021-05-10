package dao;

import models.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void createNewMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        em.close();
    }
}
