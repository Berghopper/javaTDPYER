import java.util.Scanner;

public class Ex6TestScores {
    public static void main(String[] args) {
        System.out.print("Give me 5 test scores (seperated by ,) e.g.; 1,2,3,4,5 : ");
        Scanner scanner = new Scanner(System.in);
        String testscores = scanner.nextLine();
        String[] testscoresArray = testscores.split(",");
        if (testscoresArray.length != 5) {
            System.out.println("Error! too little test or too many scores found!");
            throw new java.lang.RuntimeException("Too little or too many test scores!");
        }
        int counter = 0;
        for (String item : testscoresArray) {
            int score = Integer.parseInt(item);
            if (score > 0 && score <= 10) {
                if (Integer.parseInt(item) > 7) {
                    counter++;
                }
            } else {
                System.out.println("One or more scores are not between 1 and 10!");
                throw new java.lang.RuntimeException("One or more scores are not between 1 and 10!");
            }

        }
        System.out.print("Amount of scores above 7: ");
        System.out.println(counter);
    }
}
