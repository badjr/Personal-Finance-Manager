package personalfinancemanager;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Geek Squad
 */

/**
 * The purpose of this class is to have a transaction categorizer object
 * categorize transcations by taking the transaction description string and
 * checking if any of the words belongs to any of the category keyword
 * dictionaries. If so, the category is returned as a string, otherwise, "Other"
 * is returned.
 */
public final class TransactionCategorizer {
    //TODO: Add more category constants and their dictionaries.
    
    //Category constants
//    private static final TransactionCategory OTHER;
//    private static final TransactionCategory FOOD;
//    private static final TransactionCategory TRANSPORTATION;
    
    //Category keyword dictionaries
    private static String[] FOODKEYWORDS = {"kroger", "publix", "cafe", "food",
                                           "drink", "wendys", "mcdonalds",
                                           "wings", "snack", "soda", "vending",
                                           "pizza"};
    private static String[] TRANSPORTATIONKEYWORDS = {"parking", "gas", "shell", 
                           "texaco", "bp", "exxon", "conoco", "chevron"};
    
    /**
     * The categorize method will check every word in the transcation
     * description string and check if it belongs to any of the keyword
     * dictionaries. If it does, a string describing the description is
     * returned. Otherwise, "Other" is returned.
     * @param transactionDescription The transaction description string.
     * @return String describing the category of the transcation, or "Other" if
     * no category was found.
     */
    public String categorize(String transactionDescription) {
        Scanner s = new Scanner(transactionDescription); //The transaction description will be scanned.
        String currToken;
        while (s.hasNext()) {
            currToken = s.next();
//            System.out.println("currToken = " + currToken);
            if (!currToken.matches("[a-zA-Z]+")) { //If the current token does not contain any letters, we skip it.
                continue; //Start over from the beginning of while loop.
            }
//            System.out.println("currToken = " + currToken);
            if (Arrays.asList(FOODKEYWORDS).contains(currToken.toLowerCase())) {
                //If the FOODKEYWORDS array dictionary contains the current token, return the TransactionCategory enum FOOD as the category.
                return TransactionCategory.FOOD.toString();
            }
            else if (Arrays.asList(TRANSPORTATIONKEYWORDS).contains(currToken.toLowerCase())) {
                //If the TRANSPORTATIONKEYWORDS array dictionary contains the current token, return the TransactionCategory enum TRANSPORTATION as the category.
                return TransactionCategory.TRANSPORTATION.toString(); 
            }
        }
        s.close(); //Close scanner when done using.
        return TransactionCategory.OTHER.toString(); //If we reach this point, none of the categories matched, so the category returned is other.
    }
    
}
