package linked_list;

public class DoubleyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.previous = null;
        node.next = head;
        if (head != null) {
            head.previous = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        // if the list is empty
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        Node last = null;
        while(temp != null){
            last = temp;
            temp = temp.next;
        }
        last.next = node;
        node.previous = last;
        node.next = null;
        // since we have tail as well
        tail = node;
    }
    public Node get(int val){
        Node tempNode = head;
        while (tempNode.next != null){
            if(tempNode.value == val){
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        // to accommodate the last element
        if(tempNode.value == val){
            return tempNode;
        }
        return null;
    }
    public void insertAfter(int after, int val){
        Node beforeNode = get(after);
        Node node = new Node(val);

        if(beforeNode == null){
            System.out.println("Element doesn't exist");
            return;
        }
        // if our given element is last element
        if(beforeNode.next == null){
            insertLast(val);
            return;
        }

       node.next = beforeNode.next;
       node.previous = beforeNode;
       beforeNode.next.previous = node;
       beforeNode.next = node;
    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }
    public void displayReverse(){
        Node temp = head;
        while (temp!=null){
            tail = temp;
            temp = temp.next;

        }
        Node t = tail;
        while (t!=null){
            System.out.print(t.value + " -> ");
            t = t.previous;
        }
        System.out.print("START");
        System.out.println();
    }

}
