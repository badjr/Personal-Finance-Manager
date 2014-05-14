package personalfinancemanager;

import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */

/**
 * A Transaction has a transaction id, a date, a category, a description, and
 * an amount.
 */
public class Transaction {
    
    //Fields
    private int transactionID;
    private DateFormat date;
    private String category;
    private String description;
    private BigDecimal amount;

    /**
     * Constructor
     * @param transactionID
     * @param date
     * @param category
     * @param description
     * @param amount 
     */
    public Transaction(int transactionID, DateFormat date, String category,
                       String description, BigDecimal amount) {
        //Initialize the fields here.
        this.transactionID = transactionID;
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }
    
    //Getters
    /**
     * Method to get the transaction ID of a transaction.
     * @return The transcation ID of this transaction.
     */
    public int getTransactionID() {
        return transactionID;
    }
    
    /**
     * Method to get the date of the transaction.
     * @return The date of this transaction, as a DateFormat object.
     */
    public DateFormat getDate() {
        return date;
    }
    
    /**
     * Method to get the category of the transaction.
     * @return A String describing the category of this transaction.
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Method to get the description of this transaction.
     * @return The String describing the description of this transaction.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Method to get the amount of the transaction.
     * @return The amount of the transaction, as a BigDecimal.
     */
    public BigDecimal getAmount() {
        return amount;
    }
    
    /**
     * When a Transaction object is printed in a print statement, it will print
     * in a comma separated value format.
     * @return A formatted string of the transaction, separated by commas.
     */
    @Override
    public String toString() {
        return transactionID + "," + date + "," + category + "," + description + "," + amount;
    }
    
}
