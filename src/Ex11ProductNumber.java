import java.util.Scanner;

public class Ex11ProductNumber {
    public static void main(String[] args) {
        System.out.println("Product table!");
        double[] productTable = {2.95,4.99,5.49,7.80,8.85};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a product number!: ");
        int productNumber = scanner.nextInt();
        productNumber--;

        System.out.printf("The value of the product is: %.2f", productTable[productNumber]);
    }
}
