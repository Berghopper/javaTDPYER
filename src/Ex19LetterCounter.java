import java.util.Scanner;

public class Ex19LetterCounter {
    public static void main(String[] args) {
        System.out.println("Letter 'a' counter!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a sentence!: ");
        String input = scanner.nextLine();
        char youAreAWizardCharry = 'a';
        int total = 0;
        for (int i = 0 ; i < input.length(); i++) {
            if (youAreAWizardCharry == input.charAt(i)) {
                total++;
            }
        }
        System.out.printf("The input countains %d x the letter '%s'", total, youAreAWizardCharry);
    }
}
