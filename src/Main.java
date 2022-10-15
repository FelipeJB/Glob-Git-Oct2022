package src;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank("Morgan Stanley");
        System.out.println("Welcome to " + myBank.getName());
        System.out.println(myBank.Ana.myBankAccount.getOpeningDate());
    }
}
