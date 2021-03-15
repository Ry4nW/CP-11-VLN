/* RPS Version 1.1

- Code improvements.
- System improvements.
- Added Win/Loss counts.
- Removed "Play Again". Instead, allowed players to quit the game by pressing enter.

 */

import java.util.Scanner; // Imports the scanner class so we can obtain user input.

public class improvedRPS {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Creates a Scanner object.

        System.out.println("Welcome to Rock Paper Scissors. Press enter anytime to quit the game.");

        /* All variables necessary for the program are declared here, other than the random number generator, user
        input or checkInput. */

        String randPick = "";
        String fighter;

        String r = "r";
        String p = "p";
        String s = "s";

        String rF = "rock";
        String pF = "paper";
        String sF = "scissors";

        int winCount = 0;
        int lossCount = 0;
        int tieCount = 0;
        String count;

        /* This loop ensures that the program will run continuously. Termination will occur when
        the user inputs a empty value. */

        while (true) {

            boolean checkInput = true;

            int rand = (int) (Math.random() * 3); // This generates a random number between 0-2.

            // This loop checks for the correctness of the input until an input is valid.
            do {

                System.out.println("\nEnter 'r' for rock, 'p' for paper, or 's' for scissors:");
                fighter = input.nextLine().toLowerCase(); /* Obtains a value from the user using the Scanner object
                created earlier. {.nextLine()} is used to read the input as a string and {.toLowerCase()} converts it
                all to lower case letters for ease of testing. */

                // Checks if input equals to ENTER (no value), the user quit action.
                if (fighter.length() == 0) {
                    System.out.println("Thanks for playing.");
                    System.exit(0);

                } else if (fighter.equals(r) || fighter.equals(p) || fighter.equals(s)) /* Checks if input equals to
                     one of the fighters listed. */ {
                        checkInput = false; // Terminates loop if it is.
                }

                } while (checkInput); // Continues loop if it is not.

                /* {checkInput}, {rand} and {fighter} are placed inside the while loop for a new game every time the user
                wants to play again.
                */

                // Converts the random number generated into an opposing fighter.
                switch (rand) {
                    case 0 -> randPick = rF;
                    case 1 -> randPick = pF;
                    case 2 -> randPick = sF;
                }

                // This whole conditional determines whether or not the user has won.
                if (randPick.substring(0, 1).equals(fighter)) /* Checks for a tie */ {
                    System.out.println("Tie. I picked " + randPick + " as well.");
                    tieCount++; // Increments the "Ties" count.
                } else if ((fighter.equals(r) && randPick.equals(sF)) ||
                        (fighter.equals(p) && randPick.equals(rF)) ||
                        (fighter.equals(s) && randPick.equals(pF))) /* Checks for all win cases. */ {
                    System.out.println("Congratulations, you won. I picked " + randPick + "."); // Output for any win case.
                    winCount++; //Increments the "Wins" count.
                } else {
                    System.out.println("Haha, I win. My choice was " + randPick + "."); // Output for any loss case.
                    lossCount++; // Increments the "Losses" count.
                }
                // Changes the count string here, every time the loop ends up here, in order to update the figures.
                count = "Wins: " + winCount + " Losses: " + lossCount + " Ties: " + tieCount;
                System.out.println(count);
        }
    }
}