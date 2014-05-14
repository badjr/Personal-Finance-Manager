package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */
/**
 * The TransactionsPanelController class controls the transactions panel.
 */
public class TransactionsPanelController {

    private TransactionsModel transactionsModel;
//    private JTable transactionsTable;
    private TransactionsPanel transactionsPanel;
//    private List<Transaction> transactions;
    
    private AddTransactionDialog addExpenseDialog;
    private TransactionsTableModel transactionsTableModel;

    public TransactionsPanelController(TransactionsModel transactionsModel, TransactionsPanel transactionsPanel) {
        this.transactionsModel = transactionsModel;
//        this.transactionsTable = transactionsTable;
        this.transactionsPanel = transactionsPanel;
//        transactions = transactionsModel.getTransactionsList();
        
        //Add action listeners
        transactionsPanel.addAddTransactionButtonListener(new AddTransactionActionListener());
        transactionsPanel.addRemoveTransactionButtonListener(new RemoveTransactionActionListener());
        
        //Fill the table initially based on transactions from the table model
        transactionsTableModel = new TransactionsTableModel();
        transactionsPanel.getTransactionsTable().setModel(transactionsTableModel);
        transactionsTableModel.fillTable(transactionsModel);
        transactionsPanel.getTransactionsTable().setAutoCreateRowSorter(true);

    }

    private class RemoveTransactionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            transactionsTableModel
            transactionsModel.removeTransactionFromList(transactionsPanel.getTransactionsTable().getSelectedRow());
            transactionsTableModel.fillTable(transactionsModel);
            transactionsPanel.getTransactionsTable().repaint();
        }
    }

    private class AddTransactionDialogWindowListener implements WindowListener {

        public AddTransactionDialogWindowListener() {
        }

        @Override
        public void windowOpened(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowClosing(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
//            System.out.println("x button pressed?");
        }

        @Override
        public void windowClosed(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
//            System.out.println("add button pressed?");
            System.out.println("date = " + addExpenseDialog.getDateFromField());
            System.out.println("category = " + addExpenseDialog.getCategoryFromComboBox());
            System.out.println("description = " + addExpenseDialog.getDescriptionFromField());
            System.out.println("amount = " + addExpenseDialog.getAmountFromField());
            
            transactionsModel.addTransactionToList(new 
                    Transaction(transactionsModel.getTransactionsList().size(),
                    new DateFormat().stringToDateFormat(addExpenseDialog.getDateFromField()),
                    addExpenseDialog.getCategoryFromComboBox(),
                    addExpenseDialog.getDescriptionFromField(),
                    new BigDecimal(addExpenseDialog.getAmountFromField())));
//            System.out.println("added " + transactionsModel.getTransactionsList().get(transactionsModel.getTransactionsList().size() - 1));
            transactionsTableModel.fillTable(transactionsModel);
            transactionsPanel.getTransactionsTable().repaint();
            transactionsModel.saveTransactionsToFile();
        }

        @Override
        public void windowIconified(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowActivated(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    private class AddTransactionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addExpenseDialog = new AddTransactionDialog();
            addExpenseDialog.addWindowListener(new AddTransactionDialogWindowListener());
            addExpenseDialog.setVisible(true);
        }
        
    }
}
