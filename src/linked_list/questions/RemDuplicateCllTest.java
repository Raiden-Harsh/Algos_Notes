package linked_list.questions;

public class RemDuplicateCllTest {
    public static void main(String[] args) {
        RemDuplicateCLL cll = new RemDuplicateCLL();
        cll.insert(1);
        cll.insert(2);
        cll.insert(2);
        cll.insert(2);
        cll.insert(3);
        cll.insert(3);
        cll.insert(4);
        cll.display();
        cll.removeDupes();
        cll.display();
    }
}
