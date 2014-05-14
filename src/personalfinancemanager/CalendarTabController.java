package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Geek Squad
 */
/**
 * 
 * The CalendarTabController controls the generating of the calendar in the
 * calendar tab, and updates the CalendarModel and the CalendarTable using
 * listeners whenever the previous or next buttons are pressed.
 */
public class CalendarTabController {

    private CalendarModel calendarModel;
    private CalendarTabPanel calendarTabPanel;

    public CalendarTabController(CalendarModel calendarModel, CalendarTabPanel calendarTabPanel) {
        this.calendarModel = calendarModel;
        this.calendarTabPanel = calendarTabPanel;
        
        //Fill the calendar for the calendar on the calendar tab for the current
        //month initially.
        calendarTabPanel.setMonthAndYearLabel(calendarModel.getMonthTitle() + ", " + calendarModel.getYear());
        calendarTabPanel.setNumbersForCalendar(calendarModel);

        //Add action listeners for left and right calendar buttons.
        calendarTabPanel.addBigCalendarPreviousButtonActionListener(new BigCalendarPreviousbuttonListener());
        calendarTabPanel.addBigCalendarNextButtonActionListener(new BigCalendarNextbuttonListener());

    }

    private class BigCalendarPreviousbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Set calendar model in overviewPanelModel to previous month.
            calendarModel.setToPreviousMonth();
            //Reset the calendar and generate again for the month the CalendarModel is currently on.
            calendarTabPanel.resetCalendar();
            calendarTabPanel.setMonthAndYearLabel(calendarModel.getMonthTitle() + ", " + calendarModel.getYear());
            calendarTabPanel.setNumbersForCalendar(calendarModel);
        }
    }

    private class BigCalendarNextbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Set calendar model in overviewPanelModel to previous month.
            calendarModel.setToNextMonth();
            //Reset the calendar and generate again for the month the CalendarModel is currently on.
            calendarTabPanel.resetCalendar();
            calendarTabPanel.setMonthAndYearLabel(calendarModel.getMonthTitle() + ", " + calendarModel.getYear());
            calendarTabPanel.setNumbersForCalendar(calendarModel);
        }
    }
}
