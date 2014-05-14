package personalfinancemanager;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Geek Squad
 */
/**
 * This class holds all the data the overview panel will need.
 */
public class OverviewPanelModel {

    private Profile loggedInProfile;
    private CalendarModel calendarModel;
    private List<Transaction> transactions;
    private BigDecimal creditsForMonth;
    private BigDecimal debitsForMonth;
    
    public OverviewPanelModel(Profile loggedInProfile) {
        this.loggedInProfile = loggedInProfile;
        calendarModel = new CalendarModel();
        this.transactions = loggedInProfile.getTransactions();
    }

    public String getLoggedInUserName() {
        return loggedInProfile.getUserName();
    }

    public String getMonthAndYearFromCalendarModel() {
        return calendarModel.getMonthTitle() + ", " + calendarModel.getYear();
    }
    
    public CalendarModel getCalendarModel() {
        return calendarModel;
    }
    
    public BigDecimal getCreditsForMonth() {
        return creditsForMonth;
    }
    public BigDecimal getDebitsForMonth() {
        return debitsForMonth;
    }
    
    /**
     * Sums all the credits for a month.
     * @param calendarModel The CalendarModel holding the current month.
     */
    public void setCreditsForMonth(CalendarModel calendarModel) {
        creditsForMonth = new BigDecimal("0.00");
        //Add 1 to month, because months in CalendarModel are stored from 0 - 11, and transactions store months from 1 - 12.        
        int month = calendarModel.getMonth() + 1;
        Transaction currTransaction;
        for (int i = 0; i < transactions.size(); i++) {
            currTransaction = transactions.get(i);
            if (currTransaction.getDate().getMonth() == month
                    && currTransaction.getAmount().compareTo(new BigDecimal("0.00")) > 0) {
                creditsForMonth = creditsForMonth.add(currTransaction.getAmount());
            }
        }
    }
    /**
     * Sums all the debits for a month.
     * @param calendarModel The CalendarModel holding the current month.
     */
    public void setDebitsForMonth(CalendarModel calendarModel) {
        debitsForMonth = new BigDecimal("0.00");
        //Add 1 to month, because months in CalendarModel are stored from 0 - 11, and transactions store months from 1 - 12.
        int month = calendarModel.getMonth() + 1;
        Transaction currTransaction;
        for (int i = 0; i < transactions.size(); i++) {
            currTransaction = transactions.get(i);
            if (currTransaction.getDate().getMonth() == month
                    && currTransaction.getAmount().compareTo(new BigDecimal("0.00")) < 0) {
                debitsForMonth = debitsForMonth.add(currTransaction.getAmount());
            }
        }
    }
    
}