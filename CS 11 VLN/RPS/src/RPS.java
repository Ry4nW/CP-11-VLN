//RPS 1.0

import java.util.Scanner; // Imports the scanner class so we can obtain user input.

public class RPS {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Creates a Scanner object.

        System.out.println("Welcome to Rock Paper Scissors.");

        /* All variables necessary for the program are declared here, other than the random number generator
        and user input. */

        String randPick = "";
        String r = "rock";
        String p = "paper";
        String s = "scissors";

        boolean run = true;
        boolean checkInput = true;

        /* This loop ensures that the program will run continuously. Termination will occur when
        when the {run} variable is declared false. */

        while (run) {

            System.out.println("\nFighters available: \nRock\nPaper\nScissors\n\nEnter your fighter of choice: ");

            int rand = (int) (Math.random() * 3); // This generates a random number between 0-2.
            String fighter = input.nextLine().toLowerCase(); /* Obtains a value from the user using the Scanner object
            created earlier. {.nextLine()} is used to read the input as a string and {.toLowerCase()} converts it all to
            lower case letters for ease of testing. */

            // Both variables are placed inside the while loop for a new game every time the user wants to play again.

            // This loop checks for the correctness of the input until {checkInput} is declared false.
            while (checkInput) {

                // Tests if input equals to one of the fighters listed.
                if (fighter.equals(r) || fighter.equals(p) || fighter.equals(s)) {
                    checkInput = false; // End of checking input.
                } else {
                    System.out.println("You didn't choose one of the three fighters. Enter again: ");
                    fighter = input.nextLine().toLowerCase(); // Runs user input again if previous input was not valid.
                }
            }

            // Converts the random number generated into an opposing fighter.
            switch (rand) {
                case 0 -> randPick = r;
                case 1 -> randPick = p;
                case 2 -> randPick = s;
            }

            // This whole conditional determines whether or not the user has won.
            if (randPick.equals(fighter)) /* Checks for a tie */ {
                System.out.println("Tie. I picked " + randPick + " as well.");
            } else if ((fighter.equals(r) && randPick.equals(s)) ||
                    (fighter.equals(p) && randPick.equals(r)) ||
                    (fighter.equals(s) && randPick.equals(p))) /* Checks for all win cases. */ {
                System.out.println("Congratulations, you won. I picked " + randPick + "."); // Output for any win case.
            } else {
                System.out.println("Haha, I win. My choice was " + randPick + "."); // Output for any lose case.
            }

            System.out.println("Play Again?");

            String play = input.nextLine().toLowerCase(); /* Input for whether or not the user wants to continue the
            game. */

            // Checks if user DOESN'T want to play. Else, goes back to the top of the loop and continues running.
            if (play.equals("no")) {
                run = false; // Terminates program.
            }
        }
        System.out.println("Thanks for playing.");
    }
}