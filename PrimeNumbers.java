// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PrimeNumbers {
    public static void main(String[] args) {
        int number = 0;
        int divider = 2;
        boolean answer = true;

        if (number <= 1)
        {
            System.out.println("The number " + number + " is not a prime number");
        }
        else
        {
            while (number < divider)
            {
                if (number % divider == 0)
                {
                    System.out.println("The number " + number + " is not a prime number");
                    divider++;
                    answer = false;
                    break;
                }

                if(answer)
                {
                    System.out.println("The number " + number + " is a prime number");
                }
            }
        }

    }
}