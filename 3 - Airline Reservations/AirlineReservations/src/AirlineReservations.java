import java.util.Scanner;
/**
 * Prompts the user to select a type of seat to reserve and displays an associated boarding pass.
 * The program will notify the user if a seat section is unavailable and will offer an option
 * to select the available seat. If the user opts out of selecting the available seat, they will be informed
 * of the next flight and the program will terminate. If no seats are available, the user will be informed
 * of the next flight and the program will terminate.
 * @author Alexandre Paquette
 * @version Mar 23, 2022
 */

public class AirlineReservations{

    /**
     * Executable method to start the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seats[] = new boolean[10];
        int input;
        
        do{//main menu loop
            String type, message;
            if(seatAvailable(seats, 1, 10) == -1){ //no Seats Available
                System.out.println("Next flight leaves in 3 hours.");
                input = 0;  //terminate program
            }else if(seatAvailable(seats, 1, 5) == -1 ^ seatAvailable(seats, 6, 10) == -1){ //one section unavailable, but not both
                String noSeats = (seatAvailable(seats, 1, 5) == -1) ? "Economy":"First Class";
                String availableSeats = ("Economy".equals(noSeats)) ? " First Class":"n Economy";
                
                message = noSeats + " section is full. Would you like a" + availableSeats + " ticket?\n1 - Yes\n2 - No\n";
                
                input = getIntegerInput(message, 1, 2);
                
                if(input == 2){
                    System.out.println("Next flight leaves in 3 hours.");
                    input = 0;  //terminate program
                }else{
                    if(noSeats.equals("First Class")){
                        input = 2;//assign 2 for correct switch statement selection
                    }
                }
            }else{//both sections available
                message = "Please type 1 for First Class.\nPlease type 2 for Economy.\nPlease type 0 to terminate program.\n";
                input = getIntegerInput(message, 0, 2);
            }
            
            switch(input){
                    case 0 -> {
                        System.out.println("Have a nice day!"); //farewell message upon termination
                        break;
                    }
                    case 1 -> {
                        System.out.println("You have selected First Class");//First Class
                        int seat = seatAvailable(seats, 6, 10); 
                        seats[seat] = true;  //assign seat
                        showBoardingPass(seat + 1, "First Class");  //show boarding pass
                        break;
                    }
                    case 2 -> {
                        System.out.println("You have selected Economy");//Economy
                        int seat = seatAvailable(seats, 1, 5); 
                        seats[seat] = true;   //assign seat
                        showBoardingPass(seat + 1, "Economy");      //show boarding pass
                        break;
                    }
                    default -> System.out.println("Invalid Input");//Invalid
                }//end of switch
        }while(input != 0);
    }
    
    /**
     * Print out a boarding pass with the provided seat number and seat type.
     * @param seatNum Assigned seat number
     * @param type Assigned seat type
     */
    public static void showBoardingPass(int seatNum, String type){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%s%n", type);
        System.out.printf("Seat Number: %d%n", seatNum);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /**
     * Takes an array of seats with a specified upper and lower range, and returns the first available seat.
     * Will return -1 if no seats are available.
     * @param seats Boolean array of seats
     * @param lowerRange Lower seat position, minimum 1, max length of array
     * @param upperRange Upper seat position, minimum 1, max length of array
     * @return Returns the first available seat in the range, returns -1 if no seats are available.
     */
    public static int seatAvailable(boolean [] seats, int lowerRange, int upperRange){
        for (int x = lowerRange-1; x <= upperRange-1; x++) {
            if (!seats[x]) {
                return x;//return index of available seat
            }
        }
        return -1;//-1 if no seats are available
    }
    
    /**
     * Displays a provided message to the user and prompts them for input so long as the input is invalid.
     * @param message String of message to display to user
     * @param min Minimum acceptable value, inclusive
     * @param max Maximum acceptable value, inclusive
     * @return returns valid input from the user between min and max values
     */
    public static int getIntegerInput(String message, int min, int max){
        int input = 0;
        do{
            System.out.print(message);  //print message for user
            System.out.print("\nEnter: ");
            try{
                Scanner in = new Scanner(System.in);
                input = in.nextInt();   //take integer
            }//end of try
            catch(Exception e){//catch non-intenger input
                System.out.println("Invalid Input");//Invalid
            }
        }while(input < min && input > max);

        return input;   //return input
    }
}