package src.org.globantBank.persistence;

import src.org.globantBank.data.Bank;

public class DataInitializer {
    public Bank loadBank() {
        Bank myBank = new Bank("Bancolombia");
        return myBank;
    }
}
