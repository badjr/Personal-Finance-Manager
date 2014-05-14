package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.DefaultListModel;

/**
 *
 * @author Geek Squad
 */
/**
 * The AccountSetupWizardController controls the AccountSetupWizard JFrame.
 */
public class AccountSetupWizardController {

    private AccountSetupWizard accountSetupWizard;
    private AccountSetupWizardModel accountSetupWizardModel;

    public AccountSetupWizardController(AccountSetupWizardModel accountSetupWizardModel, AccountSetupWizard accountSetupWizard) {
        this.accountSetupWizard = accountSetupWizard;
        this.accountSetupWizardModel = accountSetupWizardModel;
        accountSetupWizard.addOkButtonListener(new OkButtonActionListener());
        accountSetupWizard.addBrowseButtonListener(new BrowseButtonListener());


        accountSetupWizard.addAddBillButtonListener(new AddBillButtonListener());
        accountSetupWizard.addAddDebtButtonListener(new AddDebtButtonListener());
    }

    /**
     * When the add bill button is pressed, this will add the bill to the JList
     * for the bills.
     */
    private class AddBillButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("You just pressed the add bill button.");
            //Add the bill to the List of bills, which is contained in
            //accountSetupWizardModel.
            String billName = accountSetupWizard.getBillNameFromField();
            BigDecimal amount = new BigDecimal(accountSetupWizard.getBillAmountFromField());
            int dueDate = accountSetupWizard.getDueDateFromComboBox();
            accountSetupWizardModel.addBillToList(new Bill(billName, amount, dueDate));

            //Make a DefaultListModel that will be used by the JList.
            DefaultListModel billsListModel = new DefaultListModel();
            //Add all the whole List of bills to the billsListModel.
            for (int i = 0; i < accountSetupWizardModel.getBillsList().size(); i++) {
                billsListModel.addElement(accountSetupWizardModel.getBillsList().get(i).toString());
            }
            //Update the JList to show the bill just added.
            accountSetupWizard.setBillsList(billsListModel);
        }
    }

    /**
     * When the "Add Debt" button is pressed, it will show in the JList beside
     * it.
     */
    private class AddDebtButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("You just pressed the add debt button.");
            //Add the bill to the List of bills, which is contained in
            //accountSetupWizardModel.
            String debtName = accountSetupWizard.getDebtNameFromField();
            String debtType = accountSetupWizard.getDebtTypeFromField();
            BigDecimal totalAmountofDebt = new BigDecimal(accountSetupWizard.getTotalAmountOfDebtFromField());
            BigDecimal totalAmountPaidOff = new BigDecimal(accountSetupWizard.getAmountDebtPaidOffFromField());
            BigDecimal interestRate = new BigDecimal(accountSetupWizard.getInterestRateFromField());
            BigDecimal monthlyPayment = new BigDecimal(accountSetupWizard.getMonthlyPaymentFromField());
            accountSetupWizardModel.addDebtToList(new Debt(debtName, debtType, totalAmountofDebt, totalAmountPaidOff, interestRate, monthlyPayment));

            //Make a DefaultListModel that will be used by the JList.            
            DefaultListModel debtsListModel = new DefaultListModel();
            for (int i = 0; i < accountSetupWizardModel.getDebtsList().size(); i++) {
                debtsListModel.addElement(accountSetupWizardModel.getDebtsList().get(i).toString());
            }
            //Update the JList to show the debt just added.
            accountSetupWizard.setDebtsList(debtsListModel);
        }
    }

    /**
     * When the browse button is pressed, the file chooser dialog is opened.
     */
    private class BrowseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //File chooser dialog is opened here, and it returns the string of
            //the file chosen.
            String fileChosen = accountSetupWizardModel.browseForFile();
            //Set the label for the file just chosen.
            accountSetupWizard.setFileChosenLabel(fileChosen);
        }
    }

    /**
     * When the ok button is pressed, add the transactions to the account setup
     * wizard model, and dispose it.
     * //TODO: There is a usage of accountSetupWizardModel.getTransactionsList
     * in main. Ideally, want to get rid of the .loadTransactionsFromFile here.
     */
    class OkButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            accountSetupWizardModel.loadTransactionsFromFile(accountSetupWizard.getSelectedBank());
            accountSetupWizard.dispose(); //Close account setup wizard.
        }
    }
}
