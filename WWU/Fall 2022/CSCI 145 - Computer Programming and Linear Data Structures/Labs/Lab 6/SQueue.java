import java.util.LinkedList;
import java.util.Stack;

public class SQueue {
    Stack<Integer> stack = new Stack<Integer>();

    public void add(int x) {
        // Add the input to the stack
        stack.push(x);
    }

    public int remove() {
        try {
            // Make a temp stack
            Stack<Integer> temp = new Stack<Integer>();

            // This is the variable that we are going to return
            int returnValue = 0;

            // While the stack is not empty
            while (!stack.isEmpty()) {
                // Add all of the elements to temp from stack
                temp.push(stack.pop());
            }

            // Take the first value from the top of the temp and store it to return later
            returnValue = temp.pop();

            // While temp is not empty
            while (!temp.isEmpty()) {
                // Move all of the elements from temp to stack
                stack.push(temp.pop());
            }

            // Return the first value that got popped from temp
            return returnValue;
        } catch (Exception ex) { // Catch incase an error occurs
            System.out.println("An error has occurred");
            return -1;
        }
    }

    public int peek() {
        try {
            // Create a temp stack
            Stack<Integer> temp = new Stack<Integer>();

            // This is the variable we are going to store the value to return for later
            int returnValue = 0;

            // While stack is not empty
            while (!stack.isEmpty()) {
                // Move everything over to the temp stack
                temp.push(stack.pop());
            }

            // Take the first value from temp and store it in he returnValue variable for later
            returnValue = temp.pop();

            // Add the value back to the stack
            stack.push(returnValue);

            // While temp is not empty
            while (!temp.isEmpty()) {
                // Move everything back to stack from temp
                stack.push(temp.pop());
            }

            // Return the value that is at the bottom
            return returnValue;
        } catch (Exception ex) { // Catch in case an error accurs
            System.out.println("An error has occurred");
            return -1;
        }
    }

    public int size() {
        // Get the size fo the stack
        return stack.size();
    }

    public boolean isEmpty() {
        // Get if the stack is empty or not
        return stack.isEmpty();
    }
}