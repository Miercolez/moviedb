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

    public void changeActorName(Long actorId, String newActorName) {
        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        actor.setName(newActorName);
        em.getTransaction().commit();
        em.close();
    }

    public void changeActorAge(Long actorId, int newActorAge) {
        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        actor.setAge(newActorAge);
        em.getTransaction().commit();
        em.close();
    }
}
