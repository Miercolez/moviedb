package dao;

import models.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ActorDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void addNewActor(Actor actor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        em.close();

    }
}
