public class linkListTest {

    public static void main(String[] args) {
        IntegerLinkedList ll = new IntegerLinkedList();

        System.out.println("\n\nInsert Back:");
        for (int i = 0; i <= 10; i++)
            ll.insertBack(i);

        ll.print();

        System.out.println("\n\nInsert Front: ");
        for (int i = -1; i >= -10; i--){
            ll.insertFront(i);
        }

        ll.print();

        System.out.println("get: ");
        System.out.println("Index 4: " + ll.get(4));
        System.out.println("Index 10: " + ll.get(10));
        System.out.println("Index 0: " + ll.get(0));
        System.out.println("Index 8: " + ll.get(8));
        System.out.println("Index 3: " + ll.get(2));
        System.out.println("Index 1: " + ll.get(1));

        System.out.println("Remove Front and Back: ");
        for(int i = 0; i < 3; i++){
            ll.removeFront();
            ll.removeBack();
        }

        ll.print();

        System.out.println("Remove at index 5: ");

        ll.removeAt(5);

        ll.print();
    }
}