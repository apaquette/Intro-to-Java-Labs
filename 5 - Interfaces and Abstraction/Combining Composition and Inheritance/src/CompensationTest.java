
/**
 * CompensationTest class to test polymorphic Employee and Invoice classes with Payable class.
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public class CompensationTest{

    /**
     * Executable method to start the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Payable[] payableObjects = new Payable[] {
            new Invoice("01234", "seat", 2, 375.00),
            new Invoice("56789", "tire", 4, 79.95),
            new Employee("John", "Smith", "111-11-1111", new SalariedCompensationModel(800.00)),
            new Employee("Lisa", "Barnes", "888-88-8888", new BasePlusCommissionCompensationModel(1200.00, 0.05, 500)),
            new Employee("Alex", "Paquette", "999-99-9999", new HourlyCompensationModel(25, 40)),
            new Employee("Jacynthe", "Paquette", "777-77-7777", new CommissionCompensationModel(600, 0.07))
        };
        
        System.out.println("Invoices and Employees processed polymorphically:");
        
        //process each elements in array
        for (Payable currentPayable : payableObjects) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s %npayment due: $%,.2f%n", 
            currentPayable, currentPayable.getPaymentAmount()); 
      }
    }
}
