import java.util.Scanner;

public class Summation {

    public static void main(String[] args) {
        sumIntegers();
    }

    public static void sumIntegers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many integers will be summed? ");

        int n = scanner.nextInt();

        int total = 0;

        for (int i = 0; i < n; i++){
            System.out.print("Enter an integer: ");
            total += scanner.nextInt();
        }

        System.out.println("The Summation is: " + total);
    }
}
