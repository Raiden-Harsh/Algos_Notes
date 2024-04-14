package linked_list.questions;

public class RemDuplicateCLL {
    int size;
    Node head;

    private class Node {
        int val;
        Node next;

        // constructors
        public Node(int val) {
            this.val = val;
        }

        public Node(Node node) {
            this.val = node.val;
            this.next = node.next;
        }
    }

    // Insert elements
    public void insert(int val) {
        if (size == 0) {
            // new LL
            Node node = new Node(val);
            head = node;
            size++;
            return;
        }
        Node temp;
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // we are at the end of the list
        Node node = new Node(val);
        temp.next = node;
        node.next = null;
        size++;
    }

    // Display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    // method to remove duplicates
    public void removeDupes() {
        Node temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }

    }
}
