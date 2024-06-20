import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Displays arithmetic problems for the user to practice, and informs the user
 * if they are ready for the next level or require further instruction.
 * The program will prompt the user for a difficult level which corresponds with
 * the number of digits the numbers can have. It also prompts the user to select
 * the type of arithmetic problems they'd like to practice.
 * @author Alexandre Paquette
 * @version Feb 23, 2022
 */

public class ComputerAssistedInstruction{
    /**
     * Main method for Computer Assisted Instruction Program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int answers[] = new int[2];     //stores wins/losses
        int numRange[] = new int[2];    //stores the range of numbers that can be used
        int arithmetics;                //stores the type of arithmetics selection

        setDifficulty(numRange);
        arithmetics = setArithemtics();

        do{
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

            runQuestion(answers, numRange, arithmetics);

            if(checkAnswers(answers)){
                answers = new int[2]; //reset answers
            }

        }while(getContinue());

        System.out.print("Goodbye!");
    }

    /**
     * Prompts the user to select the type of arithmetic problems they'd like
     * to see and returns the selection. This method will continue prompting the
     * user for an input if an invalid input is provided. Options listed:<br>
     * 1 - Addition <br>
     * 2 - Subtraction <br>
     * 3 - Multiplication <br>
     * 4 - Integer Division <br>
     * 5 - Random
     * @return Returns the select option provided by the user.
     */
    public static int setArithemtics(){
        int select;

        do{
            Scanner in = new Scanner(System.in);
            select = -1;    //initialize to invalid value

            System.out.printf("Choose type of arithemtic problem to study:%n1 - Addition%n2 - Subtraction%n3 - Multiplication%n4 - Integer Division%n5 - Random Mix%n%nEnter: ");

            try{
                select = in.nextInt();
                if(select > 5 || select < 1){//check for valid input range
                    System.out.println("Please enter a valid selection.");
                }
            }catch(Exception e){//catch invalid input
                System.out.println("Please enter an integer.");
            }
        }while(select > 5 || select < 1); //

        return select;
    }

    /**
     * Displays a randomly generated problem and asks the user for input until
     * they provides the correct answer.
     * @param answers Array used for tracking answers. Index 0 for correct, 1 for incorrect
     * @param numRange Array used to determine the range of numbers that can be generated. 0 for min, 1 for max. Range is inclusive.
     * @param ARITHMETICS Integer to determine type of problems to be generated (takes 1 to 5). See {@link #setArithemtics() setArithemtics}
     */
    public static void runQuestion(int[] answers, int[] numRange, final int ARITHMETICS) {
        int input;
        int problem[] = new int[3];
        int actualArithmetics = (ARITHMETICS == 5) ? generateNumRange(0,3):(ARITHMETICS - 1); //if arithmetics is 5, generate a random problem, else assign value minus one
        String operator[] = {"plus", "minus", "times", "divided by"};

        generateQuestion(problem, numRange, actualArithmetics);
        System.out.printf("How much is %d %s %d?%n", problem[0], operator[actualArithmetics], problem[1]);

        do{
            try{
                Scanner in = new Scanner(System.in);

                input = in.nextInt();

                if(problem[2] == input){//correct answer
                    showCorrectMessage();
                    answers[0]++;
                }else{//incorrect answer
                    showIncorrectMessage();
                    answers[1]++;
                }
            }
            catch(Exception e){//catch incorrect input
                System.out.println("Please enter an integer.");
                input = problem[2] + 1; //assign incorrect value for while conditional
            }
        }while(input != problem[2]); //keep taking inputs while invalid input
    }

    /**
     * This method is used to display a random message from four options when
     * the user gets a correct answer.
     */
    public static void showCorrectMessage(){
        switch (generateNumRange(0,3)){
            case 0 -> System.out.println("Very Good!");
            case 1 -> System.out.println("Excellent!");
            case 2 -> System.out.println("Nice work!");
            case 3 -> System.out.println("Keep up the good work!");
        }
    }

    /**
     * This method is used to display a random message from four options when
     * the user gets an incorrect answer.
     */
    private static void showIncorrectMessage() {
        switch (generateNumRange(0,3)){
            case 0 -> System.out.println("No. Please try again.");
            case 1 -> System.out.println("Wrong. Try once more.");
            case 2 -> System.out.println("Don’t give up!");
            case 3 -> System.out.println("No. Keep trying.");
        }
    }

    /**
     * This method generates a random problem from a given number range and
     * type of arithmetic, and is stored in the prob parameter.
     * @param prob Problem array used to store num 1, 2, and solution
     * @param numRange Range used to determine what numbers can be generated. (index 0 - min, index 1 - max, inclusive)
     * @param arithemtics Used to determine the type of problem (0 - addition, 1 - subtraction, 2 - multiplication, 3 - integer division)
     */
    public static void generateQuestion(int prob[], int numRange[], int arithemtics){
        prob[0] = generateNumRange(numRange[0],numRange[1]);    //generate the first number
        prob[1] = generateNumRange(numRange[0],numRange[1]);    //generate the second number
        switch(arithemtics){
            case 0 -> //addition
                prob[2] = prob[0] + prob[1];
            case 1 -> //subtraction
                prob[2] = prob[0] - prob[1];
            case 2 -> //multiplication
                prob[2] = prob[0] * prob[1];
            case 3 -> //division
                prob[2] = prob[0] / prob[1];
        }
    }

    /**
     * This method prompts the user on whether they wish to try another problem.
     * This method will continue prompting the user for an input if an invalid
     * input is provided.
     * @return True if the user wants to try another problem, false if not.
     */
    public static boolean getContinue(){
        boolean invalid;        //loop sentinel
        boolean input = false;

        do{
            try{
                Scanner in = new Scanner(System.in);

                System.out.println("Try another problem? Type true or false.");

                input = in.nextBoolean();
                invalid = false;
            }catch(Exception e){//catch invalid inputs
                System.out.println("Please type true or false.");

                invalid = true;
            }
        }while(invalid);//keep taking inputs while invalid is true

        return input;
    }

    /**
     * Prompts the user to select a difficulty level of 1 or higher, and
     * calculate and store the number range based on the user input. The
     * difficulty level corresponds with the number of digits in the problem.
     * This method will continue to prompt the user until a valid input is
     * provided.
     * @param numRange Used to store the number range based on the user's input. Index 0 for min and 1 for max
     */
    public static void setDifficulty(int numRange[]){
        int difficulty;     //difficulty
        boolean invalid;    //loop sentinel

        do{
            try{
                Scanner in = new Scanner(System.in);

                System.out.println("Choose a difficulty level (1 or higher):");

                difficulty = in.nextInt();
                invalid = false;

                if(difficulty < 1){//check for valid input range
                    System.out.println("Difficulty level must be 1 or higher");
                    invalid = true;
                }else{//calculate range based on difficulty level
                    numRange[0] = (int) Math.pow(10,(difficulty - 1));
                    numRange[1] = (numRange[0]*10) - 1;
                }
            }catch(Exception e){//catch invalid inputs
                System.out.println("Please enter an integer.");
                invalid = true;
            }
        }while(invalid);//keep taking inputs while invalid is true
    }

    /**
     * Checks if fewer than 10 answers have been provided, and if not, display a
     * message either informing the user to see their teacher for help, or that
     * they are ready for the next level. 75% or higher results in message for
     * next level, less results in message to see the teacher for help.
     * @param answers Int array where index 0 and index 1 correspond to number of correct and incorrect answers respectively
     * @return Returns false if fewer than 10 answers are provided, true if not
     */
    public static boolean checkAnswers(int answers[]){
        int totalAnswers = answers[0] + answers[1];

        if(totalAnswers < 10){
            return false; //return false if fewer than 10 answers were given
        }else{
            if((double)answers[0]/totalAnswers < 0.75){//if more than 75% of the answers are correct
                System.out.println("Please ask your teacher for extra help.");
            }else{//if less than 75% of the answers are correct
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            return true; //return true if more than 10 answers are given
        }
    }

    /**
     * Generates a random number between min and max inclusive.
     * @param min Minimum number that can be generated
     * @param max Maximum number that can be generated
     * @return Returns the random number generated
     */
    public static int generateNumRange(int min, int max){
        final SecureRandom randomNumbers = new SecureRandom();

        return (min + randomNumbers.nextInt(max+1));
    }
}
