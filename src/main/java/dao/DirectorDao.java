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
}
