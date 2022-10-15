package src;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

public class Main {
    public static void main(String[] args) {
        Client Ana = new Client(189, "Ana", "das3654" );
        System.out.println(Ana.myBankAccount.getOpeningDate());
    }
}
