/**
 * Hourly Compensation Model class used to store wage and hours.
 * All fields must be non-negative values. Implements Compensation Model
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class HourlyCompensationModel implements CompensationModel {
    private double wage;
    private int hours;
    
    private final String compensationName = "Hourly";
    
    /**
     * No-argument constructor that initializes each instance variable to zero
     */
    public HourlyCompensationModel() {
        this(0,0);
    }
    
    /**
     * All argument constructor with commission rate and base salary supplied. 
     * Values supplied below zero will be defaulted to zero
     * @param wage hourly wage, cannot be below zero
     * @param hours work hours, cannot be below zero
     */
    public HourlyCompensationModel(double wage, int hours) {
        if (wage < 0.0) { // validate wage
             wage = 0;
        }
        if ((hours < 0.0) || (hours > 168.0)) { // validate hours
            hours = 0;
        }
        this.wage = wage;
        this.hours = hours;
    }

    /**
     * Get Wage method
     * @return Returns wage of the instance
     */
    public double getWage() {
        return wage;
    }

    /**
     * Set wage method
     * @param wage hourly wage, cannot be below zero
     */
    public void setWage(double wage) {
        if(wage < 0.0){
            wage = 0;
        }
        this.wage = wage;
    }

    /**
     * Get Hours method
     * @return Returns hours of the instance
     */
    public int getHours() {
        return hours;
    }

    /**
     * Set hours method
     * @param hours work hours, cannot be below zero
     */
    public void setHours(int hours) {
        if(hours < 0.0){
            hours = 0;
        }
        this.hours = hours;
    }

    /**
     * Get Compensation Model Name method
     * @return returns sting of compensation name
     */
    @Override
    public String getCompensationModelName() {
        return compensationName;
    }
    
    /**
     * Earnings method that calculates and returns wages with overtime if applicable
     * @return Hourly wage + overtime wage
     */
    @Override
    public double earnings() {
        if (hours <= 40) { // no overtime                           
            return getWage() * getHours();                                
        }                                                                
        else {                                                           
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;  
        }
    }
    
    /**
     * Returns formatted earnings in currency format
     * @return Earnings formatted in currency format
     */
    @Override
    public String toString() {
        return String.format("Earnings: %s%n", nf.format(earnings()));
    }
}
