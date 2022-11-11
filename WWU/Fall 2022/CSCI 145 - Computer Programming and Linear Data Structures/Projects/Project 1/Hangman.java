import java.util.Scanner;

import javax.crypto.SecretKey;

public class Hangman {
    private static final boolean testingMode = true;

    // Allow these to be used by methods in the class
    private static String secretWord = "";
    private static String publicWord = "";

    public static void main(String[] args) {
        // The difficulty so we can set the variables accordingly
        char difficulty;

        // The variables that change based on difficulty
        int guesses = 0;
        int indexes = 0;

        // The input method
        Scanner scan = new Scanner(System.in);

        // The game loop
        while (true) {

            // The loop to get valid input
            do {
                // Reset the variables
                secretWord = "";
                publicWord = "";

                // Ask the user what difficulty and get the user input
                System.out.print("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
                difficulty = scan.nextLine().charAt(0);

                // Set the variables based on difficulty
                // (E)asy Guesses: 15 | Indexes: 4
                // (I)ntermediate Guesses: 12 | Indexes: 3
                // (H)ard Guesses: 10 | Indexes: 2

                // If the RandomWord.newWord() method allowed for word selection based on
                // difficulty this could be easily implemented
                switch (difficulty) {
                    case 'e':
                        guesses = 15;
                        indexes = 4;
                        secretWord = RandomWord.newWord();
                        break;
                    case 'i':
                        guesses = 12;
                        indexes = 3;
                        secretWord = RandomWord.newWord();
                        break;
                    case 'h':
                        guesses = 10;
                        indexes = 2;
                        secretWord = RandomWord.newWord();
                        break;
                    default:
                        // If the input is invalid it asks use user to reenter it
                        System.out.println("Invalid difficulty. Try Again...");
                        break;
                }

                // Sets the publicWord variable to all dashes, the length of the secretWord
                for (int i = 0; i < secretWord.length(); i++) {
                    publicWord += "-";
                }
            } while (guesses == 0);

            // Prints out what the secret mode is in testing mode
            if (testingMode)
                System.out.println("The secret word is: " + secretWord);

            // The input we get from the user. It is a string because if the user enters
            // "solve" we don't want to just take 's'
            String guess;

            // Loop while publicWord doesn't equal privateWord (this would indicate that the
            // word has been found) and while guesses > 0 (this would indicate if we didn't
            // find the word)
            while (!secretWord.equals(publicWord) && guesses > 0) {
                // Print out the remaining guesses to the user
                System.out.println("Guesses Remaining: " + guesses);
                // Ask the user for a character to guess
                System.out.print("Please enter the letter you want to guess: ");
                // Take the users input
                guess = scan.nextLine();

                // Check to see if the user entered "solve" instead of a character
                if (guess.toLowerCase().equals("solve")) {
                    // Prompt the user to enter the word they think privateWord is
                    System.out.print("Please solve the word: ");
                    // Get the input from the user
                    guess = scan.nextLine();

                    // If the guess is the secret word
                    if (guess.toLowerCase().equals(secretWord)) {
                        // Set publicWord to secretWord (this is used outside of this loop)
                        publicWord = secretWord;
                        // Break out of the game loop
                        break;
                    } else {
                        // Let the user know that isn't he right word
                        System.out.println("That is not the secret word");
                        // Decrement the amount of guesses
                        guesses--;
                    }
                } else {
                    // Assume the input is valid until checked
                    boolean isValidInput = true;

                    // Ask the user for which indexes it would like to check
                    System.out.println("Please enter the spaces you want to check (separated by spaces):");
                    // Get the users input
                    String input = scan.nextLine();

                    // Separate the input into a str array
                    String temp[] = input.split("\\s+");
                    // Create an int array the same length as the str array
                    int index[] = new int[temp.length];

                    // Try to parse each of the indexes into ints from strings
                    try {
                        // Make sure that the amount of indexes entered is the same amount of those
                        // allowed
                        if (temp.length == indexes) {
                            // Go through every index entered
                            for (int i = 0; i < indexes; i++) {
                                // Parse the string value into an int value
                                index[i] = Integer.parseInt(temp[i]);
                                // Check to see if that is in the range of the word
                                if (index[i] > secretWord.length() - 1) {
                                    // If it is out of range set isValidInput to false
                                    isValidInput = false;
                                }
                            }
                        }
                        // If the input isn't valid let the user know
                        if (!isValidInput)
                            System.out.println("Your input is not valid. Try again.");
                    } catch (Exception ex) {
                        // If the user entered an invalid index (like a letter or symbol) let the user
                        // know it was invalid
                        System.out.println("Your input is not valid. Try again.");
                    }

                    // The input has to be valid for this to not break
                    if (isValidInput) {
                        // Check to see if the guess is vlid
                        if (checkGuess(guess.charAt(0), index)) {
                            // If it is update the public word and let the user know
                            System.out.println("Your guess is in the word!");
                            System.out.println("The updated word is: " + publicWord);
                        } else {
                            // If the guess was wrong let the user know
                            System.out.println("Your letter was not found in the spaces you provided.");
                            // Decrement the amount of guesses
                            guesses--;
                        }
                    }
                }
            }

            // After the game is over

            // If the secret word is the same as the public word
            if (secretWord.equals(publicWord)) {
                // The user wong the game
                System.out.println("You have guessed the word! Congratulations");
            } else {
                // Otherwise the user lost the game
                System.out.println("You have failed to guess the word... :( ");
            }
            // Check to see if the user would like to play again
            System.out.print("Would you like to play again? Yes(y) or No(n)");

            char playAgain = scan.nextLine().charAt(0);

            // If no, break out of the game loop
            if (playAgain == ('n' | 'N')) {
                break;
            }
        }
    }

    static boolean checkGuess(char guess, int[] index) {
        // This boolean states wether or not the publicWord has been updated
        boolean changed = false;

        // Check every index in the indexes provided
        for (int i = 0; i < index.length; i++) {

            // Check check index[i] of secretWord to see if it is the same as guess
            if (secretWord.toLowerCase().charAt(index[i]) == guess) {
                // If it is set that index to whatever the guess is
                String temp = "";
                // And set the changed to true
                changed = true;
                // Loop through the publicWord string
                for (int j = 0; j < publicWord.length(); j++) {
                    // If the index that we are at for the word is the same as where we found the
                    // match
                    if (j == index[i])
                        // Add that to the end of the string
                        temp = temp + guess;
                    else
                        // Otherwise add whatever was there before to the end of the string
                        temp = temp + publicWord.charAt(j);
                }
                // Then set the publicWord equal to the temp value (what was storing the new
                // updated word)
                publicWord = temp;
            }
        }

        // Then we are going to return wether or not we changed the publicWord. If we
        // did that means there was a character that was found, otherwise we didn't find
        // anything
        return changed;
    }

}