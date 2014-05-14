package personalfinancemanager;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Geek Squad
 */

/**
 * The DebtManagerPanelController controls the adding of debts to the debt
 * manager tab.
 */
public class DebtManagerPanelController {

    private DebtsModel debtsModel;
    private JPanel debtManagerTabPanel;
    private List<Debt> debts;

    public DebtManagerPanelController(DebtsModel debtsModel, JPanel debtManagerTabPanel) {
        this.debtsModel = debtsModel;
        this.debtManagerTabPanel = debtManagerTabPanel;
    }

    public void addDebtsToPanel() {
        DebtPanel debtPanel;
        debts = debtsModel.getDebtsList();
        for (int i = 0; i < debts.size(); i++) {
//            System.out.println(debts.get(i));
            debtPanel = new DebtPanel(debts.get(i));
//            debtPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, debts.get(i).getDebtName(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
////            debtPanel.setName("Debt Name"); // NOI18N
//            debtPanel.setName(debts.get(i).getDebtName());
            debtPanel.setDebtTitleBorder(debts.get(i).getDebtName());
            debtManagerTabPanel.setLayout(new javax.swing.BoxLayout(debtManagerTabPanel, javax.swing.BoxLayout.Y_AXIS));
            debtManagerTabPanel.add(debtPanel); 
        }
        if (debts.isEmpty()) {
            debtManagerTabPanel.setLayout(new javax.swing.BoxLayout(debtManagerTabPanel, javax.swing.BoxLayout.Y_AXIS));
            debtManagerTabPanel.add(new JLabel("No debts to show."));
        }
    }
}
