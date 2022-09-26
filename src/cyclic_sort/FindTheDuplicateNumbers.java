package cyclic_sort;
/*
Q) Given an array of integers nums containing n + 1 integers, where each integer is in the range [1,n] inclusive!
   There is ONLY ONE repeated number in nums, return this repeated number!
   You must solve the problem without modifying the original array and use only constant extra space.
 */

import java.util.Arrays;

public class FindTheDuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,4,2};
        System.out.println(ans(nums));
        System.out.println(Arrays.toString(nums));
    }
    static int ans(int[] arr){
        cyclicSort(arr);
        //question says only one duplicate element so it will be pushed to last!
        return arr[arr.length-1];
    }
    static void cyclicSort(int[] arr){
        int i = 0;
        //if we have duplicate elements, we have to check that:
            // if we have the correct element at the correct index or not!
            //i.e. if the element is at the correct index or not, if we face duplicate elements then,
            // they will be already at the correct index and the extras will be pushed to end!
        while (i<arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){ //array ki correct index per element nahi hai tabhi swap kro!
                swap(arr,i,correctIndex);
            }else {
                i++;
            }
        }

    }
    static void swap (int[] arr,int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
