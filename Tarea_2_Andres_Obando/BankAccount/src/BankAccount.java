/**
 * This class defines a bank account
 * @author: Andres Felipe Obando Reinoso
 * @version: 1.0
 */

public class BankAccount {
    private double amount;
    private String fullName;

    /**
     * Initial constructor
     */
    public BankAccount()
    {
        this.amount = 0;
        this.fullName = "";
    }

    /**
     * Constructor with a full name
     * @param nameUser The user's fullname
     */
    public BankAccount (String nameUser)
    {
        this.amount = 0;
        this.fullName = nameUser;
    }

    /**
     * Method to retrieve the bank account's balance
     * @return a double value representing the current bank account's balance (Amount)
     */
    public double getAmount()
    {
        return this.amount;
    }

    /**
     * Method to retrieve the bank account's name
     * @return a string value representing the current bank account's full name (Amount)
     */
    public String getFullName()
    {
        return this.fullName;
    }

    /**
     * Method to assign an amount to the current bank account's amount
     * @param newAmount The new amount to assign
     */
    public void setAmount (double newAmount)
    {
        this.amount = newAmount;
    }

    public void setFullName (String newName)
    {
        this.fullName = newName;
    }
}
