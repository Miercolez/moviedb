package dao;

import models.Actor;
import models.Director;
import models.Movie;
import models.MovieGenre;
import utility.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class StatisticDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void showTotalNumbersOfActorsAndDirectors() {

        EntityManager em = emf.createEntityManager();

        System.out.print("\nActors");

        em.createNamedQuery("Actor.findAll", Actor.class).getResultList().forEach(System.out::println);

        System.out.print("\nDirectors");

        em.createNamedQuery("Director.findAll", Director.class).getResultList().forEach(System.out::println);

        em.close();
    }

    public void showNumberOfActorsInAMovie(Long movieId) {

        EntityManager em = emf.createEntityManager();

        Movie movie = em.find(Movie.class, movieId);

        System.out.print("\nTotal Number of Actors in " + movie.getTitle() + " is ");

        System.out.println(em.createQuery("SELECT COUNT(m.actors) FROM Movie m WHERE m.id = :movieId", Actor.class)
                .setParameter("movieId", movieId).getSingleResult() + ".");

        em.close();
    }

    public void showActorsFemaleToMaleDistribution() {


        EntityManager em = emf.createEntityManager();

        Long females = em.createQuery("SELECT COUNT(a.gender) FROM Actor a WHERE a.gender = :female", Long.class)
                .setParameter("female", "Female").getSingleResult();

        Long males = em.createQuery("SELECT COUNT(a.gender) FROM Actor a WHERE a.gender = :male", Long.class)
                .setParameter("male", "Male").getSingleResult();



        System.out.println("\nTotal Number of Actors= " + (females + males));
        System.out.println("Total Number of Female Actors= " + females);
        System.out.println("Total Number of Male Actors= " + males);
        System.out.printf("Percentage of Female actors = %.2f%%\n", ((double) females / (double) (females + males) * 100.0));
        System.out.printf("Percentage of Male actors = %.2f%%\n", ((double) males / (double) (females + males) * 100.0));

        em.close();
    }

    public void showMovieWithLowestAverageRating() {

        EntityManager em = emf.createEntityManager();

        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();


            System.out.println("\nThe movie with lowest average rating is:");
            System.out.print(movies.stream()
                    .filter(m -> !m.averageMovieRating().equals("Still no rating"))
                    .min(Comparator.comparing(Movie::averageMovieRating))
                    .get()
                    .getTitle());

            System.out.println(" with rating of " + movies.stream()
                    .map(Movie::averageMovieRating)
                    .filter(s -> !s.equals("Still no rating"))
                    .min(String::compareTo)
                    .get() + ".");

        em.close();
    }

    public void showMovieWithHighestAverageRating() {

        EntityManager em = emf.createEntityManager();

        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();


            System.out.println("\nThe movie with highest average rating is:");

            System.out.print(movies.stream()
                    .filter(m -> !m.averageMovieRating().equals("Still no rating"))
                    .max(Comparator.comparing(Movie::averageMovieRating))
                    .get().getTitle());

            System.out.println(" with rating of " + movies.stream()
                    .map(Movie::averageMovieRating)
                    .filter(s -> !s.equals("Still no rating"))
                    .max(String::compareTo)
                    .get() + ".");

        em.close();

    }

    public void showAllMoviesInASpecificGenre(Genres genre) {
        EntityManager em = emf.createEntityManager();

        MovieGenre g = em.createQuery("SELECT g FROM MovieGenre g WHERE g.genre =:genre", MovieGenre.class)
                .setParameter("genre", genre)
                .getSingleResult();

        System.out.println("\nMovies with the " + genre.toString() + " genre is: ");
        g.getMovies().forEach(movie->System.out.println(movie.getTitle()));


        em.close();

    }
}
