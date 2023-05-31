package linked_list;
// remove the duplicate elements of a singly linked list

public class QuestionOne {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.insertFirst(1);
        linkedList.insertFirst(1);
        System.out.println("Input Linked List : ");
        linkedList.display();
        linkedList.removeDuplicate();
        System.out.println("After Removing duplicates : ");
        linkedList.display();
    }
}
