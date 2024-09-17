package stack_and_queue;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }


    @Override
    public boolean push(int entity) throws CustomStackException {
        if(isFull()){
            // create a new array double the size
            int temp[] = new int[data.length *2];
            // copy each element to the new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            // now our data will reference the new temp array
            data = temp;
        }
        return super.push(entity);
    }
}
