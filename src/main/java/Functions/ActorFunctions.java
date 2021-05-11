package Functions;

import dao.ActorDao;
import models.Actor;

public class ActorFunctions {
    static ActorDao actorDao = new ActorDao();
    public static void addNewActor(String actorName, int actorAge, String actorGender) {

        Actor actor = new Actor(actorName, actorAge, actorGender);


        actorDao.addNewActor(actor);
    }
}
