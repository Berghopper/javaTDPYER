package basic_exercises;

import java.util.Scanner;

public class Ex10Prompt {
    public static void main(String[] args) {
        System.out.println("Promter!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to quit [Y,N]? ");
        String input = scanner.nextLine();
        switch (input) {
            case "Y":
                System.out.println("Continuing program!");
                break;
            case "N":
                System.out.println("Stopping program!");
                break;
            default:
                System.out.println("What do you mean?...");
                throw new java.lang.RuntimeException("Great you crashed it again...");
        }
    }
}
