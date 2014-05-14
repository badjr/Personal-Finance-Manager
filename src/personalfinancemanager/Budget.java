package personalfinancemanager;

import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */
/**
 * The Budget is the amount of money available for spending per month for a
 * certain expense category. A Budget contains a budget name, a monthly budget 
 * limit, and the amount spent so far for the month.
 */
public class Budget {

    private String budgetName;
    private BigDecimal budgetLimit;
    private BigDecimal budgetSpentSoFar;

    public Budget(String budgetName, BigDecimal budgetLimit, BigDecimal budgetSpentSoFar) {
        this.budgetName = budgetName;
        this.budgetLimit = budgetLimit;
        this.budgetSpentSoFar = budgetSpentSoFar;
    }
    
    public String getBudgetName() {
        return budgetName;
    }

    public BigDecimal getBudgetLimit() {
        return budgetLimit;
    }

    public BigDecimal getBudgetSpentSofar() {
        return budgetSpentSoFar;
    }

    public void setBudgetName(String newBudgetName) {
        budgetName = newBudgetName;
    }

    public void setBudgetLimit(BigDecimal budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    public void setBudgetSpentSoFar(BigDecimal budgetSpentSoFar) {
        this.budgetSpentSoFar = budgetSpentSoFar;
    }
}
