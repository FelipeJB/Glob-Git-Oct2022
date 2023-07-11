public class Globant {
    public static void main(String[] args) {

        int num1 = 5;

        for (int i = 2; i < num1; i++) {
            if (num1 % i == 0) {
                System.out.println("El numero " + num1 + " no es primo");
                break;

            }
           else if (i == (num1 - 1)) {
                System.out.println("El numero " + num1 + "  es primo");

            }

        }
    }
}

