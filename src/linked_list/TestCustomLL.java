package linked_list;

public class TestCustomLL {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.insertFirst(7);
        linkedList.insertFirst(6);
        linkedList.insertFirst(5);
        linkedList.insertFirst(4);
        linkedList.insertFirst(3);
        linkedList.display();
        System.out.println();

        linkedList.insertLast(12);
        linkedList.insertLast(18);
        linkedList.display();
        linkedList.insert(999,3);
        System.out.println();
        linkedList.display();
        linkedList.deleteFirst();
        System.out.println();
        linkedList.display();
        System.out.println();


        // new LinkedList for deletion
        CustomLinkedList ll = new CustomLinkedList();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(99);
        ll.display();
        System.out.println(ll.deleteLast());
        ll.display();
        System.out.println(ll.delete(2));
        ll.display();
        System.out.println(ll.find(5));

    }
}
