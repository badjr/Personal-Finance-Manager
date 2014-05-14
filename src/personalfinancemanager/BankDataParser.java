package personalfinancemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geek Squad
 */
/**
 * The BankDataParser class provides an object that will parse bank data from
 * .csv files. The bank data parser currently supports BoA, Suntrust, Wells
 * Fargo, JPC, and Chase.
 */
public class BankDataParser {

    private List<Transaction> transactions;
    private int transactionIDCounter;
    DateFormat date;
    private String dateString;
    private String category;
    private String description;
    private String amount;
    private int day;
    private int month;
    private int year;
    private TransactionCategorizer transactionCategorizer;

    /**
     * Bank of America .csv parser
     *
     * @pre File f exists and is accessible.
     * @post The List transactions is now populated based on the entries in the
     * .csv file, or initialized to an empty List if no transactions were found.
     * @param f The .csv file to be parsed.
     * @return List containing transactions parsed from the .csv file.
     */
    public List getBoaTransactionsFromFile(File f) {
        transactions = new ArrayList();
        transactionCategorizer = new TransactionCategorizer();
        Scanner dateScan = null;
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",");
            s.nextLine();
            s.nextLine(); //Skip first 2 lines, transactions start on 3rd line.
            while (s.hasNextLine()) {
                dateString = s.next();
//                category = null;
                description = s.next();
                category = transactionCategorizer.categorize(description);
                amount = s.next();
                dateScan = new Scanner(dateString).useDelimiter("/");
//                System.out.println("dateString = " + dateString);
//                System.out.println("month = " + month + "; day = " + day + "; year = " + year);
                month = dateScan.nextInt();
                day = dateScan.nextInt();
                year = dateScan.nextInt();
//                System.out.println("month = " + month + "; day = " + day + "; year = " + year);
//                c.set(year, month, day);
                date = new DateFormat(month, day, year);
//                System.out.println("amount = " + amount);

                //This will mess up if there's a comma in the transaction descrption
                transactions.add(new Transaction(transactionIDCounter++, date,
                                                 category, description, new BigDecimal(amount)));

                s.nextLine(); //Skip the rest of the line.
            }
            dateScan.close(); //Close the scanner when done using.
            s.close(); //Close the scanner when done using.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(BankDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;
    }

    /**
     * Suntrust .csv parser
     *
     * @pre File f exists and is accessible.
     * @post The List transactions is now populated based on the entries in the
     * .csv file, or initialized to an empty List if no transactions were found.
     * @param f The .csv file to be parsed.
     * @return List containing transactions parsed from the .csv file.
     */
    public List getSuntrustTransactionsFromFile(File f) {
        transactions = new ArrayList();
        Scanner dateScan = null;
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",");
            s.nextLine(); // First line is description of the ccv
            s.nextLine(); // Second line is blank
            while (s.hasNextLine()) {
                // fields go Date,Check Number,Description,Debit,Credit,Running Balance

                dateString = s.next(); // Date
                s.next();              // Skip check number
                description = s.next();// description of debit/credit
                amount = s.next();     // Get the amount. If this workd, it was a debit
                if (amount == "0") {       // If it was a 0 then there was a credit instead
                    amount = s.next(); // so reassign with the next field, already positive.
                }
                else {
                    int iAmount = Integer.parseInt(amount); // convert the amount string to an int
                    iAmount = 0 - iAmount; // make it negative, since it's a debit (money spent)
                    amount = Integer.toString(iAmount); // Store back as a string in the amount var.
                    s.next();           // Skip over the empty credit field.
                }
                s.next();               // this would be the runninc account total if needed.
                category = null;

                dateScan = new Scanner(dateString).useDelimiter("/");
                month = dateScan.nextInt();
                day = dateScan.nextInt();
                year = dateScan.nextInt();
                date = new DateFormat(month, day, year);

                transactions.add(new Transaction(transactionIDCounter++, date,
                                                 null, description, new BigDecimal(amount)));

            }
            dateScan.close(); //Close the scanner when done using it.
            s.close(); //Close the scanner when done using it.

        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(BankDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;
    }

    /**
     * Wells Fargo .csv parser
     *
     * @pre File f exists and is accessible.
     * @post The List transactions is now populated based on the entries in the
     * .csv file, or initialized to an empty List if no transactions were found.
     * @param f The .csv file to be parsed.
     * @return List containing transactions parsed from the .csv file.
     */
    public List getWellsFargoTransactionsFromFile(File f) {
        transactions = new ArrayList();
        Scanner dateScan = null;
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",");
            while (s.hasNextLine()) {
                dateString = s.next();
                dateString = dateString.substring(1, dateString.length() - 1);
                amount = s.next();
                amount = amount.substring(1, amount.length() - 1);
                s.next();
                s.next();
                category = null;
                description = s.next();
                System.out.println(dateString);
                dateScan = new Scanner(dateString).useDelimiter("/");
                month = dateScan.nextInt();
                day = dateScan.nextInt();
                year = dateScan.nextInt();
                date = new DateFormat(month, day, year);

                transactions.add(new Transaction(transactionIDCounter++, date,
                                                 null, description, new BigDecimal(amount)));
                if (s.hasNextLine()) {
                    s.nextLine();
                }
            }
            dateScan.close(); //Close the scanner when done using it.
            s.close(); //Close the scanner when done using it.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(BankDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;

    }

    /**
     * JPC .csv parser
     *
     * @pre File f exists and is accessible.
     * @post The List transactions is now populated based on the entries in the
     * .csv file, or initialized to an empty List if no transactions were found.
     * @param f The .csv file to be parsed.
     * @return List containing transactions parsed from the .csv file.
     */
    public List getJPCTransactionsFromFile(File f) {
        transactions = new ArrayList();
        Scanner dateScan = null;
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",");
            s.nextLine();
            s.nextLine(); //Skip first 2 lines, transactions start on 3rd line.
            while (s.hasNextLine()) {
                dateString = s.next();
                category = null;
                description = s.next();
                amount = s.next();
                dateScan = new Scanner(dateString).useDelimiter("/");
//                System.out.println("dateString = " + dateString);
//                System.out.println("month = " + month + "; day = " + day + "; year = " + year);
                month = dateScan.nextInt();
                day = dateScan.nextInt();
                year = dateScan.nextInt();
//                System.out.println("month = " + month + "; day = " + day + "; year = " + year);
//                c.set(year, month, day);
                date = new DateFormat(month, day, year);
//                System.out.println("amount = " + amount);

                //This will mess up if there's a comma in the transaction descrption
                transactions.add(new Transaction(transactionIDCounter++, date,
                                                 null, description, new BigDecimal(amount)));

                s.nextLine(); //Skip the rest of the line.
            }
            dateScan.close(); //Close the scanner when done using it.
            s.close(); //Close the scanner when done using it.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(BankDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;
    }
    /**
     * ChaseBank .csv parser
     *
     * @pre File f exists and is accessible.
     * @post The List transactions is now populated based on the entries in the
     * .csv file, or initialized to an empty List if no transactions were found.
     * @param f The .csv file to be parsed.
     * @return List containing transactions parsed from the .csv file.
     */
//    public List getChaseBankTransactionsFromFile(File f) {
//    }
}
