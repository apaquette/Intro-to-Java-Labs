/**
 * Employee class used to store First Name, Last Name, Social Security Number, and Compensation Model.
 * All fields except Compensation Model are final.
 * Implements Payable interface.
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class Employee implements Payable{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private CompensationModel compModel; //"has-a" Compensation Model
    
    /**
     * All argument constructor with first name, last name, social security number, and compensation model.
     * @param firstName Employee First Name
     * @param lastName Employee Last Name
     * @param socialSecurityNumber Employee Social Security Number
     * @param model Employee Compensation Model
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber, CompensationModel model) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.compModel = model;
   }

    /**
     * Get First Name method
     * @return Employee First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get Last Name method
     * @return Employee Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get Social Security Number method
     * @return Employee Social Security Number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    
    /**
     * Get Compensation Model Method
     * @return Employee Compensation Model
     */
    public CompensationModel getCompensationModel() {
        return compModel;
    }

    /**
     * Set Compensation Model Method
     * @param model Employee Compensation Model
     */
    public void setCompensationModel(CompensationModel model) {
        this.compModel = model;
    }
    
    /**
     * Returns earnings determines by the compensation model
     * @return Earnings from compensation model
     */
    public double earnings(){
        return compModel.earnings();
    }

    /**
     * Returns payment amount. Determined by earnings() functions
     * @return payment amount
     */
    @Override
    public double getPaymentAmount() {
        return earnings();
    }
    
    /**
     * Returns employee record listing compensation model, first and last name, social security number, and earnings
     * @return Employee Record
     */
    @Override
    public String toString() {
       return String.format("%s%n%s %s%nSocial Security Number: %s%n%s",compModel.getCompensationModelName(), 
          firstName, lastName, socialSecurityNumber, compModel.toString());
    }
}
