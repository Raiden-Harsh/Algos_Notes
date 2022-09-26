package cyclic_sort;

import java.util.Arrays;

/*
Q) Given an unsorted integer array nums, return the smallest missing positive integer.
   You must use an algorithm that runs in  O(N) time, and uses O(1) constant extra space!
 */
public class FindFirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,-1,3,4};
        System.out.println(Arrays.toString(nums));
        System.out.println("smallest missing positive integer: "+ ans(nums));
    }

    static int ans(int[] arr) {
        cyclicSort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // -ve and elements > length of array should be ignored!
            if (arr[i] <= 0 || arr[i] > arr.length) {
                i++;
                // we want to start with the updated 'i' so, continue!
                continue;
            }
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }


        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
