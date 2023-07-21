import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int num1;
        int num2;
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert first number: ");
        num1 = sc.nextInt();

        System.out.println("Insert Second number: ");
        num2 = sc.nextInt();

        System.out.println("This is the sum of: " + calculator.sum(num1,num2));
        System.out.println("This is the substraction of: " + calculator.substract(num1,num2));
        System.out.println("This is the multiplication of: " + calculator.multiply(num1,num2));
        System.out.println("This is the division of: " + calculator.divide(num1,num2));

        }
    }