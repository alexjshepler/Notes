import java.util.Scanner;

public class Summation {

    public static void main(String[] args) {
        sumIntegers();
    }

    public static void sumIntegers() {
        Scanner scanner = new Scanner(System.in);

        // Gets the amount of numbers that will be summed
        System.out.print("How many integers will be summed? ");

        int n = scanner.nextInt();

        int total = 0;

        // Gets all of the numbers that will be summed
        for (int i = 0; i < n; i++){
            // Get input
            System.out.print("Enter an integer: ");
            // Adds the input to the running total
            total += scanner.nextInt();
        }

        // Prints out the total
        System.out.println("The Summation is: " + total);
    }
}
