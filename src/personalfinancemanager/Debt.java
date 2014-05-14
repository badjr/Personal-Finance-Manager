package personalfinancemanager;

import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */

/**
 * A Debt is a financial obligation of an amount to be paid in the future. It
 * consists of a name, type, total amount of the debt, amount paid off, interest
 * rate, and monthly payment.
 */
public class Debt {

    //fields
    private String debtName;
    private String debtType;
    private BigDecimal totalAmountOfDebt;
    private BigDecimal amountPaidOff;
    private BigDecimal interestRate;
    private BigDecimal monthlyPayment;

    //Constructor
    public Debt(String debtName, String debtType, BigDecimal totalAmountOfDebt,
                BigDecimal amountPaidOff, BigDecimal interestRate, 
                BigDecimal monthlyPayment) {
        //Initialize the fields here.
        this.debtName = debtName;
        this.debtType = debtType;
        this.totalAmountOfDebt = totalAmountOfDebt;
        this.amountPaidOff = amountPaidOff;
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;


    } 
    
    //Getters
    public String getDebtName() {
        return debtName;
    }
    
    public String getDebtType() {
        return debtType;
    }

    public BigDecimal getTotalAmountOfDebt() {
        return totalAmountOfDebt;
    }

    public BigDecimal getAmountPaidOff() {
        return amountPaidOff;
    }

    public BigDecimal getInterestrate() {
        return interestRate;
    }
    
    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }
    
    //Setters
    public void setAmountPaidOff(BigDecimal amountPaidOff) {
        this.amountPaidOff = amountPaidOff;
    }

    @Override
    public String toString() {
        return debtName + "," + debtType + "," + totalAmountOfDebt + "," + amountPaidOff + "," + interestRate + "," + monthlyPayment;
    }
}
