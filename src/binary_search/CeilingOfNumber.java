package binary_search;

import java.util.Arrays;

/*
* Question: find the ceiling of a target number in the given array
* ceiling is the smallest number which is greater or equal to the target element.
* Assume that you are given an ascending order array
* */
public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr ={-3,-1,0,3,5,6,12,15,17};
        int target=13;
        int ans= findTheCeiling(arr,target);
        System.out.println("Ceiling number in the given array with target :"+target);
        System.out.println(Arrays.toString(arr));
        System.out.println("is: "+arr[ans]);
        int ans2=floorOfANumber(arr,target);
        System.out.println("Floor of the number is :"+arr[ans2]);

    }
    static int findTheCeiling(int[] arr,int target){
        int start=0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else
                return mid;
        }
        /*
         * when the loop ends the start will be more than end
         * and the middle value will be closest to our target!
         * so for ceiling number we can return the number at start
         * and for floor number we can return the number at end
         * as the start will be (middle+1)
         * and the end will be(middle-1)
         */

        return start;
    }
    /*
     *floor of a number is the largest number which is smaller than or equal to the given number!
     */
    static int floorOfANumber(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else
                return mid;
        }


        return end;
    }


}
