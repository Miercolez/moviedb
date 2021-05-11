package utility;
import java.util.Scanner;

public class Read {

    static Scanner sc = new Scanner(System.in);

    public static int readInt(){
        int temp = sc.nextInt();
        sc.nextLine();
        return temp;
    }
    public static Long readLong(){
        Long temp = sc.nextLong();
        sc.nextLine();
        return temp;
    }
    public static double readDouble(){
        double temp = sc.nextDouble();
        sc.nextLine();
        return temp;
    }
    public static String readLine(){
        return sc.nextLine();
    }
}
