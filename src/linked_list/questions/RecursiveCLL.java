package linked_list.questions;

/**
 * In this we are trying to Insert in a  <code>Custom Linked List</code> at a particular <code>Index</code>
 */
// We will create our own LL in every Question


public class RecursiveCLL {
    private Node head;
    private int size;

    private class Node {
        int val;
        Node next;

        // Constructors
        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(Node node){
            this.val = node.val;
            this.next = node.next;
        }
    }

    // constructor for CLL
    public RecursiveCLL() {
        this.size = 0;
    }

    // we will use the methods here to do our questions

    /**
     * This method will insert one after the other if some <code>val</code> is given it will be assigned after the current val
     *
     * @param val
     */
    public void insert(int val) {
        // first element of LL
        if (size == 0) {
            Node node = new Node(val);
            size += 1;
            head = node;
            return;
        }
        // we need to find the last element
        Node traverse;
        traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        Node node = new Node(val);
        traverse.next = node;
        node.next = null;
        size += 1;
    }

    /**
     * this one will display the LL
     */
    public void display() {
        System.out.println("-----------------------------");
        Node traverse;
        traverse = head;
        int count = 0;
        while (traverse != null) {
            System.out.print(traverse.val + " -> ");
            traverse = traverse.next;
            count++;

        }
        System.out.print("END");
        System.out.println();
    }

    /**
     * Insert at a particular index without recursion
     *
     * @param index
     * @param val
     */
    public void insertAt(int index, int val) {
        // check for an empty list
        if (size == 0) {
            head = new Node(val);
            size++;
            return;
        }
        if (index > size + 1) {
            System.out.println("Provide valid index");
            return;
        }
        int start = 0;
        Node traverse;
        traverse = head;
        // check for 1st position
        if (index - 1 < 0) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            return;
        }
        // check for last positon
        if (index == size - 1) {
            Node temp;
            temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
            return;
        }
        while (start != index - 1) {
            traverse = traverse.next;
            start++;
        }

        // to be inserted
        Node node = new Node(val);
        // this check is required if the CLL is only one element,
        // then the traverse will be null!
        if (traverse != null) {
            node.next = traverse.next;
            traverse.next = node;
        } else {
            head.next = node;
        }
    }

    /**
     * This method will insert at a particular <code>INDEX</code> by using <code>RECURSION</code>
     */

    public void insertRec(int val, int index) {
        // A special case for 0th Index
        if(index == 0){
            Node node = new Node(val);
            node.next = head;
            head = node;
            return;
        }
            head = helper(index,val,0,new Node(head));
    }
    // helper function which will stay private
    // we could have used to reduce the index as well
    private Node helper(int index,int val,int currIndex,Node currNode){
        //base condition
        if(index == currIndex + 1){
            Node temp = new Node(val);
            size++;
            temp.next =currNode.next;
            currNode.next =temp;
            return currNode;
        }
        currNode.next = helper(index,val,currIndex+1,currNode.next);
        return currNode;
    }
}




