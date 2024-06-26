/**
 * Project 3.6.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MemoryGame {
    public static void main(String[] args) {
        // Instantiate MemoryGameGUI
        MemoryGameGUI gameGUI = new MemoryGameGUI();
       
        // Configure the game board with 3 buttons and randomization
        gameGUI.createBoard(3, true);

        int score = 0;
        int rounds = 0;
        boolean playAgain = true;
        Random rand = new Random();

        while (playAgain) {
            rounds++;

            // Create the "memory strings"
            String[] memoryStrings = {"A", "B", "C", "D"};

            // Memory List
            List<String> randomSequence = new ArrayList<>();

            //Random Sequence String
            while (randomSequence.size() < memoryStrings.length) {
                int index = rand.nextInt(memoryStrings.length);
                String str = memoryStrings[index];
                if (!randomSequence.contains(str)) {
                    randomSequence.add(str);
                }
            }

            // Play sequence and delay it for half a second.
            String playerGuess = gameGUI.playSequence(randomSequence.toArray(new String[0]), 0.5);

            // Cleanup the guess
            playerGuess = playerGuess.replace(",", "").replace(" ", "");

            // Determine if guess matches generated one
            if (playerGuess.equals(String.join("", randomSequence))) {
                score++;
                gameGUI.matched();
            } else {
                gameGUI.tryAgain();
            }

            // Ask if you want to play again
            playAgain = gameGUI.playAgain();
        }

        // Show score and end the game
        gameGUI.showScore(score, rounds);
        gameGUI.quit();
    }
}
//Just the Orignal Instructions
// Create the "memory strings" - an array of single character strings to
    // show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.

    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.)

    // Play the game until user wants to quit.
 
      // Create a new array that will contain the randomly ordered memory strings.

      // Create a list of randomly ordered integers with no repeats, the length
      // of memory strings. Use it to create a random sequence of the memory strings.
      // - OR -
      // Overload the next method in RandomPermutation to create a random sequence
      // of the memory strings, passed as a parameter.

      // Play one sequence, delaying half a second for the strings to show
      // in the buttons. Save the player's guess.
      // (Later, you can speed up or slow down the game.)

      // Determine if player's guess matches all elements of the random sequence.
     
        // Cleanup the guess - remove commas and spaces. Refer to a new String method
        // replace to make this easy.
       
        // iterate to determine if guess matches sequence

        // If match, increase score, and signal a match, otherwise, try again.

      // Ask if user wants to play another round of the game
      // and track the number of games played.
   
    // When done playing, show score and end the game.