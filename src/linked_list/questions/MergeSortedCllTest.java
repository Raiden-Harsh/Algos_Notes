package linked_list.questions;

public class MergeSortedCllTest {
    public static void main(String[] args) {
        MergeSortedCLL cll1 = new MergeSortedCLL();
        MergeSortedCLL cll2 = new MergeSortedCLL();
        MergeSortedCLL newCll = new MergeSortedCLL();
        cll1.insert(1);
        cll1.insert(3);
        cll1.insert(5);
        cll2.insert(1);
        cll2.insert(2);
        cll2.insert(9);
        cll2.insert(14);
        cll1.display();
        cll2.display();

        newCll.merger(cll1,cll2).display();
    }
}
