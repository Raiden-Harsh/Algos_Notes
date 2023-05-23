package linked_list;

public class TestCircularLL {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);
        cll.display();
        cll.delete(2);
        cll.display();

    }
}
