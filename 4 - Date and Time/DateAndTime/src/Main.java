/**
 * Main program used to test the DateAndTime class.
 * @author Alexandre Paquette
 * @version Mar 31, 2022
 */

public class Main{
    /**
     * Executable method to start the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Increment to next day
        DateAndTime newDateTime = new DateAndTime(new Date(), new Time(23, 59, 59));
        System.out.println("Increment to the Next Day:");
        System.out.println(newDateTime);
        newDateTime.tick();
        System.out.println(newDateTime);
        
        //Increment to next year
        System.out.println();
        newDateTime = new DateAndTime(new Date(1,12,31), new Time(23, 59, 59));
        System.out.println("Increment to the Next Year:");
        System.out.println(newDateTime);
        newDateTime.tick();
        System.out.println(newDateTime);
        
        //Increment Regular Year
        System.out.println();
        newDateTime = new DateAndTime(new Date(1,2,28), new Time(23, 59, 59));
        System.out.println("Increment in non leap-year:");
        System.out.println(newDateTime);
        newDateTime.tick();
        System.out.println(newDateTime);
        
        //Increment Leap Year
        System.out.println();
        newDateTime = new DateAndTime(new Date(2020,2,28), new Time(23, 59, 59));
        System.out.println("Increment in leap-year:");
        System.out.println(newDateTime);
        newDateTime.tick();
        System.out.println(newDateTime);
        System.out.println();
        
        //Next month increment from Feb 29th on a leap year
        System.out.println("After calling nextDay() a second time in leap year:");
        newDateTime.nextDay();
        System.out.println(newDateTime);
        System.out.println();
        
        //Universal format output
        System.out.println("Universal Format:");
        System.out.println(new DateAndTime().toUniversalString());
        System.out.println();
        
        //Standard format output
        System.out.println("Standard Format:");
        System.out.println(new DateAndTime());
    }
}
