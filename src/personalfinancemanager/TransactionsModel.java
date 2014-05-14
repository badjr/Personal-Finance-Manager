package personalfinancemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
 *
 * The TransactionsModel class is a class created by us to hold Transaction
 * objects in a list. It provides the method to get transactions from a flat
 * file and to get the transaction list with a getter method.
 *
 */
public class TransactionsModel {

    private List<Transaction> transactions;

    /**
     * The purpose of this method is to get transactions stored in the
     * Profile\<Profile#>\transactions.txt file. This transacations.txt file is
     * generated when the user imports their bank .csv. The entries in
     * transactions.txt are separated by commas by transaction ID, date,
     * category, description, and amount, which are the columns of the
     * transaction table.
     *
     * @pre The File f exists and is accessible.
     * @post The transactions List is now populated based on the entries found
     * in the flat file.
     * @param f The .txt file that the transactions are stored in.
     * @return The List of Transaction objects parsed from the .txt file.
     */
    public List<Transaction> loadTransactionsFromFlatFile(File f) {
        Scanner s;
        String lineCol[];
        transactions = new ArrayList(); //Transactions will be stored in an ArrayList.

        //These variables will store the values from the transaction.
        int transactionID;
        String dateString;
        String category;
        String description;
        BigDecimal amount;

        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                lineCol = s.nextLine().split(",");
                transactionID = Integer.parseInt(lineCol[0]);
                dateString = lineCol[1];
                category = lineCol[2];
                description = lineCol[3];
                amount = new BigDecimal(lineCol[4]);
                transactions.add(new Transaction(transactionID,
                                                 new DateFormat().stringToDateFormat(dateString), category, description, amount));
            }
//            for (int i = 0; i < transactions.size(); i++) {
//                System.out.println(transactions.get(i));
//            }
            s.close(); //Close the scanner when done using it.

        }
        catch (FileNotFoundException ex) {
            try {
                //            Logger.getLogger(TransactionsModel.class.getName()).log(Level.SEVERE, null, ex);
                f.createNewFile();
            }
            catch (IOException ex1) {
                Logger.getLogger(TransactionsModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return transactions;

    }

    /**
     * Saves the List of transactions to a flatfile in csv format.
     *
     * @pre The File f exists and is accessible.
     * @post The transactions from the List are now saved to the File f.
     * @param f The .txt file that the transactions will be saved to.
     */
    public void saveTransactionsToFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        //TODO: Implement encryption
//        Encryptor encryptor = new Encryptor();

        try {
            //Create directory if doesn't exist.
//                        System.out.println("Writing file...");
            final File file = new File(System.getProperty("user.dir") + "\\Profiles\\" + PersonalFinanceManager.getLoggedInProfile().getUserID() + "\\transactions.txt");
            final File parent_directory = file.getParentFile();
            if (null != parent_directory) { //First we check if the file and directory doesn't exist.
                System.out.println("directory made = " + parent_directory.mkdirs()); //Make the directory/file here.
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < transactions.size(); i++) {
//                            System.out.println(transactions.get(i).toString());
                bw.write(transactions.get(i).toString() + System.getProperty("line.separator"));
                //System.getProperty("line.separator"), new to java 7, gets the system independent new line character.
            }

            bw.close(); //Close the scanner when done using it.
            fw.close(); //Close the scanner when done using it.
        }
        catch (IOException ex) {
            Logger.getLogger(AccountSetupWizardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Provides way to return the transactions list stored in TransactionsModel.
     *
     * @return The List of Transaction objects.
     */
    public List<Transaction> getTransactionsList() {
        return transactions;
    }

    /**
     * Adds a new transaction to the current list of transactions.
     *
     * @pre The transaction has yet to be added to the list of transactions.
     * @post The transaction is now added to the list of transactions.
     * @param transaction The new transaction to be added to the list.
     */
    public void addTransactionToList(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
        }
        transactions.add(transaction);
    }

    /**
     * Removes the transaction from the list of transactions at the index
     * provided.
     *
     * @pre The transaction has yet to be removed from the list.
     * @post The transaction is now removed from the list.
     * @param index The index of the transaction to be removed.
     */
    public void removeTransactionFromList(int index) {
        transactions.remove(index);
    }
}
