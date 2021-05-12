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
        try {
            actor.setName(newActorName);
        }catch (NullPointerException n){
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void changeActorAge(Long actorId, int newActorAge) {
        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        try {
            actor.setAge(newActorAge);
        }catch (NullPointerException n){
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void changeActorGender(Long actorId, String actorGender) {
        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, actorId);
        em.getTransaction().begin();
        try {
            actor.setGender(actorGender);
        }catch (NullPointerException n){
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteActor(Long actorId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.find(Actor.class, actorId));
        }catch (IllegalArgumentException i){
            System.out.println("The inputted object does not exist in the database.");
        }
        em.getTransaction().commit();
        em.close();
    }
}
