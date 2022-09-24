package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Q) Given the array nums of n integers where nums[i] is in the range [1,n],
   return an array of all the integers in the range [1,n] that do not appear in nums.
 */
public class FindTheMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(ans(nums));
    }
    static ArrayList<Integer>  ans(int[] arr){
        cyclicSort(arr);

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                a.add(i+1);
            }
        }
        return a;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        // this can handle duplicate elements as well!
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[correct] != arr[i]) {
                swap(arr, i, correct);
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
