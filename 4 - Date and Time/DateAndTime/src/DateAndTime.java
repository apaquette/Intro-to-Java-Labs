/**
 * DateAndTime class used to store a Date instance, and Time instance.
 * @see Time class
 * @see Date class
 * @author Alexandre Paquette
 * @version Mar 31, 2022
 */
public class DateAndTime {
    private Time time;
    private Date date;
    
    /**
     * No-argument constructor that initializes Time and Date to default values.
     */
    public DateAndTime(){
        this(new Date(), new Time());
    }
    
    /**
     * Single argument constructor with year supplied. Month and day set to one.
     * Hour, minute, and second set to zero.
     * @param year Year integer, 1 or greater accepted
     */
    public DateAndTime(int year){
        this(year, 1, 1, 0, 0, 0);
    }
    
    /**
     * Double argument constructor with year and month supplied. Day set to one.
     * Hour, minute, and second set to zero.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     */
    public DateAndTime(int year, int month){
        this(year, month, 1, 0, 0, 0);
    }
    
    /**
     * Triple argument constructor with year, month, and day supplied.
     * Hour, minute, and second set to zero.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     */
    public DateAndTime(int year, int month, int day){
        this(year, month, day, 0, 0, 0);
    }
    
    /**
     * Multi-argument constructor with year, month, day, and hour supplied.
     * Minute, and second set to zero.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     * @param hour Hour integer, 0-23 accepted
     */
    public DateAndTime(int year, int month, int day, int hour){
        this(year, month, day, hour, 0, 0);
    }
    
    /**
     * Multi-argument constructor with year, month, day, hour, and minute supplied.
     * Second set to zero.
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     * @param hour Hour integer, 0-23 accepted
     * @param minute Minute integer, 0-59 accepted
     */
    public DateAndTime(int year, int month, int day, int hour, int minute){
        this(year, month, day, hour, minute, 0);
    }
    
    /**
     * All argument constructor with year, month, day, hour, minute, and second supplied
     * @param year Year integer, 1 or greater accepted
     * @param month Month integer, 1-12 accepted
     * @param day Day integer, 1-31 accepted based on month
     * @param hour Hour integer, 0-23 accepted
     * @param minute Minute integer, 0-59 accepted
     * @param second Second integer, 0-59 accepted
     */
    public DateAndTime(int year, int month, int day, int hour, int minute, int second){
        this(new Date(year, month, day), new Time(hour, minute, second));
    }
    
    /**
     * Constructor with DateAndTime instance supplied
     * @param date DateAndTime instance
     */
    public DateAndTime(DateAndTime date){
        this(date.date, date.time);
    }
    
    /**
     * Single argument constructor with Date instance supplied. Default time
     * values set.
     * @param date
     */
    public DateAndTime(Date date) {
        this(date, new Time());
    }
    
    /**
     * Double argument constructor with Date instance and Time instance supplied.
     * @param date Date instance
     * @param time Time instance
     */
    public DateAndTime(Date date, Time time) {
        this.time = time;
        this.date = date;
    }
    
    /**
     * Increment time by one second. Will call incrementMinute() if second reaches
     * 60 and reset seconds to 0, and call incrementMinute() to increment minute
     */
    public void tick(){
        int currentTime = time.getSecond() + 1;
        
        if(currentTime > 59){
            incrementMinute(); //increment minute
            currentTime = 0; //reset to zero
        }
        time.setSecond(currentTime);
    }
   
    /**
     * Increment time by one minute. Will call incrementHour() if minute reaches
     * 60 and reset minute to 0, and call incrementHour() to increment hour
     */
    public void incrementMinute(){
        int currentTime = time.getMinute() + 1;
        
        if(currentTime > 59){
            incrementHour(); //increment hour
            currentTime = 0; //reset to zero
        }
        time.setMinute(currentTime);
    }

    /**
     * Increment time by one hour. Will reset to 0 if hour reaches 24, and call
     * nextDay() to increment day
     */
    public void incrementHour(){
        int currentTime = time.getHour() + 1;
        
        if(currentTime > 23){
            nextDay(); //increment day
            currentTime = 0; //reset to zero
        }
        time.setHour(currentTime);
    }

    /**
     * Increment date by one day. Will increment month if end of the month is reached.
     * Will increment year if end of the year is reached.
     */
    public void nextDay(){
        this.date.nextDay();
    }
   
    /**
     * Returns formatted string in standard date and time
     * @return Returns formatted date and time as standard format (YYYY-MM-DD H:MM:SS AM or PM)
     */
    @Override
    public String toString() {
      return String.format("%s %s", this.date, this.time); 
    }
    
    /**
     * Returns formatted string in universal date and time
     * @return Returns formatted date and time as universal format (YYYY-MM-DD HH:MM:SS)
     */
    public String toUniversalString(){
        return String.format("%s %s", this.date, this.time.toUniversalString());
    }
}
