import java.util.Scanner;

public class Ex1SentenceMaker {
    public static void main(String[] args) {
        System.out.println("Let's build a sentence together!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a article: ");
        String article = scanner.nextLine().toLowerCase();
        article = article.substring(0,1).toUpperCase()+article.substring(1);
        System.out.print("Give me a noun: ");
        String noun = scanner.nextLine().toLowerCase();
        System.out.print("Give me a verb: ");
        String verb = scanner.nextLine().toLowerCase();

        // Example; The dog walks
        System.out.println(String.join(" ", article, noun, verb));
    }
}
