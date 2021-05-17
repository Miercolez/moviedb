package Functions;

import dao.DirectorDao;
import models.Director;

public class DirectorFunctions {

    static DirectorDao directorDao = new DirectorDao();

    public static void closeEmf() {
        directorDao.closeEmf();
    }

    public static void addDirector(String directorName, int directorAge, String directorGender) {

        Director director = new Director(directorName, directorAge, directorGender);

        directorDao.addDirector(director);
    }

    public static void changeName(Long directorId, String newDirectorName) {
        directorDao.changeName(directorId, newDirectorName);
    }

    public static void changeAge(Long directorId, int newDirectorAge) {
        directorDao.changeAge(directorId, newDirectorAge);
    }

    public static void showAllDirectors() {
        directorDao.showAllDirectors();

        System.out.println();
    }

    public static void changeGender(Long directorId, String directorGender) {
        directorDao.changeGender(directorId, directorGender);
    }

    public static void deleteDirector(Long directorId) {
        directorDao.deleteDirector(directorId);
    }
}
