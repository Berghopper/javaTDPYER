package basic_exercises;

import java.util.Scanner;

public class Ex8LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter 3 numbers seperated by comma: ");
        String myInput = scanner.nextLine();
        String[] inputArray = myInput.split(",");
        if (inputArray.length != 3) {
            System.out.println("Error! too little test or too many numbers found!");
            throw new java.lang.RuntimeException("Too little or too many numbers!");
        }
        double largest = Double.parseDouble(inputArray[0]);
        for (int i = 1; i < 3; i++) {
            double number = Double.parseDouble(inputArray[i]);
            if (largest < number) {
                largest = number;
            }
        }
        System.out.printf("The largest number is: %.2f !", largest);
    }
}
