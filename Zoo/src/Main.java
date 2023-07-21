import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Animals animals = new Animals();
        Scanner sc = new Scanner(System.in);
        System.out.println("What animal do you want to learn about? \n" +
                "1. Hippopotamus \n" +
                "2. Jiraffe \n" +
                "3. Tiger \n" +
                "4. Panda \n");
        animals.animalCharacteristics(sc.nextInt());
        }
    }