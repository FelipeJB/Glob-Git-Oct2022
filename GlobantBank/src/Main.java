import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bank = new Bank();
        System.out.println("Welcome to Globant Bank!");
        System.out.println("Please enter your username");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.println("Please enter your password");
        int password = scan.nextInt();
        Client loginUser = null;

    }
}