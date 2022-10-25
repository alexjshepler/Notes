import java.util.Scanner;

public class MyStringManipulator {
    public static void main(String[] args) {
        // Variables to store the string and the option
        String original;
        String input;

        // Get input
        Scanner scan = new Scanner(System.in);

        // Get the text we are going to manipulate
        System.out.println("Please enter the text you'd like to manipulate");
        original = scan.nextLine();

        // Loop through all of the options until the program ends
        do {
            // Print out the current text
            System.out.println("The current string is: " + original);

            // Get the manipulation option from the user
            System.out.println("\nPlease select an option, Print Reverse, Replace All, Remove, Replace Single, Quit:");
            input = scan.nextLine().toLowerCase();

            switch (input) {
                // Print the text in reverse
                case "print reverse":
                    printReverse(original);
                    break;
                // Replace all of one character with another
                case "replace all":
                    original = replaceAll(original);
                    break;
                // Remove all of one character
                case "remove":
                    original = remove(original);
                    break;
                // Replace the first instance of a character
                case "replace single":
                    original = replaceSingle(original);
                    break;
                // Quit the program
                case "quit":
                    return;
                // Display this message to the user if they don't enter a valid option
                default:
                    System.out.println("\nYou've entered an invalid option, please try again");
                    break;
            }
            // Loop forever until the user is done
        } while (true);
    }

    // Print the string in reverse order from what it is
    static void printReverse(String text) {
        // Store the string
        String temp = "";

        // Loop through every character in the string
        for (int i = 0; i < text.length(); i++) {
            // Add the current character to the beginning of the string
            temp = text.charAt(i) + temp;
        }

        // Output the string in reverse
        System.out.println(text + " in reverse order is " + temp);
    }

    // Prompt the user to enter the character to change and the character to replace
    // it with
    static String replaceAll(String text) {
        // Store the updated string
        String temp = "";

        // The character that we want to replace and the character we want to replace it
        // with
        char replaceThis;
        char replaceWith;

        // Get input from the user
        Scanner scan = new Scanner(System.in);

        // Get the character that we want to replace
        System.out.print("\nPlease enter the character to replace: ");
        replaceThis = scan.next().charAt(0);

        // Get the character that we want to replace it with
        System.out.print("\nPlease enter the character to replace with: ");
        replaceWith = scan.next().charAt(0);

        // Loop through all of the characters in the string
        for (int i = 0; i < text.length(); i++) {
            // If the current character is the same as the one we want to replace
            if (text.charAt(i) == replaceThis) {
                // Add the character we want to replace it with to the end of the updated string
                temp += replaceWith;
            } else {
                // Add the current character to the end of the updated string
                temp += text.charAt(i);
            }
        }

        // Check to see if the updated string is the same as the one given
        if (text.equals(temp)) {
            // Give an error if they are the same
            System.out.println("\nERROR: Nothing was changed, the character to be replaced does not exit in the text");
        }

        // Return the updated string
        return temp;
    }

    // Prompt the user a character to remove
    static String remove(String text) {
        // Store the updated string
        String temp = "";

        // The character that we want to remove
        char removeThis;

        // Get input from the user
        Scanner scan = new Scanner(System.in);

        // Get the character that we want to remove from the user
        System.out.print("\nPlease enter the character to remove: ");
        removeThis = scan.next().charAt(0);

        // Loop through every character in the string
        for (int i = 0; i < text.length(); i++) {
            // If the current character doesn't match the one we want to remove add it,
            // otherwise ignore it
            if (text.charAt(i) != removeThis) {
                // Add the current character to the end of the updated string
                temp += text.charAt(i);
            }
        }

        // Check to see if the updated string is the same as the one given
        if (text.equals(temp)) {
            // If they are the same give the user an error message
            System.out.println("\nERROR: The character to be removed does not exist in the text");
        }

        // Return the updated string
        return temp;
    }

    // Prompt the user to enter a character and the character to replace it with,
    // then replace the first occurrence
    static String replaceSingle(String text) {
        // Store the updated string
        String temp = "";

        // The character that we want to replace and the character we want to replace it
        // with
        char replaceThis;
        char replaceWith;

        // Get input from the user
        Scanner scan = new Scanner(System.in);

        // Get the character we want to replace
        System.out.print("\nPlease enter the character to replace: ");
        replaceThis = scan.next().charAt(0);

        // Get the character we want to replace it with
        System.out.print("\nPlease enter the character to replace with: ");
        replaceWith = scan.next().charAt(0);

        // Loop through every character in the text
        for (int i = 0; i < text.length(); i++) {
            // If the current character is the one that we want to replace
            if (text.charAt(i) == replaceThis) {
                // Add the character we want to replace it with to the end of the updated string
                temp += replaceWith;

                // Loop through the rest of the characters
                for (int j = i + 1; j < text.length(); j++) {
                    // Add the current character to the end of the updated string
                    temp += text.charAt(j);
                }

                // Return the updated string
                return temp;
            } else {
                // Add the current character to the end of the updated string
                temp += text.charAt(i);
            }
        }

        // This will only be ran if nothing got changed, because if something does it
        // returns earlier in the program
        System.out.println("\nERROR: The character to replace did not exist in the text");

        return temp;
    }
}
