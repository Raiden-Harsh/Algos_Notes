package binary_search;
//Q) Find the number of times array is rotated!

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        int[] arr1 ={0,1,2,3,4,5,6,7};
        int[] arr2 ={7,0,1,2,3,4,5,6};
        int pivot = findPivot(arr);
        System.out.println("Pivot is at :"+pivot);
        System.out.println(" Times array is rotated! "+(pivot+1));

    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start +(end - start)/2;
            //cases for pivot
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]<=arr[start]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
