/**
 * Base Plus Commission Compensation Model class used to store gross sales, commission rate, and base salary
 * of an entity with Base Plus Commission compensation. All fields must be non-negative values.
 * Extends CommissionCompensationModel
 * Implements CompensationModel interface
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class BasePlusCommissionCompensationModel extends CommissionCompensationModel implements CompensationModel{
    private double baseSalary;
    
    private final String compensationName = "Base Plus Commission";
    
    /**
     * No-argument constructor that initializes each instance variable to zero
     */
    public BasePlusCommissionCompensationModel() {
        this(0,0,0);
    }
    
    /**
     * All argument constructor with gross sales, commission rate, and base salary supplied. 
     * Values supplied below zero will be defaulted to zero
     * @param grossSales Gross Sales double, 0 or greater accepted
     * @param commissionRate Commission Rate double, 0 or greater accepted
     * @param baseSalary Base Salary double, 0 or greater accepted
     */
    public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary) {
        super(grossSales, commissionRate);
        if(baseSalary < 0){
            baseSalary = 0;
        }
        this.baseSalary = baseSalary;
    }

    /**
     * Get Base Salary method
     * @return Returns base salary of the instance
     */
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Set Base Salary Method
     * @param baseSalary Base Salary, 0 or greater accepted, less than 0 is defaulted to 0
     */
    public void setBaseSalary(double baseSalary) {
        if(baseSalary < 0){
            baseSalary = 0;
        }
        this.baseSalary = baseSalary;
    }

    /**
     * Get Model Name method.
     * @return 
     */
    @Override
    public String getCompensationModelName() {
        return compensationName;
    }

    /**
     * Earnings method that calculates and returns Gross Sales times Commission Rate plus Base Salary
     * @return Return calculated earnings (Gross Sales * Commission Rate) + Base Salary
     */
    @Override
    public double earnings() {
        return baseSalary + getGrossSales() * getCommissionRate();
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
