public class PrimeNumbers {
    public static void main(String[] args) {
        int num1 = 12;
        for (int i = 2; i < num1; i++){
            if (num1 % i ==0){
                System.out.println("Number " + num1 + " is not a Prime Number");
                break;
            } else if (i == num1 - 1){
                System.out.println("Number " + num1 + " is a Prime Number");
            }
        }
    }
}