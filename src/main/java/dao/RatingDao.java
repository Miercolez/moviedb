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

    public void showAllRatings() {

        EntityManager em = emf.createEntityManager();

        em.createNamedQuery("MovieRating.findAll", MovieRating.class).getResultList().forEach(r -> System.out.println("\nId = " + r.getId() + "\nRating = " + r.getRating() + "\nMovie = " + r.getMovie().getTitle()));

        em.close();

    }

    public void deleteRating(Long ratingId) {

        EntityManager em = emf.createEntityManager();

        MovieRating movieRating = em.find(MovieRating.class, ratingId);

        em.getTransaction().begin();
        try {
            em.remove(movieRating);
        }catch(IllegalArgumentException i){
            System.out.println("The inputted object does not exist in the database.");
            return;
        }
        em.getTransaction().commit();

        em.close();

    }

    public void changeRating(Long ratingId, int newRating) {

        EntityManager em = emf.createEntityManager();

        MovieRating movieRating = em.find(MovieRating.class, ratingId);



        em.getTransaction().begin();
        try {
            movieRating.setRating(newRating);
        }catch(NullPointerException n){
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();

        em.close();
    }
}
