package binary_search;

import java.util.Arrays;

/*
Q) Find the largest element in a mountain array!
ex: [0,1,0] ans 1
    [1,3,6,4,2] ans 6
    [-3,-1,0,4,5,3,1,-2,-5] ans 5
 */
public class PeakInMountainArray {
    public static void main(String[] args) {
        int[] arr= {1,2,4,5,3,2,0};
        int ans = MountainArray(arr);
        System.out.println("Biggest element in the following bi-tonic array is: ");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[ans]+" at index :"+ans);

    }
    static int MountainArray(int[] arr){
        int start=0;
        int end = arr.length-1;
        while(start<end){
            int mid= start+(end-start)/2;
            //check first
            if(arr[mid]>arr[mid+1]){
                //array is in descending order
                //mid can be a possible answer or other answers will lie on the left side!
                end = mid;
            }
            else {
                //array is in ascending order!
                //we know mid+1> mid
                //possible answers will lie on right side
                start= mid+1;
            }
        }
        //both the pointers at ever instance of the loop are trying to have the biggest value
        //which is possible at that point in time
        //so when the loop breaks finally we will have both start and end pointing at the same number
        //which will be the biggest number!
        return start;// or end as both are equal
    }
}
/*
   THE THINKING BEHIND THE ALGO!
   > A mountain array or bi-tonic array is simply a sorted array which is sorted first in ascending order
    then in descending order!
   > As it is a sorted array we will be using binary search
   > If we are approaching this a binary search, we don't have the target element to find! so some modification is required
   > We can check if we are in the ascending part or the descending part, simply by the help of middle element
   > If the next element to middle is bigger then the middle element then we are in ascending part of the array,
     and we will find our answer on the right side of the array,
     so our start will be middle+1, as we know the next element to middle is greater than middle,
     so why check the middle element again!!!
   > The second case may be, when the middle element is bigger than the next element,i.e. we are in descending part of array
     so the potential answers will lie on the left side of the array!
     so our end will be the middle element (as we don't know if the element behind the middle is larger or not!)
   > And if we dry run this approach we can see that in the end both ena and start will point at the same element,
     which is the biggest element and this is out loop breaking condition!!!
*/