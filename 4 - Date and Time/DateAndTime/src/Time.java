/**
 * Time class used to store hours, minutes, and seconds. Hours range from 0 to 23,
 * minutes range from 0 to 59, and seconds range from 0 to 59. This class includes
 * setters and getters, as well as increment functions for seconds, minutes, and hours.
 * @author Alexandre Paquette
 * @version Mar 31, 2022
 */
public class Time {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    /**
     * No-argument constructor that initializes each instance variable to zero.
     */
   public Time() {                                             
      this(0, 0, 0); // invoke constructor with three arguments
   }

    /**
     * Single argument constructor with hour supplied. Minute and second set to zero.
     * @param hour Hour integer, 0-23 accepted
     */
   public Time(int hour) {                                               
      this(hour, 0, 0); // invoke constructor with three arguments 
   }

    /**
     *Double argument constructor with hour and minute supplied. Second set to zero
     * @param hour Hour integer, 0-23 accepted
     * @param minute Minute integer, 0-59 accepted
     */
   public Time(int hour, int minute) {
      this(hour, minute, 0); // invoke constructor with three arguments 
   }

    /**
     * Constructor with hour, minute, and second supplied
     * @param hour Hour integer, 0-23 accepted
     * @param minute Minute integer, 0-59 accepted
     * @param second Second integer, 0-59 accepted
     */
   public Time(int hour, int minute, int second) {                    
      if (hour < 0 || hour >= 24) {//throw exception if hour < 0 or hour >= 24
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) {//throw exception if minute < 0 or minute >= 60
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) {//throw exception if second < 0 or second >= 60
         throw new IllegalArgumentException("second must be 0-59");
      } 
      
      //assign values to instance variables
      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   }       

    /**
     * Constructor with Time instance supplied
     * @param time Time instance
     */
   public Time(Time time) {                                   
      // invoke constructor with three arguments
      this(time.hour, time.minute, time.second);
   }

    /**
     * Set time method that accepts hour, minute, and second.
     * @param hour Hour integer, 0-23 accepted
     * @param minute Minute integer, 0-59 accepted
     * @param second Second integer, 0-59 accepted
     */
   public void setTime(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) { //throw exception if hour < 0 or hour >= 24
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) { //throw exception if minute < 0 or minute >= 60
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) { //throw exception if second < 0 or second >= 60
         throw new IllegalArgumentException("second must be 0-59");
      } 
      
      //assign values to instance variables
      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   }

    /**
     * Set hour method.
     * @param hour Hour integer, 0-23 accepted
     */
   public void setHour(int hour) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }
      
      this.hour = hour;
   } 

    /**
     * Set minute method.
     * @param minute Minute integer, 0-59 accepted
     */
   public void setMinute(int minute) {
      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      this.minute = minute; 
   }

    /**
     * Set second method
     * @param second Second integer, 0-59 accepted
     */
   public void setSecond(int second) {
      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }

      this.second = second;
   }  

    /**
     * Get hour method.
     * @return Returns hour of the Time instance
     */
   public int getHour() {return hour;}  

    /**
     * Get minute method.
     * @return Returns minute of the Time instance
     */
   public int getMinute() {return minute;}

    /**
     * Get second method
     * @return Returns second of the Time instance
     */
   public int getSecond() {return second;}

    /**
     * Returns formatted string in universal time
     * @return Returns formatted time as universal format (HH:MM:SS)
     */
   public String toUniversalString() {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   }
    
    /**
     * Returns formatted time string in standard-time format
     * @return Returns formatted time as a string in standard-time format (H:MM:SS AM or PM)
     */
   @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s", 
           ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
           getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
     }

    /**
     * Increment time by one second. Will call incrementMinute() if second reaches
     * 60 and reset seconds to 0.
     */
   public void tick(){
       second++;
       if(second > 59){
           incrementMinute(); //increment minute
           second = 0; //reset to zero
       }
   }

    /**
     * Increment time by one minute. Will call incrementHour() if minute reaches
     * 60 and reset minute to 0
     */
   public void incrementMinute(){
       minute++;
       if(minute > 59){
           incrementHour(); //increment minute
           minute = 0; //reset to zero
       }
   }

    /**
     * Increment time by one hour. Will reset to 0 if hour reaches 24
     */
   public void incrementHour(){
       hour++;
       if(minute > 23){
           hour = 0; //reset to zero
       }
   }
}
