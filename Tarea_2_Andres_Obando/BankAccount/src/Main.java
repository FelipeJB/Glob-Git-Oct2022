// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double amount;
        String fullName;
        boolean finishTransaction = false;
        int option;
        BankAccount newAccount = new BankAccount();

        System.out.println("Welcome to Test Bank. \n Please, enter your full name");
        fullName = scan.nextLine();

        while(fullName.equals(""))
        {
                System.out.println("I'm sorry, but I cannot recognize your name. Please, try again");
                fullName = scan.nextLine();
        }

        newAccount.setFullName(fullName);
        System.out.println("Thank you and welcome " + newAccount.getFullName());

        while(!finishTransaction)
        {
            System.out.println("Please, select an operation to do: \n 1. Add money \n 2. Retrieve money \n 3. Exit");
            option = scan.nextInt();
            switch(option)
            {
                case 1:
                    System.out.println("Please, enter the amount to add:");
                    amount = scan.nextDouble();
                    while(amount <= 0)
                    {
                        System.out.println("I'm sorry, but I cannot recognize the amount. Please, try again");
                        amount = scan.nextDouble();
                    }
                    newAccount.setAmount(newAccount.getAmount() + amount);
                    System.out.println("Process successful. Your current balance is " + newAccount.getAmount());
                    break;

                case 2:
                    System.out.println("Please, enter the amount to retrieve:");
                    amount = scan.nextDouble();
                    while((amount <= 0) || (amount > newAccount.getAmount()))
                    {
                        if(amount <= 0)
                        {
                            System.out.println("I'm sorry, but I cannot recognize negative amounts. Please, try again");
                            amount = scan.nextDouble();
                        }
                        else
                        {
                            System.out.println("I'm sorry, but I cannot recognize the amount. Please, try again");
                            amount = scan.nextDouble();
                        }
                    }

                    newAccount.setAmount(newAccount.getAmount() - amount);
                    System.out.println("Process successful. Your current balance is " + newAccount.getAmount());
                    break;

                case 3:
                    System.out.println("Thank you and have a good day.");
                    finishTransaction = true;
                    break;

                default:
                    System.out.println("I'm sorry, but I cannot recognize the option. Please, try again!");
                    finishTransaction = false;
                    break;
            }
        }
    }
}