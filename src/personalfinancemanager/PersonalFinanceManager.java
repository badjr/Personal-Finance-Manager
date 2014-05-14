package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Team Geeksquad
 * Personal Finance Manager+
 * 
 */
/**
 * This is the main class. The flow between different windows like the profile
 * creator, login dialog, main window frame, etc. is controlled here.
 *
 */
public class PersonalFinanceManager {

    static MainWindowFrame mainWindowFrame;
    static ProfileCreatorDialog profileCreatorDialog;
    static ProfileCreatorController profileCreatorController;
    static AccountSetupWizardModel accountSetupWizardModel;
    static AccountSetupWizard acctSetupWizardFrame;
    static AccountSetupWizardController acctSetupWizardController;
    static LoginDialog loginDialog;
    static LoginDialogController loginDialogController;
    static OverviewPanelController overviewPanelController;
    static OverviewPanelModel overviewPanelModel;
    static TransactionsModel transactionsModel;
    static TransactionsPanelController transactionsTableController;
    static CalendarModel bigCalendarModel;
    static CalendarTabController calendarTabController;
    static BillsModel billsModel;
    static DebtsModel debtsModel;
    static DebtManagerPanelController debtPanelController;
    static ProfileEntry loggedInProfileEntry;
    static Profile loggedInProfile;
    static ProfileDB profileDatabase;
    static List transactions;
    static Calculator calculator;
    static List debts;
    static List bills;
    static File f;

    public static void main(String[] args) {
        System.out.println("Hello, World.");

        mainWindowFrame = new MainWindowFrame();
        profileDatabase = new ProfileDB();

        if (!profileDatabase.isConnected()) {
            //If profileDatabase is not connected upon initialization, no profiles exist and we show the profile creator dialog.
            profileCreatorDialog = new ProfileCreatorDialog();
            profileCreatorDialog.addWindowListener(profileCreatorDialogClosingListener); //Set the window listener, so we can perform actions when closing.
            profileCreatorController = new ProfileCreatorController(profileDatabase, profileCreatorDialog); //Initialize the controller, passing in the profile database (model) and profile creator dialog (view)

            accountSetupWizardModel = new AccountSetupWizardModel();
            acctSetupWizardFrame = new AccountSetupWizard();
            //  acctSetupWizardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            acctSetupWizardFrame.addWindowListener(accountSetupWizardClosingListener); //Add window listener so we can perform actions when closing.
            acctSetupWizardController = new AccountSetupWizardController(accountSetupWizardModel, acctSetupWizardFrame); //Initiallize the controller, passing in AccountSetupWizardModel, and ccountSetupwizardFrame (view).

        }
        else {
            //Else, we show the login dialog, because profiles exist.
            loginDialog = new LoginDialog();
            loginDialogController = new LoginDialogController(loginDialog, profileDatabase);
            loginDialog.addWindowListener(loginDialogClosingListener);
            loginDialog.setVisible(true);

            profileDatabase.printProfiles();
        }

        //Action listeners for the menu items
        //Add the action listener for the account setup wizard menu item.
        mainWindowFrame.addAccountSetupWizardMenuItemActionListener(new AccountSetupWizardMenuItemSelectedListener());
        //Add the action listener for the calculator menu item.
        mainWindowFrame.addCalculatorMenuItemActionListener(new CalculatorMenuItemSelectedListener());
        mainWindowFrame.addSwitchAccountsMenuItemActionListener(new SwitchAccountsMenuItemSelectedListener());

    }
    
    /**
     * This class is for performing actions if the account setup wizard dialog is selected.
     */
    private static class AccountSetupWizardMenuItemSelectedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //If you want to show the account setup wizard, you would add these lines:
//            acctSetupWizardFrame = new AccountSetupWizard();
//            acctSetupWizardFrame.setVisible(true);
            //But when you close it, the whole program closes because that's what it's currently set up to do. 
            System.out.println("You selected the account setup wizard menu item.");
        }
    }

    /**
     * Performs actions when calculaor is selected.
     */
    private static class CalculatorMenuItemSelectedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calculator = new Calculator();
            calculator.setVisible(true);

        }
    }

    /**
     * Bring up the login dialog to switch accounts.
     * //TODO: Not complete yet.
     */
    private static class SwitchAccountsMenuItemSelectedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainWindowFrame.setVisible(false);
            loginDialog.setVisible(true);
        }
    }

    /**
     * Provide a way for other classes to get the logged in profile.
     *
     * @return The currently logged in profile.
     */
    public static Profile getLoggedInProfile() {
        return loggedInProfile;
    }

    /**
     * Provide a way for other classes to get the logged in profile entry.
     * @return The currently logged in profile entry..
     */
    public static ProfileEntry getLoggedInProfileEntry() {
        return loggedInProfileEntry;
    }
    
    /**
     * Listeners for when various windows are closed. When a window is closed,
     * we make other windows visible.
     */
    
    /**
     * When the profile creator dialog is closed, we show the account setup
     * wizard.
     */
    private static WindowListener profileCreatorDialogClosingListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent w) { //This one is when the 'x' is pressed to close the dialog.
//            System.out.println("Account setup wizard was just closed.");
            System.exit(0); //Exit since we haven't finished configuring the profile yet.
        }

        @Override
        public void windowClosed(WindowEvent w) { //This is for when OK is pressed.
//            System.out.println("Profile creator dialog was just closed.");
            loggedInProfileEntry = profileCreatorController.getProfileEntry();
            //Set up the profile's transactions, bills, income, debts here.
            // loggedInProfile = new Profile(profileDatabase.getNumProfiles(), loggedInProfileEntry.getUserName(), acctSetupWizardController.getTransactionsList());
            //acctSetupWizardController.getBillsList(), acctSetupWizardController.getBillsList());
//            loggedInProfile = new Profile(profileDatabase.getNumProfiles() - 1 /*Subtract 1 because profile IDs start at 0.*/, loggedInProfileEntry.getUserName(), acctSetupWizardController.getTransactionsList());
            acctSetupWizardFrame.setVisible(true);
        }
    };
    
    /**
     * When we close the account setup wizard, we open the main window frame.
     */
    private static WindowListener accountSetupWizardClosingListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent w) { //This one is when the 'x' is pressed to close the dialog.
            System.exit(0); //Exit since we haven't finished configuring the profile yet.
//            System.out.println("Account setup wizard was just closed.");
//            mainWindowFrame.setVisible(true);
        }

        @Override
        public void windowClosed(WindowEvent w) {
            //Need this one for when the OK button is pressed.
            //When the account setup wizard is closed, we show the main window frame.
            //The user doesn't need to log in, they were logged in when profile creator dialog was closed.
            System.out.println("Account setup wizard was just closed.");

            loggedInProfile = new Profile(profileDatabase.getNumProfiles() - 1 /*Subtract 1 because profile IDs start at 0.*/, loggedInProfileEntry.getUserName(), accountSetupWizardModel.getTransactionsList());
            
            //Save the profiles, bills, debts, and transactions to flatfiles.
            profileDatabase.saveProfilesToFile();
            accountSetupWizardModel.saveBillsToFile();
            accountSetupWizardModel.saveDebtsToFile();
            accountSetupWizardModel.saveTransactionsToFile();
//            System.out.println("Just created ProfileDB.txt.");
            
            logIntoProfile();
            
            mainWindowFrame.setVisible(true);
        }
    };
    /**
     * When the login dialog is closed, we open the MainWindowFrame.
     */
    private static WindowListener loginDialogClosingListener = new WindowAdapter() {
        //When we close the account setup wizard, we open the main window frame.
        @Override
        public void windowClosing(WindowEvent w) { //This one is when the 'x' is pressed to close the dialog.
            System.exit(0); //User aborted, so exit.
        }

        @Override
        public void windowClosed(WindowEvent w) { //This one for when the login button is pressed, dispose is called.
            System.out.println("Sucessfully logged in.");
            loggedInProfile = loginDialogController.getProfile();
            System.out.println("Logged in profile ID = " + loggedInProfile.getUserID());
            
            logIntoProfile();
        }
    };

    /**
     * Loads the profile's data from flatfiles to be displayed in the tabs of
     * MainWindowFrame.
     */
    public static void logIntoProfile() {
        overviewPanelModel = new OverviewPanelModel(loggedInProfile);
        overviewPanelController = new OverviewPanelController(overviewPanelModel, mainWindowFrame.getOverviewPanel());
//            overviewPanelController.setWelcomeMessage(); //Set welcome message for the current logged in user.
        mainWindowFrame.setVisible(true); //Show the main window frame here.

        bigCalendarModel = new CalendarModel();
        calendarTabController = new CalendarTabController(bigCalendarModel, mainWindowFrame.getCalendarTabPanel());
        
        transactionsModel = new TransactionsModel();
        transactionsModel.loadTransactionsFromFlatFile(new File(System.getProperty("user.dir") + "\\Profiles\\" + loggedInProfile.getUserID() + "\\transactions.txt"));
//        TransactionsTableModel transactionsTableModel = new TransactionsTableModel();
//        mainWindowFrame.getTransactionsTable().setModel(transactionsTableModel);
//        transactionsTableModel.fillTable(transactionsModel);
//        mainWindowFrame.getTransactionsTable().setAutoCreateRowSorter(true);

        transactionsTableController = new TransactionsPanelController(transactionsModel, mainWindowFrame.getTransactionsPanel());
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainWindowFrame.getTransactionsPanel().getTransactionsTable().getColumnModel().getColumn(1).setCellRenderer(rightRenderer);        
        
        //Bills model needed for the overview panel displaying the upcoming bills.
        billsModel = new BillsModel();
        billsModel.loadBillsFromFlatFile(new File(System.getProperty("user.dir") + "\\Profiles\\" + loggedInProfile.getUserID() + "\\bills.txt"));
        
        overviewPanelModel.getCalendarModel().setBillsList(billsModel.getBillsList());
        bigCalendarModel.setBillsList(billsModel.getBillsList());
        mainWindowFrame.getOverviewPanel().setUpcomingBillsLabel(overviewPanelController.generateUpcomingBills());
        
        debtsModel = new DebtsModel();
        debtPanelController = new DebtManagerPanelController(debtsModel, mainWindowFrame.getDebtManagerTabPanel());
        debtsModel.loadDebtsFromFlatFile(new File(System.getProperty("user.dir") + "\\Profiles\\" + loggedInProfile.getUserID() + "\\debts.txt"));
        debtPanelController.addDebtsToPanel();
        
    }

    /**
     * 
     * @return The list of transactions.
     */
    public static List<Transaction> getTransactions() {
        return transactions;
    }
}
