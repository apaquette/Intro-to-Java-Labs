/**
 * Date class used to store year, month, and day. Year ranges from 1 or higher, 
 * month ranges from 1 to 12, and day ranges from 1 to 31 based on month.
 * @author Alexandre Paquette
 * @version Mar 31, 2022
 */
public class Date {
    private int year; // 1 or higher
    private int month; // 1-12
    private int day; // 1-31 based on month
    
    
    private static final int[] daysPerMonth = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * No-argument constructor that initializes each instance variable to zero
     */
    public Date(){
        this(1,1,1);
    }
    
    /**
     * Single argument constructor with year supplied. Month and day are set to one.
     * @param year Year integer, 1 or greater accepted
     */
    public Date(int year){
        this(year, 1, 1);
    }
    
    /**
     * Double argument constructor with year and month supplied. Day set to one.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     */
    public Date (int year, int month){
        this(year, month, 1);
    }

    /**
     * Constructor with year, month, and day supplied.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     */
    public Date(int year, int month, int day) {
      // check if month in range
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(
            "month (" + month + ") must be 1-12");
      }
      
      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("day (" + day + 
            ") out-of-range for the specified month and year");
      }
      
      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(isLeapYear())) {
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
      }
      
      // check if year in range
      if(year <= 0){
          throw new IllegalArgumentException("year must be greater than zero");
      }
      
      this.month = month;
      this.day = day;
      this.year = year;
   } 
    
    /**
     * Constructor with Date instance supplied
     * @param date Date instance
     */
    public Date(Date date){
        this(date.year, date.month, date.day);
    }
    
    /**
     * Set date method that accepts year, month, and day
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     */
    public void setDate(int year, int month, int day){
        // check if day in range for month
        if (day <= 0 || 
           (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
           throw new IllegalArgumentException("day (" + day + 
              ") out-of-range for the specified month and year");
        }
      
        // check if month in range
        if (month <= 0 || month > 12) {
           throw new IllegalArgumentException(
              "month (" + month + ") must be 1-12");
        }
      
        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(isLeapYear())) {
           throw new IllegalArgumentException("day (" + day +
              ") out-of-range for the specified month and year");
        }
      
      // check if year in range
      if(year <= 0){
          throw new IllegalArgumentException("year must be greater than zero");
      }
      
      this.month = month;
      this.day = day;
      this.year = year;
    }

    /**
     * Set year method
     * @param year Year integer, 1 or greater accepted
     */
    public void setYear(int year) {
        // check if year in range
        if(year <= 0){
            throw new IllegalArgumentException("year must be greater than zero");
        }

        this.year = year;
    }

    /**
     * Set month method
     * @param month Month integer, 1-12 accepted
     */
    public void setMonth(int month) {
        // check if month in range
        if (month <= 0 || month > 12) {
           throw new IllegalArgumentException(
              "month (" + month + ") must be 1-12");
        }
      
        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(isLeapYear())) {
           throw new IllegalArgumentException("day (" + day +
              ") out-of-range for the specified month and year");
        }
        
        this.month = month;
    }

    /**
     * Set day method
     * @param day Day integer, 1-31 accepted based on month
     */
    public void setDay(int day) {
        // check if day in range for month
        if (day <= 0 || 
           (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
           throw new IllegalArgumentException("day (" + day + 
              ") out-of-range for the specified month and year");
        }
        
        this.day = day;
    }
    
    /**
     * Get month method.
     * @return Returns month of the Date instance
     */
    public int getMonth() {
        return month;
    }

    /**
     * Get Day method.
     * @return Returns day of the Date instance
     */
    public int getDay() {
        return day;
    }

    /**
     * Get Year method.
     * @return Returns the year of the Date instance
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Returns formatted Date string in standard-date format
     * @return Returns formatted date as a string in standard format (YYYY-MM-DD)
     */
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day); 
    }
    
    /**
     * Increment date by one day. Will increment month if end of the month is reached.
     * Will increment year if end of the year is reached.
     */
    public void nextDay(){
        day++;
        if((isLeapYear() && month == 2 && day > 29) || (!isLeapYear() && day > daysPerMonth[month]))  {
            day = 1;
            month++;
            if(month > 12){//increment year
                month = 1;
                year++;
            }
        }
    }
    
    /**
     * Identifies the year of the current date as a leap year.
     * @return Returns true if a leap year, false else.
     */
    private boolean isLeapYear(){
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}
