import java.util.LinkedList;
import java.util.Queue;

public class QStack {
    Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int x) {
        // Add the input to the queue
        queue.add(x);
    }

    public int pop() {
        try {
            // Make a temp queue
            Queue<Integer> temp = new LinkedList<Integer>();

            // Counts the amount of entries in the queue
            int i = 0;

            // While the queue is not empty
            while (!queue.isEmpty()) {
                // Increment the counter
                i++;
                // And remove the element from queue and add it to the temp
                temp.add(queue.remove());
            }

            // Add all but the last element back to the queue
            for (int j = 1; j < i; j++)
                queue.add(temp.remove());

            // Return the last element that is in the temp queue
            return temp.remove();
        } catch (Exception ex) { // Catch incase an exception gets thrown
            System.out.println("An error has occurred");
            return -1;
        }
    }

    public int top() {
        try {
            // Make a temp queue
            Queue<Integer> temp = new LinkedList<Integer>();

            int i = 0;
            int returnValue = 0;

            // While the queue is not empty
            while (!queue.isEmpty()) {
                // Increment the counter
                i++;
                // And add the value from queue to temp
                temp.add(queue.remove());
            }

            // Move all of the elements back to the the queue from temp besides the last
            for (int j = 1; j < i; j++)
                queue.add(temp.remove());

            // Get the value of the last element i the temp queue
            returnValue = temp.remove();

            // Add it back to the queue
            queue.add(returnValue);

            // Return the last value
            return returnValue;
        } catch (Exception ex) {
            System.out.println("An error has occurred");
            return -1;
        }
    }

    public int size() {
        // Return the size of the queue
        return queue.size();
    }

    public boolean isEmpty() {
        // Return if it is empty
        return queue.isEmpty();
    }

}