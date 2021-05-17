package Functions;

import dao.ActorDao;
import models.Actor;

public class ActorFunctions {
    static ActorDao actorDao = new ActorDao();

    public static void closeEmf() {
        actorDao.closeEmf();
    }

    public static void addNewActor(String actorName, int actorAge, String actorGender) {

        Actor actor = new Actor(actorName, actorAge, actorGender);


        actorDao.addNewActor(actor);
    }

    public static void showAllActors() {
        actorDao.showAllActors();
    }

    public static void changeActorName(Long actorId, String newActorName) {

        actorDao.changeActorName(actorId, newActorName);

    }

    public static void changeActorAge(Long actorId, int newActorAge) {
        actorDao.changeActorAge(actorId, newActorAge);
    }

    public static void changeActorGender(Long actorId, String actorGender) {
        actorDao.changeActorGender(actorId, actorGender);
    }

    public static void deleteActor(Long actorId) {
        actorDao.deleteActor(actorId);
    }
}
