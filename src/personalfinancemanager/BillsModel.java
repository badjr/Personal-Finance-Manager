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
 * The DebtsModel class provides a way for Bills to be stored in a List and
 * retrieved. It also provides a method for loading bills from a flat file.
 */
public class BillsModel {

    private List<Bill> bills;
    
    public void loadBillsFromFlatFile(File f) {
        bills = new ArrayList<Bill>();
        try {
            Scanner s = new Scanner(f);
            String lineCol[];
            while (s.hasNextLine()) {
                lineCol = s.nextLine().split(",");
                String billName = lineCol[0];
                String amount = lineCol[1];
                String dueDate = lineCol[2];
                bills.add(new Bill(billName, new BigDecimal(amount), Integer.parseInt(dueDate)));
            }
            s.close(); //close scanner when done using.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(DebtsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List getBillsList() {
        return bills;
    }
}
