
package dateutilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
     * Singleton utility class to simplify managing and using dates and times.
     * 
     * @author Chathuri Perera, cperera@wctc.edu
     * @version 1.00
     */
public class DateUtilities {

     private static DateUtilities instance;
     
    /**
     * Singleton support
     *
     * @return one and only one global instance
     */
    public static DateUtilities getInstance() {
        if (instance == null) {
            instance = new DateUtilities();
        }

        return instance;
    }
     
    /**
     *Get unformatted <code>Current Date</code> and time
     * @return the current date and time
     */
    public LocalDateTime getCurrentDateAndTime(){
        LocalDateTime date = LocalDateTime.now();
         return date;
    }
    
    
    /**
     *Get only unformatted <code>Current Date</code>
     * @return the current date 
     */
    public LocalDate getCurrentDate(){
        LocalDate date = LocalDate.now();
         return date;
    }
     
    /**
     * Format a <code>Date</code> to display the order - month, date, year, hours,minutes, and seconds
     *
     * @param date - a <code>Date</code> object
     * @return a string date formatted according to the default date pattern
     * @throws IllegalArgumentException if date is null
     */
     public String getCurrentDateAndTime(LocalDateTime date)throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Date argument cannot be null");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String stringDate = date.format(format);
        return stringDate;
     }
     
    /**
     * Format a <code>Date</code> to display the order - month, date, and year
     *
     * @param date - a <code>Date</code> object
     * @return a string date formatted according to the given date pattern
     * @throws IllegalArgumentException if date is null
     */
     public String getCurrentDate(LocalDateTime date)throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Date argument cannot be null");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MMM d");
        String stringDate = date.format(format);
        return stringDate;
     }
     
     

     
     
}
