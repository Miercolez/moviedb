package dao;

import models.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ActorDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void addNewActor(Actor actor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        em.close();

    }

    public void showAllActors() {
        EntityManager em = emf.createEntityManager();
        List<Actor> actors = em.createNamedQuery("Actor.findAll", Actor.class).getResultList();
        actors.forEach(System.out::println);
        em.close();
    }
}
