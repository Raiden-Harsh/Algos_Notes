package binary_search;

public class BinarySearchCode {
    public static void main(String[] args) {
        //just a sorted array!
        int[] arr ={-12,-10,-5,0,2,5,7,12,35,36,77};
        int target = 13;
        int ans = BinarySearch(arr,target);
        System.out.println("Target is at :"+ans);


    }

    //return the index of the target element
    //return -1 if target doesn't exist
    static int BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //now we find the middle
            //int mid = (start+end)/2;
            //but there is a problem that, if start and end are big enough they may exceed the int range of java
            //we can do middle more optimised as
            int mid = start + (end - start) / 2;
            //now we check our cases
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                return mid;
        }
        return -1;
    }
   }
