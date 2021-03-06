package personalfinancemanager;

import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */

/**
 * A panel for displaying a debt, containing a titled border showing the debt
 * name, labels for the debt type, amount, amount paid off, interest rate,
 * monthly payment, and estimated completion.
 * This JPanel class allows for dynamic adding to the Debt Manager tab depending
 * on how many debts the user has.
 */
public class DebtPanel extends javax.swing.JPanel {

    /**
     * Creates new form DebtPanel
     */
    public DebtPanel(Debt debt) {
        initComponents();

        debtPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Debt Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
        debtPanel.setName(debt.getDebtName()); // NOI18N

        debtTypeLabel.setText("Type: " + debt.getDebtType());
        debtAmountLabel.setText("Amount: $" + debt.getTotalAmountOfDebt());
        amountPaidOffLabel.setText("Amount paid off: $" + debt.getAmountPaidOff().toString());
        
        BigDecimal percentagePaidOff = (debt.getAmountPaidOff()).divide(debt.getTotalAmountOfDebt()); //This will mess up if there's a non-terminating decimal.
        
        amountPaidOffProgressBar.setValue((int) Double.parseDouble((percentagePaidOff.multiply(new BigDecimal(100))).toString()));
        amountPaidOffProgressBar.setString(percentagePaidOff.multiply(new BigDecimal(100)) + "% Paid Off");
        amountPaidOffProgressBar.setStringPainted(true);

        interestRateLabel.setText("Interest rate: " + debt.getInterestrate().toString() + "%");
        monthlyPaymentLabel.setText("Monthly payment: $" + debt.getMonthlyPayment().toString());
        estimatedCompletionLabel.setText("Est. Completion: " + "Unknown");
    }

    public String getDebtTitleFromPanel() {
        return debtPanel.getName();
    }

    public String getDebtTypeFromLabel() {
        return debtTypeLabel.getText();
    }

    public String getDebtAmountFromLabel() {
        return debtAmountLabel.getText();
    }

    public String getInterestRateFromLabel() {
        return interestRateLabel.getText();
    }

    public String getMonthlyPaymentFromLabel() {
        return monthlyPaymentLabel.getText();
    }

    public void setDebtTitleBorder(String debtName) {
        debtPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, debtName, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
        debtPanel.setName(debtName); // NOI18N
    }

    public void setDebtTypeLabel(String debtType) {
        debtTypeLabel.setText("Type: " + debtType);
    }

    public void setDebtAmountLabel(String debtAmount) {
        debtAmountLabel.setText("Amount: $" + debtAmount);
    }

    public void setInterestRateLabel(String interestRate) {
        interestRateLabel.setText("Interest rate: " + interestRate + "%");
    }

    public void setMonthlyPaymentLabel(String monthlyPayment) {
        monthlyPaymentLabel.setText("Monthly payment: $" + monthlyPayment);
    }

    public void setEstCompletionLabel(String estimatedCompletion) {
        estimatedCompletionLabel.setText("Est. Completion: " + estimatedCompletion);
    }

    public void setAmountPaidOffProgressBar(int percentagePaidOff) {
        amountPaidOffProgressBar.setValue(percentagePaidOff);
        amountPaidOffProgressBar.setString(percentagePaidOff + "% Paid Off");
        amountPaidOffProgressBar.setStringPainted(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        debtPanel = new javax.swing.JPanel();
        debtTypeLabel = new javax.swing.JLabel();
        debtAmountLabel = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        amountPaidOffProgressBar = new javax.swing.JProgressBar();
        monthlyPaymentLabel = new javax.swing.JLabel();
        estimatedCompletionLabel = new javax.swing.JLabel();
        amountPaidOffLabel = new javax.swing.JLabel();

        debtPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Debt Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
        debtPanel.setName("Debt Name"); // NOI18N

        debtTypeLabel.setText("Type: Credit Card");

        debtAmountLabel.setText("Amount: $750");

        interestRateLabel.setText("Interest Rate: 4.2%");

        amountPaidOffProgressBar.setString("0% Paid Off");
        amountPaidOffProgressBar.setStringPainted(true);

        monthlyPaymentLabel.setText("Monthly Payment: $45");

        estimatedCompletionLabel.setText("Est. Completion: Feb 20th, 2014");

        amountPaidOffLabel.setText("Amount paid off: $45");

        javax.swing.GroupLayout debtPanelLayout = new javax.swing.GroupLayout(debtPanel);
        debtPanel.setLayout(debtPanelLayout);
        debtPanelLayout.setHorizontalGroup(
            debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(debtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountPaidOffProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debtPanelLayout.createSequentialGroup()
                        .addGroup(debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(interestRateLabel)
                            .addComponent(amountPaidOffLabel)
                            .addComponent(debtTypeLabel)
                            .addComponent(debtAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addGroup(debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(monthlyPaymentLabel)
                            .addComponent(estimatedCompletionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        debtPanelLayout.setVerticalGroup(
            debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(debtPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debtPanelLayout.createSequentialGroup()
                        .addComponent(debtTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debtAmountLabel))
                    .addComponent(monthlyPaymentLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(debtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(debtPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimatedCompletionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debtPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountPaidOffLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interestRateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(amountPaidOffProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(debtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(debtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        debtPanel.getAccessibleContext().setAccessibleName("Debt Panel");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountPaidOffLabel;
    private javax.swing.JProgressBar amountPaidOffProgressBar;
    private javax.swing.JLabel debtAmountLabel;
    private javax.swing.JPanel debtPanel;
    private javax.swing.JLabel debtTypeLabel;
    private javax.swing.JLabel estimatedCompletionLabel;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel monthlyPaymentLabel;
    // End of variables declaration//GEN-END:variables
}
