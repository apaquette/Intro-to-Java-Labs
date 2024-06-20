/**
 * Commission Compensation Model class used to store gross sales and commission rate.
 * All fields must be non-negative values. Implements CompensationModel interface
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class CommissionCompensationModel implements CompensationModel{
    private double grossSales;
    private double commissionRate;
    
    private final String compensationName = "Commission";
    
    /**
     * No-argument constructor that initializes each instance variable to zero
     */
    public CommissionCompensationModel() {
        this(0,0);
    }
    
    /**
     * All argument constructor with commission rate and gross sales supplied. 
     * Values supplied below zero will be defaulted to zero
     * @param grossSales Gross Sales, 0 or greater accepted
     * @param comissionRate Commission Rate, 0 or greater accepted
     */
    public CommissionCompensationModel(double grossSales, double comissionRate) {
        if(grossSales < 0){
            grossSales = 0;
        }
        if(comissionRate < 0){
            comissionRate = 0;
        }
        
        this.grossSales = grossSales;
        this.commissionRate = comissionRate;
    }
    
    /**
     * Get Gross Sales method
     * @return Returns gross sales of the instance
     */
    public double getGrossSales() {
        return grossSales;
    }
    
    /**
     * Set Gross Sales method
     * @param grossSales Gross Sales, 0 or greater accepted. Less than 0 is defaulted to 0
     */
    public void setGrossSales(double grossSales) {
        if(grossSales < 0){
            grossSales = 0;
        }
        this.grossSales = grossSales;
    }
    
    /**
     * Get Commission Rate method
     * @return Returns commission rate of the instance
     */
    public double getCommissionRate() {
        return commissionRate;
    }
    
    /**
     * Set Commission Rate method
     * @param comissionRate Commission Rate, 0 or greater accepted, less than 0 is defaulted to 0
     */
    public void setComissionRate(double comissionRate) {
        if(comissionRate < 0){
            comissionRate = 0;
        }
        this.commissionRate = comissionRate;
    }
    
    /**
     * Get Model Name method.
     * @return Returns compensation model name
     */
    @Override
    public String getCompensationModelName() {
        return compensationName;
    }
    
    /**
     * Earnings method that calculates and returns Gross Sales times Commission Rate
     * @return Return calculated earnings (Gross Sales * Commission Rate)
     */
    @Override
    public double earnings() {
        return grossSales * commissionRate;
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
