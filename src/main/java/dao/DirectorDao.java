package dao;

import models.Director;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DirectorDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void addDirector(Director director) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(director);
        em.getTransaction().commit();

        em.close();
    }

    public void changeName(Long directorId, String newDirectorName) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);

        em.getTransaction().begin();

        try {
            director.setName(newDirectorName);
        } catch (NullPointerException n) {
            System.out.println("The inputted object does not exist in the database.");
        }

        em.getTransaction().commit();

        em.close();
    }

    public void changeAge(Long directorId, int newDirectorAge) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);


        em.getTransaction().begin();
        try {
            director.setAge(newDirectorAge);
        } catch (NullPointerException n) {
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();

        em.close();
    }

    public void showAllDirectors() {
        EntityManager em = emf.createEntityManager();


        List<Director> directors = em.createNamedQuery("Director.findAll", Director.class).getResultList();
        if (directors.size() != 0) {
            directors.forEach(System.out::println);
        } else {
            System.out.println("There is no directors to be shown.");
        }
        em.close();
    }

    public void changeGender(Long directorId, String directorGender) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);

        em.getTransaction().begin();

        try {
            director.setGender(directorGender);
        } catch (NullPointerException n) {
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();

        em.close();
    }

    public void deleteDirector(Long directorId) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        try {

            em.remove(em.find(Director.class, directorId));

        } catch (IllegalArgumentException i) {
            System.out.println("The inputted object does not exist in the database.");
            return;
        }
        em.getTransaction().commit();

        em.close();
    }
}
