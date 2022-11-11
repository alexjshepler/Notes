public class IntegerLinkedList {

  private IntegerNode head;

  public boolean isEmpty() {
    // Return wether the list is empty or not
    return head == null;
  }

  public void insertFront(int val) {
    // Create a new node with the value
    IntegerNode node = new IntegerNode(val);
    // Set the nodes next node to the head
    node.setNext(head);
    // Change the head to the new node
    head = node;
  }

  public void insertBack(int val) {
    // Create a new node with value
    IntegerNode node = new IntegerNode(val);
    // Make a "runner" node and set it to the head
    IntegerNode curr = head;

    // If the head is null set the head to the new node
    if (curr == null)
      head = node;
    else {
      // Loop through every item in the list until it gets to the last node
      while (curr.getNext() != null)
        curr = curr.getNext();

      // Set the last nodes next node to the new node
      curr.setNext(node);
    }
  }

  public void print() {
    // Make a "runner" node and set it equal to the head
    IntegerNode curr = head;

    // Print out the value of the node then set the runner node to the next node and repeat
    while (curr.getNext() != null) {
      System.out.println(curr.getValue());
      curr = curr.getNext();
    }
    // The loop doesn't print out the last value so this does it
    if (curr != null)
      System.out.println(curr.getValue());
  }

  public int get(int index) {
    // Create a "runner" node and set it equal to the head
    IntegerNode curr = head;

    // Loop index - 1 times through the array
    for (int i = 0; i < index; i++) {
      if (curr.getNext() != null)
        curr = curr.getNext();
      else {
        // If the value is null print out "IndexOutOfRange"
        System.out.println("IndexOutOfRange");
        return -1;
      }
    }

    // Return the value of the current node
    return curr.getValue();
  }

  public void removeFront() {
    // If there is a next node set head equal to the next node
    if (head.getNext() != null) {
      head = head.getNext();
    }
    // If the next node is null set the head equal to null
    else {
      head = null;
    }
  }

  public void removeBack() {
    // Make a "runner" node and set it equal to the head
    IntegerNode curr = head;

    // Loop while the node two ahead isn't null
    while (curr.getNext().getNext() != null) {
      curr = curr.getNext();
    }
    // When it is set the next node to null
    curr.setNext(null);
  }

  public void removeAt(int index) {
    // Make a "runner" node and set it equal to head
    IntegerNode curr = head;

    // Go to the index - 1 of the item to remove
    for (int i = 0; i < index - 1; i++) {
      if (curr.getNext() != null)
        curr = curr.getNext();
    }

    // Because the index we want to remove is the next one, set the current next node to the next node of the next node
    curr.setNext(curr.getNext().getNext());
  }
}