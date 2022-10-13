package recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr ={1,2,3,5,64,66,77};
        int target =64;
        System.out.println(binarySearch(arr,target,0,arr.length-1));
    }
    static int binarySearch(int[] arr, int target, int start,int end){
        int middle = start +(end-start)/2;
        if(start>end){
            // target not found
            return -1;
        }
        if(arr[middle] == target){
            return middle;
        }
        if(arr[middle]>target){
            //answer will lie on left side
            return binarySearch(arr,target,start,middle-1);
        }
        // this if condition is just for understanding purpose
        //we can achieve the same by just returning it instead of -1 in the end
        if(arr[middle]<target){
            //answer will lie on the right side
            return binarySearch(arr,target,middle+1,end);
        }
        // if not caught by these three conditions i.e. target is not in array
        return -1;
    }
}
