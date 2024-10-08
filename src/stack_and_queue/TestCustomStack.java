package stack_and_queue;

import java.util.function.Supplier;

public class TestCustomStack {
    public static void main(String[] args) throws CustomStackException {
        CustomStack cs = new CustomStack();
        cs.push(1);
        cs.push(2);
        cs.push(3);
        System.out.println(cs.peek());
        System.out.println(cs.pop());
        System.out.println(cs.pop());

        CustomStack ds = new DynamicStack(1);
        ds.push(99);
        ds.push(100);

        // able to add the 100 as well
        System.out.println(ds.peek());




    }
}
