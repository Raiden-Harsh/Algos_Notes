package stack_and_queue;

public class CustomStack {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr = -1;

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    // add data to stack
    public boolean push(int entity) throws CustomStackException {
        if (isFull()) {
            throw new CustomStackException("Can't push the Stack is FULL!");
        }
        // add the entity @ptr+1 then return true
        this.data[++ptr] = entity;
        return true;

    }

    // remove data from the stack
    public int pop() throws CustomStackException {
        if (isEmpty()) {
            throw new CustomStackException("Cant pop an EMPTY Stack!");
        }
        // return the data @ptr, then reduce the ptr value by 1
        return this.data[ptr--];
    }

    //to see what is at the top
    public int peek() throws CustomStackException{
        if(isEmpty()){
            System.out.println("Can't peek in an EMPTY Stack!");
            throw new CustomStackException("EMPTY Stack exception.");
        }
        return data[ptr];
    }


    private boolean isFull() {
        // ptr is at the last index or
        return ptr + 1 > this.data.length - 1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }
}
