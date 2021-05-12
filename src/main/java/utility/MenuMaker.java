package utility;

import java.util.List;

public class MenuMaker {
    public static int menuMaker(List<String> input) {
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
                System.out.println("Bad entery");
                System.out.println();
            }
        }
    }
}
