package personalfinancemanager;

/**
 *
 * @author Geek Squad
 */

/**
 * 
 * The TransactionCategory enum allows us to have named constants for the
 * different transaction categories we will have.
 */
public enum TransactionCategory {
    OTHER("Other"), FOOD("Food & Groceries"), TRANSPORTATION("Transportation & Gas");
    
    private String transactionCategoryAsString;
    
    /**
     * 
     * @param transactionCategoryAsString The String the TransactionCategory
     * would be printed as.
     */
    private TransactionCategory(String transactionCategoryAsString) {
        this.transactionCategoryAsString = transactionCategoryAsString;
    }
    
    /**
     * Whenever the toString method is invoked, we print
     * transactionCategoryAsString, so it prints the string passed as the
     * contstructor instead of the all caps enum.
     * @return 
     */
    @Override
    public String toString() {
        return transactionCategoryAsString;
    }
    
}
