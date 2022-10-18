import GlobantBank.Data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        ArrayList <User> userList = new ArrayList<>();


        System.out.println("Welcome to the best bank - GLOBANT BANK!");

        int option;
        float addedAmount;
        float retrieveAmount;

        do{
            System.out.println("*** Please choose an option ***" +
                    "\n1. Add new User" +
                    "\n2. List users" +
                    "\n3.  - press 3" +
                    "\n4. Exit - press 4");
            option= sc.nextInt();

            switch (option){
                case 1:
                    int userID;
                    String name;
                    String userName;
                    String password;

                    System.out.println("*** Please enter the following user information ");
                    System.out.println("User ID : ");
                    userID = sc.nextInt();
                    System.out.println("User full name : ");
                    name = sc.next();
                    System.out.println("User: ");
                    userName = sc.next();
                    System.out.println("Temporal password");
                    password = sc.next();

                    User user = new User(userID,name,userName,password);
                    userList.add(user);

                    break;
                case 2:
                    System.out.println("**********  Client List  *************");
                    System.out.printf("|%20s|%20s|%20s|%20s|%20s|%20s|%n", "ID", "FULL NAME", "USER", "ACCOUNT NUMBER", "OPENING DATE", "BALANCE");
                    for (int i=0; i<userList.size(); i++){
                        System.out.println(userList.get(i));
                    }
                    break;
                case 3:
                    System.out.println("this is option 3");
                    break;
                case 4:
                    System.out.println("You have exited the program.\n Have a good day!");
                    break;
                default:
                    System.out.println("Please enter a right option");
            }

        }while (option != 4);

    }

}
