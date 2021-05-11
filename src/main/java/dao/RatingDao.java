package dao;

import models.Movie;
import models.MovieRating;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RatingDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void addRating(MovieRating rating, Long movieId) {

        EntityManager em = emf.createEntityManager();

        Movie movie = em.find(Movie.class, movieId);

        rating.setMovie(movie);

        em.getTransaction().begin();
        em.persist(rating);
        em.getTransaction().commit();

        em.close();
    }
}
