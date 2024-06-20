package targetheartratecalculator;

import java.time.LocalDate;

/**
 * Class for generating the Max Heart Rate and Target Heart Rate based on age. 
 * This class takes parameters for first and last names, as well as birth year, month, and day.
 * Birth date is used to calculate age, which is used to determine the Max Heart Rate
 * and the Target Heart Rate range.
 * @author Alexandre Paquette
 * @version 01/25/2022
 */
public class HeartRates {
  private String firstName;
  private String lastName;
  private int dobYear;
  private int dobMonth;
  private int dobDay;

  //CONSTRUCTOR
  /**
   * Constructor for HeartRates Class. Sets all attributes for an instance of 
   * the class.
   * @param firstName
   * @param lastName
   * @param year
   * @param month Number between 1-12. If invalid, defaults to 1
   * @param day 
   */
  public HeartRates(String firstName, String lastName, int year, int month, int day){
    this.firstName = firstName;
    this.lastName = lastName;
    this.dobYear = year;
    if(month <= 12 && month >= 1){
        this.dobMonth = month;
    }else{
        this.dobMonth = 1;
    }
    this.dobDay = day;
  }

  //FIRST AND LAST NAME ATTRIBUTES
  /**
   * Setter for the name attributes (first and last) of the HeartRates Class.
   * @param firstName
   * @param lastName 
   */
  public void setName(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }
  /**
   * 
   * @return Returns first and last name with space in between.
   */
  public String getName(){
    return (firstName + " " + lastName);
  }
  /**
   * 
   * @return Returns first name attribute.
   */
  public String getFirstName(){
    return firstName;
  }
  /**
   * 
   * @return Returns last name attribute.
   */
  public String getLastName(){
    return lastName;
  }

  //DATE OF BIRTH ATTRIBUTES
  /**
   * Sets the date of birth with parameters for year, month, and day.
   * @param year
   * @param month Number between 1-12. If invalid, defaults to 1
   * @param day 
   */
  public void setDOB (int year, int month, int day){
    this.dobYear = year;
    if(month <= 12 && month >= 1){
        this.dobMonth = month;
    }else{
        this.dobMonth = 1;
    }
    this.dobDay = day;
  }
  /**
   * 
   * @return Returns the date of birth in YYYY-MM-DD format.
   */
  public String getDOB(){
      return (dobYear + "-" + dobMonth + "-" + dobDay);
  }
  /**
   * 
   * @return Returns the birth year.
   */
  public int getDOBYear(){
    return dobYear;
  }
  /**
   * 
   * @return Returns the birth month as an integer (1-12).
   */
  public int getDOBMonth(){
    return dobMonth;
  }
  /**
   * 
   * @return Returns the birth day as an integer.
   */
  public int getDOBDay(){
    return dobDay;
  }

  //MISC METHODS
  /**
   * 
   * @return Returns the age as a whole number. Fractional ages not supported.
   */
  public int age(){
    int age = 0;
    int currentYear = LocalDate.now().getYear();
    int currentMonth = LocalDate.now().getMonthValue();
    int currentDay = LocalDate.now().getDayOfMonth();
    
    if(dobMonth > currentMonth || (dobMonth == currentMonth && dobDay > currentDay)){
        age--;
    }
    age += (currentYear - dobYear);
    return age;
  }
  /**
   * 
   * @return Returns the Maximum Heart Rate as a whole number in beats-per-minute
   */
  public int maxHeartRate(){
      int maxHeartRate = 220 - this.age();
      
      return maxHeartRate;
  }
  /**
   * 
   * @return Returns the Max Target Heart Rate as a whole number in beats-per-minute
   */
  public int targetHeartRateMax(){
      int targetHeartRate = (int) (maxHeartRate() * 0.85);
      
      return targetHeartRate;
  }
  /**
   * 
   * @return Returns the Min Target Heart Rate as a whole number in beats-per-minute
   */
  public int targetHeartRateMin(){
      int targetHeartRate = (int) (maxHeartRate() * 0.5);
      
      return targetHeartRate;
  }
}
