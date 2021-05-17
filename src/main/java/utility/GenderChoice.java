package utility;

import static utility.Read.*;

public class GenderChoice {

    public static String chooseGender() {


        while (true) {

            System.out.println("Gender: ");
            System.out.println("[1] - Female");
            System.out.println("[2] - Male");
            int choice = readInt();

            switch (choice) {
                case 1:
                    return "Female";
                case 2:
                    return "Male";
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

}
