package basic_exercises;

import java.util.Scanner;

public class Ex21WeirdAddition {
    public static void main(String[] args) {
        System.out.println("Weird calculator!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive int, I will add each single digit! (e.g. 3582=18): ");
        String input = scanner.nextLine().strip();
        int total = 0;
        for (int i = 0 ; i < input.length(); i++) {
            int thenumber = Integer.parseInt(input.substring(i,i+1));
            total += thenumber;
        }
        System.out.printf("Answer = %d", total);
    }
}
