package targetheartratecalculator;

import java.util.Scanner;

/**
 *  Main program that uses the HeartRates class to display attributes of the class.
 *  Will prompt the user for name (first and last), birth year, month, and day, 
 *  and display their Age, Max Heart Rage, and Target Heart Rate Range.
 * @author Alexandre Paquette
 * @version 01/25/2022
 * 
 */
public class TargetHeartRateCalculator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        Scanner in = new Scanner(System.in);
        String fName = "";
        String lName = "";
        int bYear = 0;
        int bMonth = 0;
        int bDay = 0;
        
        //GET USER INPUT
        System.out.printf("Enter the first name: ");
        fName = in.next();
        System.out.printf("Enter the last name: ");
        lName = in.next();
        System.out.printf("Enter the birth year: ");
        bYear = in.nextInt();
        System.out.printf("Enter the birth month (1-12): ");
        bMonth = in.nextInt();
        System.out.printf("Enter the birth day: ");
        bDay = in.nextInt();
        
        //HEARTRATES INSTANCE
        HeartRates rate = new HeartRates(fName, lName, bYear, bMonth, bDay);
        
        //FINAL OUTPUT
        System.out.printf("%n%nName: %s%n", rate.getName());
        System.out.printf("DOB: %s%n", rate.getDOB());
        System.out.printf("Age: %d years old%n", rate.age());
        System.out.printf("Max Heart Rate: %d bpm%n", rate.maxHeartRate());
        System.out.printf("Target Heart Rate Range: %d - %d bpm%n", rate.targetHeartRateMin(), rate.targetHeartRateMax());
    }
}
