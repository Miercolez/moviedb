package main;

import java.time.LocalDateTime;
import java.util.Scanner;
import javax.persistence.*;

import static main.Menus.mainMenu;

public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    static boolean loopMainMenu = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (loopMainMenu) {
            mainMenu();
        }
    }



}
