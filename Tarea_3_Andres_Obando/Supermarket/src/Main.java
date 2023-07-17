import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float price;
        int amount;
        String code = "";
        String fullName = "";
        boolean finishTransaction = false;
        int option;
        Supermarket MiniDollar = new Supermarket();

        System.out.println("Welcome to MiniDollar. \n");

        while(!finishTransaction)
        {
            System.out.println("Please, select an option to do: \n1. Add a new product. \n2. List all products");
            System.out.println("3. Sell a product. \n4. Remove a product. \n5. Exit");
            option = scan.nextInt();
            scan.nextLine();
            switch(option)
            {
                case 1:
                    System.out.println("Please, enter the new code to add in our system:");
                    code = scan.nextLine();

                    if(MiniDollar.getCode(code)){
                        System.out.println("ERROR: This product exists already in our store. Please, try again");
                    }
                    else{
                        System.out.println("Enter the name for the new product");
                        fullName = scan.nextLine();
                        System.out.println("Enter the price for the new product");
                        price = scan.nextFloat();
                        System.out.println("Finally, enter the stock related to the product");
                        amount = scan.nextInt();
                        MiniDollar.addProduct(code,fullName,amount,price);
                        System.out.println("Process complete!!");
                    }
                    break;

                case 2:
                    System.out.println("List of Products");
                    System.out.println("Code" + "|\t" + "Description" + "|\t" + "Price" + "|\t" + "Stock");
                    MiniDollar.listElements();
                    break;

                case 3:
                    System.out.println("Please, enter the product code to sell.");
                    code = scan.nextLine();

                    if(MiniDollar.getCode(code)){
                        System.out.println("Enter the amount of products to sell.");
                        amount = scan.nextInt();
                        if(MiniDollar.getAmount(code) < amount){
                            System.out.println("ERROR: This amount is not allowed. Please, try with a lower amount");
                        }
                        else{
                            MiniDollar.sellProduct(code, amount);
                            System.out.println("Process Complete. Total: " + MiniDollar.getPrice(code) * amount);
                        }
                    }
                    else{
                    System.out.println("ERROR: This product does not exist in our system. Please, try again.");
                    }
                    break;

                case 4:
                    System.out.println("Please, enter the product code to sell.");
                    code = scan.nextLine();
                    if(MiniDollar.getCode(code)){
                        if (MiniDollar.getAmount(code) == 0) {
                            MiniDollar.removeProduct(code);
                            System.out.println("The product has been removed successfully.");
                        }
                        else{
                            System.out.println("ERROR: The product cannot be removed.");
                        }
                    }
                    else {
                        System.out.println("ERROR: This product does not exist in our system. Please, try again.");
                    }
                    break;

                case 5:
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