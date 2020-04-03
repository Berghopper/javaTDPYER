package basic_exercises;

import java.util.Random;

public class Ex27MoreScores {
    public static void main(String[] args) {
        Random generator = new Random();
        int[] testscoresArray = new int[20];
        for (int i = 0; i < 20; i++) {
            testscoresArray[i] = generator.nextInt(99)+1;
        }
        int counter = 0;
        for (int score : testscoresArray) {
            if (score >= 85 && score <= 90) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
