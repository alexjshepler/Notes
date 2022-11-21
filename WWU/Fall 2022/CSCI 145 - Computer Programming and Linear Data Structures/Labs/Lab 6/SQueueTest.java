public class SQueueTest {
    public static void main(String[] args){
        SQueue queue;
        
        // ---------- CASE 1 ----------
        queue = new SQueue();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Adding: " + i);
            queue.add(i);
        }

        System.out.println("\nRemoving: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());

        System.out.println("\nPeeking top: " + queue.peek());

        System.out.println("\n----------");
        System.out.println("New queue");
        System.out.println("-----------\n");

        // ---------- CASE 2 ----------
        queue = new SQueue();

        System.out.println("adding: 2");
        queue.add(2);
        System.out.println("adding: 4");
        queue.add(4);
        System.out.println("adding: 8");
        queue.add(8);

        System.out.println("\nRemoving: " + queue.remove());
        System.out.println("Removing: " + queue.remove());

        System.out.println("\nIs Empty: " + queue.isEmpty());

        System.out.println("\n----------");
        System.out.println("New queue");
        System.out.println("-----------\n");

        // ---------- CASE 3 ----------
        queue = new SQueue();

        System.out.println("adding: 3");
        queue.add(3);
        System.out.println("adding: 6");
        queue.add(6);
        System.out.println("adding: 9");
        queue.add(9);

        System.out.println("\nRemoving: " + queue.remove());

        System.out.println("\nPeeking top: " + queue.peek());
        System.out.println("Is Empty: " + queue.isEmpty());
    }
}