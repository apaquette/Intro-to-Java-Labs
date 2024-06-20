/**
 * Salaried Compensation Model class used to store weekly salary. Weekly salary
 * cannot be negative. Implements Compensation Model interface.
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class SalariedCompensationModel implements CompensationModel{
    private double weeklySalary;
    public final String compensationName = "Salaried";

    /**
     * No-argument constructor that initializes weeklySalary to zero
     */
    public SalariedCompensationModel() {
        this(0);
    }
    
    /**
     * All argument constructor with weekly salary supplied. Negative values are
     * defaulted to zero
     * @param weeklySalary Weekly Salary, 0 or greater accepted.
     */
    public SalariedCompensationModel(double weeklySalary) {
        if(weeklySalary < 0){
            weeklySalary = 0;
        }
        this.weeklySalary = weeklySalary;
    }

    /**
     * Get Compensation Model Name method
     * @return Returns compensation model name
     */
    @Override
    public String getCompensationModelName() {
        return compensationName;
    }
    
    /**
     * Earnings method returns weekly salary
     * @return Returns weekly salary
     */
    @Override
    public double earnings() {
        return weeklySalary;
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
