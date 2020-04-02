import java.util.Scanner;

public class Ex2CelciusToFahrenheit {
    public static void main(String[] args) {
        System.out.println("Fahrenheit calculator");
        // F = (1.8 ×C) + 32
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many celcius?: ");
        double celcius = scanner.nextDouble();
        scanner.nextLine();
        double fahrenheit = 1.8*celcius+32;
        System.out.println(fahrenheit);
    }
}
