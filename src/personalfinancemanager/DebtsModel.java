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
 * The DebtsModel class provides a way for Debts to be stored in a List. It also
 * provides methods for loading debts from a flat file and getting the debts
 * list.
 */
public class DebtsModel {

    public List<Debt> debts;

    /**
     * @pre The file f exists and is accessible.
     * @post The List debts is now populated from the entries parsed from the
     * .csv file, or is initialized to an empty List if there were no debts.
     * @param f The .csv file containing debts to be parsed.
     */
    public void loadDebtsFromFlatFile(File f) {
        debts = new ArrayList<Debt>();
        try {
            Scanner s = new Scanner(f);
            String lineCols[];
            while (s.hasNextLine()) {
                lineCols = s.nextLine().split(",");
                String debtName = lineCols[0];
                String debtType = lineCols[1];
                String totalAmountOfDebt = lineCols[2];
                String amountPaidOff = lineCols[3];
                String interestRate = lineCols[4];
                String monthlyPayment = lineCols[5];
                debts.add(new Debt(debtName, debtType, new BigDecimal(totalAmountOfDebt), new BigDecimal(amountPaidOff), new BigDecimal(interestRate), new BigDecimal(monthlyPayment)));
            }
            s.close(); //close scanner when done using.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(DebtsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List getDebtsList() {
        return debts;
    }
}
