package dao;

import models.Actor;
import models.Director;
import models.Movie;
import models.MovieGenre;
import utility.Genres;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void closeEmf() {
        emf.close();
    }

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
        Movie movie = em.find(Movie.class, id);

        em.getTransaction().begin();
        try {
            em.remove(movie);
        } catch (IllegalArgumentException i) {
            System.out.println("The inputted object does not exist in the database");
            em.close();
            return;
        }
        em.getTransaction().commit();

        em.close();
    }

    public void changeMovieTitle(Long id, String title) {
        EntityManager em = emf.createEntityManager();

        Movie movie = em.find(Movie.class, id);


        em.getTransaction().begin();
        try {
            movie.setTitle(title);
        } catch (NullPointerException npe) {
            System.out.println("One of the inputted objects does not exist in the database");
            em.close();
            return;
        }
        em.getTransaction().commit();

        em.close();
    }

    public void addExistingActorToExistingMovie(Long actorId, Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        try {
            actor.addMovie(movie);
        } catch (NullPointerException npe) {
            System.out.println("One of the inputted objects does not exist in the database");
            em.close();
            return;
        }
        em.getTransaction().commit();
        em.close();
    }

    public void updateDirectorOfMovie(Long directorId, Long movieId) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);
        Movie movie = em.find(Movie.class, movieId);

        em.getTransaction().begin();
        try {
            movie.setDirector(director);
        } catch (NullPointerException n) {
            System.out.println("One of the inputted objects does not exist in the database");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void changeActor(Long movieId, Long oldActorId, Long newActorId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor oldActor = em.find(Actor.class, oldActorId);
        Actor newActor = em.find(Actor.class, newActorId);
        em.getTransaction().begin();
        try {
            oldActor.removeMovie(movie);
            newActor.addMovie(movie);
        } catch (NullPointerException n) {
            System.out.println("One of the inputted objects does not exist in the database");
        }
        em.getTransaction().commit();
        em.close();
    }


    public void removeActorFromMovie(Long movieId, Long actorId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        try {
            actor.removeMovie(movie);
        } catch (NullPointerException n) {
            System.out.println("One of the inputted objects does not exist in the database");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void removeDirectorFromMovie(Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        em.getTransaction().begin();
        try {
            movie.setDirector(null);
        } catch (NullPointerException n) {
            System.out.println("One of the inputted objects does not exist in the database");
        }

        em.getTransaction().commit();
        em.close();
    }

    public void addGenreToMovie(Long movieId, Genres genre) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        List<MovieGenre> genres = em.createNamedQuery("MovieGenre.findAll", MovieGenre.class).getResultList();

        MovieGenre genreDB = genres.stream()
                .filter(g -> g.getGenre().equals(genre))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        em.getTransaction().begin();

        try {
            movie.addMovieGenre(genreDB);
        } catch (
                NullPointerException n) {
            System.out.println("One of the inputted objects does not exist in the database");
        }

        em.getTransaction().commit();
        em.close();

    }

    public List<MovieGenre> showGenreForMovie(Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        List<MovieGenre> genres;
        try {
            genres = movie.getMovieGenres();
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
        em.close();
        return genres;
    }

    public void removeGenreFromMovie(MovieGenre genre, Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);

        em.getTransaction().begin();
        try {
            movie.removeMovieGenre(em.merge(genre));
        } catch (NullPointerException e) {

            System.out.println("One of the inputted objects does not exist in the database");
        }
        em.getTransaction().commit();

        em.close();
    }

    public Movie findMovie(Long movieId) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        em.close();
        return movie;
    }
}
