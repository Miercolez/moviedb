package utility;

import java.util.*;
import java.util.stream.Collectors;

public class Read {

    static Scanner sc = new Scanner(System.in);

    public static int readInt() {

        while (true) {
            try {

                return sc.nextInt();

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Wrong input, please try again.");

                System.out.print("\nMake a choice: ");

            } finally {
                sc.nextLine();
            }
        }
    }

    public static Long readLong() {

        while (true) {
            try {

                return sc.nextLong();

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Wrong input, please try again.");

                System.out.print("\nMake a choice: ");

            } finally {
                sc.nextLine();
            }
        }
    }

    public static String readLine() {
        return sc.nextLine();
    }

    public static Genres readGenre() {
        List<Genres> genres = Arrays.asList(Genres.values());
        List<String> genresString = genres.stream()
                .map(Genres::getLabel)
                .collect(Collectors.toList());
        int chosenGenre = chooseFromGenreList(genresString) - 1;

        return genres.get(chosenGenre);
    }

    public static int chooseFromGenreList(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + input.get(i));
        }

        while (true) {
            System.out.print("Make your choice: ");
            int choice = Read.readInt();
            System.out.println();
            if (0 < choice && choice <= input.size()) {

                return choice;

            } else {
                System.out.println("Bad entry");
                System.out.println();
            }
        }
    }
}
