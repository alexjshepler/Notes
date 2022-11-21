public class QStackTest {
    public static void main(String[] args) {
        QStack stack ;
        
        // ---------- CASE 1 ----------
        stack = new QStack();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Pushing: " + i);
            stack.push(i);
        }

        System.out.println("\nPopping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());

        System.out.println("\nPeeking top: " + stack.top());

        System.out.println("\n----------");
        System.out.println("New Stack");
        System.out.println("-----------\n");

        // ---------- CASE 2 ----------
        stack = new QStack();

        System.out.println("Pushing: 2");
        stack.push(2);
        System.out.println("Pushing: 4");
        stack.push(4);
        System.out.println("Pushing: 8");
        stack.push(8);

        System.out.println("\nPopping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());

        System.out.println("\nIs Empty: " + stack.isEmpty());

        System.out.println("\n----------");
        System.out.println("New Stack");
        System.out.println("-----------\n");

        // ---------- CASE 3 ----------
        stack = new QStack();

        System.out.println("Pushing: 3");
        stack.push(3);
        System.out.println("Pushing: 6");
        stack.push(6);
        System.out.println("Pushing: 9");
        stack.push(9);

        System.out.println("\nPopping: " + stack.pop());

        System.out.println("\nPeeking top: " + stack.top());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}