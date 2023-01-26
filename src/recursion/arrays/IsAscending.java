package recursion.arrays;

public class IsAscending {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(check(arr,0));
    }
    public static boolean check(int[] arr,int i){
        // if the pointer is at last element of array then
        // it is sorted in ascending order
        if(i == arr.length-1){
            return true;
        }
        return arr[i]<arr[i+1] && check(arr,i+1);
    }
}
