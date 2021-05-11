package dao;

import models.Director;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        director.setName(newDirectorName);

        em.getTransaction().begin();
        em.merge(director);
        em.getTransaction().commit();

        em.close();
    }

    public void changeAge(Long directorId, int newDirectorAge) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);

        director.setAge(newDirectorAge);

        em.getTransaction().begin();
        em.merge(director);
        em.getTransaction().commit();

        em.close();
    }

    public void showAllDirectors() {
        EntityManager em = emf.createEntityManager();

        em.createNamedQuery("Director.findAll", Director.class).getResultList().forEach(System.out::println);

        em.close();
    }

    public void changeGender(Long directorId, String directorGender) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);

        director.setGender(directorGender);

        em.getTransaction().begin();
        em.merge(director);
        em.getTransaction().commit();

        em.close();
    }

    public void deleteDirector(Long directorId) {
        EntityManager em = emf.createEntityManager();

        Director director = em.find(Director.class, directorId);

        em.getTransaction().begin();
        em.remove(director);
        em.getTransaction().commit();

        em.close();
    }
}
