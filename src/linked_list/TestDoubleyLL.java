package linked_list;

public class TestDoubleyLL {
    public static void main(String[] args) {
        DoubleyLinkedList list = new DoubleyLinkedList();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.displayReverse();
        list.insertLast(11);
        list.display();
        list.insertAfter(4,44);
        list.display();
        list.insertAfter(11,111);
        list.display();

    }
}
