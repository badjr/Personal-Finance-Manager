package personalfinancemanager;

import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Geek Squad
 */
/**
 * 
 * The CalendarTabPanel contains the big calendar table and left and right
 * buttons for adjusting the calendar for the previous or next month.
 */
public class CalendarTabPanel extends javax.swing.JPanel {

    /**
     * Creates new form CalendarTabPanel
     */
    public CalendarTabPanel() {
        initComponents();
    }

    /**
     * Sets the calender on the calendar tab to whatever calendarModel's current
     * month is set to.
     *
     * @param calendarModel The calendar model, a custom class which holds a
     * date and allows us to get the max days in the month.
     */
    public void setNumbersForCalendar(CalendarModel calendarModel) {
        DefaultTableCellRenderer textAlignmentRenderer = new DefaultTableCellRenderer(); //Renderer for the text in table cells.
        textAlignmentRenderer.setHorizontalAlignment(JLabel.LEFT); //Horizontal align left.
        textAlignmentRenderer.setVerticalAlignment(JLabel.TOP); //Vertical align top.
        for (int i = 0; i < bigCalendarTable.getColumnCount(); i++) {
            bigCalendarTable.getColumnModel().getColumn(i).setCellRenderer(textAlignmentRenderer); //Set the alignment to top left for the ith column.   
        }

        //Add 1, because the zeller function calculates with months
        //being from 3 - 14.
        int month = calendarModel.getMonth() + 1;
        int year = calendarModel.getYear();

        //If month is 1 or 2, add 12 because the Zeller function
        //only computes months from 3 - 14.
        if (month == 1 || month == 2) {
            month = month + 12;
            //Subtract from the year, because if January or February,
            //we use the 13th or 14th month of the previous year.
            year--;
        }

        //We use Zeller's congruence to calculate the day of the week 0 - 6,
        //which is used to calculate the correct column on the 0th row to start
        //on in the calendar table. The result is stored in firstDayMonthIndex.
        int firstDayInMonthColIndex = calendarModel.zeller(1, month, year % 100, year / 100);

        //Filling in the numbers before the 1st from the previous month.
        Calendar prevMonthCalendar = Calendar.getInstance();
        //Subtract 2 from month for prevMonthCalendar, one because we store the
        //months in the calendar model from 0 - 11, one more to go back to the
        //previous month.
        prevMonthCalendar.set(year, month - 2, 1);
        int daysInPrevMonth = new CalendarModel(prevMonthCalendar).getDaysInMonth();
//        System.out.println("days in month for" + calendarModel.getMonthAndYearForCalendar() + " = " + daysInPrevMonth);

        //Calculating the column index of the previous month's last day.
        //Subtract one because Saturday is indexed as 0 from Zeller's function,
        //and Sunday is 1, Monday is 2, etc., but we want to make the index
        //based on 0 starting with Sunday.
        //Subtract another one because we want the previous column from the
        //first day of the current month.
        int prevMonthLastDayColIdx = firstDayInMonthColIndex - 2;
        //If prevMonthLastDayColIdx happens to be 0 or 1, we will have a
        //negative column index, so add 7 to push it to the correct positive
        //column index.
        if (prevMonthLastDayColIdx < 0) {
            prevMonthLastDayColIdx += 7;
        }
        //This is where the numbers from the previous month are filled.
        for (int i = prevMonthLastDayColIdx; i >= 0; i--) {
            bigCalendarTable.getModel().setValueAt("<html><font color=\"gray\">" + daysInPrevMonth + "</font></html>", 0, i);
            daysInPrevMonth--;
        }

        //Get the total days in the month for the current month we want to
        //display.
        int daysInMonth = calendarModel.getDaysInMonth();
        //This is where the numbers on the calendar are generated. i is the row
        //index, j is the column index.
        int dayOfMonth = 1;
        int i, j = 0;
        for (i = 0; dayOfMonth <= daysInMonth; i++) {
            //The ternary operator sets j to firstDayMonthIndex - 1 only if
            //i = 0, (because columns in the table use 0-based indexing). 
            //This is so the 1st day of the month can be placed in the correct
            //column for the month and year that the calendar model is
            //currently on. Otherwise, j is set to 0 because for subsequent rows
            //of the calendar, we can start printing the days of the month
            //starting from the 0th column.
            for (j = ((i == 0) ? firstDayInMonthColIndex - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                //The Zeller function represents 0 as Saturday, so if
                //firstDayMonthIndex happened to be 0, j would be calculated as
                //-1, so we add 7 so it will use the correct column number for
                //Saturday, which is 6.
                if (j == -1) {
                    j += 7;
                }

                //If the 1st of the month happens to be on a Sunday, increment i
                //so we start the month on the second row and put the previous
                //month's days on the first row.
                if (i == 0 && j == 0) {
                    i++;
                }

                bigCalendarTable.getModel().setValueAt(dayOfMonth, i, j); //Set the value at row i, column j
                dayOfMonth++;
            }
        }

        //Filling the rest of the calendar after the last day of the current
        //month in gray.
        //Decrement i by 1, because we want to began filling the next month's
        //dates starting on the same row where the current month's dates left
        //off.
        i--;
        dayOfMonth = 1;
        for (; i < 6; i++) {
            for (; j < 7; j++) {
                bigCalendarTable.getModel().setValueAt("<html><font color=\"gray\">" + dayOfMonth + "</font></html>", i, j);
                dayOfMonth++;
            }
            j = 0;
        }
    }

    /**
     * Clears all the dates in the calendar table.
     */
    public void resetCalendar() {
        for (int i = 0; i < bigCalendarTable.getRowCount(); i++) {
            for (int j = 0; j < bigCalendarTable.getColumnCount(); j++) {
                bigCalendarTable.getModel().setValueAt("", i, j);
            }
        }
    }

    public void addBigCalendarPreviousButtonActionListener(ActionListener al) {
        bigCalendarPreviousMonthButton.addActionListener(al);
    }

    public void addBigCalendarNextButtonActionListener(ActionListener al) {
        bigCalendarNextMonthButton.addActionListener(al);
    }

    public void setMonthAndYearLabel(String monthAndYear) {
        bigCalendarMonthAndYearLabel.setText(monthAndYear);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarTabPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        bigCalendarPreviousMonthButton = new javax.swing.JButton();
        bigCalendarMonthAndYearLabel = new javax.swing.JLabel();
        bigCalendarNextMonthButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bigCalendarTable = new javax.swing.JTable();

        calendarTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar2.setRollover(true);

        jButton5.setText("Add Event");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton5);

        jButton7.setText("Customize Display");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton7);

        jButton8.setText("Monthly/Weekly Overview");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton8);

        calendarTabPanel.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 732, 35));

        bigCalendarPreviousMonthButton.setText("<<");
        calendarTabPanel.add(bigCalendarPreviousMonthButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, -1, -1));

        bigCalendarMonthAndYearLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        bigCalendarMonthAndYearLabel.setText("MonthName, Year");
        calendarTabPanel.add(bigCalendarMonthAndYearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 52, -1, -1));

        bigCalendarNextMonthButton.setText(">>");
        calendarTabPanel.add(bigCalendarNextMonthButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 56, -1, -1));

        bigCalendarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bigCalendarTable.setColumnSelectionAllowed(true);
        bigCalendarTable.setGridColor(new java.awt.Color(102, 102, 102));
        bigCalendarTable.setRequestFocusEnabled(false);
        bigCalendarTable.setRowHeight(75);
        bigCalendarTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bigCalendarTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(bigCalendarTable);

        calendarTabPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 732, 477));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bigCalendarMonthAndYearLabel;
    private javax.swing.JButton bigCalendarNextMonthButton;
    private javax.swing.JButton bigCalendarPreviousMonthButton;
    private javax.swing.JTable bigCalendarTable;
    private javax.swing.JPanel calendarTabPanel;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
