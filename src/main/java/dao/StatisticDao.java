package dao;

import models.Actor;
import models.Director;
import models.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class StatisticDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void showTotalNumbersOfActorsAndDirectors() {

        EntityManager em = emf.createEntityManager();

        System.out.println("Actors");

        em.createNamedQuery("Actor.findAll", Actor.class).getResultList().forEach(System.out::println);

        System.out.println("Directors");

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

//        double f = females.doubleValue();

        double percentFemale = ((double) females / (double) (females + males) * 100.0);
        double percentMale = ((double) males / (double) (females + males) * 100.0);

        System.out.println("Total Number of Actors= " + (females + males));
        System.out.println("Total Number of Female Actors= " + females);
        System.out.println("Total Number of Male Actors= " + males);
        System.out.println("Percentage of Female Actors= " + percentFemale + "%");
        System.out.println("Percentage of Male Actors= " + percentMale + "%");

        em.close();
    }

    public void showMovieWithLowestAverageRating() {

        EntityManager em = emf.createEntityManager();

        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();

        try {
            System.out.println("\nThe movie with lowest average rating is:");
            System.out.print(movies.stream()
                    .filter(m -> !m.equals("Still no rating"))
                    .min(Comparator.comparing(Movie::averageMovieRating))
                    .get()
                    .getTitle());

            System.out.println(" with rating of " + movies.stream()
                    .filter(m -> !m.equals("Still no rating"))
                    .map(m -> m.averageMovieRating())
                    .min(String::compareTo)
                    .get() + ".");

        } catch (NullPointerException npe) {
            System.out.println("There is still movies with no rating. Please add a rating to see this statistic");
        }

        em.close();
    }

    public void showMovieWithHighestAverageRating() {

        EntityManager em = emf.createEntityManager();

        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();

        try {
            System.out.println("\nThe movie with highest average rating is:");

            System.out.print(movies.stream()
                    .filter(m -> !m.equals("Still no rating"))
                    .max(Comparator.comparing(Movie::averageMovieRating))
                    .get().getTitle());

            System.out.println(" with rating of " + movies.stream()
                    .filter(m -> !m.equals("Still no rating"))
                    .map(m -> m.averageMovieRating())
                    .max(String::compareTo)
                    .get() + ".");

        } catch (NullPointerException npe) {
            System.out.println("There is still movies with no rating. Please add a rating to see this statistic");
        }

        em.close();

    }
}
