package personalfinancemanager;

import java.math.BigDecimal;

/**
 *
 * @author Geek Squad
 */

/**
 * A Bill is a monthly payment due that has a name, amount, and due day of a
 * month.
 */
public class Bill {

    private String name;
    private BigDecimal amount;
    private int dueDayOfMonth;

    public Bill(String name, BigDecimal amount, int dueDate) {

        //Initialize the fields here.
        this.name = name;
        this.amount = amount;
        this.dueDayOfMonth = dueDate;
//        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    
    public int getDueDayOfMonth() {
        return dueDayOfMonth;
    }

    @Override
    public String toString() {
        return name + "," + amount + "," + dueDayOfMonth/* + "," + frequency*/;
    }
}
