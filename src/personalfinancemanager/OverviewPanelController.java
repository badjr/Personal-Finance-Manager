package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joda.time.DateTime;

/**
 *
 * @author Geek Squad
 */
/**
 * This class will control all the actions of the overview tab.
 */
public class OverviewPanelController {

    private OverviewPanelModel overviewPanelModel;
    private OverviewPanel overviewPanel;

    public OverviewPanelController(OverviewPanelModel overviewPanelModel, OverviewPanel overviewPanel) {
        this.overviewPanelModel = overviewPanelModel;
        this.overviewPanel = overviewPanel;

        overviewPanel.setMonthAndYearLabel(overviewPanelModel.getMonthAndYearFromCalendarModel());
        overviewPanel.setWelcomeLoggedInUserText(overviewPanelModel.getLoggedInUserName());
        //Fill the calendar for the calendar on the overview tab for the current month.
        overviewPanel.setNumbersForCalendar(overviewPanelModel.getCalendarModel());
        
        //Add listeners
        overviewPanel.addLeftCalendarButtonListener(new LeftCalendarButtonListener());
        overviewPanel.addRightCalendarButtonListener(new RightCalendarButtonListener());

    }
    
    /**
     * This method generates bills associated with a profile and returns a
     * String of the upcoming bills to be displayed on the Overview screen.
     * Bills are due on a fixed day of every month, and if the current day is
     * past the monthly due day of the month for the bill, the date for next
     * month's bill will be shown.
     * @return The String of the bills that are coming up.
     */
    public String generateUpcomingBills() {
        String upcomingBills = "<html>"; //Use html so we can get new lines in the budgets panel.
        Bill currentBill;
        DateTime todaysDate = new DateTime(); //Joda-Time library for date and time is used here. Need to download the library.
        DateTime dueDate;
        DateFormat dueDateFormatted;
        
        //We get the bills from overviewPanelModel's calendarModel's Bill List.
        for (int i = 0; i < overviewPanelModel.getCalendarModel().getBills().size(); i++) {
            currentBill = overviewPanelModel.getCalendarModel().getBills().get(i);
            upcomingBills += currentBill.getName() + " bill of $" + currentBill.getAmount() + " due on ";
            
            //If today's date is before or on the bill's due date, we display
            //the bill still being due for this month.
            if (todaysDate.getDayOfMonth() <= currentBill.getDueDayOfMonth()) {
                dueDateFormatted = new DateFormat(todaysDate.getMonthOfYear(), currentBill.getDueDayOfMonth(), todaysDate.getYear());
                upcomingBills += dueDateFormatted;
            }
            //Else, we display the bill being due for next month.
            else {
                //Add one month to today's date, because we want to display the
                //bill being due next month.
                dueDate = todaysDate.plusMonths(1);
                dueDateFormatted = new DateFormat(dueDate.getMonthOfYear(), currentBill.getDueDayOfMonth(), dueDate.getYear());
                upcomingBills += dueDateFormatted;
            }
            upcomingBills += "<br>"; //Line break for each bill.
        }
        
        if (overviewPanelModel.getCalendarModel().getBills().isEmpty()) {
            upcomingBills += "No bills to show.";
        }
        
        upcomingBills += "</html>"; //Close html tag.
        return upcomingBills;
    }

    private class LeftCalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Set calendar model in overviewPanelModel to previous month.
            overviewPanelModel.getCalendarModel().setToPreviousMonth();
            //Reset the calendar and generate again for the month the CalendarModel is currently on.
            overviewPanel.resetCalendar();
            overviewPanel.setMonthAndYearLabel(overviewPanelModel.getMonthAndYearFromCalendarModel());
            overviewPanel.setNumbersForCalendar(overviewPanelModel.getCalendarModel());
            
            //Set total credits/debits for the month in overviewPanelModel
            //and set the labels on overviewPanel.
            overviewPanelModel.setCreditsForMonth(overviewPanelModel.getCalendarModel());
            overviewPanel.setCreditsForMonthLabel(overviewPanelModel.getCreditsForMonth());
            overviewPanelModel.setDebitsForMonth(overviewPanelModel.getCalendarModel());
            overviewPanel.setDebitsForMonthLabel(overviewPanelModel.getDebitsForMonth());
            
        }
    }

    private class RightCalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Set calendar model in overviewPanelModel to previous month.
            overviewPanelModel.getCalendarModel().setToNextMonth();
            //Reset the calendar and generate again for the month the CalendarModel is currently on.
            overviewPanel.resetCalendar();
            overviewPanel.setMonthAndYearLabel(overviewPanelModel.getMonthAndYearFromCalendarModel());
            overviewPanel.setNumbersForCalendar(overviewPanelModel.getCalendarModel());
            
            //Set total credits/debits for the month in overviewPanelModel
            //and set the labels on overviewPanel.
            overviewPanelModel.setCreditsForMonth(overviewPanelModel.getCalendarModel());
            overviewPanel.setCreditsForMonthLabel(overviewPanelModel.getCreditsForMonth());
            overviewPanelModel.setDebitsForMonth(overviewPanelModel.getCalendarModel());
            overviewPanel.setDebitsForMonthLabel(overviewPanelModel.getDebitsForMonth());            
            
        }
    }
}
