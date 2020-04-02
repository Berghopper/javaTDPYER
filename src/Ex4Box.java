import java.util.Scanner;

public class Ex4Box {
    public static void main(String[] args) {
        System.out.println("Box calculator!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Side L: ");
        double sideL = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Side W: ");
        double sideW = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Side H: ");
        double sideH = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("The surface area of the box is: ");
        System.out.println(sideL*sideW*sideH);
        System.out.print("The volume of the box is: ");
        System.out.println(2*((sideL*sideW+sideL*sideH+sideH*sideW)));
    }
}
