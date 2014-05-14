package personalfinancemanager;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Geek Squad
 */
/**
 * The TransactionsTableModel is our custom table that extends
 * AbstractTableModel. It will be used to render the transactions in the
 * transactions table. It uses a TransactionsModel object, which is a class
 * created by us that holds transactions in a List.
 */
public class TransactionsTableModel extends AbstractTableModel {

    String[] columnNames = {"Date",
                            "Transaction ID",
                            "Category",
                            "Description",
                            "Amount"};
    
    Object[][] data;
    /**
     * This method places the transactions into the TransactionsTableModel's
     * Object[][] data array. The fillTable method will take a TransactionsModel
     * as a parameter, which is a class created by us that holds the
     * transactions in a List and provides a way for us to get that List.
     * @param transactionsModel Our custom class serving as the model for transactions.
     */
    public void fillTable(TransactionsModel transactionsModel) {
        List<Transaction> trans = transactionsModel.getTransactionsList();
        if (trans.isEmpty()) {
            data = new Object[1][5];
            return;
        }
        data = new Object[trans.size()][5];
        for (int i = 0; i < trans.size(); i++) {
            data[i][0] = trans.get(i).getDate();
            data[i][1] = trans.get(i).getTransactionID();
            data[i][2] = trans.get(i).getCategory();
            data[i][3] = trans.get(i).getDescription();
            data[i][4] = trans.get(i).getAmount();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        }
        else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
