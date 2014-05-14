package personalfinancemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Geek Squad
 */
public class AccountSetupWizardModel {

    private BankDataParser bankDataParser;
    private List<Transaction> transactions;
    private List<Debt> debts;
    private List<Bill> bills;
    private static JFileChooser jFileChooser;
    private static File fileChosen;

    public AccountSetupWizardModel() {
        this.bankDataParser = new BankDataParser();
        bills = new ArrayList<Bill>();
        debts = new ArrayList<Debt>();
    }

    /**
     * Opens up a FileChooser dialog to we can browse for a .csv file.
     * @return The file selected from the file chooser.
     */
    public String browseForFile() {
        jFileChooser = new JFileChooser(System.getProperty("user.dir")); //Initialize the file chooser dialog.

        jFileChooser.setDialogTitle("Importing bank transaction files");
        jFileChooser.setFileFilter(new CSVFileFilter()); //Set the file filter for only .csv files.
        jFileChooser.setName(""); // NOI18N
        
        int returnVal = jFileChooser.showOpenDialog(jFileChooser); //Show the file chooser. When it is closed, it will return an int value.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //If the value is the APPROVE_OPTION constant, set file chosen to the file the user chose.
            fileChosen = jFileChooser.getSelectedFile();
//                try {
            // What to do with the file, e.g. display it in a TextArea
            return fileChosen.getName().toString(); //On the account setup wizard, we show the file chosen on one of the labels.
        }
        else {
            //Else, we set the file chosen string to null return it. The file
            //chosenlabel on account setup wizard will be set to none,
            //signifying no file chosen.
            fileChosen = null;
            System.out.println("File access cancelled by user.");
            return "none";
        }

    }

    /**
     * This method will store transactions from the transactions .csv file
     * into the List transactions.
     * //TODO: Notify user if they haven't chosen a .csv, to ask if they're sure
     * and want to do it later.
     * @param selectedBank The string of the bank selected from the combo box.
     */
    public void loadTransactionsFromFile(String selectedBank) {

        if (fileChosen != null) {
            if (selectedBank.compareTo("Bank of America") == 0) {
                //If a Bank of America .csv was chosen, we store the 
                //transactions in the List transcations.
                transactions = bankDataParser.getBoaTransactionsFromFile(fileChosen);
            }
            else if (selectedBank.compareTo("Wells Fargo") == 0) {
                //Store the transactions into the List transactions.
                transactions = bankDataParser.getWellsFargoTransactionsFromFile(fileChosen);
            }
            else {
                System.out.println("This bank isn't supported yet.");
            }
        }
        else {
            transactions = new ArrayList();
//            System.out.println("You haven't chosen a file yet.");
        }
    }

    /**
     * When the add bill button is pressed, this adds the bill to the
     * AccountSetupWizardModel bills List.
     * @param bill The bill to be added to List bills.
     */
    public void addBillToList(Bill bill) {
        bills.add(bill);
    }
    
    /**
     * When the add debt button is pressed, this adds the debt to the
     * AccountSetupWizardModel debts list.
     * @param debt The debt to be added to List debts.
     */
    public void addDebtToList(Debt debt) {
        debts.add(debt);
    }

    public List getTransactionsList() {
        return transactions;
    }

    public List getDebtsList() {
        return debts;
    }

    public List getBillsList() {
        return bills;
    }

    /**
     * Saves the List of transactions to a flatfile in csv format.
     */
    public void saveTransactionsToFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        //TODO: Implement encryption
//        Encryptor encryptor = new Encryptor();

        try {
            //Create directory if doesn't exist.
//                        System.out.println("Writing file...");
            final File file = new File(System.getProperty("user.dir") + "\\Profiles\\" + PersonalFinanceManager.getLoggedInProfileEntry().getUserID() + "\\transactions.txt");
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
     * Saves the List of bills to a flatfile in csv format.
     */
    public void saveBillsToFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        //TODO: Implement encryption
//        Encryptor encryptor = new Encryptor();
        try {
            //Create directory if doesn't exist.
//                        System.out.println("Writing file...");
            final File file = new File(System.getProperty("user.dir") + "\\Profiles\\" + PersonalFinanceManager.getLoggedInProfileEntry().getUserID() + "\\bills.txt");
            final File parent_directory = file.getParentFile();
            if (null != parent_directory) { //First we check if the file and directory doesn't exist.
                System.out.println("directory made = " + parent_directory.mkdirs()); //Make the directory/file here.
//                            parent_directory.mkdirs();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < bills.size(); i++) {
//                            System.out.println(transactions.get(i).toString());
                bw.write(bills.get(i).toString() + System.getProperty("line.separator"));
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
     * Saves the List of debts to a flatfile in csv format.
     */
    public void saveDebtsToFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        //TODO: Implement encryption
//        Encryptor encryptor = new Encryptor();
        try {
            //Create directory if doesn't exist.
//                        System.out.println("Writing file...");
            final File file = new File(System.getProperty("user.dir") + "\\Profiles\\" + PersonalFinanceManager.getLoggedInProfileEntry().getUserID() + "\\debts.txt");
            final File parent_directory = file.getParentFile();
            if (null != parent_directory) { //First we check if the file and directory doesn't exist.
                System.out.println("directory made = " + parent_directory.mkdirs()); //Make the directory/file here.
//                            parent_directory.mkdirs();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < debts.size(); i++) {
//                            System.out.println(transactions.get(i).toString());
                bw.write(debts.get(i).toString() + System.getProperty("line.separator"));
                //System.getProperty("line.separator"), new to java 7, gets the system independent new line character.
            }

            bw.close(); //Close the scanner when done using it.
            fw.close(); //Close the scanner when done using it.
        }
        catch (IOException ex) {
            Logger.getLogger(AccountSetupWizardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/**
 * The CSVFileFilter ensures only .csv files are shown in the FileChooser
 * dialog.
 */
class CSVFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with ".csv" extension
//        return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
        return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
    }

    @Override
    public String getDescription() {
        // This description will be displayed in the dialog,
        // hard-coded = ugly, should be done via I18N
//        return "Text documents (*.txt)";
        return "Comma separated values (*.csv)";
    }
}
