package stack_and_queue;

import java.util.*;

public class InbuildStackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("---------Stack---------");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


// Queue is an interface, so we use LL for its implementation.
        System.out.println("----------Queue---------");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("---------Deque-------------");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        // should return 1
        System.out.println(deque.removeFirst());
        // should return 4
        System.out.println(deque.removeLast());

    }
}
