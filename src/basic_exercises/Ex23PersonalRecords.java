package basic_exercises;

import java.util.Scanner;

public class Ex23PersonalRecords {
    public static void main(String[] args) {
        String[] names = {"Bob Ross", "John Johnson", "Ross Bob"};
        String[] birthDates = {"1942-10-29","2000-02-23","1980-01-05"};
        String[] phoneNumbers = {"+555555551","+555555552","+555555553"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a name to check: ");
        String nameToCheck = scanner.nextLine();
        int finalIndex = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(nameToCheck)) {
                finalIndex = i;
                break;
            }
        }
        if (finalIndex == -1) {
            System.out.println("Can't find anything!");
        } else {
            System.out.println("Info on person: ");
            System.out.printf("Phone number: %s \nBirthday: %s", phoneNumbers[finalIndex], birthDates[finalIndex]);
        }


    }
}
