import java.util.Scanner;

public class Ex9Validation {
    public static void main(String[] args) {
        System.out.println("Validator!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");
        double inputValue = scanner.nextDouble();
        scanner.nextLine();
        if (!(inputValue > 0 && inputValue <= 10)) {
            System.out.println("Value is not correct!");
            throw new java.lang.RuntimeException("Are you really that dense?");
        } else {
            System.out.println("Value seems fine, move along!");
        }
    }
}
