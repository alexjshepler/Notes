import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Initialize the variables
        char op;
        double x = 0;
        double y = 0;

        boolean exit = false;

        Scanner scanner = new Scanner(System.in);

        while (!exit) {

            // Get operator
            System.out.print(
                    "Please select an operation ( (A)ddition); (S)ubtraction; (M)ultiplication; (D)ivision; or (Q)uit: ");
            op = scanner.next().charAt(0);

            // Get variables and make sure the user didn't want to exit
            if (op != 'q') {
                System.out.print("Enter the first operand: ");
                x = scanner.nextDouble();
                System.out.print("Enter the second operand: ");
                y = scanner.nextDouble();
            }

            // Determine what to do based on op
            switch (op) {
                case 'a':
                    add(x, y);
                    break;
                case 's':
                    subtract(x, y);
                    break;
                case 'm':
                    multiply(x, y);
                    break;
                case 'd':
                    divide(x, y);
                    break;
                case 'q':
                    exit = true;
                    break;
                default:
                    System.out.println("Please make sure to put valid input");
                    break;
            }
        }
    }

    public static void add(double x, double y) {
        // Print the result
        System.out.println(x + " + " + y + " = " + (x + y));
    }

    public static void subtract(double x, double y) {
        // Print the result
        System.out.println(x + " - " + y + " = " + (x - y));
    }

    public static void multiply(double x, double y) {
        // Print the result
        System.out.println(x + " * " + y + " = " + (x * y));
    }

    public static void divide(double x, double y) {
        // Print the result
        System.out.println(x + " / " + y + " = " + (x / y));
    }
}