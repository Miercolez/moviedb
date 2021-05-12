package Menus;

import utility.Genres;
import utility.MenuMaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class chooseGenreMenu {

    public static Genres ChooseGenreMenu() {
        List<Genres> genres = Arrays.asList(Genres.values());
        List<String> genresString = genres.stream()
                .map(g -> g.getLable())
                .collect(Collectors.toList());
        int index = MenuMaker.menuMaker(genresString) - 1;
        return genres.get(index);
    }
}
