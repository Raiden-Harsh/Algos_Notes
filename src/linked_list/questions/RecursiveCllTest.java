package linked_list.questions;

public class RecursiveCllTest {
    public static void main(String[] args) {
        RecursiveCLL cll = new RecursiveCLL();
        cll.insert(5);
        cll.insert(7);
        cll.insert(1);
        cll.insert(9);
        cll.insert(10);
        cll.display();
       // cll.insertAt(4,69);
     //   cll.display();
        cll.insertRec(69,3);
        cll.display();


    }
}
