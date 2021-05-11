package Functions;

import dao.DirectorDao;
import models.Director;

public class DirectorFunctions {

    static DirectorDao directorDao = new DirectorDao();

    public static void addDirector(String directorName, int directorAge, String directorGender) {

        Director director = new Director(directorName,directorAge,directorGender);

        directorDao.addDirector(director);
    }
}
