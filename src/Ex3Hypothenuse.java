import java.util.Scanner;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Ex3Hypothenuse {
    public static void main(String[] args) {
        System.out.println("Hypothenuse calculator!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Side a: ");
        double sideA = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Side b: ");
        double sideB = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Hypothenuse is: ");
        System.out.print(sqrt(pow(sideA, 2)+pow(sideB, 2)));

    }
}
