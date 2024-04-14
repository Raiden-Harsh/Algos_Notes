package linked_list.questions;

public class MergeSortedCLL {
    int size;
    Node head;

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node node) {
            this.val = node.val;
            this.next = node.next;
        }
    }

    // Insert in CLL
    public void insert(int val) {
        if (size == 0) {
            Node node = new Node(val);
            head = node;
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        size++;
    }

    // Display in CLL
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println();
    }

    // merging with creating a new list
    public MergeSortedCLL merger(MergeSortedCLL head1, MergeSortedCLL head2) {
        MergeSortedCLL newCll = new MergeSortedCLL();
        Node pointer1 = head1.head;
        Node pointer2 = head2.head;


        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                newCll.insert(pointer1.val);
                pointer1 = pointer1.next;
            } else {
                newCll.insert(pointer2.val);
                pointer2 = pointer2.next;
            }
        }
        // check which one was ended first
        if (pointer1 != null) {
            // add all remaining elements of pointer1 to new ll
            while (pointer1 != null) {
                newCll.insert(pointer1.val);
                pointer1 = pointer1.next;
            }
        } else {
            // add all remaining elements of pointer2 to new ll
            while (pointer2 != null) {
                newCll.insert(pointer2.val);
                pointer2 = pointer2.next;
            }
        }

        return newCll;
    }
}
