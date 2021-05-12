package main;

import utility.Genres;

import static Menus.chooseGenreMenu.ChooseGenreMenu;

public class TestMain {

    public static void main(String[] args) {
        Genres gener = ChooseGenreMenu();
        System.out.println();
        System.out.println(gener);
    }
}
