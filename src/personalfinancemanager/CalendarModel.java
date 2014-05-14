package personalfinancemanager;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Geek Squad
 */
/**
 * The CalendarModel class is our custom class holding the month, day, and year
 * of a date. Month goes from 0 to 11.
 */
public class CalendarModel {

    private Calendar todaysDate;
    private int month; //Goes from 0 - 11.
    private int dayOfMonth;
    private int year;
    private static final String monthStrings[] = {"January", "February", "March",
                                                  "April", "May", "June", "July",
                                                  "August", "September", "October",
                                                  "November", "December"};
    private List<Bill> bills;

    public CalendarModel() {
        todaysDate = Calendar.getInstance();
        month = todaysDate.get(Calendar.MONTH);
        dayOfMonth = todaysDate.get(Calendar.DAY_OF_MONTH);
        year = todaysDate.get(Calendar.YEAR);
    }
    
    public CalendarModel(Calendar todaysDate) {
        this.todaysDate = todaysDate;
        month = todaysDate.get(Calendar.MONTH);
        dayOfMonth = todaysDate.get(Calendar.DAY_OF_MONTH);
        year = todaysDate.get(Calendar.YEAR);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     *
     * @return The month number of the year, from 0 to 11. January = 0,
     * December = 11.
     */
    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    /**
     * 
     * @return The month title, as a string.
     */
    public String getMonthTitle() {
        return monthStrings[month];
    }

    public Calendar getCalendarInstance() {
        return todaysDate;
    }

    /**
     *
     * @param q Day of the month
     * @param m The month, 3 = March, 4 = April, 5 = May, ..., 13 = January, 14
     * = February
     * @param K Year of the century (year mod 100)
     * @param J The century (year / 100)
     * @return The day of week of the entered date. 0 = Saturday, 1 = Sunday,
     * etc.
     */
    public int zeller(int q, int m, int K, int J) {
        //h = (q + 26(m + 1)/10 + Y + Y / 4 + J / 4 + 5J) mod 7
        //h = (q + 13(m + 1)/5 + Y + Y / 4 + J / 4 + 5J) mod 7
        return (q + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
    }
    
    /**
     *
     * @return The days in the month of the current month stored in the calendar
     * model.
     */
    public int getDaysInMonth() {
        int daysInMonth;
        //Add 1 to the month, because months are stored from 0 - 11.
        switch (month + 1) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            default:
                daysInMonth = 31;
        }
        return daysInMonth;
    }
    
    public List<Bill> getBills() {
        return bills;
    }

    public void setToPreviousMonth() {
        todaysDate.set(year, month - 1, dayOfMonth);
        
        month = todaysDate.get(Calendar.MONTH);
        dayOfMonth = todaysDate.get(Calendar.DAY_OF_MONTH);
        year = todaysDate.get(Calendar.YEAR);
        
    }
    
    public void setToNextMonth() {
        todaysDate.set(year, month + 1, dayOfMonth);
        
        month = todaysDate.get(Calendar.MONTH);
        dayOfMonth = todaysDate.get(Calendar.DAY_OF_MONTH);
        year = todaysDate.get(Calendar.YEAR);
        
    }
    
    public void setBillsList(List bills) {
        this.bills = bills;
    }

    /**
     * @param year The year to test if is a leap year.
     * @return True if the year is a leap year, false otherwise.
     */
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
