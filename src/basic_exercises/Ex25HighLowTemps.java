package basic_exercises;

import java.util.Scanner;

public class Ex25HighLowTemps {
    public static void main(String[] args) {
        System.out.println("Give me the highest and lowest temps of the year!\n ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me the lowest (seperated by comma): ");
        String[] lowest = scanner.nextLine().split(",");
        System.out.print("Give me the highest (seperated by comma): ");
        String[] highest = scanner.nextLine().split(",");

        if (lowest.length != 12 || highest.length != 12) {
            System.out.println("That's not quite right! (too many or too little values)");
        } else {
            System.out.println("Stored in highest and lowest array");
        }
    }
}
