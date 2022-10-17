package org.globant.GlobantBankLogic;

import java.util.Scanner;

    public class Reader {

        public static int intScanner(){
            try {
                Scanner scan = new Scanner(System.in);
                int scannedInt = scan.nextInt();
                return scannedInt;
            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid input, please input a number without symbols");
                return -1;
            }
        }

        public static float floatScanner(){
            try {
                Scanner scan = new Scanner(System.in);
                float scannedFloat = scan.nextFloat();
                return scannedFloat;
            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid input, please input a number without symbols");
                return -1;
            }
        }

        public static String StringScanner(){
            Scanner scan = new Scanner(System.in);
            String scannedString = scan.nextLine();
            return scannedString;
        }

}
