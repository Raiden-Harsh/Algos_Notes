package cyclic_sort;
/*
Q) Given an array nums containing n distinct integers in the range [0,n]. Return the only number in the range,
that is missing form the array!
Follow Up: could you implement the solution only using O(1) extra space complexity and O(N) time complexity.
 */

import java.util.Arrays;

public class QMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,0};
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(arr));
        int ans = ans(arr);
        System.out.println("missing number: "+ ans );
    }
    static int ans(int[] arr){
        cyclicSort(arr);
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] != i){
                return i;
            }

        }
        // this means that N is not in the array! so we return that
        return arr.length;
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        boolean run = true;
        // no need for a check of empty array as it should have all numbers form 1 to N!
        while (run){
            if(i == arr.length -1){
                // checking last element is unnecessary!
                //here we break the loop in style 🤣
                run = false;
            }
            if(i == arr[i]){
                //element at correct position!
                i++;
            }else {
                //ith element is not at its correct index, so we swap it!
                if(arr[i] == arr.length){
                    i++; //skip that
                    continue;
                }
                swap(arr,i,arr[i]);

            }
        }

    }

    static void swap(int[] arr, int first, int second) {
        //swap first with second
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
