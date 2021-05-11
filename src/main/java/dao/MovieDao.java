package dao;

import models.Actor;
import models.Director;
import models.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MovieDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void createNewMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();

        em.close();
    }

    public void showAllMovies() {

        EntityManager em = emf.createEntityManager();

        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();

        for (Movie movie : movies) {
            System.out.println(movie);
        }

        em.close();

    }

    public void deleteMovie(Long id) {
        EntityManager em = emf.createEntityManager();
        Movie movie =em.find(Movie.class,id);

        em.getTransaction().begin();
        em.remove(movie);
        em.getTransaction().commit();

        em.close();
    }

    public void changeMovieTitle(Long id, String title) {
        EntityManager em = emf.createEntityManager();

        Movie movie = em.find(Movie.class, id);
        movie.setTitle(title);

        em.getTransaction().begin();
        em.merge(movie);
        em.getTransaction().commit();

        em.close();
    }

    public void addExistingActorToExistingMovie(Long actorId, Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        actor.addMovie(movie);
        em.getTransaction().commit();
        em.close();
    }

    public void updateDirectorOfMovie(Long directorId, Long movieId) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);
        Movie movie = em.find(Movie.class, movieId);

        em.getTransaction().begin();

        movie.setDirector(director);

        em.getTransaction().commit();
        em.close();
    }

    public void changeActor(Long movieId, Long oldActorId, Long newActorId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor oldActor = em.find(Actor.class, oldActorId);
        Actor newActor = em.find(Actor.class, newActorId);
        em.getTransaction().begin();
        oldActor.removeMovie(movie);
        newActor.addMovie(movie);
        em.getTransaction().commit();
        em.close();
    }


    public void removeActorFromMovie(Long movieId, Long actorId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        actor.removeMovie(movie);
        em.getTransaction().commit();
        em.close();
    }

    public void removeDirectorFromMovie(Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        em.getTransaction().begin();
        movie.setDirector(null);
        em.getTransaction().commit();
        em.close();
    }
}
