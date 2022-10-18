import java.util.Scanner;

public class SmallestDouble {
    public static void main(String[] args){
        findSmallestDouble();
    }

    public static void findSmallestDouble(){
        Scanner scanner = new Scanner(System.in);

        // Gets the amount of numbers that will be summed
        System.out.print("How many doubles will be entered? ");

        int n = scanner.nextInt();

        double smallest = 0;

        // Get all of the inputs
        for (int i = 0; i < n; i++){
            // Get input
            System.out.print("Enter a double: ");
            double input = scanner.nextDouble();

            // If first double entered, is smallest
            if(n == 0){
                smallest = input;
            }
            // If the input is smaller than the smallest, it is smaller
            else if(smallest > input){
                smallest = input;
            }
        }
        System.out.println("The smallest double is : " + smallest);
    }
}