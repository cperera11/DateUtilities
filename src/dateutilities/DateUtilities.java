package dateutilities;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * This date time utility class is to provide various date and time utility
 * methods using new Java 8 API.
 *
 * @author Chathuri Perera, cperera@wctc.edu
 * @version 1.00
 * @since 1.08
 */
public class DateUtilities {

    /**
     * Get unformatted <code>Current Date</code> and time
     *
     * @return the current date and time
     */
    public LocalDateTime getCurrentDateAndTime() {
        LocalDateTime date = LocalDateTime.now();
        return date;
    }

    /**
     * Get only unformatted <code>Current Date</code>
     *
     * @return the current date
     */
    public LocalDate getCurrentDate() {
        LocalDate date = LocalDate.now();
        return date;
    }

    /**
     * Format current <code>Date</code> to the most common pattern - month,
     * date, year
     *
     * @return the current formatted string date to the pattern month, date,
     * year
     */
    public String formatCurrentDateToPatternMonthDayYear() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
        return (date.format(format));
    }

    /**
     * Format a date and/or time string according to the specified pattern.
     *
     * @param dateString - a <code>String</code> representation of a date and/or
     * time
     * @param pattern - a <code>SimpleDateFormat</code> date/time pattern
     * @return a date and/or time formatted according to the user given pattern
     * @throws IllegalArgumentException if pattern is not recognized
     */
    public String format(String dateString, String pattern)
            throws IllegalArgumentException {

        LocalDate localDate = LocalDate.parse(dateString);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return (localDate.format(format));
    }

    /**
     * Convert a user input string <code>Date</code> to a local date type.
     *
     * @param userDate - a string representation of a date
     * @return the given string day in Local date type
     * @throws IllegalArgumentException if date is null
     */
    public LocalDate convertStringDateToLocalDate(String userDate) throws IllegalArgumentException {
        if (userDate == null) {
            throw new IllegalArgumentException("Date argument cannot be null");
        }
        LocalDate localDate = LocalDate.parse(userDate);
        return localDate;
    }

    /**
     * Increment a user input string <code>Date</code> in any user given number
     * of days, weeks, months, or years by using the parse pattern yyyy-mm-dd.
     * Other than the string date, at least a 0 is required for every integer
     * arguments
     *
     * @param date - a string representation of a date
     * @param days - number of integer days needs to be incremented
     * @param weeks - number of integer weeks needs to be incremented
     * @param months - number of integer months needs to be incremented
     * @param years - number of integer years needs to be incremented
     * @return the incremented string date in Local date type
     * @throws IllegalArgumentException if date or number of days, weeks,
     * months, or years are null
     */
    public LocalDate incrementAGivenDateByGivenNumberOfDaysWeeksMonthsOrYears(String date, int days, int weeks, int months, int years)
            throws IllegalArgumentException {
        if (date == null || days < 0 || weeks < 0 || months < 0 || years < 0) {
            throw new IllegalArgumentException("Date argument cannot be null or the number of days, weeks, months, or years"
                    + " cannot be less than 0");
        }
        LocalDate givenDate = LocalDate.parse(date);
        LocalDate incrementedDate = givenDate.plusDays(days);
        incrementedDate = incrementedDate.plusWeeks(weeks);
        incrementedDate = incrementedDate.plusMonths(months);
        incrementedDate = incrementedDate.plusYears(years);
        return incrementedDate;
    }

    /**
     * Decrement a user input string <code>Date</code> in any user given number
     * of days, weeks, months, or years by using the parse pattern yyyy-mm-dd.
     * Other than the string date, at least a 0 is required for every integer
     * arguments
     *
     * @param date - a string representation of a date
     * @param days - number of integer days needs to be decremented
     * @param weeks - number of integer weeks needs to be decremented
     * @param months - number of integer months needs to be decremented
     * @param years - number of integer years needs to be decremented
     * @return the decremented string date in Local date type
     * @throws IllegalArgumentException if date or number of days, weeks,
     * months, or years are null
     */
    public LocalDate decrementAGivenDateByGivenNumberOfDaysWeeksMonthsOrYears(String date, int days, int weeks, int months, int years)
            throws IllegalArgumentException {
        if (date == null || days < 0 || weeks < 0 || months < 0 || years < 0) {
            throw new IllegalArgumentException("Date argument cannot be null or the number of days, weeks, months, or years"
                    + " cannot be less than 0");
        }
        LocalDate givenDate = LocalDate.parse(date);
        LocalDate decrementedDate = givenDate.minusDays(days);
        decrementedDate = decrementedDate.minusWeeks(weeks);
        decrementedDate = decrementedDate.minusMonths(months);
        decrementedDate = decrementedDate.minusYears(years);
        return decrementedDate;
    }

    /**
     * Increment a user input string <code>Date</code> in any user given number
     * of minutes or hours by using the parse pattern yyyy-mm-dd. Other than the
     * string date, at least a 0 is required for every integer arguments
     *
     * @param date - a string representation of a date
     * @param seconds - number of integer seconds needs to be incremented
     * @param minutes - number of integer minutes needs to be incremented
     * @param hours - number of integer hours needs to be incremented
     * @return the incremented string date in Local date type
     * @throws IllegalArgumentException if date or number of seconds, minutes or
     * hours are null
     */
    public String incrementAGivenDateByGivenNumberOfMinutesOrHours(String date, int seconds, int minutes, int hours)
            throws IllegalArgumentException {
        if (date == null || minutes < 0 || hours < 0) {
            throw new IllegalArgumentException("Date argument cannot be null or the number of minutes or hours"
                    + " cannot be less than 0");
        }
        LocalDateTime givenDate = LocalDateTime.parse(date);
        LocalDateTime incrementedDateTime = givenDate.plusSeconds(seconds);
        incrementedDateTime = incrementedDateTime.plusMinutes(minutes);
        incrementedDateTime = incrementedDateTime.plusHours(hours);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm");
        return incrementedDateTime.format(format);
    }

    /**
     * Decrement a user input string <code>Date</code> in any user given number
     * of minutes or hours by using the parse pattern yyyy-mm-dd. Other than the
     * string date, at least a 0 is required for every integer arguments
     *
     * @param date - a string representation of a date
     * @param seconds - number of integer seconds needs to be decremented
     * @param minutes - number of integer minutes needs to be decremented
     * @param hours - number of integer hours needs to be decremented
     * @return the incremented string date in Local date type
     * @throws IllegalArgumentException if date or number of seconds, minutes or
     * hours are null
     */
    public String decrementAGivenDateByGivenNumberOfMinutesOrHours(String date, int seconds, int minutes, int hours)
            throws IllegalArgumentException {
        if (date == null || minutes < 0 || hours < 0) {
            throw new IllegalArgumentException("Date argument cannot be null or the number of minutes or hours"
                    + " cannot be less than 0");
        }
        LocalDateTime givenDate = LocalDateTime.parse(date);
        LocalDateTime decrementedDateTime = givenDate.minusSeconds(seconds);
        decrementedDateTime = decrementedDateTime.minusMinutes(minutes);
        decrementedDateTime = decrementedDateTime.minusHours(hours);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm");
        return decrementedDateTime.format(format);
    }

    /**
     * Find the difference between two dates in days.
     *
     * @param startDate - a <code>String</code> representation of a date
     * @param endDate - a <code>String</code> representation of a date
     * @return the difference of two days in days
     * @throws IllegalArgumentException if string arguments are null
     */
    public long findDayDiffInDays(String startDate, String endDate) throws IllegalArgumentException {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("startDate and endDate cannot be null");
        }
        LocalDateTime start_Date = LocalDateTime.parse(startDate);
        LocalDateTime end_Date = LocalDateTime.parse(endDate);
        Duration diff = Duration.between(start_Date, end_Date);
        return diff.toDays();
    }

    /**
     * Find the difference between two dates in hours.
     *
     * @param startDate - a <code>String</code> representation of a date
     * @param endDate - a <code>String</code> representation of a date
     * @return the difference of two days in hours
     * @throws IllegalArgumentException if string arguments are null
     */
    public long findDayDiffInhours(String startDate, String endDate) throws IllegalArgumentException {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("startDate and endDate cannot be null");
        }
        LocalDateTime start_Date = LocalDateTime.parse(startDate);
        LocalDateTime end_Date = LocalDateTime.parse(endDate);
        Duration diff = Duration.between(start_Date, end_Date);
        return diff.toHours();
    }

    /**
     * Find the difference between two dates in minutes.
     *
     * @param startDate - a <code>String</code> representation of a date
     * @param endDate - a <code>String</code> representation of a date
     * @return the difference of two days in minutes
     * @throws IllegalArgumentException if string arguments are null
     */
    public long findDayDiffInMinutes(String startDate, String endDate) throws IllegalArgumentException {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("startDate and endDate cannot be null");
        }
        LocalDateTime start_Date = LocalDateTime.parse(startDate);
        LocalDateTime end_Date = LocalDateTime.parse(endDate);
        Duration diff = Duration.between(start_Date, end_Date);
        return diff.toMinutes();
    }

    /**
     * Find the difference between two dates in hours and minutes.
     *
     * @param startDate - a <code>String</code> representation of a date
     * @param endDate - a <code>String</code> representation of a date
     * @return the difference of two days in hours and minutes
     * @throws IllegalArgumentException if string arguments are null
     */
    public String findDayDiffInHoursAndMinutes(String startDate, String endDate) throws IllegalArgumentException {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("startDate and endDate cannot be null");
        }
        LocalDateTime start_Date = LocalDateTime.parse(startDate);
        LocalDateTime end_Date = LocalDateTime.parse(endDate);
        Duration diff = Duration.between(start_Date, end_Date);
        long hrs = diff.toHours();
        long min = diff.toMinutes() % 60;
        return ("Hours: " + hrs + ", Minutes: " + min);

    }

}
