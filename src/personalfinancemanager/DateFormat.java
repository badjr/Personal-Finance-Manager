package personalfinancemanager;

import java.util.Scanner;

/**
 *
 * @author Geek Squad
 */
/**
 * A DateFormat is an object holding the month, day, and year of a date, and is
 * used to format a date as a m/d/yyyy String.
 */
public class DateFormat {
    //TODO use comparater interface to make dates comparable.

    private int month;
    private int day;
    private int year;

    /**
     * Empty constructor for DateFormat instances that we don't want to
     * initialize immediately.
     */
    public DateFormat() {
    }

    /**
     * This constructor takes ints month, day, and year as parameters.
     *
     * @param month Month from 1 - 12
     * @param day Day from 1 - 31
     * @param year Any year
     */
    public DateFormat(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * Takes a string, in m/d/yyyy format, and constructs a new DateFormat
     * object based on the date parsed from the string.
     *
     * @pre This DateFormat's fields are initially null.
     * @post This DateFormat's fields are now set based on the values parsed
     * from the date string.
     * @param dateString A date string, in the format of m/d/yyyy that will be
     * used to construct a DateFormat object.
     * @return The DateFormat corresponding to the parameter dateString.
     */
    public DateFormat stringToDateFormat(String dateString) {
        Scanner s = new Scanner(dateString).useDelimiter("/");
        month = s.nextInt();
        day = s.nextInt();
        year = s.nextInt();
        s.close(); //Close scanner when done using.
        return this;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    /**
     *
     * @return The date, in m/d/yyyy format as a string.
     */
    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }
}
